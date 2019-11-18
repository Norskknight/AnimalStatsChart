package controller;

import entity.Animal;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import persistence.GenericDAO;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "addAnimal", urlPatterns = {"/addAnimal"})
public class AddAnimal extends HttpServlet {

    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDAO<User> userDao = new GenericDAO<>(User.class);
        GenericDAO<Animal> animalGenericDAO = new GenericDAO<>(Animal.class);

        //get list of users by id
        logger.debug(req.getRemoteUser());
        List users = userDao.findByPropertyEqual("Userid",req.getRemoteUser());
        User user = (User)users.get(0);
        logger.debug(user);

        //create animal from user information
        Animal animal = new Animal(
                req.getParameter("name"),
                req.getParameter("class"),
                req.getParameter("fiction"),
                Integer.parseInt(req.getParameter("health")),
                Integer.parseInt(req.getParameter("stamina")),
                Integer.parseInt(req.getParameter("strength")),
                Integer.parseInt(req.getParameter("agility")),
                Integer.parseInt(req.getParameter("dexterity")),
                Integer.parseInt(req.getParameter("intelligence")),
                user
        );

        //add the animal to the users list
        int id = animalGenericDAO.create(animal);
        logger.debug(id);
        String message = "<p> Latest Animal added" + animal.getName()+"</p>";

        RequestDispatcher dispatcher = req.getRequestDispatcher("/showUserAnimals.jsp");
        // This will be available as ${message}
        req.setAttribute("message", message);
        dispatcher.forward(req, resp);
    }
}
