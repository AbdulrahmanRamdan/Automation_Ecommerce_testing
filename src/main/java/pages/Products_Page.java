package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Random;

public class Products_Page {
    private WebDriver driver;
    private By red_Color_Path=By.id("attribute-option-15");
    private By products_Path=By.className("product-item");
    private By tags_Block_Path=By.className("block-popular-tags");
    private By tags_Path=By.cssSelector("div.tags>ul>li");
    private By page_Title_Path=By.className("page-title");
    private By items_Path=By.cssSelector("h2.product-title>a");

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public Products_Page(WebDriver driver){
        this.driver=driver;
    }
    public void click_Red_Color_Filter() {
        driver.findElement(red_Color_Path).click();
    }
    public void click_Product(){
        driver.findElement(products_Path).click();
    }
    public void scroll_down_to_Tags(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(tags_Block_Path));
    }
    public String select_Random_Tag(){
        ArrayList<WebElement>webElements= (ArrayList<WebElement>) driver.findElements(tags_Path);
        Random random=new Random();
        int index= random.ints(1, webElements.size()).findFirst().getAsInt();
        String tag_Name=webElements.get(index-1).getText();
        webElements.get(index-1).click();
        return tag_Name;
    }
    public String get_Page_Title(){
        return driver.findElement(page_Title_Path).getText();
    }
    public void click_Random_Item(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.className("page-title")));
        ArrayList<WebElement> webElements = (ArrayList<WebElement>) driver.findElements(items_Path);
        Random random=new Random();
        int index= random.ints(1, webElements.size()).findFirst().getAsInt();
        Actions actions=new Actions(driver);
        actions.moveToElement(webElements.get(index-1)).build().perform();
        webElements.get(0).click();
    }

}
