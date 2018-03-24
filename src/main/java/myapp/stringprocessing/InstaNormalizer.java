package myapp.stringprocessing;

import java.util.List;

/**
 * Created by Gundeep on 24/03/18.
 */
public class InstaNormalizer implements Normalizer {

    List<String> data;

    public enum NormalizeType {LOWER_CASE}

    public static final NormalizeType DEFAULT_NORMALIZE_TYPE = NormalizeType.LOWER_CASE;

    public InstaNormalizer(List<String> data) {
        this.data = data;
    }

    @Override
    public void normalize() {

        /**
         * normalize the input data according to the normalize type
         *
         * @param normalizeType
         * @return
         */
        normalize(DEFAULT_NORMALIZE_TYPE);
    }

    public void normalize(NormalizeType normalizeType) {

        if (data == null || data.isEmpty()) {
            return;
        }

        switch (normalizeType) {
            case LOWER_CASE:
                for (int i = 0; i < data.size(); i++) {
                    data.set(i, data.get(i).toLowerCase());
                }
                break;
            default:
                normalize(DEFAULT_NORMALIZE_TYPE);
                break;

        }

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
