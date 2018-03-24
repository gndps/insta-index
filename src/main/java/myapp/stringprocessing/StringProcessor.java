package myapp.stringprocessing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gundeep on 24/03/18.
 */
public class StringProcessor {

    /*
    Class init methods
     */

    List<String> data;

    public StringProcessor(List<String> data) {
        this.data = data;
    }

    public static StringProcessor init(String str) {
        List<String> data = new ArrayList<>();
        if(str!=null && !str.isEmpty()) {
            data.add(str);
        }
        StringProcessor processor = new StringProcessor(data);
        return processor;
    }

    public static StringProcessor init(List<String> data) {
        StringProcessor processor = new StringProcessor(data);
        return processor;
    }


    /*
    Tokenize methods for chaining
     */

    public StringProcessor tokenize() {
        return tokenize(InstaTokenizer.DEFAULT_TOKENIZE_TYPE);
    }

    public StringProcessor tokenize(String splitChar) {
        InstaTokenizer tokenizer = new InstaTokenizer(data);
        tokenizer.tokenize(splitChar);
        data = tokenizer.getData();
        return this;
    }

    public StringProcessor tokenize(Tokenizer tokenizer) {
        tokenizer.setData(data);
        tokenizer.tokenize();
        data = tokenizer.getData();
        return this;
    }

    /*
    Normalize methods for chaining
     */

    public StringProcessor normalize() {
        return normalize(InstaNormalizer.DEFAULT_NORMALIZE_TYPE);
    }

    private StringProcessor normalize(InstaNormalizer.NormalizeType normalizeType) {
        InstaNormalizer normalizer = new InstaNormalizer(data);
        normalizer.normalize(normalizeType);
        data = normalizer.getData();
        return this;
    }

    /**
     * For using a custom normalizer
     *
     * @param normalizer
     * @return
     */
    private StringProcessor normalize(Normalizer normalizer) {
        normalizer.setData(data);
        normalizer.normalize();
        data = normalizer.getData();
        return this;
    }


    /**
     * get the final processed data
     *
     * @return
     */
    public List<String> getProcessedData() {
        return data;
    }

}
