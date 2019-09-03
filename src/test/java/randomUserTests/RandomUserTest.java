package randomUserTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;
import steps.api.RandomUserSteps;
import steps.common.UICommonSteps;

public class RandomUserTest {

    private RandomUserSteps randomUserSteps;
    private UICommonSteps uiCommonSteps;
    private WebDriver driver;
    @Parameters({"amount"})
    @Test
    public void printOutMenAndWomenAmounts(int amount) {
        randomUserSteps = new RandomUserSteps();
        randomUserSteps.getSetOfUsers(amount);
        System.out.println(String.format("Amount of women: %d;", randomUserSteps.getGenderAmountFromUsersList("female")));
        System.out.println(String.format("Amount of men: %d;", randomUserSteps.getGenderAmountFromUsersList("male")));
    }
    @BeforeTest
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void searchForUserInFacebook(){
        uiCommonSteps.checkForUserInFacebook(driver);
    }

    @AfterTest
    public void Close() {
        driver.close();
        // driver.quit();
    }

}
