package jm.task.core.jdbc.dao;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;
import java.util.*;


public class UserDaoJDBCImpl extends Util implements UserDao {

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() throws SQLException, ClassNotFoundException {
        Statement statement = null;
        Connection connection = getConnection();
        try {
            System.out.println("Создание таблицы пользователей в БД");
            statement = connection.createStatement();
            String SQL = "CREATE TABLE mytestjava.users(id INT NOT NULL AUTO_INCREMENT," +
                    " name VARCHAR(45)," +
                    " lastname VARCHAR(45)," +
                    " age INT(3) not NULL, PRIMARY KEY (id))";
            statement.executeUpdate(SQL);
            System.out.println("Таблица пользователей успешно создана");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        }
    }

    public void dropUsersTable() throws SQLException, ClassNotFoundException {
        Statement statement = null;
        Connection connection = getConnection();
        try {
            System.out.println("Удаление таблицы");
            statement = connection.createStatement();
            String SQL = "DROP TABLE users";
            statement.executeUpdate(SQL);
            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) throws ClassNotFoundException, SQLException {
        Statement statement = null;
        Connection connection = getConnection();
        try {
            System.out.println("Сохранение пользователя");
            String SQL = "INSERT INTO users(name, lastName, age) VALUES('" + name + "','" + lastName + "','" + age + "')";
            statement = connection.createStatement();
            statement.executeUpdate(SQL);
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
               if(statement != null) {
                  statement.close();
            }
            if(connection != null) {
              connection.close();
            }
        }
    }

    public void removeUserById(long id) throws SQLException, ClassNotFoundException {
        Statement statement = null;
        Connection connection = getConnection();
        try {
            System.out.println("Удаление пользователя по id");
            statement = connection.createStatement();
            String SQL = "DELETE FROM users WHERE id";
            statement.executeUpdate(SQL);
            System.out.println("Пользователь удален по id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        }
    }

    public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        Statement statement = null;
        List<User> users = new ArrayList<>();
        try {
            System.out.println("Получение всех пользователей");
            statement = connection.createStatement();
            String SQL = "SELECT id, name, lastName, age FROM users";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                System.out.println(user);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        if(statement != null) {
            statement.close();
        }
        if(connection != null) {
            connection.close();
        }
    }
        return users;
    }

    public void cleanUsersTable() throws ClassNotFoundException, SQLException {
        Statement statement = null;
        Connection connection = getConnection();
        try {
            System.out.println("Очистка таблицы");
            statement = connection.createStatement();
            String SQL = "DELETE from users";
            statement.executeUpdate(SQL);
            System.out.println("Таблица удачно очищена");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        }
    }
}