/*
 * /*
 * KARLA ALEJANDRA GRACIA BARAJAS
*5IM8
 */
 
package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (password.equals("123")) {
            out.print("Bienvenida, " + name);
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            request.getRequestDispatcher("suma.html").include(request, response);
        } else {
            out.print("KARLA ALEJANDRA GRACIA BARAJAS");
            request.getRequestDispatcher("error.html").include(request, response);
        }
        out.close();
    }

}
