package hockey;

/*
      "must": [
        {
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
        },
        {
          "nested": {
            "path": "IP01P010",
            "query": {
              "bool": {
                "must": [
                  { "match": { "IP01P010.PSTDIST": "Ljungbyhed" } }
                ]
              }
            },
            "inner_hits": {}
          }
        }
      ]
 */
public class Bool {

    public final Must[] must;

    public Bool() {
        //default constructor
        this(null);
    }

    public Bool(Must[] must) {
        this.must = must;
    }
}
