package ua.nure.poliakov.Task2;

import ua.nure.poliakov.Task2.user.UserManager;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Forward forward = new Forward();
        HttpSession session = req.getSession();
        UserManager userManager = new UserManager();

        String login = req.getParameter("addLogin");
        String password = req.getParameter("addPassword");
        String name = req.getParameter("addName");
        String email = req.getParameter("addEmail");


        if (req.getParameter("add") != null) {

            session.setAttribute("addLogin", login);
            session.setAttribute("addPassword", password);
            session.setAttribute("addName", name);
            session.setAttribute("addEmail", email);

            if (name.length() >= 5 && login.length() >= 5 && email.length() >= 5 && password.length() >= 4) {

                userManager.setUser(session.getAttribute("addLogin").toString(), session.getAttribute("addPassword").toString(),
                        session.getAttribute("addName").toString(), session.getAttribute("addEmail").toString());

                session.setAttribute("usersList", userManager.getList());
                forward.forward("admin.jsp", req, resp);
            } else {
                forward.forward("/file/add.jsp", req, resp);
            }
        }

    }
}