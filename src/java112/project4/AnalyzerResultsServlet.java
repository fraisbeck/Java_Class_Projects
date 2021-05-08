package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.utilities.*;
import java112.analyzer.*;

/**
 *  This will perform searches for employees in the employee database
 *
 *@author    fraisbeck
 */
 @WebServlet(
     name = "AnalyzerResults",
     urlPatterns = { "/analyzerResults" }
 )
 public class AnalyzerResultsServlet extends HttpServlet implements PropertiesLoader {

     // String for the upload directory
     private String uploadDirectory = "C:/uploads";

     /**
      *  Handles HTTP GET requests.
      *
      *@param  request               the HttpRequest
      *@param  response              the HttpResponse
      *@exception  ServletException  if there is a general
      *                              servlet exception
      *@exception  IOException       if there is a general
      *                              I/O exception
      */
     public void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {



        //Create the url
        String url = "/jsp/analyzerResults.jsp";

        //Forward to jsp page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
     }
 }
