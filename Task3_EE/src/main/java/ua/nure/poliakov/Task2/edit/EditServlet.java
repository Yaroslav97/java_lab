package ua.nure.poliakov.Task2.edit;

import ua.nure.poliakov.Task2.Forward;
import ua.nure.poliakov.Task2.password.Password;
import ua.nure.poliakov.Task2.user.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/editServlet")
public class EditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Forward forward = new Forward();
        HttpSession session = req.getSession();

        String name = req.getParameter("editName");
        String email = req.getParameter("editEmail");
        String password = req.getParameter("editPassword");

        DBManager dbManager = new DBManager();

        dbManager.getAllList();

        if (req.getParameter("edit") != null) {
            if (name.length() >= 4 && email.length() >= 4 && password.length() >= 4) {
                dbManager.edit(name, session.getAttribute("eLogin").toString(), email, Password.encodePassword(password));

                session.setAttribute("usersList", dbManager.getAllList());

                System.out.println("update " + session.getAttribute("eLogin").toString());
            } else {
                forward.forward("/file/edit.jsp", req, resp);
            }

            if (dbManager.group(session.getAttribute("login").toString()).equals("admin")) {
                forward.forward("admin.jsp", req, resp);
            } else {
                forward.forward("user.jsp", req, resp);
            }
        }
    }
}