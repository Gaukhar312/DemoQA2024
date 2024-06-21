import demoqa.enums.Endpoints;
import demoqa.pages.CheckBox;
import demoqa.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;

public class CheckboxTest extends BaseTest {
    @Test(groups = {"Regression","SQL","1234"}, description = "CheckBoxTest")
     void testBox(){
        browserHelper.open(ConfigReader.getValue("baseURL") + Endpoints.CHECKBOX.getEndpoint());
         checkBox.fullUpCheckBox();
//         checkBox.buttonT();
//         checkBox.buttonDesktopT();
//         checkBox.buttonDocumentsT();
//         checkBox.buttonDownloadsT();
//         checkBox.clickHomeT();
//         checkBox.resultT();


        String value = "You have selected :\n" +
                "home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile";
        Assert.assertEquals(value,checkBox.result.getText());

     }

}
