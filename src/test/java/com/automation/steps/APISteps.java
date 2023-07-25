package com.automation.steps;

import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.automation.utils.RestApiDemo.readDataFromFile;

public class APISteps {
    @Given("user set up request for {string} end point")
    public void user_set_up_request_for_end_point(String endpoint) {

        RestAssuredUtils.setEndPoint(endpoint);
    }

    @When("user perform GET request")
    public void user_perform_get_request() {
        RestAssuredUtils.get();
    }
    @When("user perform POST request")
    public void user_perform_post_request() {
        RestAssuredUtils.post();
    }
    @When("user perform PUT request")
    public void user_perform_put_request() {
        RestAssuredUtils.put();
    }

    @Then("verify status code is {int}")
    public void verify_status_code_is(int statusCode) {
        Assert.assertEquals(statusCode,RestAssuredUtils.getStatusCode());
    }

    @And("set header value {string} to {string}")
    public void setHeaderValueTo(String key, String value) {
        RestAssuredUtils.setHeader(key,value);
    }

    @And("set body for the create booking request")
    public void setBodyForTheCreateBookingRequest() throws FileNotFoundException {
        RestAssuredUtils.setBody(readDataFromFile("/Users/subankulova/IdeaProjects/CucumberAutomationFramework/src/test/resources/data/create_user_body.json"));
    }
    public static String readDataFromFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\Z");
        return sc.next();
    }

    @And("set body for the create token request")
    public void setBodyForTheCreateTokenRequest() throws FileNotFoundException {
        RestAssuredUtils.setBody(readDataFromFile("/Users/subankulova/IdeaProjects/CucumberAutomationFramework/src/test/resources/data/create_token_body.json"));

    }

    @And("verify response body has a token")
    public void verifyResponseBodyHasAToken() {
        String token = RestAssuredUtils.getResponseField("token");
        System.out.println("===> "+ token);
        Assert.assertTrue(token.isEmpty());
    }
}
