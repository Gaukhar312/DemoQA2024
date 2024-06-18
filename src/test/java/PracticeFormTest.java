import demoqa.entity.PracticFormEntity;
import demoqa.enums.Endpoints;
import demoqa.utils.ConfigReader;
import org.testng.annotations.Test;


public class PracticeFormTest extends BaseTest{
    @Test
public void practiceFormTest(){
  browserHelper.open(ConfigReader.getValue("baseURL") + Endpoints.PRACTICEFORM.getEndpoint());

    PracticFormEntity practicFormEntity = randomUtils.generateRandomPracticeFormEntity();
    // practiceFormPage.selectGender(practicFormEntity.getGender());
    practiceFormPage.fillPracticeForm(practicFormEntity);



}
}
