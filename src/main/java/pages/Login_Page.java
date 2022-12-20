package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    private By email_TF_Path= By.id("Email");
    private By password_TF_Path=By.id("Password");
    private By login_BTN_Path=By.className("login-button");
    private By forget_Password_Path=By.className("forgot-password");
    public Login_Page(WebDriver driver) {
        this.driver=driver;
    }
    public void enter_Email_and_Password(String email,String password){
        WebElement email_TF=driver.findElement(email_TF_Path);
        WebElement password_TF=driver.findElement(password_TF_Path);
        email_TF.clear();password_TF.clear();
        email_TF.sendKeys(email);password_TF.sendKeys(password);
    }
    public void click_Login_BTN(){
        driver.findElement(login_BTN_Path).click();
    }
    public void click_Forget_Password(){driver.findElement(forget_Password_Path).click();}
}
