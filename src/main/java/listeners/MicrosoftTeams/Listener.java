package listeners.MicrosoftTeams;

import io.restassured.RestAssured;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.List;

import static listeners.MicrosoftTeams.AdaptiveCardReqBody.*;

public class Listener implements ITestListener, ISuiteListener{

    List<ItemsItem> TestCaseID = new ArrayList<>();
    List<ItemsItem> TestCaseName = new ArrayList<>();
    List<ItemsItem> TestResult = new ArrayList<>();

    @Override
    public void onTestStart(ITestResult result) {
        TestCaseName.add(ItemsItem.builder()
                .type("TextBlock")
                .text(result.getMethod().getMethodName())
                .weight("Bolder")
                .wrap(true)
                .build());


        TestCaseID.add(ItemsItem.builder()
                .type("TextBlock")
                .text("[14567](https://adaptivecards.io)")
                .weight("Bolder")
                .wrap(true)
                .build());
    }

    @Override
    public void onTestSuccess(ITestResult result) {




        TestResult.add(ItemsItem.builder()
                .type("TextBlock")
                .text("PASS")
                .weight("Bolder")
                .color("good")
                .wrap(true)
                .build());
    }

    @Override
    public void onTestFailure(ITestResult result) {


        TestResult.add(ItemsItem.builder()
                .type("TextBlock")
                .text("FAIL")
                .weight("Bolder")
                .color("attention")
                .wrap(true)
                .build());
    }

    @Override
    public void onFinish(ISuite suite) {

        Builder builder = new Builder(TestCaseName,TestCaseID,TestResult);

        RestAssured.baseURI="https://bhargavkumar65gmail.webhook.office.com/webhookb2/df93b3ce-071f-4e0c-932c-8f148084a9b0@0486e5b4-f3e8-4386-9ab4-cf2657814955/IncomingWebhook/f4f0699bf68449248abede270bfe8e44/51337ede-bd85-472e-8bf2-4d8ae127399c";
        RestAssured.given().log().body()
                .body(builder.reqBody())
                .when()
                .post()
                .then().log().body()
                .statusCode(200);
    }

}
