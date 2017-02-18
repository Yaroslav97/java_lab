package ua.nure.poliakov.Task2.user;

public class User {
    private int id;
    private String fullName;
    private String login;
    private String email;
    private String group;
    private String password;

    public User() {
    }

    public User(String login, String password, String fullName, String email) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }

    public User(String fullName, String login, String email, String group, String password) {
        this.fullName = fullName;
        this.login = login;
        this.email = email;
        this.group = group;
        this.password = password;
    }

    public User(int id, String fullName, String login, String email, String group, String password) {
        this.id = id;
        this.fullName = fullName;
        this.login = login;
        this.email = email;
        this.group = group;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}