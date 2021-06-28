package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void createUsersTable() throws SQLException, ClassNotFoundException, IOException;

    void dropUsersTable() throws SQLException, ClassNotFoundException, IOException;

    void saveUser(String name, String lastName, byte age) throws SQLException, ClassNotFoundException;

    void removeUserById(long id) throws SQLException, ClassNotFoundException;

    List<User> getAllUsers() throws ClassNotFoundException, SQLException;

    void cleanUsersTable() throws ClassNotFoundException, SQLException;

}
