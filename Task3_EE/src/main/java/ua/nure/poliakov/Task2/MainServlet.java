package ua.nure.poliakov.Task2;

import ua.nure.poliakov.Task2.password.Password;
import ua.nure.poliakov.Task2.user.DBManager;
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

        session.setMaxInactiveInterval(240);

        Forward forward = new Forward();

        DBManager dbManager = new DBManager();

        dbManager.getAllList();

        if (dbManager.existUser(login)) {

            if (dbManager.group(login).equals("admin") && Password.encodePassword(password).equals(dbManager.getUser(login).getPassword())) {
                System.out.println(dbManager.getList());

                session.setAttribute("usersList", dbManager.getAllList());

                session.setAttribute("fullName", dbManager.fullName(login));

                resp.sendRedirect("admin.jsp");

                System.out.println("Admin " + dbManager.fullName(login));
            } else if (dbManager.group(login).equals("user") && Password.encodePassword(password).equals(dbManager.getUser(login).getPassword())) {
                System.out.println(dbManager.getList());

                session.setAttribute("usersList", dbManager.getAllList());
                session.setAttribute("fullName", dbManager.fullName(login));

                forward.forward("user.jsp", req, resp);
                System.out.println("User: " + login);
            } else {
                forward.forward("index.jsp", req, resp);
                System.out.println("login or password is wrong");
            }
        } else {
            forward.forward("index.jsp", req, resp);
            System.out.println("account is not exist");
        }
    }
}
