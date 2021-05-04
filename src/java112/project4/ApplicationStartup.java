package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.utilities.*;
import java112.employee.*;

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
        Properties properties = loadProperties("/project4.properties");
        context.setAttribute("project4Properties", properties);
        EmployeeDirectory employeeDirectory = new EmployeeDirectory(properties);
        context.setAttribute("employeeDirectory", employeeDirectory);
    }
}
