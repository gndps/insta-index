package myapp.stringprocessing;

import java.util.List;

/**
 * Created by Gundeep on 24/03/18.
 */
public interface Tokenizer {

    public void tokenize();

    public List<String> getData();

    public void setData(List<String> data);

}
