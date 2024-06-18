package demoqa.pages;

import demoqa.drivers.DriverManager;
import demoqa.helper.WebElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebElementActions webElementActions;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        this.webElementActions = new WebElementActions(driver);
    }
}

