package randomUserTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import steps.api.RandomUserSteps;
import steps.common.UICommonSteps;

import java.io.IOException;
import java.util.logging.Logger;

public class CheckRandomUserFromFileTest {
    private RandomUserSteps randomUserSteps;
    private UICommonSteps uiCommonSteps;
    private WebDriver driver;
    private static Logger log = Logger.getLogger(CheckRandomUserFromFileTest.class.getName());
    private static final String CHROMEDRIVER_PATH = "src\\main\\java\\chromedriver.exe";

    @BeforeSuite
    @Parameters({"amountOfUsers"})
    public void writeUsersDataIntoFile(int amountOfUsers) {
        randomUserSteps = new RandomUserSteps();
        randomUserSteps.getSetOfUsers(amountOfUsers);
        try {
            randomUserSteps.writeUsersIntoFile();
        } catch ( IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeTest
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        uiCommonSteps=new UICommonSteps();
        randomUserSteps=new RandomUserSteps();
    }

    @Test
    @Parameters({"amountOfUsers"})
    public void searchRandomUserFromFile(int amountOfUsers){
        String name = randomUserSteps.readNameOfRandomUserFromFile(amountOfUsers);
        if (!name.equals("EMPTY"))
            Assert.assertTrue(uiCommonSteps.checkForUserInFacebook(driver, name),
                    String.format("There isn't such user \"%s\" in Facebook.", name));
        else
            log.info("Impossible to search for empty string");
    }

    @AfterTest
    public void Close() {
        driver.close();
    }

}
