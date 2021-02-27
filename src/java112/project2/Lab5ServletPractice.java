package java112.project2;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab and is the second servlet for the course.
 *
 *@author    fRaisbeck
 */
@WebServlet(
    name = "lab5",
    urlPatterns = { "/lab5" }
)
public class Lab5ServletPractice extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */

    private int hitCount;
    private String instantiatedTime;

    public void init() throws ServletException {
        // Reset hit counter
        hitCount = 0;
        log("The init method is executing <= this is from the log");
        instantiatedTime = currentDateTime();
        log(currentDateTime());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        // increment hitCount
        hitCount++;

        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        log("The doGet method is executing <= this is from the log " + hitCount);
        log(currentDateTime());
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Lab5Servlet Output</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Frank Raisbeck Finished Lab 2-5</h1>");
        out.print("<table style='width:50%'>");
        out.print("<tr>");
        out.print("<th>First Date and Time the servlet was accessed</th>");
        out.print("<th>Current date and time</th>");
        out.print("<th>Servlet Hit Counter</th>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>" + instantiatedTime + "</td>");
        out.print("<td>" + currentDateTime() + "</td>");
        out.print("<td>" + hitCount + "</td>");
        out.print("</tr>");
        out.print("</table>");
        out.print("</ br></ br>");
        out.print("<p>The log file doesn't display any information before the Servlet was accessed in the browser.</p>");
        out.print("</ br></ br>");
        out.print("<p>After accessing the Servlet in the browser the log information displays the init information first."
                + "  Right after that the doGet log information is printed out.  And every refresh after or revist afterwards ONLY the"
                + " doGet log information is printed.</p>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

    public String currentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return (dtf.format(now));
    }

}
