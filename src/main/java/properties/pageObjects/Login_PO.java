package properties.pageObjects;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Global_Vars;
import java.time.Duration;
public class Login_PO extends Base_PO {
    public Login_PO(){
        super();
    }
    private HomePage_PO homePage_po;
    public @FindBy(id = "user-name")
    WebElement userNameTxt;
    public @FindBy(id = "password")
    WebElement userPasswordTxt;
    public @FindBy(id = "login-button")
    WebElement loginBtn;
    public @FindBy(xpath = "//h3")
    WebElement errorLoginMessage;
    public @FindBy(css = ".form_group:nth-child(1) path")
    WebElement xIconUser;
    public @FindBy(css = ".form_group:nth-child(2) path")
    WebElement xIconPassword;
    public void NavigateToLoginPage(){
        navigateTo_URL(Global_Vars.SAUCEDEMO_URL);
    }
    public void setUserName(String username){
        sendKeys(userNameTxt, username);
    }
    public void setUserPassword(String password){
        sendKeys(userPasswordTxt, password);
    }
    public void clickOn_Login_Button(){
        waitForWebElementAndClick(loginBtn);
    }
    public void waitForAlert_And_ValidateLOGINText(String text){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(errorLoginMessage));
        String elementText = errorLoginMessage.getText();
        Assert.assertEquals(elementText, text);
    }
    public void validateLoginPageBtn(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
    }
    public void actionValidLogin(String username, String password){
        sendKeys(userNameTxt, username);
        sendKeys(userPasswordTxt, password);
        waitForWebElementAndClick(loginBtn);
    }
    public void FirstStepOpenAndLogIn(String username, String password) {
        NavigateToLoginPage();
        actionValidLogin(username, password);
        waitFor(homePage_po.SwagLabsLbl);
        org.junit.Assert.assertEquals(homePage_po.SwagLabsLbl.getText(), "Swag Labs");
    }
}
