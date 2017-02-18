package ua.nure.poliakov.Task2.remove;

import ua.nure.poliakov.Task2.Forward;
import ua.nure.poliakov.Task2.user.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/removeServlet")

public class RemoveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbManager = new DBManager();

        HttpSession session = req.getSession();

        Forward forward = new Forward();

        if (req.getParameter("del") != null) {
            dbManager.removeByLogin(session.getAttribute("delLogin").toString());
            dbManager.removeUser(session.getAttribute("delLogin").toString());

            session.setAttribute("usersList", dbManager.getAllList());

            System.out.println("delete " + session.getAttribute("delLogin").toString());
            forward.forward("admin.jsp", req, resp);
        }
    }
}