package tae.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RevTimesheet {
    public static final String title = "Timesheet";

    @FindBy(xpath = "//input[starts-with(@id, '80:')]")
    public WebElement mon;

    @FindBy(xpath = "//input[starts-with(@id, '92:')]")
    public WebElement tue;

    @FindBy(xpath = "//input[starts-with(@id, '104:')]")
    public WebElement wed;

    @FindBy(xpath = "//input[starts-with(@id, '116:')]")
    public WebElement thu;

    @FindBy(xpath = "//input[starts-with(@id, '128:')]")
    public WebElement fri;

    @FindBy(xpath = "//button[@class='slds-button slds-button_brand']")
    public WebElement submitButton;

    @FindBy(xpath =  "//div[contains(@class, 'slds-theme--success')]")
    public WebElement successAlert;

    public RevTimesheet (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
