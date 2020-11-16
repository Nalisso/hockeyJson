package hockey;

import java.util.Map;

/*
                "must": [
                { "match": { "IP01P006.GeoAreaID": "DK" } },
                { "match": { "IP01P006.GeoAreaIdTp": "1" } },
                { "match": { "IP01P006.LCStActvEffDt": "2005-04-07" } },
                { "match": { "IP01P006.IPXLCStTp": "4" } }
                ]
 */
public class NestedMust {

    public final Map<String, String> match;

    public NestedMust() {
        //default constructor
        this(null);
    }

    public NestedMust(Map<String, String> match) {
        this.match = match;
    }
}
