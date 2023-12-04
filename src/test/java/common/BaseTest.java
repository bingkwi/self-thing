package common;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    private void setDriver(String browserType, String appURL) {
        System.out.println("áioudhahdjkashjdhasjkdhjkashjkdas");
        if (!browserType.equals("chrome")) {
            System.out.println("Browser:" + browserType + "is invalid, launching Chrome as ");
        }
        driver = initChromeDriver(appURL);
    }

    private WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching Chrome browser...");
        String driverPath = "C:\\Users\\bichquynh.nguyen\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    @Parameters({ "browserType", "appURL" })
    @BeforeClass
    public void initializeTestBaseSetup(String browserType, String appURL) {
        try {
            System.out.println("ádlhasdjknasdasjkdjkasbn");
            // Khởi tạo driver và browser
            setDriver(browserType, appURL);
        } catch (Exception e) {
            System.out.println("Error..." + Arrays.toString(e.getStackTrace()));
        }
    }

    @AfterClass
    public static void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
    public static void threadSleep(double second) {
        try
        {
            Thread.sleep((long) (1000*second));
        }
        catch(InterruptedException e)
        {
            throw new RuntimeException(e);
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
    }
}
