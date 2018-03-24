package myapp.models;

/**
 * Created by Gundeep on 24/03/18.
 */
public class Document {

    int id;
    String text;

    public Document() {
    }

    public Document(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
