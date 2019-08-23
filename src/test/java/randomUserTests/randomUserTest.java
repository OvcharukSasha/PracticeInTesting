package randomUserTests;

import org.testng.annotations.Test;
import steps.api.RandomUserSteps;


public class randomUserTest {

    private RandomUserSteps randomUserSteps;

    @Test
    public void printOutMenAndWomen()
    {
        randomUserSteps=new RandomUserSteps();
        randomUserSteps.GetFirstHundredUsers();
    }
}
