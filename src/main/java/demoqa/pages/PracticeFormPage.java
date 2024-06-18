package demoqa.pages;

import demoqa.entity.PracticFormEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class PracticeFormPage extends BasePage{
    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")
    public WebElement genderInput;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")
    public WebElement genderInput2;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[3]/label")
    public WebElement genderInput3;

    @FindBy(id = "userNumber")
    public WebElement mobileNumberInput;

    @FindBy(id = "subjectsContainer")
    public WebElement subjectInput;

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]")
    public WebElement hobbiesInput;

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]")
    public WebElement hobbiesInput2;

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]")
    public WebElement hobbiesInput3;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy(id = "state")
    public WebElement stateInput;

    @FindBy(xpath = "//*[@id=\"state\"]/div/div[1]/div[1]")
    public WebElement stateButton;

    @FindBy(xpath = "//*[@id=\"city\"]//div[contains(@class,'css-1hwfws3')]")
    public WebElement cityInput;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthInput;

    @FindBy(id = "submit")
    public WebElement submitButton;

    public final Random random = new Random();

    public final List<WebElement> genderOptions = List.of(genderInput, genderInput2, genderInput3);
    public final List<WebElement> hobbiesOptions = List.of(hobbiesInput, hobbiesInput2, hobbiesInput3);

    public PracticeFormPage fillPracticeForm(PracticFormEntity practiceFormEntity) {
        webElementActions.sendKeys(firstNameInput, practiceFormEntity.getFullName())
                .sendKeys(lastNameInput, practiceFormEntity.getLastName())
                .sendKeys(emailInput, practiceFormEntity.getEmail())
                .click(genderOptions.get(random.nextInt(genderOptions.size())))
                .sendKeys(mobileNumberInput, String.valueOf(practiceFormEntity.getMobileNumber()));

        webElementActions.click(subjectInput);
        webElementActions.jsSendKeys(subjectInput, practiceFormEntity.getSubject());

        webElementActions.click(hobbiesOptions.get(random.nextInt(hobbiesOptions.size())))
                .sendKeys(currentAddressInput, practiceFormEntity.getCurrentAddress());






        // Выбор случайной станы и города
        webElementActions.click(stateInput);
        List<WebElement> states = webElementActions.getElements(By.xpath("//div[contains(@id,'react-select-3-option')]"));
        WebElement randomState = states.get(random.nextInt(states.size()));
        randomState.click();

        webElementActions.click(cityInput);
        List<WebElement> cities = webElementActions.getElements(By.xpath("//div[contains(@id,'react-select-4-option')]"));
        WebElement randomCity = cities.get(random.nextInt(cities.size()));
        randomCity.click();

        webElementActions.click(submitButton);
        return this;


    }}




