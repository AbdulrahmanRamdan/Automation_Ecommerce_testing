package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Wishlist_Page {
    private WebDriver driver;
    private By page_Title_Path= By.className("page-title");
    private By products_Names_Path=By.className("product-name");
    public Wishlist_Page(WebDriver driver){
        this.driver=driver;
    }
    public void scroll_to_Page_Title(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(page_Title_Path));
    }
    public ArrayList<String> get_Wishlist_Products_Names(){
        ArrayList<String>names=new ArrayList<>();
        ArrayList<WebElement> elements= (ArrayList<WebElement>) driver.findElements(products_Names_Path);
        for (WebElement e: elements ) {
            names.add(e.getText());
        }
        return names;
    }
}
