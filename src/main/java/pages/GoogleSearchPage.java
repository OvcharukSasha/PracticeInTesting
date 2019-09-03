package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    private WebDriver driver;

    private static final String GOOGLE_SEARCH_PAGE_URL = "https://www.google.com";

    @FindBy(xpath = "//*[@id=\"hplogo\"]")
    private WebElement logoImg;

    @FindBy(xpath = "//*//*[@title=\"Search\"]")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class=\"FPdoLc VlcLAe\"]//input[@name=\"btnK\"]")
    private WebElement googleSearchButton;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void openGoogleSearchPage(){
        driver.get(GOOGLE_SEARCH_PAGE_URL);
    }
    public WebElement getLogoImg() {
        return this.logoImg;
    }

    public String getURL() {
        return GOOGLE_SEARCH_PAGE_URL;
    }

    public boolean logoIsDisplayed() {
        return this.logoImg.isDisplayed();
    }

    public void googleSearchButtonClick() {
        this.googleSearchButton.click();
    }

    public void setTextToGoogleSearchInput(String value){
        searchInput.sendKeys(value);
    }
}
