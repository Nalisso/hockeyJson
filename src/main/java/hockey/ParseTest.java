package hockey;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

public class ParseTest {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Search elasticSearch = mapper.readValue(getJsonInput(), Search.class);
            Arrays.stream(elasticSearch.query.bool.must).forEach(must -> printIt(must.nested));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private static void printIt(Nested nested) {
        System.out.println(nested.path);
        Arrays.stream(nested.query.bool.must).forEach(nestedMust -> System.out.println("\t" + nestedMust.match));
    }

    private static String getJsonInput() {
        return "{\n" +
                "  \"size\": 10,\n" +
                "  \"query\": {\n" +
                "    \"bool\": {\n" +
                "      \"must\": [\n" +
                "        {\n" +
                "          \"nested\": {\n" +
                "            \"path\": \"IP01P006\",\n" +
                "            \"query\": {\n" +
                "              \"bool\": { \"must\": [\n" +
                "                { \"match\": { \"IP01P006.GeoAreaID\": \"DK\" } },\n" +
                "                { \"match\": { \"IP01P006.GeoAreaIdTp\": \"1\" } },\n" +
                "                { \"match\": { \"IP01P006.LCStActvEffDt\": \"2005-04-07\" } },\n" +
                "                { \"match\": { \"IP01P006.IPXLCStTp\": \"4\" } }\n" +
                "                ]\n" +
                "              }\n" +
                "            },\n" +
                "            \"inner_hits\": {}\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"nested\": {\n" +
                "            \"path\": \"IP01P010\",\n" +
                "            \"query\": {\n" +
                "              \"bool\": {\n" +
                "                \"must\": [\n" +
                "                  { \"match\": { \"IP01P010.PSTDIST\": \"Ljungbyhed\" } }\n" +
                "                ]\n" +
                "              }\n" +
                "            },\n" +
                "            \"inner_hits\": {}\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}";
    }

}
