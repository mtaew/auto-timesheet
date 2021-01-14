package tae.gluecode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tae.pages.RevHome;
import tae.pages.RevLogin;
import tae.pages.RevTimesheet;

public class TimesheetDriver {
    
    public RevLogin rl;
    public RevHome rh;
    public RevTimesheet rt;

    @Given("User is at the login page")
    public void user_is_at_the_login_page() {
        this.rl = new RevLogin(TimesheetDriverUtil.driver);
        assertEquals(RevLogin.title, TimesheetDriverUtil.driver.getTitle());
    }

    @When("User inputs email")
    public void user_inputs_email() {
        WebDriverWait wait = new WebDriverWait(TimesheetDriverUtil.driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
        this.rl.username.sendKeys(System.getenv("TimesheetEmail"));
    }

    @When("their password")
    public void their_password() {
        WebDriverWait wait = new WebDriverWait(TimesheetDriverUtil.driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        this.rl.password.sendKeys(System.getenv("TimesheetPass"));
    }

    @When("submit the information")
    public void submit_the_information() {
        this.rl.submitButton.click();
    }

    @Then("the user is redirected to their userhome page")
    public void the_user_is_redirected_to_their_userhome_page() {
        this.rh = new RevHome(TimesheetDriverUtil.driver);
        WebDriverWait wait = new WebDriverWait(TimesheetDriverUtil.driver, 4);
        wait.until(ExpectedConditions.titleContains("Home"));
        assertEquals(RevHome.title, TimesheetDriverUtil.driver.getTitle());
    }

    /*
        Scenario: submit timesheet
    */
    @When("User clicks timesheet button")
    public void user_clicks_timesheet_button() {
        TimesheetDriverUtil.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.rh.submitButton.click();
    }

    @When("enters the hours")
    public void enters_the_hours() {
        this.rt = new RevTimesheet(TimesheetDriverUtil.driver);
        TimesheetDriverUtil.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.rt.mon.clear();
        this.rt.mon.sendKeys("8");
        this.rt.tue.clear();
        this.rt.tue.sendKeys("8");
        this.rt.wed.clear();
        this.rt.wed.sendKeys("8");
        this.rt.thu.clear();
        this.rt.thu.sendKeys("8");
        this.rt.fri.clear();
        this.rt.fri.sendKeys("8");
    }

    @When("clicks submit button")
    public void clicks_submit_button() {
        this.rt.submitButton.click();
    }

    @Then("user should be notified of successful submission")
    public void user_should_be_notified_of_successful_submission() {
        WebDriverWait wait = new WebDriverWait(TimesheetDriverUtil.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'slds-theme--success')]")));
        assertTrue(this.rt.successAlert.getText().contains("Timesheet submitted successfully"));
    }
}
