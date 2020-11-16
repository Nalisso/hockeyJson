package hockey;

/*
              "bool": { "must": [
                { "match": { "IP01P006.GeoAreaID": "DK" } },
                { "match": { "IP01P006.GeoAreaIdTp": "1" } },
                { "match": { "IP01P006.LCStActvEffDt": "2005-04-07" } },
                { "match": { "IP01P006.IPXLCStTp": "4" } }
                ]
              }
 */
public class NestedBool {

    public final NestedMust[] must;

    public NestedBool() {
        //default constructor
        this(null);
    }

    public NestedBool(NestedMust[] must) {
        this.must = must;
    }
}
