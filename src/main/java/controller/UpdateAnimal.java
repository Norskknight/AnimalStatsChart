package controller;

import entity.Animal;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet(name = "updateAnimal", urlPatterns = {"/updateAnimal"})
public class UpdateAnimal extends HttpServlet {
    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UpdateAnimal(req, resp);
    }

    private void UpdateAnimal(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(req.getParameter("job") + " Animal by id");
        GenericDAO<Animal> animalGenericDAO = new GenericDAO<>(Animal.class);
        Animal animal = animalGenericDAO.getById(Integer.parseInt(req.getParameter("id")));
        RequestDispatcher dispatcher;

        if (!req.getRemoteUser().equals(animal.getUser().getUserName())){
            String message = animal.getName() +" with ID: " + animal.getId() + " is not your animal";
            req.setAttribute("message" ,message);

            dispatcher = req.getRequestDispatcher("/UserAnimals");
            dispatcher.forward(req, resp);
        } else {

            if (req.getParameter("job").equals("Delete")){
                logger.info("Delete Animal by id");
                animalGenericDAO.delete(animal);

                String message = animal.getName() +" with ID: " + animal.getId() + " Has been deleted";
                req.setAttribute("message" ,message);

                dispatcher = req.getRequestDispatcher("/UserAnimals");
            } else {
                logger.info("Update Animal by id");

                animal.setName(req.getParameter("name"));
                animal.setAnimalClass(req.getParameter("class"));
                animal.setFiction(req.getParameter("fiction"));
                animal.setHealth(Integer.parseInt(req.getParameter("health")));
                animal.setStamina(Integer.parseInt(req.getParameter("stamina")));
                animal.setStrength(Integer.parseInt(req.getParameter("strength")));
                animal.setAgility(Integer.parseInt(req.getParameter("agility")));
                animal.setDexterity(Integer.parseInt(req.getParameter("dexterity")));
                animal.setIntelligence(Integer.parseInt(req.getParameter("intelligence")));

                animalGenericDAO.update(animal);


                String message = animal.getName() +" with ID: " + animal.getId() + " Has been Updated";
                req.setAttribute("message" ,message);
                dispatcher = req.getRequestDispatcher("/UserAnimals");
            }
            dispatcher.forward(req, resp);
        }
    }
}
