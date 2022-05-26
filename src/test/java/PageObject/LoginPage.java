package PageObject;

import Utilities.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends Base {
    public LoginPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "name")
    @CacheLookup
    private WebElement emailField;

    @FindBy(id = "password")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(xpath = "//*/a[contains(text(),'Login')]")
    @CacheLookup
    private WebElement signInButton;

    @FindBy(xpath = "//h1[contains(text(),'School of Rock')]")
    @CacheLookup
    private WebElement LoginPageHeader;



//    public static WebDriver driver;
//    public static WebDriverWait wait;
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//    public LoginPage(WebDriver driver, WebDriverWait wait) {
//        LoginPage.driver = driver;
//        LoginPage.wait = wait;
//
//    }


    public void fillEmailData(String email) {

        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.isEnabled();
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void fillPasswordData(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.isEnabled();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.isEnabled();
        signInButton.click();
    }

    public boolean loginPageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(LoginPageHeader));
        LoginPageHeader.isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.isDisplayed();
        return true;
    }

}
