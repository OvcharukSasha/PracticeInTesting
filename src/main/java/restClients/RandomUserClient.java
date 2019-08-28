package restClients;

import DTOs.DTORandomUser;
import com.google.gson.Gson;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.List;

public class RandomUserClient {
    private static final String GET_USER_REQUEST = "https://randomuser.me/api/";
    private static final String NUMBER_PARAMETER = "results";

    public List<DTORandomUser.Result> getMultipleUsers(int usersAmount) {
        Response response = given().queryParam(NUMBER_PARAMETER, usersAmount).get(GET_USER_REQUEST);
        DTORandomUser randomUsersDTO = new Gson().fromJson(response.asString(), DTORandomUser.class);
        List<DTORandomUser.Result> results = randomUsersDTO.getResults();

        return results;
    }
}
