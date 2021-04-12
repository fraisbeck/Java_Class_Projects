package java112.project3;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a Project3
 *
 *@author    fraisbeck
 */
@WebServlet(
    name = "requestServlet",
    urlPatterns = { "/request-servlet" }
)
public class HttpRequestServlet extends HttpServlet {

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

        HttpRequestData newRequest = new HttpRequestData();

        newRequest.setRemoteComputer(request.getRemoteHost());
        newRequest.setRemoteAddress(request.getRemoteAddr());
        newRequest.setRequestMethod(request.getMethod());
        newRequest.setRequestURI(request.getRequestURI());
        newRequest.setRequestURL(request.getRequestURL());
        newRequest.setProtocolRequest(request.getProtocol());
        newRequest.setServerName(request.getServerName());
        newRequest.setServerPortNumber(request.getServerPort());
        newRequest.setLocaleServer(request.getLocale());
        newRequest.setStringQuery(request.getQueryString());
        newRequest.setQueryParameter(request.getParameter("queryParameter"));
        newRequest.setUserAgent(request.getHeader("User-Agent"));

        request.setAttribute("results", newRequest);

        String url = "/project3HTTPRequestData.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
