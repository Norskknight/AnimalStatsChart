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

@WebServlet(name = "deleteAnimal", urlPatterns = {"/deleteAnimal"})
public class DeleteAnimal extends HttpServlet {
    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DeleteAnimalByid(req, resp);
    }

    private void DeleteAnimalByid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("animalId"));
        logger.info(id);
        GenericDAO<Animal> animalGenericDAO = new GenericDAO<>(Animal.class);
        Animal animal = animalGenericDAO.getById(id);
        logger.info(animal.getId());
        animalGenericDAO.delete(animal);
        String message = animal.getName() + " with id " +animal.getId()+ " Has been deleted";
        req.setAttribute("message", message);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin");

        dispatcher.forward(req, resp);
    }


}
