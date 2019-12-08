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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SearchByName(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SearchByName(req, resp);
    }

    private void SearchByName(HttpServletRequest req, HttpServletResponse resp) {
        // TODO: 12/8/19 req get animal id and params update animal
    }


}
