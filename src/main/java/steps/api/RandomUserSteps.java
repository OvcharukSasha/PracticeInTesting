package steps.api;
import DTOs.DTORandomUser;
import restClients.RandomUserClient;
import java.util.List;


public class RandomUserSteps {

    private RandomUserClient randomUserClient = new RandomUserClient();
    private List<DTORandomUser.Result> resultsList;

    public void getSetOfUsers(int numberOfUsers) {
        resultsList = randomUserClient.getMultipleUsers(numberOfUsers);
    }

    public int getGenderAmountFromUsersList(String gender) {
        return (int) resultsList.stream()
                                .filter(e -> e.getGender().equalsIgnoreCase(gender))
                                .count();
    }
}
