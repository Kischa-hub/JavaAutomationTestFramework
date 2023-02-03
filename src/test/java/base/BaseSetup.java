package base;


import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class BaseSetup {
    private WebDriver driver;
    //private final int WAIT_FOR_ELEMENT_TIMEOUT = 30;
    enum DriverType {
        CHROME,FIREFOX
    }


    @BeforeAll
    public void setUp(DriverType driverType){

        if(driverType==DriverType.CHROME){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (driverType== DriverType.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();

    }
    @BeforeEach
    public void goHome(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

    /*
    @AfterEach
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/"+result.getName()+".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        // System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
    }*/


}
