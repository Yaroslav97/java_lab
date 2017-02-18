package ua.nure.poliakov.Task2.edit;

import ua.nure.poliakov.Task2.Forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/editForward")
public class EditForward extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String login = req.getParameter("eLogin");
        String email = req.getParameter("eEmail");
        String fullName = req.getParameter("eFullName");
        String password = req.getParameter("ePassword");

        session.setAttribute("eLogin", login);
        session.setAttribute("eEmail", email);
        session.setAttribute("eFullName", fullName);
        session.setAttribute("ePassword", password);

        Forward forward = new Forward();
        forward.forward("/file/edit.jsp", req, resp);
    }
}
