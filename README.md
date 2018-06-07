# WorthTask

1- Build with Maven using Java 10.
2- TestNG Framework and Selenium are used in Java.
3- Only happy path with mandatory fields are checked.
4- Number of test cases are be able to increased. Only two test cases are created in this test suite.


You can find the end to end test cases here:

First Test includes:

1) Navigate to "https://nomad-test-spa.azurewebsites.net/declaration-residence".
2) Starts Application.
3) Selects Application Reason as "In connection with tax or social security contributions".
4) Fills out all forms with just mandatory fields.
5) Verifies the Summary Information.
6) Checks completed application is saved under "My Applications" page.


Second Test includes:
1) Navigate to "https://nomad-test-spa.azurewebsites.net/declaration-residence".
2) Starts Application.
3) Selects Application Reason as "Renewing a driving license".
4) Fills out all forms with just mandatory fields.
5) Verifies the Summary Information.
6) Checks completed application is saved under "My Applications" page.
