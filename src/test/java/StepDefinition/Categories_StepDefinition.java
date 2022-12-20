package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Home_Page;

public class Categories_StepDefinition {
    private Home_Page home_page;
    String expect_Result_title;
    @When("User randomly hover selected category")
    public void hover_Randomly_Category(){
        home_page=new Base_StepDefinition().home_page;
        home_page.random_Category_Selection();
    }
    @And("open Sub category if found")
    public void select_SubCategory_If_Found(){
        expect_Result_title=home_page.select_SubCategory();
    }
    @Then("check page title")
    public void check_Page_Title(){
       Assert.assertTrue("not The same Result title", home_page.get_Result_Title().equalsIgnoreCase(expect_Result_title));
    }
}
