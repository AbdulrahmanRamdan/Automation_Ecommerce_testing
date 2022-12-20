package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.Home_Page;
import pages.Product_Page;
import pages.Wishlist_Page;

import java.util.ArrayList;

public class Add_Wishlist_StepDefinition {
    String product_Name=null;
    private Product_Page product_page;
    private Wishlist_Page wishlist_page;
    private Home_Page home_page;
    @And("add item into WishList")
    public void add_Product_into_Wishlist(){
        product_page=new Product_Page(new Base_StepDefinition().driver);
        product_Name=product_page.get_Product_Name();
        product_page.scroll_to_Add_into_Cart_BTN();
        product_page.click_Add_to_Wishlist();
    }
    @And("click WishList button")
    public void click_WihList_Btn(){
        home_page=new Home_Page(product_page.getDriver());
        home_page.click_To_Wishlist();
    }
    @Then("check item name in WishList")
    public void check_ProductName_In_Wishlist(){
        wishlist_page=new Wishlist_Page(home_page.getDriver());
        ArrayList<String>names=wishlist_page.get_Wishlist_Products_Names();
        Assert.assertTrue("Product not added in Wishlist",names.toString().contains(product_Name));

    }
}
