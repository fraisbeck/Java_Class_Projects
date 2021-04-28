package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab 4-2 Unit 4
 *
 *@author    fraisbeck
 */
@WebServlet(
    name = "Project4SessionLab",
    urlPatterns = { "/Project4SessionLab" }
)
public class Project4SessionLab extends HttpServlet {

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
            PrintWriter out = response.getWriter();

            HttpSession session = request.getSession();
            Integer sessionCounter = (Integer) session.getAttribute("project4SessionCounter");
            String title = "Session Attribute";

            if (sessionCounter != null) {
                sessionCounter++;
            } if (sessionCounter == null) {
                sessionCounter = 1;
            }

            session.setAttribute("title", title);
            session.setAttribute("project4SessionCounter", sessionCounter);
            String url = "/project4Session.jsp";

            RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

    }
}
