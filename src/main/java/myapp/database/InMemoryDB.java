package myapp.database;

import myapp.models.Document;
import myapp.stringprocessing.StringProcessor;

import java.util.*;

/**
 * Created by Gundeep on 24/03/18.
 */
public class InMemoryDB implements InstaDatabase {

    public static InMemoryDB instance;
    public HashMap<Integer, String> inMemoryDatabase;

    public static InMemoryDB getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new InMemoryDB();
            return instance;
        }
    }

    public Document getDocumentById(int id) {
        if (inMemoryDatabase != null && inMemoryDatabase.containsKey(id)) {
            String val = inMemoryDatabase.get(id);
            return new Document(id, val);
        } else {
            return null;
        }
    }

    @Override
    public boolean saveOrUpdateDocument(Document document) {
        if (document == null) {
            return false;
        }

        if (getDocumentById(document.getId()) != null) {
            return udpateDocument(document);
        } else {
            return saveDocument(document);
        }
    }

    private boolean udpateDocument(Document document) {
        if (inMemoryDatabase == null) {
            return false;
        }
        inMemoryDatabase.put(document.getId(), document.getText());
        return true;
    }

    private boolean saveDocument(Document document) {
        if (inMemoryDatabase == null) {
            inMemoryDatabase = new HashMap<>();
        }
        inMemoryDatabase.put(document.getId(), document.getText());
        return true;
    }

    @Override
    public List<Document> searchDocuments(String searchTerm) {
        List<Document> docs = new ArrayList<>();
        List<String> processedStrings = StringProcessor.init(searchTerm)
                .tokenize()
                .normalize()
                .getProcessedData();
        Set<Integer> allDocIds = new HashSet<>();

        for (String str : processedStrings) {
            List<Integer> docIds = getDocIds(str);
            if (docIds != null && docIds.size() > 0) {
                allDocIds.addAll(docIds);
            }
        }

        for (Integer id : allDocIds) {
            docs.add(getDocumentById(id));
        }

        return docs;
    }

    private List<Integer> getDocIds(String searchTerm) {
        if (inMemoryDatabase == null) {
            return null;
        }

        List<Integer> docIds = new ArrayList<>();

        for (Map.Entry<Integer, String> entry : inMemoryDatabase.entrySet()) {
            List<String> searchTokens = StringProcessor.init(entry.getValue()).tokenize().normalize().getProcessedData();
            if (searchTokens.contains(searchTerm)) {
                docIds.add(entry.getKey());
            }
        }

        return docIds;
    }

}
