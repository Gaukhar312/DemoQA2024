package demoqa.helper;

import demoqa.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class WebElementActions {
//    Actions actions = new Actions(DriverManager.getDriver());

    private WebDriver driver;
    private Actions actions;

    public WebElementActions(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }



    public WebElementActions click(WebElement element) {
            // waitElementToBeClickAble(element);
            scrollToElement(element);
            element.click();
            return this;
        }

        public WebElementActions sendKeys(WebElement element, String txt) {
            waitElementToBeVisible(element);
            scrollToElement(element);
            element.sendKeys(txt);
            return this;
        }



        public WebElementActions waitElementToBeClickAble(WebElement element) {
            new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30))
                    .until(ExpectedConditions.elementToBeClickable(element));
            return this;
        }

        public WebElementActions waitElementToBeVisible(WebElement element) {
            new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30))
                    .until(ExpectedConditions.visibilityOf(element));
            return this;
        }

        public WebElementActions scrollToElement(WebElement element){
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            return this;
}
    public WebElementActions print(WebElement element){
        System.out.println(element.getText());
        return this;
    }
    public WebElementActions jsSendKeys(WebElement element, String txt) {
        if (txt != null && !txt.isEmpty()) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value=arguments[1];", element, txt);
        } else {
            throw new IllegalArgumentException("Keys to send should be a not null and not empty CharSequence");
        }
        return this;
    }


    }





