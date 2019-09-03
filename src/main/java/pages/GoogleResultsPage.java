package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleResultsPage {

    private WebDriver driver;


    @FindBy(xpath = "//cite")
    private List<WebElement> links;

    @FindBy(xpath = "//*[@id=\"resultStats\"]")
    private WebElement resultStatus;

    public GoogleResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    public String getURL() {
        return driver.getCurrentUrl();
    }

    public boolean resultStatusIsDisplayed() {
        return this.resultStatus.isDisplayed();
    }

    public List<WebElement> getLinksOnPage(){
        return links;
    }



}