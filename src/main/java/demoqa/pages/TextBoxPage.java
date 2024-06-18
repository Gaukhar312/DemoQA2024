package demoqa.pages;

import demoqa.drivers.DriverManager;
import demoqa.entity.TextBoxEntity;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BasePage{




        @FindBy(id = "userName")
        public WebElement fullNameInput;


        @FindBy(id = "userEmail")
        public WebElement emailInput;

        @FindBy(id = "currentAddress")
        public WebElement currentAddressInput;

        @FindBy(id = "permanentAddress")
        public WebElement permanentAddressInput;

        @FindBy(id = "submit")
        public WebElement submitBtn;


        public TextBoxPage fillUpTextBoxForm(String fullname, String email, String currAddress, String permAddress){
            webElementActions.sendKeys(fullNameInput,fullname)
                    .sendKeys(emailInput,email)
                    .sendKeys(currentAddressInput,currAddress)
                    .sendKeys(permanentAddressInput,permAddress)
                    .click(submitBtn);
            return this;
        }

        public TextBoxPage fillUpTextBoxForm(TextBoxEntity textBoxEntity) {
            webElementActions.sendKeys(fullNameInput, textBoxEntity.getFullName())
                    .sendKeys(emailInput, textBoxEntity.getEmail())
                    .sendKeys(currentAddressInput, textBoxEntity.getCurrentAddress())
                    .sendKeys(permanentAddressInput, textBoxEntity.getPermanentAddress())
                    .click(submitBtn);
            return this;
        }
    }