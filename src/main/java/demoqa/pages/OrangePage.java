package demoqa.pages;

import demoqa.drivers.DriverManager;
import demoqa.enums.Orange;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class OrangePage extends BasePage{
    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement admin ;

    @FindBy(xpath = "//input[@placeholder='Password']")
public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement button;

    @FindBy(xpath = "//div[@class='oxd-topbar-body']")
    public WebElement topBarParent;
    @FindBy(className= "oxd-topbar-body")
    public  WebElement topBar1;



    public OrangePage fillUpRegistration(){
        webElementActions.sendKeys(admin,"Admin").sendKeys(password,"admin123").click(button);
        return this;


    }
    public OrangePage switchToBarMenu(Orange topBarMenu){
//        WebElement orangeMenu = DriverManager.getDriver().findElement(By.xpath("//div[@class='oxd-topbar-body']/nav/ul/li/span[contains(text(), '"+topBarMenu.getOrange()+" ')]"));
        List<WebElement> orangeList = DriverManager.getDriver().findElements(By.xpath("//div[@class='oxd-topbar-body']/nav/ul/li/span[contains(text(), '"+topBarMenu.getOrange()+" ')]"));
        if (!orangeList.isEmpty()){
            Random random = new Random();
            WebElement randomI = orangeList.get(random.nextInt(orangeList.size()));
            webElementActions.click(randomI);
        }return this;

    }
    public OrangePage orangeTopBar(Orange orangeEnum) {
        topBar1.findElement(By.xpath("//nav/ul/li/a[contains(text(), '" + orangeEnum.getOrange() + "')]")).click();
return this;

    }


}
