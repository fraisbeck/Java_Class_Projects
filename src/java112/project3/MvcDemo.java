package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * @author fRaisbeck
 *
 */
@WebServlet(
    name = "mvcDemo",
    urlPatterns = { "/mvc-demo" }
)
public class MvcDemo extends HttpServlet {

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

        BeanOne myBean = new BeanOne();

        myBean.setData("I'm special!");

        request.setAttribute("myCoolBean", myBean);

        String url = "/jsp/beanOneDemo.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
