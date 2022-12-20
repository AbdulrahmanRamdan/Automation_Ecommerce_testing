package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CompareList_Page;
import pages.Product_Page;

import java.util.ArrayList;

public class Add_To_Compare_StepDefinition {
    private Product_Page product_page;
    private CompareList_Page compareListPage;
    private String productName=null;
    @And("add item into CompareList")
    public void add_Product_To_compare(){
        product_page=new Product_Page(new Base_StepDefinition().driver);
        productName=product_page.get_Product_Name();
        product_page.scroll_to_Add_into_Cart_BTN();
        product_page.click_Add_to_CompareList();
    }
    @And("scroll down and click compare list")
    public void scroll_down_and_click_CompareList() throws InterruptedException {
        product_page.scroll_Down();
        Thread.sleep(3000 );
        product_page.click_CompareList_Link();
    }
    @Then("check item name in Compare List")
    public void check_Product_Name_in_CompareList(){
        compareListPage=new CompareList_Page(product_page.getDriver());
        ArrayList<String>names =compareListPage.get_Products_Names();
        Assert.assertTrue("Product not added into CompareList",names.toString().contains(productName));
    }
}
