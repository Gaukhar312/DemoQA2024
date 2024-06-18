package demoqa.helper;


import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {

        private WebDriver driver;

        public BrowserHelper(WebDriver driver){
            this.driver =driver;

        }
        public void open(String url){
            driver.navigate().to(url);

        }

        public void goBack(){

            driver.navigate().back();
        }
        public void goForward(){
            driver.navigate().forward();
        }
        public void refreshThePage(){
            driver.navigate().refresh();
        }

        public Set<String> getWindowHandles(){
            return driver.getWindowHandles();
        }

        public void switchToWindow(int index){
            LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());

            if (index <0 || index >windowsId.size())
                throw new IllegalArgumentException("Invalid index" + index);

            driver.switchTo().window(windowsId.get(index));

        }

        public void switchToParentWindow(){
            LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());

            driver.switchTo().window(windowsId.get(0));

        }
        public void switchToParentWithChildClose(){
            switchToParentWindow();
            LinkedList <String> windowId = new LinkedList<>(getWindowHandles());
            for (int i =1 ; i < windowId.size(); i++){
                driver.switchTo().window(windowId.get(i));
                driver.close();
            }
            switchToParentWindow();

}

    }
