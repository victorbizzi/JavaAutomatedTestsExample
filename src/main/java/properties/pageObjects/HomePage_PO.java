package properties.pageObjects;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_PO extends Base_PO {
    public HomePage_PO(){
        super();
    }
    public @FindBy(xpath = "//div[3]/a")
    WebElement chartBtn;
    public @FindBy(xpath = "//div[@id='header_container']/div/div[2]/div")
    WebElement SwagLabsLbl;
    public @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    WebElement burgerBtn;
    public @FindBy(id = "logout_sidebar_link")
    WebElement logoutBtn;
    public @FindBy(xpath = "//a[@id='item_4_title_link']/div")
    WebElement productNameBackpack;
    public void clickOn_HomeChart_Button(){
        waitForWebElementAndClick(chartBtn);
    }
    public void validate_SuccessfulSubmissionMessage_Text(){
        waitFor(SwagLabsLbl);
        Assert.assertEquals(SwagLabsLbl.getText(), "Swag Labs");
    }
    public void clickOn_BugerMenu(){
        waitForWebElementAndClick(burgerBtn);
    }
    public void clickOn_LogOutBtn(){
        waitForWebElementAndClick(logoutBtn);
    }
    public void clickOn_FirstProduct(){
        waitForWebElementAndClick(productNameBackpack);
    }
}
