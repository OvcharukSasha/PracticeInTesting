package steps.common;

import DTOs.DTORandomUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.GoogleResultsPage;
import pages.GoogleSearchPage;
import steps.api.RandomUserSteps;

import java.util.List;

public class UICommonSteps {
    private GoogleSearchPage googleSearchPage;
    private GoogleResultsPage googleResultsPage;
    private static RandomUserSteps randomUserSteps=new RandomUserSteps();
    public boolean checkForUserInFacebook(WebDriver driver) {
        initializeGoogleSearchPage(driver);
       DTORandomUser.Result randomUser= randomUserSteps.getRandomUser();
       searchForUser(randomUser.getName());
googleResultsPage=new GoogleResultsPage(driver);
googleResultsPage.waitResultPageLoad();
        List<WebElement> links= googleResultsPage.getLinksOnPage();
        boolean res=false;
        for (WebElement we:links) {
            if (we.getText().contains("facebook.com")) {
                res = true;
                return res;

            }

        }
        return res;
    }

    private void searchForUser(String name){
        googleSearchPage.waitGooglePageLoad();
        googleSearchPage.setTextToGoogleSearchInput(name);
        googleSearchPage.googleSearchButtonClick();

    }
    private void initializeGoogleSearchPage(WebDriver driver) {
        googleSearchPage =new GoogleSearchPage(driver);
        googleSearchPage.openGoogleSearchPage();
    }
}
