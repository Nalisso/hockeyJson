package hockey;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/*
            "path": "IP01P006",
            "query": {
              "bool": { "must": [
                { "match": { "IP01P006.GeoAreaID": "DK" } },
                { "match": { "IP01P006.GeoAreaIdTp": "1" } },
                { "match": { "IP01P006.LCStActvEffDt": "2005-04-07" } },
                { "match": { "IP01P006.IPXLCStTp": "4" } }
                ]
              }
            },
            "inner_hits": {}
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Nested {

    public final String path;
    public final NestedQuery query;
    public final InnerHits innerHits;

    public Nested() {
        //default constructor
        this(null, null, null);
    }

    public Nested(String path, NestedQuery query, InnerHits innerHits) {
        this.path = path;
        this.query = query;
        this.innerHits = innerHits;
    }
}
