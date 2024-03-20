package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import command.ActionCommand;
import command.factory.ActionFactory;
import resource.ConfigurationManager;
import resource.MessageManager;

/**
 * The FrontController class represents a controller handling incoming requests in a web application.
 * It processes both GET and POST requests and delegates commands to execute specific actions.
 */
public class FrontController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    /**
     * Handles incoming GET requests by processing them through the processRequest method.
     *
     * @param request  The HttpServletRequest object containing the request made by the client.
     * @param response The HttpServletResponse object for sending the response to the client.
     * @throws ServletException If a servlet-specific problem occurs.
     * @throws IOException      If an input or output error occurs while the servlet is handling the GET request.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles incoming POST requests by processing them through the processRequest method.
     *
     * @param request  The HttpServletRequest object containing the request made by the client.
     * @param response The HttpServletResponse object for sending the response to the client.
     * @throws ServletException If a servlet-specific problem occurs.
     * @throws IOException      If an input or output error occurs while the servlet is handling the POST request.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Processes the incoming request, determines the command, and executes the appropriate action.
     *
     * @param request  The HttpServletRequest object containing the request made by the client.
     * @param response The HttpServletResponse object for sending the response to the client.
     * @throws ServletException If a servlet-specific problem occurs.
     * @throws IOException      If an input or output error occurs while processing the request.
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        // Determines the command coming from the JSP
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);

        // Calls the execute() method and passes parameters to the specific command handler class
        page = command.execute(request);

        // Returns the response page
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            // Forwards the request to the response page
            dispatcher.forward(request, response);
        } else {
            // Sets up the page with an error message
            page = ConfigurationManager.getProperty("path.page.index"); // /index.jsp
            request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
            request.getSession().invalidate();
        }
    }
}
