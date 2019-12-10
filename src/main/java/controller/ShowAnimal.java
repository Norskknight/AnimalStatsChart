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

@WebServlet(name = "showAnimal", urlPatterns = {"/showAnimal"})
public class ShowAnimal extends HttpServlet {
    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShowAnimal(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShowAnimal(req, resp);
    }

    private void ShowAnimal(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("show animal");
        GenericDAO<Animal> animalGenericDAO = new GenericDAO<>(Animal.class);
        int animalID = Integer.parseInt(req.getParameter("id"));
        Animal animal = animalGenericDAO.getById(animalID);

        req.setAttribute("animal", animal);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/updateAnimal.jsp");
        dispatcher.forward(req, resp);
    }
}