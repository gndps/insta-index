package myapp.services;

import myapp.database.DatabaseUtil;
import myapp.models.Document;

import java.util.List;

/**
 * Created by Gundeep on 24/03/18.
 */
public class DocumentService {

    public boolean saveData(Document data) {
        return new DatabaseUtil().saveOrUpdateDocument(data);
    }

    public List<Document> searchData(String queryString) {
        return new DatabaseUtil().searchDocuments(queryString);
    }
}
