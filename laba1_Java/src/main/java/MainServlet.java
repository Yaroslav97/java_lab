import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by comteh on 10.10.2016.
 */

@WebServlet("/call")

public class MainServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        int result = 0;

        int x = Integer.parseInt(req.getParameter("x"));
        int y = Integer.parseInt(req.getParameter("y"));

        char val = req.getParameter("operation").charAt(0);


        switch (val) {
            case '+':
                result = x + y;
                out.println("<a href='http://localhost:8086/index.jsp'>Home</a>\n<br>");
                out.printf("Result: %d ", result);
                break;
            case '-':
                result = x - y;
                out.println("<a href='http://localhost:8086/index.jsp'>Home</a>\n<br>");
                out.printf("Result: %d ", result);
                break;
            case '*':
                result = x * y;
                out.println("<a href='http://localhost:8086/index.jsp'>Home</a>\n<br>");
                out.printf("Result: %d ", result);
                break;
            case '/':
                if (y == 0) {
                    System.out.println("/by zero");
                    out.print("/by zero");
                } else {
                    result = x / y;
                    out.println("<a href='http://localhost:8086/index.jsp'>Home</a>\n<br>");
                    out.printf("Result: %d ", result);
                }
                break;
        }
    }
}
