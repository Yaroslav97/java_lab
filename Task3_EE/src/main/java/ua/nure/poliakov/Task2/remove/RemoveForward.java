package ua.nure.poliakov.Task2.remove;

import ua.nure.poliakov.Task2.Forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/removeForward")

public class RemoveForward extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = req.getParameter("delLogin");
        session.setAttribute("delLogin", login);

        Forward forward = new Forward();
        forward.forward("/file/remove.jsp", req, resp);
    }
}