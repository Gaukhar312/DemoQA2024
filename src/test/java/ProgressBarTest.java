
import demoqa.enums.Endpoints;
import demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

public class ProgressBarTest extends BaseTest {
    @Test
    public void progressTest() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL") + Endpoints.PROGRESSBAR.getEndpoint());
        progressBar.progressBarStart.   click();

        int max = 1000;
        for (int i = 0; i < max; i++) {
            String value = progressBar.progressBar1.getAttribute("aria-valuenow");
            if (value != null){
            int a = Integer.parseInt(value);

            if (a >= 52){
                progressBar.progressBarStart.click();
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
