package restClients;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RandomUserClient {
    private static final String GET_USER_REQUEST = "https://randomuser.me/api/";
    private static final String NUMBER_PARAMETER = "results";

    public void getMultipleUsers(int usersAmount) {

        Response response = given().queryParam(NUMBER_PARAMETER, usersAmount).get(GET_USER_REQUEST);
        System.out.println(response.getBody().asString());
    }
}
