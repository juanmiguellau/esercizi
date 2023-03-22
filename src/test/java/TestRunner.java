import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.DriverUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestRunner {
    private final String URL = "https://automationteststore.com";

    private static ChromeDriver chromeDriver;
    private static FirefoxDriver firefoxDriver;
    private static DriverUtil driverUtil;

    static ExtentSparkReporter spark;
    static ExtentReports extent;
    static ExtentTest test;


    @BeforeAll
    public static void beforeAll() {

        // Far andare in errore la piattaforma se browser != chrome || firefox
        // Gestire il tipo di driver che stiamo utilizzando
        // Avviare firefox in modalita full screen come chrome
        // Creare un metodo per gestire il report

        String browser = System.getProperty("browser");
        try {
            if (browser.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--kiosk");
                chromeDriver = new ChromeDriver(options);
                driverUtil = new DriverUtil(chromeDriver);
            } else if (browser.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                firefoxDriver = new FirefoxDriver();
                driverUtil=new DriverUtil(firefoxDriver);

            }
            } catch (Exception ex) {
            System.out.println("errore piattaforma");
        }


        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeEach
    public void beforeEach() {
       // chromeDriver.get(URL);
        firefoxDriver.get(URL);
    }

    @AfterAll
    public static void afterAll() {
        //chromeDriver.close();
        test.pass("close test");
        test.info("test completed");
        extent.flush();
    }


    public static ChromeDriver getChromeDriver() {
        return chromeDriver;
    }

    public static DriverUtil getDriverUtil() {
        return driverUtil;
    }

    //private static final ChromeDriver driver = getChromeDriver();

}

