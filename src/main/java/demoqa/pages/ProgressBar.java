package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgressBar extends BasePage {
    @FindBy(id = "startStopButton")
    public WebElement progressBarStart;

    @FindBy(xpath = "//div[@aria-valuenow]")
    public WebElement progressBar1;
}


