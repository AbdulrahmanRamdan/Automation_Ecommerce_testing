package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Home_Page;
import pages.Register_Page;

public class Register_StepDefinition {
    private Register_Page register_page;
    private Home_Page home_page;
    @Given("navigate to register page")
    public void navigate_to_Register_Page(){
        home_page=new Base_StepDefinition().home_page;
        register_page= home_page.navigate_to_Register();
    }
    @When("User choose gender")
    public void choose_Gender(){
        register_page.choose_Gender('M');
    }
    @And("^User should enter \"(.*)\" and \"(.*)\"$")
    public void enter_Names(String fName,String lName){
        register_page.enter_First_and_Last_Names("Abdo","Ramadan");
    }
    @And("User should enter BirthDate")
    public void enter_BirthDate(){
        register_page.enter_Brith_Date(22,12,1999);
    }
    @And("User should enter Email and Company")
    public void enter_Email_and_Company(){
        register_page.enter_Email_and_Company("abdulrahmanramadan71@gmail.com","FWD");
    }
    @And("User should enter Password and Confirm Password")
    public void enter_Password(){
        String pass="Abdo2212";
        register_page.enter_Password_and_ConfirmPassword(pass,pass);
    }
    @And("click register button")
    public void click_Register_Button(){
        register_page.click_Register_BTN();
    }
    @Then("display register confirmation message")
    public void check_Confirmation_Message_display(){
        Assert.assertTrue("Confirm message is not display",register_page.confirm_Message_Display());
    }
}
