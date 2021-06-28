package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.io.IOException;
import java.sql.SQLException;


public class Main {


    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Evander", "Holyfield", (byte) 58);
        userService.saveUser("Roy", "Jones", (byte) 52);
        userService.saveUser("Mike", "Tyson", (byte) 54);
        userService.saveUser("Kostya", "Tszyu", (byte) 51);
        userService.getAllUsers();
        userService.removeUserById(1L);
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
