package persistence;

import entity.Animal;
import entity.AverageAnimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.*;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import javax.jnlp.PersistenceService;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.List;

public class GenericDAO<T> {

    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public GenericDAO(Class<T> type) {
        this.type = type;
    }

    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    public int create(T entity) {
        int id;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    public List<T> getAll() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    public <T> T getById(int id){
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

    public void update(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public List<T> findByPropertyEqual(String propertyName, Object value) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> results = session.createQuery(query).getResultList();
        session.close();
        return results;
    }

    public void getAnimalAverageByGroup() {
        logger.info("get ave");
        Session session = getSession();
        // TODO: 12/7/19 this is buged max gets the bigest value not the most values https://stackoverflow.com/questions/12446368/sql-returning-the-most-common-value-for-each-person
        String queryString = "select a.AnimalsName, max(a.AnimalsClass), max(a.AnimalsFiction), avg(a.AnimalsHealth), avg(a.AnimalsStamina),avg(a.AnimalsStrength), avg(a.AnimalsAgility), avg(a.AnimalsDexterity), avg(a.AnimalsIntelligence)from Animals a group by a.AnimalsName";
        Query query = session.createNativeQuery(queryString);

        List<T> averageAnimals = ((NativeQuery) query).list();

        //truncate DB
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("TRUNCATE TABLE AnimalStatsChart.AverageAnimals").executeUpdate();
        transaction.commit();
        session.close();
        //enter into database aveanimals
        GenericDAO<AverageAnimal> averageAnimalDAO = new GenericDAO(AverageAnimal.class);
        for ( Object animal : averageAnimals) {
            String list = Arrays.deepToString((Object[]) animal);
            logger.info(list);
            String[] aveAnimal = list.split("[ \\[\\],]+");
            AverageAnimal newAveAnimal = new AverageAnimal(aveAnimal[1], aveAnimal[2], aveAnimal[3], (int) Double.parseDouble(aveAnimal[4]),(int) Double.parseDouble(aveAnimal[5]),(int) Double.parseDouble(aveAnimal[6]),(int) Double.parseDouble(aveAnimal[7]),(int) Double.parseDouble(aveAnimal[8]),(int) Double.parseDouble(aveAnimal[9]));
            logger.info(aveAnimal[1]);
            logger.info(newAveAnimal);
            averageAnimalDAO.create(newAveAnimal);
        }
    }
}
