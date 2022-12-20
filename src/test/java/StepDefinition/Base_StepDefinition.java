package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pages.Home_Page;

import java.time.Duration;

public class Base_StepDefinition {
    public static WebDriver driver;

    public static Home_Page home_page;
    @Before
    public void set_Up(){
        driver=WebDriverManager.chromedriver().avoidShutdownHook().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        home_page=new Home_Page(driver);
    }
    @After
    public void finish(){
        driver.quit();
    }

}
