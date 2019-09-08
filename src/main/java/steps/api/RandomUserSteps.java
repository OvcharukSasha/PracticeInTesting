package steps.api;
import DTOs.DTORandomUser;
import restClients.RandomUserClient;
import java.util.List;
import java.util.logging.Logger;

public class RandomUserSteps {
    private RandomUserClient randomUserClient = new RandomUserClient();
    private List<DTORandomUser.Result> resultsList;
    private static Logger log = Logger.getLogger(RandomUserSteps.class.getName());

    public void getSetOfUsers(int numberOfUsers) {
        log.info(String.format("Getting %d random users...",numberOfUsers));
        resultsList = randomUserClient.getMultipleUsers(numberOfUsers);
    }

    public int getGenderAmountFromUsersList(String gender) {
        return (int) resultsList.stream()
                                .filter(e -> e.getGender().equalsIgnoreCase(gender))
                                .count();
    }
    public String getNameOfRandomUser(){
        return getRandomUser().getName();
    }

    private DTORandomUser.Result getRandomUser() {
        log.info("Getting one random user...");
        return randomUserClient.getUser();
    }
}
