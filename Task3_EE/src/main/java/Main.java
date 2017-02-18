import ua.nure.poliakov.Task2.user.DBManager;

import java.sql.*;

public class Main {

    //private static final String URL = "jdbc:mysql://localhost:3306/usersdb?user=root&password=poliak1997&autoReconnect=true&useSSL=false";

    public static void main(String[] args) throws SQLException {

       /* try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL); Statement statement = connection.createStatement()) {

            //statement.execute("INSERT INTO users (fullName, login, getEmail, `group`, password) VALUES ('Patrick Star', 'star', 'star@nure.ua', 'user', 'star');");
            //statement.executeUpdate("UPDATE users SET id=4 WHERE id=9;");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");
            System.out.println(resultSet);

            System.out.println("Connect");
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
/*

       String query = "select * from users;";
       String insert = "INSERT INTO users (fullName, login, getEmail, `group`, password) VALUES (?, ?, ?, ?, ?);";

        User user = new User();

        Connect connect = new Connect();




        PreparedStatement preparedStatement = connect.getConnection().prepareStatement(insert);

        preparedStatement.setString(1, "b");
        preparedStatement.setString(2, "c");
        preparedStatement.setString(3, "d");
        preparedStatement.setString(4, "e");
        preparedStatement.setString(5, "a");

        preparedStatement.execute();




        Statement statement = connect.getConnection().createStatement();
        ResultSet result = statement.executeQuery(query);
*/
/*
        while (result.next()){
            user.setId(result.getInt("id"));
            user.setFullName(result.getString("fullName"));
            user.setLogin(result.getString("login"));
            user.setEmail(result.getString("getEmail"));
            user.setGroup(result.getString(5));
            user.setPassword(result.getString("password"));

            System.out.println(user);
        }*/


        DBManager dbManager = new DBManager();
        //dbManager.add("name", "login", "getEmail", "user", "pass");
        //dbManager.add("name1", "login1", "email1", "user1", "pass1");
        //dbManager.edit("namsdd", "cor", "getEmail", "pass"); //do not work
        //dbManager.getByLogin("admin");


        //dbManager.add("John Shoo","cor","cor@nure.ua", "user", "cor" );


        //dbManager.removeByLogin("login");

        //dbManager.getAllList();

        System.out.println();

        System.out.println(dbManager.getAllList());
    }
}