package com.fing.pis.bizativiti.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fing.pis.bizativiti.web.Util.Extension;
import com.fing.pis.bizativiti.web.Util.ParsedUrl;

/**
 * Servlet implementation class StatusServlet
 */
@WebServlet("/status/*")
public class StatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ParsedUrl parsedUrl = Util.parseUrl(request.getPathInfo());
        if (parsedUrl.isValid()) {
            if (parsedUrl.getExtension() == Extension.HTML) {
                response.getOutputStream().print(
                        String.format("<html><body>Ticket <strong>%s</strong></body></html>", parsedUrl.getTicketId()));
            } else if (parsedUrl.getExtension() == Extension.JSON) {
                response.setContentType("application/json");
                response.getOutputStream().print("{\"ticketId\":\"" + parsedUrl.getTicketId() + "\"}");
            } else {
                // no sabemos manejar la extensión
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}