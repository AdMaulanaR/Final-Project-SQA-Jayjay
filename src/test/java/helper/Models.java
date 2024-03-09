package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Models {
    private static RequestSpecification request;

    public static void setUpHeaders() {
        request = RestAssured.given()
                .header("app-id", "65d5faa10b4ddb627ee6e7a7");
    }
    public static Response getListUsers(String endpoint){
        setUpHeaders();
        return request.when().get(endpoint);
    }
}
