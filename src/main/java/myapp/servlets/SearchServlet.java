package myapp.servlets;

import com.google.appengine.repackaged.com.google.gson.Gson;
import myapp.models.Document;
import myapp.models.SearchResult;
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
        SearchResult result = new SearchResult(docs);
        Gson gson = new Gson();
        String jsonString = gson.toJson(result);
        resp.setContentType("application/json");
        resp.getWriter().println(jsonString);
    }

}
