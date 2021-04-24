package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab 2 Unit 4
 *
 *@author    fraisbeck
 */
@WebServlet(
    name = "JSTLLab1Servlet",
    urlPatterns = { "/JSTLLab1Servlet" }
)
public class JSTLLab1Servlet extends HttpServlet {

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

            List frankWords = new ArrayList();
            frankWords.add("Video Games");
            frankWords.add("Coding");
            frankWords.add("Puzzles");
            frankWords.add("Board Games");
            frankWords.add("DnD");
            frankWords.add("Volley Ball");
            frankWords.add("Card Games");
            frankWords.add("Comic Books");

            request.setAttribute("myList", frankWords);

            String url = "/jstl-lab2.jsp";

            RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

    }
}
