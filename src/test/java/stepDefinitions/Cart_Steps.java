package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import properties.pageObjects.*;
public class Cart_Steps extends Base_PO {
    private Cart_PO cart_po;
    private HomePage_PO homePage_po;
    private Base_PO base_po;
    public Cart_Steps(Cart_PO cart_po, HomePage_PO homePage_po,Base_PO base_po) {
        this.cart_po = cart_po;
        this.base_po = base_po;
        this.homePage_po = homePage_po;
    }
    @And("The Shopping_cart_badge should not appear")
    public void the_Shopping_cart_badge_should_not_appear() throws InterruptedException {
        base_po.waitFor(cart_po.ShoppingCartContainer);
        Thread.sleep(2000);
        cart_po.ShoppingCartBadgeNotAppears();
    }
    @And("I click in Add To Cart button in first product")
    public void click_in_Add_To_Cart_button_in_first_product(){
        homePage_po.clickIn_AddToCart();
    }
    @Then("The Shopping_cart_badge should count 1")
    public void the_shopping_cart_badge_should_count() {
        cart_po.ShoppingCartBadgeAppears();
    }
    @And("I click in Cart Icon")
    public void i_click_in_cart_icon(){
        cart_po.clickInCartIcon();
    }
    @And("I should be redirected to Cart Page")
    public void i_should_be_redirected_to_Cart_Page(){
        cart_po.cartPageValidating();
    }
    @And("I click in button to Remove From Cart")
    public void i_click_in_button_to_Remove_From_Cart(){
        cart_po.removeProductCart();
    }
    @Then("The Shopping_cart_badge should not be displayed")
    public void the_Shopping_cart_badge_should_not_be_displayed(){
        cart_po.shopping_cart_badgeShouldNotBeDisplayed();
    }
}
