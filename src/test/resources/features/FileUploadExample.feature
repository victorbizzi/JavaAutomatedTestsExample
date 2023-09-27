@fileuploader @all
Feature: HerokuApp - File Upload Test Example

  Scenario: Select and Upload a File
    Given I access the HerokuApp File Uploader Page
    When I click on Choose File Drag And Drop
    And I select the PDF file
    And I click on Upload button
    #Then The system should display a successful upload message

