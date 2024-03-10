package helper;



public class Endpoint {
    public static final String host_dummy = "https://dummyapi.io/data/v1/";
    public static final String GET_LIST_USERS = host_dummy + "user";
    public static final String GET_USER_BY_ID = host_dummy + "user/60d0fe4f5311236168a109cd";
    public static final String GET_USER_WRONG_ID = host_dummy + "user/12345testwrongid";
    public static final String GET_POST_CREATE_NEW_USER = host_dummy + "/user/create";
}
