package java112.project3;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab 3-2
 *
 *@author    fraisbeck
 */
@WebServlet(
    name = "lab33Servlet",
    urlPatterns = { "/lab33Servlet" }
)
public class Lab33Servlet extends HttpServlet {

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

        Map map = new HashMap();

        map.put("number", 42);
        map.put("text", "This is some sample text.");
        map.put("html", "<h2>This is a Header 2</h2>");
        map.put("aDate", new Date());

        request.setAttribute("myMap", map);

        String url = "/jsp/lab33.jsp";

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
