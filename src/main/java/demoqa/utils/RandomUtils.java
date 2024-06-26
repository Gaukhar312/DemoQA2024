package demoqa.utils;

import com.github.javafaker.Faker;
import demoqa.entity.Employee;
import demoqa.entity.PracticFormEntity;
import demoqa.entity.TextBoxEntity;

public class RandomUtils {
//    faker это рандомные значения
Faker faker = new Faker();
public  TextBoxEntity generateRandomTextBoxEntity(){
    TextBoxEntity textBoxEntity = new TextBoxEntity();
    textBoxEntity.setFullName(faker.name().fullName());
    textBoxEntity.setEmail(faker.internet().emailAddress());
    textBoxEntity.setCurrentAddress(faker.address().fullAddress());
    textBoxEntity.setPermanentAddress(faker.address().secondaryAddress());
    return textBoxEntity;
}
    public PracticFormEntity generateRandomPracticeFormEntity(){
        PracticFormEntity practicFormEntity = new PracticFormEntity();
        practicFormEntity.setFullName(faker.name().fullName());
        practicFormEntity.setLastName(faker.name().lastName());
        practicFormEntity.setEmail(faker.internet().emailAddress());
        practicFormEntity.setMobileNumber(Long.parseLong(faker.phoneNumber().subscriberNumber(10)));
        practicFormEntity.setSubject(faker.superhero().name());
        practicFormEntity.setCurrentAddress(faker.address().fullAddress());
        return practicFormEntity;
    }
    public Employee creatMocEmployee(){
        Employee employee = new Employee();
        employee.setFirstName(faker.name().firstName());
        employee.setLastName(faker.name().lastName());
        employee.setAge(faker.number().numberBetween(18,100)); //-> МЕТОД ГЕНЕРИРУЕТ ОТ 18 ДО 100))
        employee.setEmail(faker.internet().emailAddress());
        employee.setSalary(faker.number().numberBetween(10000000l,2000000000l));
        employee.setDepartment(faker.job().position());
        return employee;
    }
}
