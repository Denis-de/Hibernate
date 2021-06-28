package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
//import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserServiceImpl implements UserService {

   // UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
    UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

    public void createUsersTable() throws SQLException, ClassNotFoundException, IOException {
        //userDaoJDBC.createUsersTable();
        userDaoHibernate.createUsersTable();
    }

    public void dropUsersTable() throws SQLException, ClassNotFoundException, IOException {
        //userDaoJDBC.dropUsersTable();
        userDaoHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws ClassNotFoundException, SQLException {
        //userDaoJDBC.saveUser(name, lastName, age);
        userDaoHibernate.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws SQLException, ClassNotFoundException {
        //userDaoJDBC.removeUserById(id);
        userDaoHibernate.removeUserById(1L);
    }

    public List<User> getAllUsers() throws ClassNotFoundException, SQLException {

        return userDaoHibernate.getAllUsers();
       // return userDaoJDBC.getAllUsers();
    }

    public void cleanUsersTable() throws ClassNotFoundException, SQLException {
       // userDaoJDBC.cleanUsersTable();
        userDaoHibernate.cleanUsersTable();
    }
}
