package listeners.MicrosoftTeams;

import io.restassured.RestAssured;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        Builder builder = new Builder(result);
        RestAssured.baseURI="https://bhargavkumar65gmail.webhook.office.com/webhookb2/df93b3ce-071f-4e0c-932c-8f148084a9b0@0486e5b4-f3e8-4386-9ab4-cf2657814955/IncomingWebhook/4af0a1b63137487ab9f30625ceb98379/51337ede-bd85-472e-8bf2-4d8ae127399c";
        RestAssured.given().log().body()
                .body(builder.reqBody())
                .when()
                .post()
                .then().log().body()
                .statusCode(200);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Builder builder = new Builder(result);
        RestAssured.baseURI="https://bhargavkumar65gmail.webhook.office.com/webhookb2/df93b3ce-071f-4e0c-932c-8f148084a9b0@0486e5b4-f3e8-4386-9ab4-cf2657814955/IncomingWebhook/4af0a1b63137487ab9f30625ceb98379/51337ede-bd85-472e-8bf2-4d8ae127399c";
        RestAssured.given().log().body()
                .body(builder.reqBody())
                .when()
                .post()
                .then().log().body()
                .statusCode(200);
    }
}
