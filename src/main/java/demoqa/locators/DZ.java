package demoqa.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class DZ {
    @Test
    void dos(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hayan\\DemoQaWinter24\\src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driverSamolet = new ChromeDriver();
        driverSamolet.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driverSamolet.manage().window().maximize();
        driverSamolet.get("https://dostavka312.kg/garnirygpt/kfc-7mkr");

        WebElement bascket = driverSamolet.findElement(By.xpath("//*[@id=\"WWMainPage\"]/div[1]/div[1]/div/div[2]/form/button"));
        bascket.click();
        driverSamolet.get("https://dostavka312.kg/cart");

        WebElement findName = driverSamolet.findElement(By.xpath("//*[@id=\"form_cart\"]/div[1]/div[1]/div[1]/input"));
        findName.sendKeys("Bumbledore");

        WebElement findAddress = driverSamolet.findElement(By.xpath("//*[@id=\"form_cart\"]/div[1]/div[1]/div[2]/input"));
        findAddress.sendKeys("Hogwards");


        WebElement findNumber = driverSamolet.findElement(By.xpath("//*[@id=\"form_cart\"]/div[1]/div[1]/div[3]/input"));
        findNumber.sendKeys("0999999999");

        WebElement findMoney = driverSamolet.findElement(By.xpath("//*[@id=\"form_cart\"]/div[1]/div[1]/div[4]/input"));
        findMoney.sendKeys("1000000");

        WebElement button = driverSamolet.findElement(By.xpath("//*[@id=\"form_cart\"]/button[1]"));
        button.click();

    }
}
