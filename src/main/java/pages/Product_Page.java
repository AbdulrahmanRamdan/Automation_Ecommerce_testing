package pages;

import org.openqa.selenium.*;

import java.util.ArrayList;

public class Product_Page {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    private By selected_Color_Path= By.className("selected-value");
    private By product_Tag_Box_Path=By.className("product-tags-box");
    private By products_Tags_Path=By.cssSelector("div.product-tags-list>ul>li.tag");
    private By add_to_Cart_BTN_Path=By.cssSelector("div.add-to-cart-panel>button");
    private By add_to_WishList_BTN_Path=By.cssSelector("div.add-to-wishlist>button");
    private By product_Name_Path= By.className("product-name");
    private By add_to_CompareList_BTN_Path=By.cssSelector("div.compare-products>button");
    private By compareList_Link_Path=By.xpath("//a[contains(text(),'Compare products list')]");

    public Product_Page(WebDriver driver){
        this.driver=driver;
    }
    public String is_Red_Selected(){
        WebElement select_Color= driver.findElement(selected_Color_Path);
       return select_Color.findElement(By.className("attribute-square-container")).getAttribute("title");
    }
    public String get_Product_Name(){
        return driver.findElement(product_Name_Path).getText();
    }
    public void scroll_To_Tag_Box(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(product_Tag_Box_Path));
    }
    public ArrayList<String> get_Product_Tags(){
        ArrayList<WebElement>elements = (ArrayList<WebElement>) driver.findElements(products_Tags_Path);
        ArrayList<String>tags_Name=new ArrayList<>();
        for (WebElement e:elements) {
            tags_Name.add(e.getText());
        }
        return tags_Name;
    }
    public void scroll_to_Add_into_Cart_BTN(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(product_Name_Path));
    }
    public void click_Add_To_Cart()  {
        driver.findElement(add_to_Cart_BTN_Path).click();
    }
    public void click_Add_to_Wishlist(){driver.findElement(add_to_WishList_BTN_Path).click();}
    public void click_Add_to_CompareList(){
        driver.findElement(add_to_CompareList_BTN_Path).click();
    }
    public void scroll_Down(){
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    }
    public void click_CompareList_Link(){
        driver.findElement(compareList_Link_Path).click();
    }
}
