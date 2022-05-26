package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public Base(WebDriver driver, WebDriverWait wait) {

        Base.driver = driver;
        Base.wait = wait;
    }
}
