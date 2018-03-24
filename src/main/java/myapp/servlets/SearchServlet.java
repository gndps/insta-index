package myapp.servlets;

import com.google.appengine.repackaged.com.google.gson.Gson;
import myapp.models.Document;
import myapp.services.DocumentService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Gundeep on 24/03/18.
 */
public class SearchServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String queryString = req.getParameter("query");
        List<Document> docs = new DocumentService().searchData(queryString);
        Gson gson = new Gson();
        String jsonString = gson.toJson(docs);
        resp.setContentType("text/plain");
        resp.getWriter().println(jsonString);
    }

}
