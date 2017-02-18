package ua.nure.poliakov.Task2.user;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

public class UserManager {
    private static final Map<String, User> users = new Hashtable<String, User>();

    public void removeUser(String login) {
        users.remove(login);
    }

    public User getUser(String login) {
        return users.get(login);
    }

    public int getSize() {
        return users.size();
    }

    public void getListFullName() {
        for (Map.Entry<String, User> item : users.entrySet()) {
            System.out.printf("Value: %s \n", item.getValue().getFullName());
        }
    }

    public String fullName(String login) {
        return users.get(login).getFullName();
    }

    public String group(String login) {
        return users.get(login).getGroup();
    }

    public boolean existUser(String login) {
        if (users.containsKey(login)) {
            return true;
        }
        return false;
    }

    public User setUser(String fullName, String login, String email, String group, String password) {
        return users.put(login, new User(fullName, login, email, group, password));
    }

    public Collection<User> getList() {
        return users.values();
    }
}