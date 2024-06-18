package demoqa.pages;


import demoqa.drivers.DriverManager;
import demoqa.entity.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WebTablePage extends  BasePage {
    @FindBy(id = "addNewRecordButton")
    public WebElement addNewBtn;

    @FindBy(id = "firstName")
    public WebElement firstnameInput;

    @FindBy(id = "lastName")
    public WebElement lastnameInput;

    @FindBy(id = "age")
    public WebElement ageInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(id = "salary")
    public WebElement salaryInput;

    @FindBy(id = "department")
    public WebElement departmentInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    @FindBy(id = "edit-record-6")
    public WebElement redaktirovat;
    @FindBy(id = "edit-record-5")
    public WebElement edited;
    @FindBy(id = "userEmail")
    public WebElement emailInput2;
    @FindBy(id = "delete-record-1")
    public  WebElement kiera1;

    public   String email1 = "Bumbledore@gmail.com";

    public WebTablePage addNewEmployee(Employee employee) {
        webElementActions.click(addNewBtn)
                .sendKeys(firstnameInput, employee.getFirstName())
                .sendKeys(lastnameInput, employee.getLastName())
                .sendKeys(ageInput, String.valueOf(employee.getAge()))
                .sendKeys(emailInput, email1)
                .sendKeys(salaryInput, String.valueOf(employee.getSalary()))
                .sendKeys(departmentInput, employee.getDepartment())
                .click(submitBtn);


        return this;
    }

    public ArrayList<Employee> getEmployeesFromTable() {
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));

        ArrayList<Employee> employees = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            String firstName = cells.get(0).getText();
            String lastName = cells.get(1).getText();
            String ageText = cells.get(2).getText().replaceAll("[^0-9]", "");
            String email = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]", "");
            String department = cells.get(5).getText();

            if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || email.isEmpty()
                    || salaryText.isEmpty() || department.isEmpty()) {
                continue;
            }

            int age = Integer.parseInt(ageText.trim());
            long salary = Long.parseLong(salaryText.trim());

            employees.add(new Employee(firstName, lastName, age, email, salary, department));

        }
        return employees;
    }

    public ArrayList<String> getEmployeesFromTable1() {
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));
        ArrayList<String> email = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            String emailSpisok = cells.get(3).getText();
            email.add(emailSpisok);
        }

        // Проверка наличия дубликатов
        boolean hasDuplicates = email.stream().distinct().count() != email.size();

        try {
            if (hasDuplicates) {
                try {

                    throw new RuntimeException("В списке есть дубликаты.");
                }catch (Exception e){
                    System.err.println("поменяйте почту " + email1);
                }
            } else {
                System.out.println("В списке нет дубликатов.");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return email;
    }
    public WebTablePage removeEmail(Employee employee){
       webElementActions.click(edited);
       emailInput2.clear();
       webElementActions.sendKeys(emailInput2, employee.getEmail()).click(submitBtn);
     return this;
    }
    public WebTablePage deleteUser (){
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));
        for (WebElement ciera : rows){
            List<WebElement> employee1 = ciera.findElements(By.cssSelector(".rt-td"));
            String userEmailDelete = employee1.get(3).getText();
            if (userEmailDelete.contains("cierra@example.com")){
                webElementActions.click(kiera1);
                break;
            }
        }
return this;
    }
}