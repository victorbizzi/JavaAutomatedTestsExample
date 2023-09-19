package properties.pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Global_Vars;
import java.io.IOException;
import java.time.Duration;

public class FileUploadExample_PO extends Base_PO{
    public FileUploadExample_PO() {
        super();
    }
    public @FindBy(xpath = "//input[@id='file-upload']")
    WebElement fileUploadBtn;
    public @FindBy(id="drag-drop-upload")
    WebElement dragAndDropBtn;
    public @FindBy(xpath = "//input[@id='file-upload']")
    WebElement fileNameUploadedLbl;
    public @FindBy(id = "file-submit")
    WebElement filesubmitBtn;
    public @FindBy(id = "uploaded-files")
    WebElement uploadSuccessMessage;
    public void NavigateToFileUploaderPage(){
        navigateTo_URL(Global_Vars.HEROKUAPPFILEUPLOADER_URL);
    }
    public void clickOnChooseFileButtonDragAndDrop(){
        waitForWebElementAndClick(dragAndDropBtn);
    }
    public void clickOnChooseFileButton(){
        waitFor(fileUploadBtn);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(fileUploadBtn)).click();
    }
    public void fileUploadAction() throws IOException, InterruptedException {
        //Runtime.getRuntime().exec("C:\\Users\\VictorMelo\\Desktop\\VictorAutoTestsSaucedemo\\VictorAutoTestsSaucedemo\\src\\test\\java\\stepDefinitions\\exampleFiles\\fileUpload.exe");
        Thread.sleep(2000);
        String filePath = "C:\\Users\\VictorMelo\\Desktop\\VictorAutoTestsSaucedemo\\VictorAutoTestsSaucedemo\\src\\test\\java\\stepDefinitions\\exampleFiles\\fileUpload.exe";
        ProcessBuilder processBuilder = new ProcessBuilder(filePath);

        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                //System.out.println("Process executed successfully");
            } else {
                System.err.println("Error: Process exited with code " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void fileSubmitClick(){
        waitForWebElementAndClick(filesubmitBtn);
    }
    public void validateUploadedFile(){

        waitFor(uploadSuccessMessage);
        org.junit.Assert.assertEquals(uploadSuccessMessage.getText(), "Swag Labs");
    }
}
