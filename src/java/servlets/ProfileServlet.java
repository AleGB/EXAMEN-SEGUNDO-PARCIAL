/*
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

public class ProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);
        String numero1 = request.getParameter("num1");
        String numero2 = request.getParameter("num2");
        int NUM1 = Integer.parseInt(numero1);
        int NUM2 = Integer.parseInt(numero2);
        HttpSession session = request.getSession(false);
        if (session != null) {
            String name = (String) session.getAttribute("name");
            int resultado = NUM1 + NUM2;
            String re = String.valueOf(resultado);
            session.setAttribute("result", re);
//            String result = (String) session.getAttribute("re");
            out.print("Hola, " + name + " estas en tu perfil, revisa tu resultado ");
            out.print("------------------------->");
            out.print(" El resultado de la suma es, " + re);
        } else {
            out.print("Primero debes inciar sesion");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        out.close();
    }
}
