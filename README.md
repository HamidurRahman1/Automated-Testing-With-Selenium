# Automated-Testing-With-Selenium

### Copyright disclaimer: Most of the explanations are organized from multiple internet sources for better understanding the tools and concepts. I do not own nor wrote majority portion of the original explanations.

This repository is to help me understand and learn more about Selenium and TestNG.

Links:
* https://www.seleniumeasy.com/selenium-tutorials
* https://www.softwaretestingmaterial.com/category/selenium/

Content:
* [Selenium](#Selenium)
* [TestNG](#TestNG)
* [Maven](#Maven)

# Selenium
### Q: What is selenium?
 - "Selenium is an free, open-source User Interface automation testing tool used to validate web applications across different 
browsers and platforms. It is used exclusively for web-based applications. Selenium is composed of multiple tools. 
It works with all major platforms has support for all major browsers as well. Selenium has integration with popular 
languages like Java, C#, Python, etc."

### Q: Components of selenium?
- Selenium IDE
    - Selenium IDE is Firefox plugin which gives us the reacord/play back feature of test cases via a GUI. It allows to write 
    a test case and convert this test case to any supporting language.
 - Selenium RC
    - Selenium RC was the main Selenium project for a long time before the WebDriver merge brought up Selenium. Selenium
      1 is still actively supported (in maintenance mode). It relies on JavaScript for automation.
 - Selenium WebDriver
    - Selenium WebDriver is a browser automation framework that accepts commands and sends them to a browser. It is 
      implemented through a browser-specific driver. It controls the browser by directly communicating with it. This is 
      now used widely over Selenium RC due to its simplicity and functionality.
 - Selenium Grid
    - Selenium Grid is a tool used to run tests on different machines against different browsers in parallel. That is, 
      running multiple tests at the same time against different machines running different browsers and operating systems.
