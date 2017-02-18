package ua.nure.poliakov.Task2.remove;

import ua.nure.poliakov.Task2.Forward;
import ua.nure.poliakov.Task2.user.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deleteServlet")

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserManager userManager = new UserManager();
        HttpSession session = req.getSession();

        Forward forward = new Forward();

        if (req.getParameter("del") != null) {
            userManager.removeUser(session.getAttribute("delLogin").toString());
            forward.forward("admin.jsp", req, resp);
            System.out.println("delete " + session.getAttribute("delLogin").toString());
        }
    }
}