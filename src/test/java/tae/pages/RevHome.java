package tae.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RevHome {
    public static final String title = "Home";

    @FindBy(xpath = "//button[@type='button'][@title='Open Current Timesheet']")
    public WebElement submitButton;

    
    public RevHome (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
