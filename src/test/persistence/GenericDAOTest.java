package persistence;

import entity.Role;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GenericDAOTest {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDAO<User> userDao;
    private List<User> users;
    private User testUser;
    int testUserId;
    Role role;
    @Before
    public void setUp() throws Exception{

        logger.info("setup");
        userDao = new GenericDAO<User>(User.class);
        testUser = new User();
        users = userDao.getAll();

        testUser.setId(1);
        testUser.setUserName("testUser");
        testUser.setUserPass("testPass");


        role = new Role();
        role.setUser(testUser);
        role.setUserName(testUser.getUserName());
        role.setName("user");
        testUser.addRole(role);

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
}