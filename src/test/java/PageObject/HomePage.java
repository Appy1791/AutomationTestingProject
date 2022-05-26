package PageObject;

import Utilities.Base;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Base {

    public HomePage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id='Rock2']//h4[contains(text(),'Hello!')]")
    @CacheLookup
    private WebElement title_video;

    @FindBy(xpath = "//*[@id='movie_player']//following::a[@title='Watch on youtube.com']")
    @CacheLookup
    private WebElement videoBrand;

    @FindBy(xpath ="//*[@id='Rock2']//button[contains(text(),'×')]")
    @CacheLookup
    private WebElement closebtn;

    @FindBy(xpath ="//*[@id='player']")
    @CacheLookup
    private WebElement video;

    @FindBy(xpath="//h1[contains(text(),'School of Rock')]")
    @CacheLookup
    private WebElement HomepageHeading;

    public void validate_video_title() {
        wait.until(ExpectedConditions.visibilityOf(title_video));
        boolean video_title_display = title_video.isDisplayed();

        Assert.assertEquals(true, video_title_display);
    }

    public void validate_video_content(){
        Actions actions = new Actions(driver);
        actions.moveToElement(video).click();
        wait.until(ExpectedConditions.visibilityOf(videoBrand));
        boolean video_title_display = videoBrand.isDisplayed();

        Assert.assertEquals(true, video_title_display);

    }

    public void closevideo(){

        wait.until(ExpectedConditions.visibilityOf(closebtn));
        if( closebtn.isDisplayed()){
            closebtn.click();
        }
    }

    public void validate_homepage(){
        wait.until(ExpectedConditions.visibilityOf(HomepageHeading));
        HomepageHeading.isDisplayed();
    }

}
