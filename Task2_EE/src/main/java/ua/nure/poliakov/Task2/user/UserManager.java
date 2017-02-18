package ua.nure.poliakov.Task2.user;

import ua.nure.poliakov.Task2.user.User;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by comteh on 24.10.2016.
 */
public class UserManager {
    private static final Map<String, User> users = new Hashtable<String, User>();

    static {
        users.put("login1", new User("login1", "login1", "John Smith", "john.smith@task2.nure.ua"));
        users.put("login2", new User("login2", "login2", "Jack Jones", "jack.jones@task2.nure.ua"));
        users.put("login3", new User("login3", "login3", "Patric Star", "patric.star@task2.nure.ua"));
        users.put("admin", new User("admin", "pass", "ua.nure.poliakov.Task2.Admin", "admin@task2.nure.ua"));
    }

    public void removeUser(String login) {
        users.remove(login);
    }

    public User getUser(String login) {
        return users.get(login);
    }

    public int getSize() {
        return users.size();
    }

    public Map<String, User> getMapUsers() {
        return users;
    }

    public Collection<User> getUsers() {
        return users.values();
    }

    public void getListLogin() {
        for (Map.Entry<String, User> item : users.entrySet()) {
            System.out.printf("Value: %s \n", item.getValue().getLogin());
        }
    }

    public void getListFullName() {
        for (Map.Entry<String, User> item : users.entrySet()) {
            System.out.printf("Value: %s \n", item.getValue().getFullName());
        }
    }

    public void getListEmail() {
        for (Map.Entry<String, User> item : users.entrySet()) {
            System.out.printf("Value: %s \n", item.getValue().getEmail());
        }
    }

    public boolean existUser(String login) {
        if (users.containsKey(login)) {
            return true;
        }
        return false;
    }

    public User setUser(String login, String password, String fullName, String email) {
        return users.put(login, new User(login, password, fullName, email));
    }

    private boolean check(String email) {
        Pattern p = Pattern.compile("^[a-z0-9\\.]+@task2.nure.ua$");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public Collection<User> getList() {
        return users.values();
    }
}
