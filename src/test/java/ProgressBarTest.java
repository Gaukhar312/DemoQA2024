
import demoqa.enums.Endpoints;
import demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

public class ProgressBarTest extends BaseTest {
    @Test(groups = {"Regression","SQL","1235"}, description = "ProgressBarTest")
    public void progressTest() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL") + Endpoints.PROGRESSBAR.getEndpoint());
        webElementActions.click(progressBar.progressBarStart);

        int max = 1000;
        for (int i = 0; i < max; i++) {
            String value = progressBar.progressBar1.getAttribute("aria-valuenow");
            if (value != null){
            int a = Integer.parseInt(value);

            if (a >= 52){
                webElementActions.click(progressBar.progressBarStart);
                System.out.println(a);
                break;
            }

            try {
                Thread.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }



        }
    }

}}
