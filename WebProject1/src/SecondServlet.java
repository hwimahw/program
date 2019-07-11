import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/hello")
public class SecondServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // получаем сессию
        HttpSession session = request.getSession();
        // получаем объект name
        String name = (String) session.getAttribute("name");

        PrintWriter out = response.getWriter();
        try {
            // если объект ранее не установлен
            if(name == null) {
                // устанавливаем объект с ключом name
                session.setAttribute("name", "Tom Soyer");
                out.println("Session data are set");
            }
            else {
                out.println("Name: " + name);
            }
        }
        finally {
            out.close();
        }
    }
}