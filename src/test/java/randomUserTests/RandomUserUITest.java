package randomUserTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.api.RandomUserSteps;
import steps.common.UICommonSteps;

public class RandomUserUITest {

    private RandomUserSteps randomUserSteps;
    private UICommonSteps uiCommonSteps;
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        uiCommonSteps=new UICommonSteps();
        randomUserSteps=new RandomUserSteps();
    }

    @Test
    public void searchForUserInFacebook() {
        String name = randomUserSteps.getNameOfRandomUser();
        Assert.assertTrue(uiCommonSteps.checkForUserInFacebook(driver, name),
                String.format("There isn't such user \"%s\" in Facebook.", name));
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
