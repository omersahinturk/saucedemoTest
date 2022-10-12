package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUpDriver(Method method) {

        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ellef\\\\OneDrive\\\\Desktop\\\\Selenium\\\\libs\\\\chromedriver_win32\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


//    @AfterMethod(alwaysRun = true)
//    public void tearDown(){
//        driver.quit();
//    }
}
