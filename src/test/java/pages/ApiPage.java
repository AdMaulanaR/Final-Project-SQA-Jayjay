package pages;


import helper.Endpoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jdk.jfr.ContentType;
import org.assertj.core.api.AssertionsForClassTypes;
import org.assertj.core.util.Objects;

import java.io.File;
import java.util.List;

import static helper.Models.getListUsers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiPage {
    String setUrl;
    Response res;
    public void prepareUrlFor(String url){
        switch (url) {
            case "GET_LIST_USERS":
                setUrl = Endpoint.GET_LIST_USERS;
                break;
            case "GET_SPECIFIC_USER":
                setUrl = Endpoint.GET_SPECIFIC_USER;
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

        List<Object> id = res.jsonPath().getList("id");
//        List<Object> title = res.jsonPath().getList("title");
//        List<Object> firstName = res.jsonPath().getList("firstName");
//        List<Object> lastName = res.jsonPath().getList("lastName");
//        List<Object> gender = res.jsonPath().getList("gender");
//        List<Object> email = res.jsonPath().getList("email");

        System.out.println(id.get(0));

        AssertionsForClassTypes.assertThat(id.get(0)).isNotNull();
//        AssertionsForClassTypes.assertThat(title.get(0)).isIn("mr", "ms", "mrs", "miss", "dr", "");
//        AssertionsForClassTypes.assertThat(firstName.get(0)).isNotNull();
//        AssertionsForClassTypes.assertThat(lastName.get(0)).isNotNull();
//        AssertionsForClassTypes.assertThat(gender.get(0)).isIn("male", "female", "other", "");
//        AssertionsForClassTypes.assertThat(email.get(0)).isNotNull();
    }
    public void validationResponseJsonWithJSONSchema(String filename){
        File JSONFile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }
}
