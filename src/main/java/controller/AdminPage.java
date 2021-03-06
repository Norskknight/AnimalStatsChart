package controller;

import entity.Animal;
import persistence.GenericDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "adminPage", urlPatterns = { "/admin"})
public class AdminPage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDAO<Animal> animalGenericDAO = new GenericDAO<>(Animal.class);
        List animals = animalGenericDAO.getAll();
        req.setAttribute("Animals", animals );

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin" + ".jsp");

        dispatcher.forward(req, resp);

    }
}
