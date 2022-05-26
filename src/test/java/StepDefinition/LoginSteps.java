package StepDefinition;

import PageObject.HomePage;
import PageObject.LoginPage;
import Utilities.PropertyReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    public WebDriver driver = Hooks.driver;
    public WebDriverWait wait;

    public LoginSteps() throws Exception {

        PropertyReader propertiesReader = new PropertyReader();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(propertiesReader.getTimeout()));
    }

    @Given("User is on login page")
    public void user_is_on_login_page() {
        LoginPage loginpageobj = new LoginPage(driver,wait);
        loginpageobj.loginPageIsDisplayed();

    }
    @When("User enter valid {string} and {string}")
    public void user_enter_valid_and(String Username, String Password) {
        LoginPage loginpageobj = new LoginPage(driver,wait);
        loginpageobj.loginPageIsDisplayed();
        loginpageobj.fillEmailData(Username);
        loginpageobj.fillPasswordData(Password);
    }
    @When("User click on login button")
    public void user_click_on_login_button() {
        LoginPage loginpageobj = new LoginPage(driver,wait);
        loginpageobj.clickSignInButton();

    }
    @Then("User should be navigate to video window")
    public void user_should_be_navigate_to_video_window() throws Exception{

        HomePage homepageObj = new HomePage(driver,wait);
        homepageObj.validate_video_title();
        Thread.sleep(4000);
    }

    @When("close video window")
    public void close_video_window() {
        HomePage homepageObj = new HomePage(driver,wait);
        homepageObj.closevideo();
    }
    @Then("User should navigate to homepage")
    public void user_should_navigate_to_homepage() {
        HomePage homepageObj = new HomePage(driver,wait);
        homepageObj.validate_homepage();
    }

}
