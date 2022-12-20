package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Cart_Page;
import pages.Home_Page;
import pages.Product_Page;
import pages.Products_Page;

import java.util.ArrayList;

public class Add_Cart_StepDefinition {
    private Home_Page home_page;
    private Product_Page product_page;
    private Products_Page productsPage;
    private Cart_Page cart_page;
    private String product_name=null;
    @And("click random product")
    public void click_Random_Product(){
        home_page=new Base_StepDefinition().home_page;
        home_page.open_Books_Cat();
        productsPage=new Products_Page(home_page.getDriver());
        productsPage.click_Random_Item();
    }
    @And("add item into Cart")
    public void add_Product_into_Cart() {
        product_page=new Product_Page(productsPage.getDriver());
        product_page.scroll_to_Add_into_Cart_BTN();
        product_page.click_Add_To_Cart();
        product_name=product_page.get_Product_Name();
    }
    @Then("check item name in cart")
    public void check_Product_Name_If_Added_into_Cart(){
        home_page.setDriver(product_page.getDriver());
        home_page.click_Shopping_Cart();
        cart_page=new Cart_Page(home_page.getDriver());
        ArrayList<String>products_Names=cart_page.get_Products_Names();
        Assert.assertTrue("product not added into cart",products_Names.toString().contains(product_name));
    }
    @When("User choose item and add to cart")
    public void user_Choose_Items(){
        click_Random_Product();
        add_Product_into_Cart();
        home_page.setDriver(product_page.getDriver());
        home_page.click_Shopping_Cart();
    }
}
