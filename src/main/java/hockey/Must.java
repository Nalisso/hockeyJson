package hockey;

/*
          "nested": {
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
          }
 */
public class Must {

    public final Nested nested;

    public Must() {
        //default constructor
        this(null);
    }

    public Must(Nested nested) {
        this.nested = nested;
    }
}
