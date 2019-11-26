package persistence;

import entity.Animal;
import entity.AverageAnimal;
import entity.Role;
import entity.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import util.DatabaseUtility;



import java.util.Arrays;
import java.util.List;


import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;
import static org.junit.Assert.assertEquals;

public class GenericDAOTest {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDAO<User> userDao;
    private GenericDAO<Animal> animalDao;
    private GenericDAO<AverageAnimal> averageAnimalDAO;
    private List<User> users;
    private User testUser;
    int testUserId;
    Role role;
    DatabaseUtility databaseUtility;

    @Before
    public void setUp() throws Exception{
        databaseUtility = new DatabaseUtility();
        databaseUtility.runSQL("cleardb.sql");

        databaseUtility.runSQL("testdb.sql");

        logger.info("setup");
        userDao = new GenericDAO<User>(User.class);
        animalDao = new GenericDAO<Animal>(Animal.class);
        testUser = new User();
        users = userDao.getAll();

        testUser.setId(88);
        testUser.setUserName("testUser");
        testUser.setUserPass("testPass");

        role = new Role();
        role.setUser(testUser);
        role.setUserName(testUser.getUserName());
        role.setName("user");
        testUser.addRole(role);

        Animal testAnimal = new Animal("a","a","a",1,2,3,4,5,6,testUser);

        testUser.addAnimal(testAnimal);
    }

    @Test
    public void createUser() {
        logger.info("createUser");
        testUserId = userDao.create(testUser);
        logger.info("user id =" + testUserId);
        assertEquals(users.size() + 1,userDao.getAll().size());
    }

    @Test
    public void getAllUsers() {
        logger.info("get all users");
        List<User> usersTest = userDao.getAll();
        assertEquals(users.size() ,usersTest.size());
    }

    @Test
    public void getUserById() {
        logger.info("get user by id");
       int findUserById = users.get(0).getId();
        User testFindUserById = userDao.getById(findUserById);
    assertEquals(findUserById,testFindUserById.getId());
    }

    @Test
    public void update() {
        logger.info("update user");

        User updateUserTest = new User();
        updateUserTest.setUserName("UpdateName");
        updateUserTest.setUserPass("something");
        role.setUser(updateUserTest);
        role.setUserName(updateUserTest.getUserName());
        updateUserTest.addRole(role);
        userDao.create(updateUserTest);

        updateUserTest.setUserName("changedName");

        userDao.update(updateUserTest);

        logger.info("user" + updateUserTest.getUserName());
        assertEquals("changedName",updateUserTest.getUserName());
    }

    @Test
    public void deleteUser() {
       logger.info("delete user testUser");
       List<User> findUsers = userDao.findByPropertyEqual("userName","testUser");
       User user = findUsers.get(0);
        logger.info("user found = " + user.getUserName());
        userDao.delete(user);
        assertEquals(users.size() - 1,userDao.getAll().size());
    }

    @Test
    public void findByPropertyEqual() {
    }

    @Test
    public void aveTest(){
        logger.info("ave test");
        List average = animalDao.getAnimalAverageByGroup();
        for ( Object animal : average) {
            String list = Arrays.deepToString((Object[]) animal);
            // TODO: 11/25/19 parse string enter into Averige animaltable 
            JSONArray.parse(list);
            
            logger.info(listt.size());

        }
    }
}