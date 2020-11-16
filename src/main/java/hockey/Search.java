package hockey;

/*
{
  "size": 10,
  "query": {
    "bool": {
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
    }
  }
}
 */
public class Search {

    public final int size;
    public final Query query;

    public Search() {
        //default constructor
        this(0, null);
    }

    public Search(int size, Query query) {
        this.size = size;
        this.query = query;
    }
}
