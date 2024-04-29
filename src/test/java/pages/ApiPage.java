package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.File;
import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {
    String setUrl, global_id = null;
    Response res;
    public void prepareUrlFor(String url){
        switch (url) {
            case "GET_LIST_USERS":
                setUrl = Endpoint.GET_LIST_USERS;
                break;
            case "GET_USER_BY_ID":
                setUrl = Endpoint.GET_USER_BY_ID;
                break;
            case "GET_USER_WRONG_ID":
                setUrl = Endpoint.GET_USER_WRONG_ID;
                break;
            case "GET_POST_CREATE_NEW_USER":
                setUrl = Endpoint.GET_POST_CREATE_NEW_USER;
                break;
            case "DELETE_USER":
                setUrl = Endpoint.DELETE_USER;
                break;
            default:
                System.out.println("input right url");
        }
    }
    public void hitApiGetListUsers(){
        res = getListUsers(setUrl);
    }
    public void validationStatusCodeIsEqualsTo(int statusCode){
        assertThat(res.statusCode()).isEqualTo(statusCode);
//        System.out.println(res.getBody().asString());
    }
    public void validationResponseBodyGetListUsers() {

        String id = res.jsonPath().getString("data[10].id");
        String title = res.jsonPath().getString("data[10].title");
        String firstName = res.jsonPath().getString("data[10].firstName");
        String lastName = res.jsonPath().getString("data[10].lastName");
        String picture = res.jsonPath().getString("data[10].picture");
        assertThat(id).isNotNull();
        assertThat(title).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(picture).isNotNull();

    }
    public void validationResponseJsonWithJSONSchema(String filename){
        File JSONFile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }
    public void hitApiGetUserById(){
        res = getListUsers(setUrl);
//        System.out.println(res.getBody().asString());
    }
    public void validationResponseBodyUser(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String title = jsonPathEvaluator.get("title");
        String firstName = jsonPathEvaluator.get("firstName");
        String lastName = jsonPathEvaluator.get("lastName");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");

        assertThat(id).isNotNull();
        assertThat(title).isIn("ms", "mr", "miss", "mrs");
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");

        global_id = id;

    }
    public void hitApiGetUserWrongId(){
        res = getListUsers(setUrl);
    }
    public void hitApiGetPostCreateNewUser(){
        res = postCreateNewData(setUrl);
//        System.out.println(res.getBody().asString());
    }
    public void hitApiDeleteUser(){
        prepareUrlFor("DELETE_USER");
        res = deleteUser(setUrl, global_id);
//        System.out.println("url yg digunakan untuk delete" + setUrl + global_id);
//        System.out.println(res.getBody().asString());
    }
    public void hitApiGetPostCreateNewMin(){
        res = postCreateUserMin(setUrl);
//        System.out.println(res.getBody().asString());
    }
    public void validationResponseBodyUserMin(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.get("firstName");
        String lastName = jsonPathEvaluator.get("lastName");
        String email = jsonPathEvaluator.get("email");

        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();
    }
    public void hitApiPostCreateNewUserWithoutEmail(){
        res = postCreateUserWithoutEmail(setUrl);
    }
}
