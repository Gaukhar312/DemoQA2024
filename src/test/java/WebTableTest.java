
import demoqa.entity.Employee;
import demoqa.enums.Endpoints;
import demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest extends BaseTest{

    @Test(groups = {"E2E","API","4567"}, description = "WebTableTest")
    public  void tes123(){
        browserHelper.open(ConfigReader.getValue("baseURL") + Endpoints.WEBTABLE.getEndpoint());
        Employee employe = randomUtils.creatMocEmployee();

        webTablePage.addNewEmployee(randomUtils.creatMocEmployee());
        webTablePage.addNewEmployee(randomUtils.creatMocEmployee());
        List<Employee> employees = webTablePage.getEmployeesFromTable();


        for(Employee employee : employees ){
            System.out.println(employee);
        }
        webTablePage.getEmployeesFromTable1();
        webTablePage.deleteUser();
        webTablePage.removeEmail(randomUtils.creatMocEmployee());




    }
}