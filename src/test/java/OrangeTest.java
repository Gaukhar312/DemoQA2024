import demoqa.enums.Orange;
import demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

public class OrangeTest extends BaseTest {
    @Test(groups = {"Smoke","UI","1234"}, description = "CheckBoxTest")
    void testOrange(){
        browserHelper.open(ConfigReader.getValue("baseOrangeURL") + Orange.ADMIN.getOrange());
        orangePage.fillUpRegistration();
        orangePage.switchToBarMenu(Orange.CONFIGURATION);
        orangePage.orangeTopBar(Orange.CORPORATEBRANDING);
    }
}
