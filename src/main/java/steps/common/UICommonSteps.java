package steps.common;

import DTOs.DTORandomUser;
import org.openqa.selenium.WebDriver;
import pages.GoogleSearchPage;
import steps.api.RandomUserSteps;

public class UICommonSteps {
    private GoogleSearchPage googleSearchPage;
    private static RandomUserSteps randomUserSteps=new RandomUserSteps();
    public void checkForUserInFacebook(WebDriver driver) {
        initializeGoogleSearchPage(driver);
       DTORandomUser.Result randomUser= randomUserSteps.getRandomUser();
       searchForUser(randomUser.getName());

    }

    private void searchForUser(String name){
        googleSearchPage.setTextToGoogleSearchInput(name);
        googleSearchPage.googleSearchButtonClick();

    }
    private void initializeGoogleSearchPage(WebDriver driver) {
        googleSearchPage =new GoogleSearchPage(driver);
        googleSearchPage.openGoogleSearchPage();
    }
}
