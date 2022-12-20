package StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Home_Page;
import pages.Result_Page;

import java.util.ArrayList;

public class Search_StepDefinition {
    private Home_Page home_page;
    private Result_Page result_page;
    private String search_Word="Apple";
    @When("User enter search word and click enter key")
    public void enter_Search_Key(){
        home_page=new Base_StepDefinition().home_page;
        home_page.search(search_Word);
        result_page=home_page.get_Result();
    }

    @Then("related items should be display")
    public void check_Related_Result(){
        ArrayList<String>result_Titles=result_page.get_Result_Items_Title();
        for (String s:result_Titles) {
            Assert.assertTrue("Not contain search word",s.contains(search_Word));
        }
    }
}
