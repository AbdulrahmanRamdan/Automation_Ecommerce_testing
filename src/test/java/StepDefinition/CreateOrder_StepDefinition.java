package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.Cart_Page;
import pages.CheckOut_Page;
import pages.CheckoutCompletedPage;

public class CreateOrder_StepDefinition {
    private Cart_Page cart_page;
    private CheckOut_Page checkOut_page;
    private CheckoutCompletedPage completedPage;
    @And("Accept the term and click Checkout")
    public void accept_Terms_and_checkout(){
        cart_page=new Cart_Page(new Base_StepDefinition().driver);
        cart_page.scroll_Down();
        cart_page.accept_Terms();
        cart_page.click_Checkout();
    }
    @And("fill checkout data")
    public void fill_Data() throws InterruptedException {
        Thread.sleep(3000);
        checkOut_page=new CheckOut_Page(cart_page.getDriver());
        checkOut_page.setCountry();
        checkOut_page.setCity("Cairo");
        checkOut_page.setAddress1("cairo");
        checkOut_page.setPhoneNumber("01111");
        checkOut_page.setZipCode("46202");
        checkOut_page.clickContinue1();
    }
    @And("choose Shipping Method")
    public void choose_Shipping_Method(){
        checkOut_page.clickContinue2();
    }
    @And("choose Payment Method")
    public void choose_SPayment_Method(){
        checkOut_page.clickContinue3();
    }
    @And("read Payment information")
    public void read_Payment_info(){
        checkOut_page.clickContinue4();
    }
    @And("confirm payment")
    public void confirm_Payment(){
        completedPage=checkOut_page.clickConfirm();
    }
    @Then("confirm order message should be display")
    public void check_Order_Message(){
        Assert.assertEquals(completedPage.getConfirmationMessage(),"Your order has been successfully processed!");
    }
}
