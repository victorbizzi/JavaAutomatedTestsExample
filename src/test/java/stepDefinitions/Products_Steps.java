package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import properties.pageObjects.Base_PO;
import properties.pageObjects.HomePage_PO;
import properties.pageObjects.Login_PO;
import properties.pageObjects.Products_PO;

public class Products_Steps extends Base_PO {
    private HomePage_PO homePage_po;
    private Login_PO login_po;
    private Products_PO products_po;
    public Products_Steps(Login_PO login_po, HomePage_PO homePage_po, Products_PO products_po) {
        this.login_po = login_po;
        this.homePage_po = homePage_po;
        this.products_po = products_po;
    }
    @And("I click on the Product Name")
    public void i_click_on_the_product_name() {
        homePage_po.clickOn_FirstProduct();
    }
    @Then("The Product Page Details should be opened")
    public void the_product_page_details_should_be_opened() {
        products_po.validate_openedProduct();
    }
}


