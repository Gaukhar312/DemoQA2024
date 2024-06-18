package demoqa.pages;

import demoqa.helper.WebElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBox extends BasePage {
    @FindBy(xpath = "//*[@id=\"item-1\"]/span")
    public WebElement checkBox ;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/span/button")
    public WebElement button;

      @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button")
      public WebElement buttonDesktop;

      @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button")
      public WebElement buttonDocuments;

      @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button")
      public WebElement buttonDownloads;

      @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/span/label/span[1]")
      public WebElement clickHome;

    @FindBy(xpath = "//div[@class='display-result mt-4']")
    public WebElement result;
//public CheckBox checkBoxT (){
//    actions.click(checkBox);
//    return this;
//
//}
public CheckBox fullUpCheckBox () {
    webElementActions.click(checkBox)
            .click(button)
            .click(buttonDesktop)
            .click(buttonDocuments)
            .click(buttonDownloads)
            .click(clickHome)
            .print(result);
    return this;

//    public CheckBox buttonT(){
//    actions.click(button);
//    return this;
//}
//public CheckBox buttonDesktopT(){
//    actions.click(buttonDesktop);
//    return this;
//}
//public CheckBox buttonDocumentsT(){
//    actions.click(buttonDocuments);
//    return this;
//}
//public CheckBox buttonDownloadsT(){
//    actions.click(buttonDownloads);
//    return this;
//}
//public CheckBox clickHomeT(){
//    actions.click(clickHome);
//    return this;
//}
//public CheckBox resultT(){
//    actions.print(result);
//    return this;
//}

}}