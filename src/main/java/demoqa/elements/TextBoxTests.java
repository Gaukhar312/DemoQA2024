package demoqa.elements;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;



public class TextBoxTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hayan\\DemoQaWinter24\\src\\main\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    void checkFullNameField() throws InterruptedException {
        driver.get("https://demoqa.com/text-box");

        WebElement fullname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
        fullname.sendKeys("Roman");
        Thread.sleep(4000);
    }

    @Test
    void checkEmailField() throws InterruptedException {
        driver.get("https://demoqa.com/text-box");

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")));
        email.sendKeys("appozit@mail.ru");
        Thread.sleep(4000);
    }

    @Test
    void checkCurrentAddressField() throws InterruptedException {
        driver.get("https://demoqa.com/text-box");

        WebElement currentAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currentAddress")));
        currentAddress.sendKeys("Bishkek , 123 Kolomkylova st");
        Thread.sleep(4000);
    }

    @Test
    void checkPermanentAddressField() throws InterruptedException {
        driver.get("https://demoqa.com/text-box");

        WebElement permanentAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("permanentAddress")));
        permanentAddress.sendKeys("London Baker Street ");
        Thread.sleep(4000);
    }

    @Test
    void submitForm() throws InterruptedException {
        driver.get("https://demoqa.com/text-box");

        WebElement fullname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
        fullname.sendKeys("Roman");
        System.out.println("Full Name: Roman");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("appozit@mail.ru");
        System.out.println("Email: appozit@mail.ru");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Bishkek , 123 Kolomkylova st");
        System.out.println("Current Address: Bishkek , 123 Kolomkylova st");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("London Baker Street");
        System.out.println("Permanent Address: London Baker Street");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        Thread.sleep(10000);
    }

    @AfterClass
    void tearDown() {
        if (driver != null) {
            driver.quit();
}
    }
}
