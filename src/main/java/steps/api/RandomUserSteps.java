package steps.api;

import DTOs.DTORandomUser;
import helpers.utils.FileWriterReader;
import restClients.RandomUserClient;

import java.io.*;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class RandomUserSteps {
    private RandomUserClient randomUserClient = new RandomUserClient();
    private List<DTORandomUser.Result> resultsList;
    private static Logger log = Logger.getLogger(RandomUserSteps.class.getName());
    private FileWriterReader fileWriterReader = new FileWriterReader();

    public void getSetOfUsers(int numberOfUsers) {
        log.info(String.format("Getting %d random users...", numberOfUsers));
        resultsList = randomUserClient.getMultipleUsers(numberOfUsers);
    }

    public int getGenderAmountFromUsersList(String gender) {
        return (int) resultsList.stream()
                .filter(e -> e.getGender().equalsIgnoreCase(gender))
                .count();
    }

    public String getNameOfRandomUser() {
        return getRandomUser().getName();
    }

    private DTORandomUser.Result getRandomUser() {
        log.info("Getting one random user...");
        return randomUserClient.getUser();
    }

    public List<String> getUserNames() {
        return resultsList.stream().map(x -> x.getName()).collect(Collectors.toList());
    }

    public void writeUsersIntoFile() throws IOException {
        fileWriterReader.writeDataIntoFile("Users", getUserNames());
    }

    public String readNameOfRandomUserFromFile(int amountOfUsers) {
        int i = new Random().nextInt(amountOfUsers) + 1;
        return fileWriterReader.readPropertyById(i, "Users");
    }
}
