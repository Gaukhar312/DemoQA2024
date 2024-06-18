package demoqa.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FirefoxWebDriver {
    public static WebDriver LoadFireFoxDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hayan\\DemoQaWinter24\\src\\main\\resources\\driver\\chromedriver.exe");


        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
