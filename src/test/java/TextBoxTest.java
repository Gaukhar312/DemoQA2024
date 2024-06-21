
import demoqa.entity.TextBoxEntity;

import demoqa.enums.Endpoints;
import demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {
    @Test(groups = {"Smoke","4323"}, description = "TextBoxTest")
    public void textBoxTest(){

        browserHelper.open(ConfigReader.getValue("baseURL") + Endpoints.TEXTBOX.getEndpoint());
        TextBoxEntity textBoxEntity = randomUtils.generateRandomTextBoxEntity();

        textBoxPage.fillUpTextBoxForm(textBoxEntity);
         }
}
