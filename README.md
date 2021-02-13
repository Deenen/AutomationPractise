Main computing language: Java\
UI test Automation tool: selenium WebDriver\
built automation tool: Maven\
IDE: intellij\
Framework: Cucumber BDD, DDD hybrid Framework

I used Page Object Model(POM) for my framework, so that it will be easier to manage and maintain the framework.\
All the webElements and related methods will be in their corresponding page, in order to locate and re-use them easily.

For locating webElements, if the webElements has unique id, name, className or tag I used @FindBy annotation. \
However, if I noticed multiple webElements with similar xpath, I used dynamic xpath with String.format().\
This is to ensure to create only one method that can select multiple webelements.\
For example: userSelectToAndSelectFromTheMenu(String mainMenu, String subMenu) method under Homepage, \
Where we have multiple options for parameters.

I implemented Behavior-driven development(BDD) approach to simplify reading and understanding the framework.\
Test cases are written using Gherkin language, which is similar to English.
For each user story, I created Cucumber feature files, which stored under resources package.

I implemented the actual code in the step_definitions classes,\
where we can created an object of the page classes, so that we can have access to their webElement and Methods.

I triggered my framework from the Runner class,\
Which is able to accept different types of tags so that it can run different test cases.\
I also added a FailedRunner Class. If there were any failed scenarios, we can just trigger it from here.\
In the future, we can add more Runner class to our need as well, such as runner class for Smoke or Regression\
Additionally, if we had multiple test cases, we could add another Runner class as well for parallel Testing.

All general re-usable methods are stored under utility package.\
Here, I created Singleton Design Pattern Driver Class to allow my framework to pass the same instance of my webdriver in one session\
I also created ConfigurationReader class as well so we can read the information from configuration.Properties,\
(For instance: browser type, environment, username and password)

One last thing is that, I implemented Maven Cucumber Reporting, so that, at the end, it will generate a well designed report.

Here is the general flow of my Framework:
- Create a feature file for given test cases using Gherkin language
- Locate necessary webElement under pages 
- Implement the actual code in step definition 
- Run it from Runner class depend on our need

Benefits of using this framework is that it is easy to maintain, highly organized, high re-usability,
supports multi browsers, parallel testing, generates well designed reports and many more.\
It not only supports frontend UI testing, but also can be modified to do database testing using JDBC and API testing with restAssuard.

As mentioned in my email, when I was testing the website, it would sometimes become unstable and wouldn't load.\
Here is a short video to demonstrate that the Framework is functional.\
[![AutomationPractise Demo Video](https://github.com/Alimu-A/AutomationPractise/blob/master/AutomationPractise%20Demo.gif)](https://drive.google.com/file/d/1JmimGtpSOml6VJs3OQFvvqEhq18ZznHF/view?usp=sharing)

Here is the screenshot of a sample generated maven cucumber report.\
![Automation Practise Generated sample Report](https://github.com/Alimu-A/AutomationPractise/blob/master/AutoamtionPractise%20Report.jpg)

