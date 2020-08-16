package listeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;

public class ElasticResultSender {

    private static final ObjectMapper OM = new ObjectMapper();
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_VALUE = "application/json";
    private static final String ELASTICSEARCH_URL = "http://localhost:9200/app/suite";

    public static void send(final Elastic_Json_TestStatus testStatus){
        try {
            Unirest.post(ELASTICSEARCH_URL)
                    .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                    .body(OM.writeValueAsString(testStatus)).asJson();
        } catch (Exception e) {
            //System.out.println("Unable to connect to Elastic Search Node");
            //e.printStackTrace();
        }
    }


}