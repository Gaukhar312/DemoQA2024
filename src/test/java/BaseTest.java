import demoqa.drivers.DriverManager;
import demoqa.helper.BrowserHelper;
import demoqa.pages.*;
import demoqa.utils.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
protected WebDriver driver;
protected CheckBox checkBox;
protected TextBoxPage textBoxPage;
protected RandomUtils randomUtils;
protected BrowserHelper browserHelper;
protected PracticeFormPage practiceFormPage;

protected ProgressBar progressBar;
    protected WebTablePage webTablePage;
    protected  OrangePage orangePage;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver = DriverManager.getDriver();
        textBoxPage = new TextBoxPage();
        randomUtils = new RandomUtils();
        checkBox = new CheckBox();
        browserHelper = new BrowserHelper(driver);
        progressBar = new ProgressBar();
        practiceFormPage = new PracticeFormPage();
        webTablePage = new WebTablePage();
        orangePage = new OrangePage();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        DriverManager.closeDriver();
    }




}
