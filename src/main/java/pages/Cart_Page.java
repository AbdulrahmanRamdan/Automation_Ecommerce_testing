package pages;

import org.openqa.selenium.*;

import java.util.ArrayList;

public class Cart_Page {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    private By product_Name_Path= By.className("product-name");
    private By checkout_BTN_Path=By.id("checkout");
    private By terms_Path=By.id("termsofservice");
    public Cart_Page(WebDriver driver){
        this.driver=driver;
    }
    public ArrayList<String> get_Products_Names(){
        ArrayList<String> names=new ArrayList<>();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(product_Name_Path));
        ArrayList<WebElement>elements= (ArrayList<WebElement>) driver.findElements(product_Name_Path);
        for (WebElement e:elements) {
            names.add(e.getText());
        }
        return names;
    }
    public void accept_Terms(){
        driver.findElement(terms_Path).click();
    }
    public void click_Checkout(){
        driver.findElement(checkout_BTN_Path).click();
    }
    public void scroll_Down(){
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    }
}
