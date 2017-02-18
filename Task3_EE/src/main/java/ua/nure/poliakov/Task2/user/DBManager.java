package ua.nure.poliakov.Task2.user;

import ua.nure.poliakov.Task2.connection.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class DBManager extends UserManager {

    private static final String INSERT = "INSERT INTO users (fullName, login, email, `group`, password) VALUES (?, ?, ?, ?, ?)";

    private static final String UPDATE = "UPDATE users SET fullName=?, login=?, email=?, password=? WHERE login=?";

    private static final String SELECT = "SELECT * FROM users;";

    Connect connect = new Connect();

    User user = new User();

    public void add(String fullName, String login, String email, String group, String password) {

        try (PreparedStatement preparedStatement = connect.getConnection().prepareStatement(INSERT)) {

            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, group);
            preparedStatement.setString(5, password);

            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void edit(String fullName, String login, String email, String password) {
        try (PreparedStatement preparedStatement = connect.getConnection().prepareStatement(UPDATE)) {

            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, login);

            preparedStatement.executeUpdate();

            System.out.println("update");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Collection<User> getAllList() {

        Statement statement = null;
        try {
            statement = connect.getConnection().createStatement();

            ResultSet result = statement.executeQuery(SELECT);

            while (result.next()) {
                user.setId(result.getInt("id"));
                user.setFullName(result.getString("fullName"));
                user.setLogin(result.getString("login"));
                user.setEmail(result.getString("email"));
                user.setGroup(result.getString(5));
                user.setPassword(result.getString("password"));

                //System.out.println(user);

                setUser(user.getFullName(), user.getLogin(), user.getEmail(), user.getGroup(), user.getPassword());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return getList();
    }

    public void getByLogin(String login) {

        String query = "select * from users WHERE login='" + login + "';";

        try {
            Statement statement = connect.getConnection().createStatement();

            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                user.setId(result.getInt("id"));
                user.setFullName(result.getString("fullName"));
                user.setLogin(result.getString("login"));
                user.setEmail(result.getString("getEmail"));
                user.setGroup(result.getString(5));
                user.setPassword(result.getString("password"));

                System.out.println(user);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void removeByLogin(String login) {
        try (Statement preparedStatement = connect.getConnection().createStatement();) {
            preparedStatement.execute("DELETE FROM users WHERE login='" + login + "'");

            System.out.println("User where login - " + login + " is removed");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}