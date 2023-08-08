## SDET-Tech-Test
All the integration test for API's will be automated in this repo using Java, Rest-assured,Cucumber and Junit

### To start with the project
* Maven should be installed and configured
* Java should be installed and configured preferable java20
* clone the repository (Branch : main)
* Import the project into an IDE and install cucumber plugin


### Some of the key features of this framework:
* It generates report with all the step details. Report will be generated HTML format.
* Generates execution logs, with detailed request and response details in **logging.txt** file
* Feature file has been parameterised with examples.
* Test execution can be triggered form command line
* Easy integration to CI/CD pipeline
* Design pattern (Singleton, Factory, Builder) and all the oops concepts used

## Running Test:
* To execute the tests run **"mvn test verify"** or open cucumber/Options/TestRunner.java and right click run test runner
* Logs can be found in **logging.txt** file
* Test reports can be found in folder **/target/cucumber-html-reports/overview-features.html**
* Json report can be found in **\target\jsonReports**

