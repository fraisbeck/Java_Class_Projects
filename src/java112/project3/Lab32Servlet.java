package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab 3-2
 *
 *@author    fraisbeck
 */
@WebServlet(
    name = "lab32Servlet",
    urlPatterns = { "/lab32Servlet" }
)
public class Lab32Servlet extends HttpServlet {

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
        out.print("<HEAD><TITLE>Lab 3-2</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>" + request.getServerName() + "</h1>");
        out.print("<p>" + request.getLocale() + "</p>");
        out.print("<p>" + request.getServletContext() + "</p>");
        out.print("<p>" + request.getLocalName() + "</p>");
        out.print("<p>" + request.getScheme() + "</p>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}
