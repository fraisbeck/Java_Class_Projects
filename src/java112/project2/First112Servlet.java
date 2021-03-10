package java112.project2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of Project 2 and is the first servlet for the course.
 *
 *@author    fRaisbeck
 */
@WebServlet(
    name = "first112Servlet",
    urlPatterns = { "/first" }
)
public class First112Servlet extends HttpServlet {
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
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>First112Servlet Output</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Frank Raisbeck Java Programming 112 Spring 2021</h1>");
        out.print("<a href='/java112'>Back to the homepage</a>");
        out.print("</br></br>");
        out.print("<img src='images/javaFirstServlet.jpg' class='post-img' alt='Java Image' />");
        out.print("</br>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}
