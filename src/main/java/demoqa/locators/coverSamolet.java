package demoqa.locators;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class coverSamolet {



    @Test
    void dostavka(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hayan\\DemoQaWinter24\\src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driversamolet= new ChromeDriver();
        driversamolet.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driversamolet.manage().window().maximize();
        driversamolet.get("https://dostavka312.kg/garnirygpt/restoran-pishpek");

        WebElement vybor = driversamolet.findElement(By.xpath("//*[@id=\"WWMainPage\"]/div[1]/div[1]/div/div[2]/form/button"));
        vybor.click();
        driversamolet.get("https://dostavka312.kg/cart");

        WebElement findName = driversamolet.findElement(By.xpath("//*[@id=\"form_cart\"]/div[1]/div[1]/div[1]/input"));
        findName.sendKeys("Bumbledor");

        WebElement findAdress = driversamolet.findElement(By.xpath("//*[@id=\"form_cart\"]/div[1]/div[1]/div[2]/input"));
        findAdress.sendKeys("BumbledorPink37");

        WebElement findPhone = driversamolet.findElement(By.xpath("//*[@id=\"form_cart\"]/div[1]/div[1]/div[3]/input"));
        findPhone.sendKeys("996999999999");

        WebElement findSdacha = driversamolet.findElement(By.xpath("//*[@id=\"form_cart\"]/div[1]/div[1]/div[4]/input"));
        findSdacha.sendKeys("1000000");

        WebElement zakaz = driversamolet.findElement(By.xpath("//*[@id=\"form_cart\"]/button[1]"));
        zakaz.click();




    }
}


