package randomUserTests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.api.RandomUserSteps;

public class RandomUserAPITest {
    private RandomUserSteps randomUserSteps;

    @Parameters({"amountOfUsers"})
    @Test
    public void printOutMenAndWomenAmounts(int amountOfUsers) {
        randomUserSteps = new RandomUserSteps();
        randomUserSteps.getSetOfUsers(amountOfUsers);
        System.out.println(String.format("Amount of women: %d;", randomUserSteps.getGenderAmountFromUsersList("female")));
        System.out.println(String.format("Amount of men: %d;", randomUserSteps.getGenderAmountFromUsersList("male")));
    }
}
