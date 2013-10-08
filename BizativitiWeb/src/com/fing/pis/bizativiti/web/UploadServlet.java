package com.fing.pis.bizativiti.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fing.pis.bizativiti.web.api.FactoryApi;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload/")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // obtenemos archivo
        Part filePart = request.getPart("file"); // obtenemos <input type="file" name="file">
        String filename = getFilename(filePart);
        InputStream filecontent = filePart.getInputStream();
        String ticketId = FactoryApi.getApi().upload(filename, filecontent);
        // TODO: capturar errores
        // devolvemos json: {"status": "ok"/"failed", "ticket_id": xxx}
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        writer.append("{\"status\":\"ok\",\"ticket_id\":\"").append(ticketId).append("\"}");
    }

    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

}