package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

public class Home_Page {
    private By register_BTN_Path=By.className("ico-register");
    private By shopping_Cart_BTN_Path=By.className("ico-cart");
    private By login_BTN_Path=By.className("ico-login");
    private By logout_BTN_Path=By.className("ico-logout");
    private By search_TF_path=By.id("small-searchterms");
    private By customer_Currency_Path=By.id("customerCurrency");
    private By dollar_Currency_Path=By.xpath("//select[@id='customerCurrency']//option[contains(text(),'US')]");
    private By euro_Currency_Path=By.xpath("//select[@id='customerCurrency']//option[contains(text(),'Euro')]");
    private By categories_Path=By.cssSelector("ul.notmobile>li");
    private By page_Title_Path=By.className("page-title");
    private By wish_List_BTN_Path=By.className("ico-wishlist");
    private WebDriver driver;
    ArrayList<WebElement>webElements;
    int index;
    public void click_Shopping_Cart(){
        driver.findElement(shopping_Cart_BTN_Path).click();
    }
    public String get_Result_Title(){
        return driver.findElement(page_Title_Path).getText();
    }
    public void select_Shoes_sub_category(){
        new Actions(driver).moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Apparel')]"))).perform();
        driver.findElement(By.xpath("//a[contains(text(),'Shoes')]")).click();
    }

    public void random_Category_Selection(){
        webElements= (ArrayList<WebElement>) driver.findElements(categories_Path);
        Random random=new Random();
        index= random.ints(1, webElements.size()).findFirst().getAsInt();
        Actions action=new Actions(driver) ;
        action.moveToElement(webElements.get(index-1)).perform();
    }
    public void open_Books_Cat(){
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[5]/a")).click();
    }
    public String select_SubCategory(){
        try {

           if(index<4){
               By sub=By.cssSelector("ul.notmobile>li:nth-of-type("+index+")>ul>li");
            WebElement element=  driver.findElement(sub);
            String text=element.getText();
            element.click();
            return text;
            }
           else{
               String text=webElements.get(index-1).getText();
               webElements.get(index-1).click();
               return text;
           }
        }
        catch (NoSuchElementException e){
            webElements.get(index-1).click();
            return webElements.get(index-1).getText();
        }
    }
    public void click_To_Wishlist(){
        driver.findElement(wish_List_BTN_Path).click();
    }

    public String get_Current_Currency(){
        return driver.findElements(By.className("actual-price")).get(0).getText();
    }

    public void choose_Euro(){
        driver.findElement(customer_Currency_Path).click();
        driver.findElement(euro_Currency_Path).click();
    }
    public void choose_Dollar(){
        driver.findElement(customer_Currency_Path).click();
        driver.findElement(dollar_Currency_Path).click();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public boolean logout_BTN_displayed(){
        return driver.findElement(logout_BTN_Path).isDisplayed();
    }
    public void search(String searchword){
        WebElement search_Element=driver.findElement(search_TF_path);
        search_Element.clear();
        search_Element.sendKeys(searchword);
        search_Element.sendKeys(Keys.ENTER);
    }

    public Result_Page get_Result(){
        return new Result_Page(driver);
    }
    public Home_Page(WebDriver driver) {
        this.driver=driver;
        this.driver.get("https://demo.nopcommerce.com/");
    }
    public Register_Page navigate_to_Register(){
        driver.findElement(register_BTN_Path).click();
        return new Register_Page(driver);
    }
    public Login_Page navigate_to_Login(){
        driver.findElement(login_BTN_Path).click();
        return new Login_Page(driver);
    }

}
