package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Home_Page;
import pages.Login_Page;

public class Login_StepDefinition {
    private Login_Page login_page;
    private Home_Page home_page;
    private String email="abdulrahmanramadan781@gmail.com";
    private String password="Abdo2212";
    @Given("navigate to login page")
    public void navigate_to_Login_Page(){
        home_page=new Base_StepDefinition().home_page;
        login_page=home_page.navigate_to_Login();
    }
    @When("^User enter \"(.*)\" and \"(.*)\"$")
    public void enter_Email_Password(String email, String password){
        login_page.enter_Email_and_Password(this.email,this.password);
    }
    @And("Click login button")
    public void click_Login(){
        login_page.click_Login_BTN();
    }
    @Then("go to home page and logout button is displayed")
    public void check_Logout_BTN_is_displayed(){
        home_page.setDriver(login_page.getDriver());
       Assert.assertTrue( "User is not logged",home_page.logout_BTN_displayed());
    }
    @Given("User logged into website")
    public void user_Login(){
        navigate_to_Login_Page();
        enter_Email_Password("","");
        click_Login();
        check_Logout_BTN_is_displayed();
    }
}
