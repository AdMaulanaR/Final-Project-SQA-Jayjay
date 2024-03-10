package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStep {
    ApiPage apiPage;
    public ApiStep(){
        this.apiPage = new ApiPage();
    }
    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        apiPage.prepareUrlFor(url);
    }

    @And("hit api get list users")
    public void hitApiGetListUsers() {
        apiPage.hitApiGetListUsers();
    }

    @Then("validation status code is equals to {int}")
    public void validationStatusCodeIsEqualsTo(int statusCode) {
        apiPage.validationStatusCodeIsEqualsTo(statusCode);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPage.validationResponseBodyGetListUsers();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String fileName) {
        apiPage.validationResponseJsonWithJSONSchema(fileName);
    }

    @And("hit api get user by id")
    public void hitApiGetUserById() {
        apiPage.hitApiGetUserById();
    }

    @Then("validation response body user")
    public void validationResponseBodyUser() {
        apiPage.validationResponseBodyUser();
    }

    @And("hit api get user wrong id")
    public void hitApiGetUserWrongId() {
        apiPage.hitApiGetUserWrongId();
    }

    @And("hit api get post create new user")
    public void hitApiGetPostCreateNewUser() {
        apiPage.hitApiGetPostCreateNewUser();
    }
}
