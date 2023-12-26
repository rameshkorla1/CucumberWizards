Feature: Contact Us Feature

@ContactUs
Scenario Outline: Contact Us Scenario with different set of Data

Given user navigates to contact us page
When user fills the form from given sheetname "<SheetName>" and rownumber <RowNumber>
And user clicks on send button
Then it shows a successful message "Your message has been successfully sent to our team."

Examples:
|SheetName|RowNumber|
|Contactus|0|
|Contactus|1|