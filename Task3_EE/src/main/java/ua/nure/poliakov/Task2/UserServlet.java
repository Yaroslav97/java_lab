package ua.nure.poliakov.Task2;

import ua.nure.poliakov.Task2.user.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/userServlet")

public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Forward forward = new Forward();
        HttpSession session = req.getSession();
        DBManager dbManager = new DBManager();

        session.setAttribute("usersList", dbManager.getAllList());

        if (req.getParameter("logout") != null) {
            session.invalidate();
            resp.sendRedirect("index.jsp");
            System.out.println("logout");
        }
    }
}
