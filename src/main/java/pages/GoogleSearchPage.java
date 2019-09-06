package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage {

    private WebDriver driver;

    private static final String GOOGLE_SEARCH_PAGE_URL = "https://www.google.com";

    private static WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"hplogo\"]")
    private WebElement logoImg;

    @FindBy(xpath = "//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class=\"FPdoLc VlcLAe\"]//input[@name=\"btnK\"]")
    private WebElement googleSearchButton;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, 2000);

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
        wait.until(ExpectedConditions.elementToBeClickable(googleSearchButton));
        this.googleSearchButton.click();
    }

    public void setTextToGoogleSearchInput(String value) {
        searchInput.sendKeys(value);
        wait.until(ExpectedConditions.visibilityOf(searchInput));
    }

    public void waitGooglePageLoad() {
        wait.until(ExpectedConditions.visibilityOf(searchInput));
    }
}
