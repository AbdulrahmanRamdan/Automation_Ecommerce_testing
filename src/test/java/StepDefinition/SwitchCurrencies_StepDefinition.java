package StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Home_Page;

public class SwitchCurrencies_StepDefinition {
    private Home_Page home_page;
    @When("User switch from US to Euro")
    public void switch_to_Euro(){
        home_page=new Base_StepDefinition().home_page;
        home_page.choose_Euro();
    }
    @Then("current currency should be change to Euro")
    public void check_Currency_Euro(){
        Assert.assertTrue("not Euro",home_page.get_Current_Currency().contains("€"));
    }
    @When("User switch from Euro to US")
    public void switch_to_USDollar(){
        home_page=new Base_StepDefinition().home_page;
        home_page.choose_Dollar();
    }
    @Then("current currency should be change to US")
    public void check_Currency_USDollar(){
        Assert.assertTrue("not Dollar",home_page.get_Current_Currency().contains("$"));
    }
}
