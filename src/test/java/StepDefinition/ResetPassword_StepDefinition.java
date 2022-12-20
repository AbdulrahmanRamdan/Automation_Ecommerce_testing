package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Home_Page;
import pages.Login_Page;
import pages.ResetPassword_Page;

public class ResetPassword_StepDefinition {
    private Login_Page login_page;
    private Home_Page home_page;
    private ResetPassword_Page resetPassword_page;
    private String email="abdulrahmanramadan71@gmail.com";
    @When("User click on forget password")
    public void navigate_to_Reset_Page(){
        home_page=new Base_StepDefinition().home_page;
        login_page=home_page.navigate_to_Login();
        login_page.click_Forget_Password();
        resetPassword_page=new ResetPassword_Page(login_page.getDriver());
    }
    @And("enter his or her email")
    public void enter_Email(){
        resetPassword_page.enter_Email(email);
    }
    @And("click recover")
    public void
    click_Recover(){
        resetPassword_page.click_Cover_BTN();;
    }
    @Then("display instruction confirmation message")
    public void check_Instruction_Message(){
        String expected_Message="Email with instructions has been sent to you.";
        Assert.assertEquals(expected_Message,resetPassword_page.get_Message_Content());
    }
}
