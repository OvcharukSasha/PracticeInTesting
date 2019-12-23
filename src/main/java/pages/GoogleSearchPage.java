package pages;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//input[@class=\"gLFyf gsfi\"]")
    private WebElement searchInput;

    @FindBy(xpath = "//div[contains(@class, 'FPdoLc')]//input[@name='btnK']")
    private WebElement googleSearchButton;

    @FindBy(xpath="//div[@class='UUbT9']")
    private WebElement dropdownMatches;

    private By searchButtonInDropdown=By.cssSelector("div.UUbT9 input.gNO89b");

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public void openGoogleSearchPage() {
        driver.get(GOOGLE_SEARCH_PAGE_URL);
    }

    public void googleSearchButtonClick() {
        if (dropdownMatches.isDisplayed()) {
            WebElement searchButton = dropdownMatches.findElement(searchButtonInDropdown);
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            searchButton.click();
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(googleSearchButton));
            this.googleSearchButton.click();
        }
    }

    public void setTextToGoogleSearchInput(String value) {
        searchInput.sendKeys(value);
    }

    public void waitGooglePageLoad() {
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOf(searchInput),
                        ExpectedConditions.visibilityOf(logoImg))
        );
    }
}
