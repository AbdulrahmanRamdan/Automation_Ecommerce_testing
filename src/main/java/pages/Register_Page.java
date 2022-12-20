package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Register_Page {
    private By gender_Male_Path= By.id("gender-male");
    private By gender_Female_Path= By.id("gender-female");
    private By first_Name_TF_Path=By.id("FirstName");
    private By last_Name_TF_Path=By.id("LastName");
    private By birthday_Date_Day_Path=By.name("DateOfBirthDay");
    private By birthday_Date_Month_Path=By.name("DateOfBirthMonth");
    private By birthday_Date_Year_Path=By.name("DateOfBirthYear");
    private By email_TF_Path=By.id("Email");
    private By company_Name_Path=By.id("Company");
    private By password_TF_Path=By.id("Password");
    private By confirm_Password_TF_Path=By.id("ConfirmPassword");
    private By register_BTN_Path=By.id("register-button");
    private By confirm_Message_Path=By.className("result");
    private WebDriver driver;
    public Register_Page(WebDriver driver) {
        this.driver=driver;
    }
    public void click_Register_BTN(){
        driver.findElement(register_BTN_Path).click();
    }
    public void choose_Gender(char c){
        if(c=='M'){
            driver.findElement(gender_Male_Path);
        }
        else if(c=='F'){
            driver.findElement(gender_Female_Path);
        }
    }
    public void enter_First_and_Last_Names(String fName ,String lName){
        WebElement first_Name_TF=driver.findElement(first_Name_TF_Path);
        WebElement last_Name_TF=driver.findElement(last_Name_TF_Path);
        first_Name_TF.clear(); last_Name_TF.clear();
        first_Name_TF.sendKeys(fName); last_Name_TF.sendKeys(lName);
    }
    public void enter_Brith_Date(int day,int month,int year){
        driver.findElement(birthday_Date_Day_Path).click();
        driver.findElement(By.cssSelector("select[name=\"DateOfBirthDay\"]>option[value=\""+day+"\"]")).click();
        driver.findElement(birthday_Date_Month_Path).click();
        driver.findElement(By.cssSelector("select[name=\"DateOfBirthMonth\"]>option[value=\""+month+"\"]")).click();
        driver.findElement(birthday_Date_Year_Path).click();
        driver.findElement(By.cssSelector("select[name=\"DateOfBirthYear\"]>option[value=\""+year+"\"]")).click();
    }
    public void enter_Email_and_Company(String email,String company){
        WebElement email_TF=driver.findElement(email_TF_Path);
        WebElement company_TF=driver.findElement(company_Name_Path);
        email_TF.clear();company_TF.clear();
        email_TF.sendKeys(email);company_TF.sendKeys(company);
    }
    public void enter_Password_and_ConfirmPassword(String password,String confirmPassword){
        WebElement password_TF=driver.findElement(password_TF_Path);
        WebElement confirm_Password_TF=driver.findElement(confirm_Password_TF_Path);
        password_TF.clear();confirm_Password_TF.clear();
        password_TF.sendKeys(password);confirm_Password_TF.sendKeys(confirmPassword);
    }
    public boolean confirm_Message_Display(){
        return driver.findElement(confirm_Message_Path).isDisplayed();
    }

}
