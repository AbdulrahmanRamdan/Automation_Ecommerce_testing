package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Result_Page {
    private WebDriver driver;
    private By result_Items_Title_Path= By.className("product-title");

    public Result_Page(WebDriver driver){
        this.driver=driver;
    }
    public ArrayList<String> get_Result_Items_Title(){
        ArrayList<WebElement>elements= (ArrayList<WebElement>) driver.findElements(result_Items_Title_Path);
        ArrayList<String>titles =new ArrayList<>();
        for (WebElement e:elements) {
            titles.add(e.getText());
        }
        return titles;
    }

}
