package com.gautam.stepDefinitions;

import com.gautam.utils.AssertionUtils;
import com.gautam.utils.CommonUtils;
import com.gautam.utils.ConfigUtils;
import com.gautam.utils.RestUtils;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import static com.gautam.utils.ConfigUtils.getPropertyByKey;

public class PetStoreSteps {
    String request =null;
    Response response = null;
    static String petId = null;
    static final Logger logger = Logger.getLogger(PetStoreSteps.class);

    @Before
    public void setup(){
        ConfigUtils.loadProperties();
        RestUtils.setBaseURI(getPropertyByKey("rest.url"));
        RestUtils.setContentType(ContentType.JSON);
    }
    @Given("^User build a web service request for \"([^\"]*)\"$")
    public void userBuildAWebServiceRequest(String requestType) {
        switch (requestType.toUpperCase()) {
            case "ADDPET":
                request = CommonUtils.readFileFromResources("addPet.json");
                logger.info("ADD PET Request Body :- " + request);
                break;
            case "SOLDPET":
                request = CommonUtils.readFileFromResources("petSold.json");
                JSONObject soldPetJSON = new JSONObject(request);
                soldPetJSON.put("id",petId);
                request = soldPetJSON.toString();
                logger.info("SOLD PET Request Body :- " + request);
                break;

        }
    }

    @When("^User make a \"([^\"]*)\" request$")
    public void userMakeAPOSTRequest(String requestType) {
        switch (requestType.toUpperCase()) {
            case "ADDPET":
                String uri = ConfigUtils.getPropertyByKey("add.pet");
                response = RestUtils.postRequest(request,uri);
                logger.info("ADD PET response:-" + response.asString());
                break;
            case "AVAILABLEPETS":
                response = RestUtils.getRequest("status","available",ConfigUtils.getPropertyByKey("available.pets"));
                logger.info("AVAILABLE PETS response:-" + response.asString());
                break;
            case "SOLDPET":
                response = RestUtils.putRequest(request,ConfigUtils.getPropertyByKey("update.pet"));
                logger.info("SOLD PET response:-" + response.asString());
                break;
            case "DELETEPET":
                response = RestUtils.deleteRequest(ConfigUtils.getPropertyByKey("update.pet")+"/"+petId);
                logger.info("DELETE PET response:-" + response.asString());
                break;

            default:

        }
    }


    @Then("^User verify status code is \"([^\"]*)\"$")
    public void userVerifyStatusCodeIs(String statusCode) {
        AssertionUtils.assertEquals(String.valueOf(response.getStatusCode()),statusCode);
    }


    @And("^User verify \"([^\"]*)\" details$")
    public void userVerifyPetDetails(String requestType) {
        switch (requestType.toUpperCase()) {
            case "ADDPET":
                String petStatus = response.jsonPath().get("status");
                JSONObject requestObject = new JSONObject(request);
                petId = response.jsonPath().getString("id");
                ConfigUtils.updateProperty("petId",petId,"output.properties");
                AssertionUtils.assertEquals(response.jsonPath().getString("status"), requestObject.getString("status"));
                AssertionUtils.assertEquals(response.jsonPath().getString("name"), requestObject.getString("name"));
                break;
            case "AVAILABLEPETS":
                JSONArray responseArray = new JSONArray(response.asString());
                for (Object pet: responseArray) {
                    JSONObject petDetials = (JSONObject) pet;
                        AssertionUtils.assertEquals(petDetials.getString("status"),"available");
                }
                break;
            case "SOLDPET":
                JSONObject soldPetJSON = new JSONObject(request);
                AssertionUtils.assertEquals(response.jsonPath().getString("status"), soldPetJSON.getString("status"));
                AssertionUtils.assertEquals(response.jsonPath().getString("name"), soldPetJSON.getString("name"));
                break;
            case "DELETEPET":
                AssertionUtils.assertEquals(response.jsonPath().getString("message"), petId);
                AssertionUtils.assertEquals(response.jsonPath().getString("type"), "unknown");
                break;
            default:
                logger.info("Cases missing");
                break;

        }
    }

}
