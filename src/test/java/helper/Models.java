package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import static helper.Utility.generateRandomEmail;

public class Models {
    private static RequestSpecification request;

    public static void setUpHeaders() {
        request = RestAssured.given()
                .header("content-type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "65d5faa10b4ddb627ee6e7a7");
    }
    public static Response getListUsers(String endpoint){
        setUpHeaders();
        return request.when().get(endpoint);
    }
    public static Response postCreateNewData(String endpoint){

        String firstName = "AdMaulana";
        String lastName = "Rahman";
        String gender = "male";
        String email = generateRandomEmail();

        JSONObject payload = new JSONObject();
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("gender", gender);
        payload.put("email", email);

        setUpHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }
}
