package hockey;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
    ??
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InnerHits {

    public final Hits hits;

    public InnerHits() {
        //default constructor
        this(null);
    }

    public InnerHits(Hits hits) {
        this.hits = hits;
    }
}
