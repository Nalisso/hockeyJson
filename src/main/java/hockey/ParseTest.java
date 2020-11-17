package hockey;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Map;

public class ParseTest {

    private static final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static void main(String[] args) {
        try {
            //from static source, map to object to get same output format
            String staticJson = mapper.writeValueAsString(mapper.readValue(getJsonInput(), Search.class));
            System.out.println(staticJson);

            //generated
            String dynamicJson = getJsonInputFromJacksonObjectMapper();
            System.out.println(dynamicJson);

            System.out.println("Output match=" + dynamicJson.equals(staticJson));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
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

    private static String getJsonInputFromJacksonObjectMapper() throws JsonProcessingException {
        Bool bool = new Bool(getAllNested());
        Query query = new Query(bool);
        Search search = new Search(10, query);
        return mapper.writeValueAsString(search);
    }

    private static Must[] getAllNested() {
        //First
        NestedBool firstNestedBool = new NestedBool(getFirstNestedMust());
        NestedQuery firstNestedQuery = new NestedQuery(firstNestedBool);
        Nested firstNested = new Nested("IP01P006", firstNestedQuery, new InnerHits());
        //Second
        NestedBool secondNestedBool = new NestedBool(getSecondNestedMust());
        NestedQuery secondNestedQuery = new NestedQuery(secondNestedBool);
        Nested secondNested = new Nested("IP01P010", secondNestedQuery, new InnerHits());
        return new Must[]{new Must(firstNested), new Must(secondNested)};
    }

    private static NestedMust[] getFirstNestedMust() {
        NestedMust nestedMust1 = new NestedMust(Map.of("IP01P006.GeoAreaID", "DK"));
        NestedMust nestedMust2 = new NestedMust(Map.of("IP01P006.GeoAreaIdTp", "1"));
        NestedMust nestedMust3 = new NestedMust(Map.of("IP01P006.LCStActvEffDt", "2005-04-07"));
        NestedMust nestedMust4 = new NestedMust(Map.of("IP01P006.IPXLCStTp", "4"));
        return new NestedMust[]{nestedMust1, nestedMust2, nestedMust3, nestedMust4};
    }

    private static NestedMust[] getSecondNestedMust() {
        NestedMust nestedMust = new NestedMust(Map.of("IP01P010.PSTDIST", "Ljungbyhed"));
        return new NestedMust[]{nestedMust};
    }

}
