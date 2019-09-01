package randomUserTests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.api.RandomUserSteps;


public class RandomUserTest {

   private RandomUserSteps randomUserSteps;

    @Parameters({ "amount" })
    @Test
    public void printOutMenAndWomenAmounts(int amount) {
        randomUserSteps = new RandomUserSteps();
        randomUserSteps.getSetOfUsers(amount);
        System.out.println(String.format("Amount of women: %d;", randomUserSteps.getGenderAmountFromUsersList("female")));
        System.out.println(String.format("Amount of men: %d;", randomUserSteps.getGenderAmountFromUsersList("male")));
    }



}
