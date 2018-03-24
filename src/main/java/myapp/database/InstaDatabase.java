package myapp.database;

import myapp.models.Document;

import java.util.List;

/**
 * Created by Gundeep on 24/03/18.
 */
public interface InstaDatabase {

    public boolean saveOrUpdateDocument(Document document);
    public List<Document> searchDocuments(String searchTerm);

}
