package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.Home_Page;
import pages.Product_Page;
import pages.Products_Page;

import java.util.ArrayList;

public class Tags_selection_StepDefinition {
    String selected_Tag=null;
    private Home_Page home_page;
    private Products_Page productsPage;
    private Product_Page product_page;
    @And("scroll down and select random tag")
    public void select_Random_Tag(){
        home_page=new Base_StepDefinition().home_page;
        productsPage=new Products_Page(home_page.getDriver());
        productsPage.scroll_down_to_Tags();
        selected_Tag=productsPage.select_Random_Tag();
        Assert.assertTrue("tag not selected",productsPage.get_Page_Title().contains(selected_Tag));

    }
    @And("click random item")
    public void click_Random_Item(){
        productsPage.click_Random_Item();
    }
    @Then("check item if belong to tag")
    public void check_Random_Item_if_belong_to_Tags(){
        product_page=new Product_Page(productsPage.getDriver());
        product_page.scroll_To_Tag_Box();
        ArrayList<String>tags_Name=product_page.get_Product_Tags();
        Assert.assertTrue("item not belong to selected tag", tags_Name.toString().contains(selected_Tag));
    }
}
