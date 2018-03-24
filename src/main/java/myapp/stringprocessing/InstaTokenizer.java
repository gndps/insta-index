package myapp.stringprocessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gundeep on 24/03/18.
 */
public class InstaTokenizer implements Tokenizer {

    List<String> data;
    public static final String SPACE_CHAR = "\\s+";
    public static final String DEFAULT_TOKENIZE_TYPE = SPACE_CHAR;

    public InstaTokenizer(List<String> data) {
        this.data = data;
    }

    @Override
    public void tokenize() {
        tokenize(DEFAULT_TOKENIZE_TYPE);
    }

    public void tokenize(String splitChar) {
        if (data == null || data.isEmpty()) {
            return;
        }

        List<String> tokens = new ArrayList<>();

        for (String str : data) {
            tokens.addAll(Arrays.asList(str.split(splitChar)));
        }

        data = tokens;

    }

    @Override
    public List<String> getData() {
        return data;
    }

    @Override
    public void setData(List<String> data) {
        this.data = data;
    }

}
