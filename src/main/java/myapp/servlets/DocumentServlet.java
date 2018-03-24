package myapp.servlets;

import com.google.appengine.repackaged.com.google.gson.Gson;
import myapp.models.Document;
import myapp.services.DocumentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Gundeep on 22/03/18.
 */

public class DocumentServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BufferedReader reader = request.getReader();
        Gson gson = new Gson();
        Document doc = gson.fromJson(reader, Document.class);
        boolean saved = new DocumentService().saveData(doc);
        response.setContentType("text/plain");
        response.getWriter().println("{ \"saved\": \"" + (saved?"true":"false") + "\" }");

    }

}
