package ua.nure.poliakov.Task2;

import ua.nure.poliakov.Task2.user.UserManager;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Forward forward = new Forward();

        HttpSession session = req.getSession();

        UserManager userManager = new UserManager();

        session.setAttribute("usersList", userManager.getList());


        if (req.getParameter("logout") != null) {
            session.invalidate();
            forward.forward("index.jsp", req, resp);
            System.out.println("logout");
        }

    }
}