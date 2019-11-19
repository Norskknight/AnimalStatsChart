package controller;

import entity.Role;
import entity.User;
import persistence.GenericDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet(name= "SignUpUser", urlPatterns = {"/signUpUser"})
public class AddUser extends HttpServlet {

    private Logger logger = LogManager.getLogger(this.getClass());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDAO<User> userDao = new GenericDAO<>(User.class);

        //create user
        User user = new User();
        logger.debug("name="+req.getParameter("userName"));
        user.setUserName(req.getParameter("userName"));
        // TODO: 11/18/19 salt password
        user.setUserPass(req.getParameter("userPass"));
        logger.debug(user.getId());

        //create role 'user' for user 'admin' for admin
        Role role =new Role();
        role.setUser(user);
        role.setName("user");
        user.addRole(role);
        logger.debug("size="+user.getRole().size());

        //add user with dao
        int userId = userDao.create(user);
        logger.debug("id="+userId);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}
