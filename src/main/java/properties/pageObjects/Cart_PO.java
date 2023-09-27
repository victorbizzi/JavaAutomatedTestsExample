package properties.pageObjects;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Global_Vars;
import java.time.Duration;
public class Cart_PO extends Base_PO {
    public Cart_PO(){
        super();
    }
    public @FindBy(xpath = "//div[@id='shopping_cart_container']/a/span")
    WebElement shoppingCartBadge1;
    public @FindBy(id = "shopping_cart_container")
    WebElement ShoppingCartContainer;
    public void ShoppingCartBadgeNotAppears() {
        if (shoppingCartBadge1.isDisplayed()) {
            Assert.fail("Shopping cart badge is present.");
        }
    }
    public void ShoppingCartBadgeAppears() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(shoppingCartBadge1));
        if (shoppingCartBadge1.isDisplayed()) {
            Assert.assertTrue(true);
        }
    }
}
