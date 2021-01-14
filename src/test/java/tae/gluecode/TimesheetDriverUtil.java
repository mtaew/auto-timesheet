package tae.gluecode;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TimesheetDriverUtil {
    public static WebDriver driver;
    public static final String url = "https://rev2.force.com/revature/s/login/?ec=302&startURL=%2Frevature%2Fs%2F";

    @Before
    public void setup() {
        File file = new File("C:/Users/Tae/Desktop/workspaces/personalProject/CucumberSelenium/auto-timesheet/src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get(url);
    }

    @After 
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
