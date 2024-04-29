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

        String title = "mr";
        String firstName = "AdMaulana";
        String lastName = "Rahman";
        String gender = "male";
        String email = generateRandomEmail();
        String dateOfBirth = "2000-12-12";
        String phone = "08199999999";
        JSONObject payload = new JSONObject();
        payload.put("title", title);
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("dateOfBirth", dateOfBirth);
        payload.put("phone", phone);

        setUpHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response deleteUser(){
        setUpHeaders();
        return request.when().delete("https://dummyapi.io/data/v1/user/660563f482cf2daaa6e47c85");
    }

    public static Response postCreateUserMin(String endpoint){
        String firstName = "AdMaulana";
        String lastName = "Rahman";
        String email = generateRandomEmail();

        JSONObject payload = new JSONObject();
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("email",email);

        setUpHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }
    public static Response postCreateUserWithoutEmail(String endpoint){
        String firstName = "AdMaulana";
        String lastName = "Rahman";
        JSONObject payload = new JSONObject();
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);

        setUpHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }
    public static Response deleteUser(String endpoint, String user_id){
        setUpHeaders();
        String finalEndpoint = endpoint + user_id;
        return request.when().delete(finalEndpoint);
    }
//    public static Response updateUser(String endpoint, String user_id){
//        setUpHeaders();
//
//        String firstName = "AdMaulana";
//        String lastName = "Rahman";
//        String gender = "male";
//        String email = generateRandomEmail();
//        JSONObject payload = new JSONObject();
//        payload.put("firstName", firstName);
//        payload.put("lastName", lastName);
//        payload.put("gender", gender);
//        payload.put("email", email);
//
//        String finalEndpoint = endpoint + user_id;
//        return request.body(payload.toString()).when().patch(finalEndpoint);
//    }
}
