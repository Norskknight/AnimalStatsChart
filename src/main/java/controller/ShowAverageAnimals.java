package controller;

import entity.Animal;
import entity.AverageAnimal;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "showAveAnimals", urlPatterns = {"/averageAnimals"})
public class ShowAverageAnimals extends HttpServlet {

    private Logger logger = LogManager.getLogger(this.getClass());
    GenericDAO<AverageAnimal> averageAnimalGenericDAO;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       showAverageAnimals(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showAverageAnimals(req,resp);
    }

    private void showAverageAnimals(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Show Average Animals in Servlet");
        LocalDateTime now = LocalDateTime.now();
        logger.info(now);

        GenericDAO<Animal> animalGenericDAO = new GenericDAO<>(Animal.class);

        animalGenericDAO.getAnimalAverageByGroup();

        averageAnimalGenericDAO = new GenericDAO<>(AverageAnimal.class);

        List<AverageAnimal> averageAnimalsList = averageAnimalGenericDAO.getAll();
        logger.info(averageAnimalsList.size());
        req.setAttribute("averageAnimals", averageAnimalsList );

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index" + ".jsp");

        dispatcher.forward(req, resp);
    }
}
