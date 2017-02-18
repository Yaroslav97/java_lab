package ua.nure.poliakov.Task2;

import ua.nure.poliakov.Task2.user.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/call")

public class MainServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Server start");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        resp.setIntHeader("Refresh", 250);

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        if (login != null && password != null) {
            session.setAttribute("login", login);
            session.setAttribute("password", password);
        }

        out.print(login);

        session.setMaxInactiveInterval(100);// 60 seconds

        Forward forward = new Forward();

        UserManager userManager = new UserManager();


        if (userManager.existUser(login)) {

            if (login.equals("admin") && password.equals(userManager.getUser(login).getPassword())) {
                System.out.println(userManager.getList());

                session.setAttribute("usersList", userManager.getList());

                forward.forward("admin.jsp", req, resp);
                System.out.println("Admin");
            }

            else if (login.equals(userManager.getUser(login).getLogin()) && password.equals(userManager.getUser(login).getPassword())) {
                System.out.println(userManager.getList());

                session.setAttribute("usersList", userManager.getList());

                forward.forward("user.jsp", req, resp);
                System.out.println("User: " + login);
            }

            else {
                forward.forward("index.jsp", req, resp);
                System.out.println("login or password is wrong");
            }
        }

        else {
            forward.forward("index.jsp", req, resp);
            System.out.println("account is not exist");
        }

    }
}