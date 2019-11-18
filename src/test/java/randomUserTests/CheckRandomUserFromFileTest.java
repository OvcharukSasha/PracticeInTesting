package randomUserTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import steps.api.RandomUserSteps;
import steps.common.UICommonSteps;

import java.io.IOException;

public class CheckRandomUserFromFileTest {
    private RandomUserSteps randomUserSteps;
    private UICommonSteps uiCommonSteps;
    private WebDriver driver;

    @BeforeSuite
    @Parameters({"amount"})
    public void writeUsersDataIntoFile(int amount) {
        randomUserSteps = new RandomUserSteps();
        randomUserSteps.getSetOfUsers(amount);
        try {
            randomUserSteps.writeUsersIntoFile();
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        uiCommonSteps=new UICommonSteps();
        randomUserSteps=new RandomUserSteps();
    }

    @Test
    @Parameters({"amount"})
    public void searchRandomUserFromFile(int amount){
        String name = randomUserSteps.readNameOfRandomUserFromFile(amount);
        Assert.assertTrue(uiCommonSteps.checkForUserInFacebook(driver, name),
                String.format("There isn't such user \"%s\" in Facebook.", name));
    }

    @AfterTest
    public void Close() {
        driver.close();
    }

}
