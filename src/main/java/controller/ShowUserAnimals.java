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

@WebServlet(name = "showUserAnimals", urlPatterns = {"/UserAnimals"})
public class ShowUserAnimals extends HttpServlet {
    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShowUserAnimals(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShowUserAnimals(req, resp);
    }

    private void ShowUserAnimals(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDAO<User> userDao = new GenericDAO<>(User.class);
        List<User> users = userDao.findByPropertyEqual("userName",req.getRemoteUser());
        logger.debug(users.get(0).getUserName());
        Set<Animal> userAnimals = users.get(0).getAnimals();
        req.setAttribute("userAnimals", userAnimals );

        RequestDispatcher dispatcher = req.getRequestDispatcher("/showUserAnimals" + ".jsp");

        dispatcher.forward(req, resp);
    }
}
