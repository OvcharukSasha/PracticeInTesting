package randomUserTests;

import org.testng.annotations.Test;
import steps.api.RandomUserSteps;


public class randomUserTest {

    private RandomUserSteps randomUserSteps;

    @Test
    public void printOutMenAndWomenAmounts() {
        randomUserSteps = new RandomUserSteps();
        randomUserSteps.getFirstHundredUsers();
        System.out.println(String.format("Amount of women: %d;", randomUserSteps.getWomenAmountFromUsersList()));
        System.out.println(String.format("Amount of men: %d;", randomUserSteps.getMenAmountFromUsersList()));
    }
}
