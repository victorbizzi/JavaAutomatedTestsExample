package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import properties.pageObjects.Base_PO;
import properties.pageObjects.HomePage_PO;
import properties.pageObjects.Login_PO;
import utils.Global_Vars;
public class Login_Steps extends Base_PO {
    private HomePage_PO homePage_po;
    private Login_PO login_po;
    public Login_Steps(Login_PO login_po, HomePage_PO homePage_po) {
        this.login_po = login_po;
        this.homePage_po = homePage_po;
    }
    @Given("I access the Saucedemo Login Page")
    public void i_access_the_saucedemo_login_page() {
        login_po.NavigateToLoginPage();
    }
    @When("I enter a username {}")
    public void i_enter_a_username_non_existent(String username) {
        login_po.setUserName(username);
    }
    @And("I enter a password {}")
    public void i_enter_a_password_secret_sauce(String password) {
        login_po.setUserPassword(password);
    }
    @And("I click on the Login button")
    public void i_click_on_the_login_button() {
        login_po.clickOn_Login_Button();
    }
    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message(String text) {
        login_po.waitForAlert_And_ValidateLOGINText(text);
    }
    @Then("I should be Logged in and the Header should present the message Swag Labs")
    public void i_should_be_presented_with_the_following_login_validation_message(){
        homePage_po.validate_SuccessfulSubmissionMessage_Text();
    }
    @And("Click in Burger menu to expand the sidebar menu")
    public void click_in_burger_menu_to_expand_the_sidebar_menu() {
        homePage_po.clickOn_BugerMenu();
    }
    @And("Click in LogOut")
    public void click_in_log_out() {
        homePage_po.clickOn_LogOutBtn();
    }
    @Then("The user must be logged out")
    public void the_user_must_be_logged_out() {
        login_po.validateLoginPageBtn();
    }
    @Given("I access the Saucedemo Login Page and I Login In {} {}")
    public void i_access_the_saucedemo_login_page_and_i_Login_in(String username, String password){
        login_po.FirstStepOpenAndLogIn(Global_Vars.GlobalUsername, Global_Vars.GlobalUserPassword);
    }
}


