package listeners;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;

import static io.restassured.RestAssured.*;

public class PowerBI_ResultSender {

    private static final String APIKEY = "APIKEY";
    private static final String PowerBiServer = "https://api.powerbi.com";
    private static final String UPN_VALUE = "UPN_VALUE";
    private static final String Tenant_Value ="TENENT_VALUE";
    private static final String DataSet ="PUSH_DATA_SET";

    public void PushData(PowerBI_Pojo_Base PowerBI_Json_Result)  {

        RestAssured.baseURI = PowerBiServer;
        RestAssured.useRelaxedHTTPSValidation();
        //RestAssured.proxy("YOUR_PROXY", 8080);

        String Json_Payload = new Gson().toJson(PowerBI_Json_Result);
        try {
            given()
                    .header("Content-type", "application/json")
                    .queryParam("tenant", Tenant_Value)
                    .queryParam("UPN", UPN_VALUE)
                    .queryParam("Key", APIKEY)
                    .urlEncodingEnabled(false)
                    .body(Json_Payload)
                    .when().log().all().post(DataSet)
                    .then().log().all().assertThat().statusCode(200);
        }
        catch (Exception e) {
            //e.printStackTrace();
        }

    }
}
