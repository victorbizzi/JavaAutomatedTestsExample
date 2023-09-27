package properties.pageObjects;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Global_Vars;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
public class Cart_PO extends Base_PO {
    public Cart_PO(){
        super();
    }
    private Base_PO base_po;
    public Cart_PO(Base_PO base_po) {
        this.base_po = base_po;
   }
    public @FindBy(xpath = "//div[@id='shopping_cart_container']/a/span")
    WebElement shoppingCartBadge1;
    public @FindBy(id = "remove-sauce-labs-backpack")
    WebElement RemoveProductCartBtn;
    public @FindBy(id = "shopping_cart_container")
    WebElement ShoppingCartContainer;
    public @FindBy(xpath = "//span[contains(text(),'Your Cart')]")
    WebElement YourCartLbl;
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
    public void clickInCartIcon(){
        base_po.waitForWebElementAndClick(ShoppingCartContainer);
    }
    public void removeProductCart(){
        base_po.waitForWebElementAndClick(RemoveProductCartBtn);
    }
    public void cartPageValidating(){
        waitFor(YourCartLbl);
        Assert.assertEquals(YourCartLbl.getText(), "Your Cart");
    }
    public void shopping_cart_badgeShouldNotBeDisplayed(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        try {
            boolean elementInvisible = wait.until(ExpectedConditions.invisibilityOf(shoppingCartBadge1));
            if (!elementInvisible) {
                Assert.fail("Shopping cart badge is still displayed");
            }
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }
}
