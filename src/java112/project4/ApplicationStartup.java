package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.utilities.*;
import java112.employee.*;
import java112.analyzer.*;

/**
 *  This will perform the initialization for the application
 *
 *@author    fraisbeck
 */
@WebServlet(
    name = "applicationStartup",
    urlPatterns = { "/project4-Startup" },
    loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet implements PropertiesLoader {
    /**
     * Loads the properties file upon loading the web page
     * @throws ServletException [description]
     */

    public void init() {
        ServletContext context = getServletContext();
        Properties project4Properties = loadProperties("/project4.properties");
        context.setAttribute("project4Properties", project4Properties);
        EmployeeDirectory employeeDirectory = new EmployeeDirectory(project4Properties);
        context.setAttribute("employeeDirectory", employeeDirectory);
    }
}
