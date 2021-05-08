package java112.project3;

import java.io.*;
import java.util.*;
import java112.utilities.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a Project3
 *
 *@author    fraisbeck
 */
@WebServlet(
    name = "project3PropertiesServlet",
    urlPatterns = { "/project3-servlet" }
)
public class PropertiesServlet extends HttpServlet implements PropertiesLoader {

    /**
     * Declare instance variables
     */
    private Properties properties;

    /**
     * Loads the properties file upon loading the web page
     * @throws ServletException [description]
     */
    public void init() throws ServletException {
        properties = loadProperties("/project3.properties");
    }

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

        request.setAttribute("properties", properties);

        String url = "/jsp/properties.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
