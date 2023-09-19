package properties.pageObjects;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products_PO extends Base_PO{
    public Products_PO(){
        super();
    }
    public @FindBy(xpath = "//div[2]/div/div/div[2]/div")
    WebElement inventoryProductOpened;
    public @FindBy(id = "back-to-products")
    WebElement backToProductsBtn;
    public void validate_openedProduct() {
        waitFor(backToProductsBtn);
        waitFor(inventoryProductOpened);
        Assert.assertEquals(inventoryProductOpened.getText(), "Sauce Labs Backpack");
    }
}
