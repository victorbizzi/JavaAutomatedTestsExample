package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import properties.pageObjects.Base_PO;
import properties.pageObjects.FileUploadExample_PO;
import java.io.IOException;
public class FileUploadExample_Steps extends Base_PO {
    private FileUploadExample_PO fileUploadExample_po;
    public FileUploadExample_Steps(FileUploadExample_PO fileUploadExample_po) {
        this.fileUploadExample_po = fileUploadExample_po;
    }
    @Given("I access the HerokuApp File Uploader Page")
    public void i_access_the_saucedemo_login_page() {
        fileUploadExample_po.NavigateToFileUploaderPage();
    }
    @When("I click on Choose File Drag And Drop")
    public void i_click_on_choose_file_dragAndDrop() throws InterruptedException {
        fileUploadExample_po.clickOnChooseFileButtonDragAndDrop();
        Thread.sleep(2000);
    }
    @And("I select the PDF file")
    public void i_select_the_pdf_file() throws IOException, InterruptedException {
        fileUploadExample_po.fileUploadAction();
        Thread.sleep(2000);
    }
    @And("I click on Upload button")
    public void i_click_on_upload_button() {
        fileUploadExample_po.fileSubmitClick();
    }
    @Then("The system should display a successful upload message")
    public void the_system_should_display_a_successful_upload_message(){
            fileUploadExample_po.validateUploadedFile();
    }
}
