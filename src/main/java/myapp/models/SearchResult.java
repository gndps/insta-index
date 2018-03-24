package myapp.models;

import java.util.List;

/**
 * Created by Gundeep on 24/03/18.
 */
public class SearchResult {

    int count;
    List<Document> docs;

    public SearchResult() {
    }

    public SearchResult(int count, List<Document> docs) {
        this.count = count;
        this.docs = docs;
    }

    public SearchResult(List<Document> docs) {
        this.docs = docs;
        if(docs!=null) {
            count = docs.size();
        }
    }
}
