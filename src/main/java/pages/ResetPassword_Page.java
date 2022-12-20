package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPassword_Page {
    private WebDriver driver;
    private By message_Path= By.className("content");
    private By email_TF_Path=By.id("Email");
    private By cover_BTN_Path=By.name("send-email");

    public ResetPassword_Page(WebDriver driver) {
        this.driver=driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public void enter_Email(String email){
        driver.findElement(email_TF_Path).sendKeys(email);
    }
    public void click_Cover_BTN(){
        driver.findElement(cover_BTN_Path).click();
    }
    public String get_Message_Content(){
        return driver.findElement(message_Path).getText();
    }
}
