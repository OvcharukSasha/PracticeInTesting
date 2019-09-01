package restClients;

import DTOs.DTORandomUser;
import com.google.gson.Gson;
import  static helpers.RandomUserAPIHelper.sendGetMultipleUsersWithParams;
import io.restassured.response.Response;


import java.util.List;

public class RandomUserClient {

    public List<DTORandomUser.Result> getMultipleUsers(int usersAmount) {
        Response response = sendGetMultipleUsersWithParams(usersAmount);
        return getDTORandomUserFromResponse(response).getResults();
    }

    public DTORandomUser getDTORandomUserFromResponse(Response response){
        return new Gson().fromJson(response.asString(), DTORandomUser.class);
    }

}
