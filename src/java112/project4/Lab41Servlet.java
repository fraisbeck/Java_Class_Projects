package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab 4-1 Unit 4
 *
 *@author    fraisbeck
 */
@WebServlet(
    name = "Lab41Servlet",
    urlPatterns = { "/Lab41Servlet" }
)
public class Lab41Servlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

            PrintWriter out = response.getWriter();
            out.print("<HTML>");
            out.print("<HEAD><TITLE>Lab 4-1</TITLE></HEAD>");
            out.print("<BODY>");
            out.print("<p>The first name entered: " + request.getParameter("firstName") + "</p>");
            out.print("<p>The last name entered: " + request.getParameter("lastName") + "</p>");
            out.print("<p>The pronoun choice entered: " + request.getParameter("sexChoice") + "</p>");
            out.print("</BODY>");
            out.print("</HTML>");
            out.close();

    }
}
