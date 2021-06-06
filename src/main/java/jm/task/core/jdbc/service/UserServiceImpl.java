package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

    public void createUsersTable() throws SQLException, ClassNotFoundException {
        userDaoJDBC.createUsersTable();
    }

    public void dropUsersTable() throws SQLException, ClassNotFoundException {
        userDaoJDBC.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws ClassNotFoundException, SQLException {
        userDaoJDBC.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws SQLException, ClassNotFoundException {
        userDaoJDBC.removeUserById(id);
    }

    public List<User> getAllUsers() throws ClassNotFoundException, SQLException {

        return userDaoJDBC.getAllUsers();
    }

    public void cleanUsersTable() throws ClassNotFoundException, SQLException {
        userDaoJDBC.cleanUsersTable();
    }
}
