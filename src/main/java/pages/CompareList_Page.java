package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class CompareList_Page {
    private By products_Names_Path= By.cssSelector("tr.product-name>td");
    private WebDriver driver;
    public CompareList_Page(WebDriver driver){
        this.driver=driver;
    }
    public ArrayList<String> get_Products_Names(){
        ArrayList<String>names=new ArrayList<>();
        ArrayList<WebElement>elements= (ArrayList<WebElement>) driver.findElements(products_Names_Path);
        for (WebElement e:elements) {
            names.add(e.getText());
        }
        return names;
    }
}
