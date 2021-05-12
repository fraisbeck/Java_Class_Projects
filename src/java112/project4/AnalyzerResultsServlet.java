package java112.project4;

import java.io.*;
import java.util.*;
import java.lang.Object.*;
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
 @MultipartConfig

 public class AnalyzerResultsServlet extends HttpServlet implements PropertiesLoader {

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

        // Create a session Variable
        HttpSession session = request.getSession();
        String analyzerProperties = "/project4Analyzer.properties";
        Part filePart = request.getPart("uploadedFile");
        String fileName = filePart.getSubmittedFileName();
        filePart.write(fileName);

        String path = "/home/student/tomcat/work/Catalina/localhost/java112/" + fileName;
        String[] input = new String[]{path, analyzerProperties};

        FileAnalysis analyzer = new FileAnalysis();
        analyzer.analyze(input);

        String success = fileName + " has been uploaded and analyzed.  Click the links below to see the results.";
        session.setAttribute("success", success);

        //Create the url
        String url = "/jsp/analyzerResults.jsp";

        //Forward to jsp page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
     }
 }
