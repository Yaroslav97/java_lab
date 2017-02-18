package ua.nure.poliakov.Task2;

import ua.nure.poliakov.Task2.password.Password;
import ua.nure.poliakov.Task2.user.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addUserServlet")

public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Forward forward = new Forward();
        HttpSession session = req.getSession();

        String name = req.getParameter("addName");
        String login = req.getParameter("addLogin");
        String email = req.getParameter("addEmail");
        String group = req.getParameter("addGroup");
        String password = req.getParameter("addPassword");


        if (req.getParameter("add") != null) {

            session.setAttribute("addName", name);
            session.setAttribute("addLogin", login);
            session.setAttribute("addEmail", email);
            session.setAttribute("addGroup", group);
            session.setAttribute("addPassword", password);

            if (name.length() >= 4 && login.length() >= 4 && email.length() >= 4 && password.length() >= 4) {

                DBManager dbManager = new DBManager();
                dbManager.add(name, login, email, group, Password.encodePassword(password));

                session.setAttribute("usersList", dbManager.getAllList());

                System.out.println("account for " + name + " added to DB");

                forward.forward("admin.jsp", req, resp);
            } else {
                forward.forward("/file/add.jsp", req, resp);
            }
        }
    }
}