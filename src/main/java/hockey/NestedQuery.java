package hockey;

/*
           "query": {
              "bool": { "must": [
                { "match": { "IP01P006.GeoAreaID": "DK" } },
                { "match": { "IP01P006.GeoAreaIdTp": "1" } },
                { "match": { "IP01P006.LCStActvEffDt": "2005-04-07" } },
                { "match": { "IP01P006.IPXLCStTp": "4" } }
                ]
              }
            }
 */
public class NestedQuery {

    public final NestedBool bool;

    public NestedQuery() {
        //default constructor
        this(null);
    }

    public NestedQuery(NestedBool bool) {
        this.bool = bool;
    }
}
