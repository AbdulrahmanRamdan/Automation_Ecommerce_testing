package StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.Assert;
import pages.Home_Page;
import pages.Product_Page;
import pages.Products_Page;

public class Colored_Filter_StepDefninition {
    private Home_Page home_page;
    private Products_Page products_page;
    private Product_Page product_page;
    @When("User hover selected Apparel category and open Shoes Sub category")
    public void goto_Shoes(){
        home_page=new Base_StepDefinition().home_page;
        home_page.select_Shoes_sub_category();
    }
    @An("choose color filter")
    public void choose_Color_filter() throws InterruptedException {
        products_page=new Products_Page(home_page.getDriver());
        products_page.click_Red_Color_Filter();
        Thread.sleep(3000);
        products_page.click_Product();
    }
    @Then("check Item color")
    public void check_Product_Color(){
        product_page=new Product_Page(products_page.getDriver());
        Assert.assertEquals("Not same color", "Red",product_page.is_Red_Selected());
    }
}
