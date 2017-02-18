package ua.nure.poliakov.Task2.edit;

import ua.nure.poliakov.Task2.Forward;
import ua.nure.poliakov.Task2.user.UserManager;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserManager userManager = new UserManager();
        Forward forward = new Forward();
        HttpSession session = req.getSession();

        String name = req.getParameter("editName");
        String email = req.getParameter("editEmail");
        String password = req.getParameter("editPassword");

        if (req.getParameter("edit") != null) {
            if (name.length() >= 5 && email.length() >= 5 && password.length() >= 4) {
                userManager.setUser(session.getAttribute("eLogin").toString(), password, name, email);
                System.out.println("update " + session.getAttribute("eLogin").toString());
            }
            else {
                forward.forward("/file/edit.jsp", req, resp);
            }

            if(session.getAttribute("login").toString().equals("admin")){
                forward.forward("admin.jsp", req, resp);
            }
            else {
                forward.forward("user.jsp", req, resp);
            }
            session.invalidate();
        }
    }
}