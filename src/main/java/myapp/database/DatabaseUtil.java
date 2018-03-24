package myapp.database;

import myapp.models.Document;

import java.util.List;

/**
 * Created by Gundeep on 24/03/18.
 */
public class DatabaseUtil implements InstaDatabase {

    enum InUseDatabase {InMemoryDatabase};

    /**
     * more apt to set in a properties file
     */
    public static InUseDatabase CURRENT_IN_USE_DB = InUseDatabase.InMemoryDatabase;

    @Override
    public boolean saveOrUpdateDocument(Document document) {
        switch (CURRENT_IN_USE_DB) {
            case InMemoryDatabase:
                return InMemoryDB.getInstance().saveOrUpdateDocument(document);
            default:
                return false;
        }
    }

    @Override
    public List<Document> searchDocuments(String searchTerm) {
        switch (CURRENT_IN_USE_DB) {
            case InMemoryDatabase:
                return InMemoryDB.getInstance().searchDocuments(searchTerm);
            default:
                return null;
        }
    }
}
