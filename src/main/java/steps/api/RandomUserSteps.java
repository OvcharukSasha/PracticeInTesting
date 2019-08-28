package steps.api;
import DTOs.DTORandomUser;
import restClients.RandomUserClient;
import java.util.List;


public class RandomUserSteps {

    private RandomUserClient randomUserClient = new RandomUserClient();
    private List<DTORandomUser.Result> resultsList;

    public void getFirstHundredUsers() {
        int numberOfUsers = 100;
        resultsList = randomUserClient.getMultipleUsers(numberOfUsers);
    }

    public int getWomenAmountFromUsersList() {
        return (int) resultsList.stream()
                                .filter(e -> e.getGender().equalsIgnoreCase("female"))
                                .count();
    }

    public int getMenAmountFromUsersList() {
        return (int) resultsList.stream()
                                .filter(e -> e.getGender().equalsIgnoreCase("male"))
                                .count();
    }
}
