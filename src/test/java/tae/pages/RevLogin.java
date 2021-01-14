package tae.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RevLogin {
    public static final String title = "Login";

    @FindBy(xpath = "//input[@type='text']")
    public WebElement username;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement submitButton;
    
    public RevLogin (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}