package steps.api;

import io.restassured.response.Response;
import restClients.RandomUserClient;

import java.util.ArrayList;

public class RandomUserSteps {
    private RandomUserClient randomUserClient=new RandomUserClient();

    public void GetFirstHundredUsers()
    {
        int numberOfUsers=100;
        randomUserClient.getMultipleUsers(numberOfUsers);
    }
}
