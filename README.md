# Automated-Testing-With-Selenium

### Copyright disclaimer: Most of the explanations are organized from multiple internet sources for better understanding the tools and concepts. I do not own nor wrote majority portion of the original explanations.

This repository is to help me understand and learn more about Selenium and TestNG.

Content:
* [Selenium](#Selenium)
* [TestNG](#TestNG)
* [Maven](#Maven)


---

# Selenium

### Q: What is selenium?
 - Selenium is an free, open-source User Interface automation testing tool used to validate web applications across different 
browsers and platforms. It is used exclusively for web-based applications. Selenium is composed of multiple tools. 
It works with all major platforms has support for all major browsers as well. Selenium has integration with popular 
languages like Java, C#, Python, etc.

### Q: Components of selenium?
 - <h4>Selenium IDE</h4>
    - Selenium IDE is Firefox plugin which gives us the reacord/play back feature of test cases via a GUI. It allows to write 
    a test case and convert this test case to any supporting language.
 - <h4>Selenium RC</h4>
    - Selenium RC was the main Selenium project for a long time before the WebDriver merge brought up Selenium. Selenium
      1 is still actively supported (in maintenance mode). It relies on JavaScript for automation.
 - <h4>Selenium WebDriver</h4>
    - Selenium WebDriver is a browser automation framework that accepts commands and sends them to a browser. It is 
      implemented through a browser-specific driver. It controls the browser by directly communicating with it. This is 
      now used widely over Selenium RC due to its simplicity and functionality.
 - <h4>Selenium Grid</h4>
    - Selenium Grid is a tool used to run tests on different machines against different browsers in parallel. That is, 
      running multiple tests at the same time against different machines running different browsers and operating systems.

### What is Selenium WebDriver Architecture?
1. All Test classes or suites are converted to JSON format as soon as they are being run.
2. All JSON generated in step 1 will be sent to Browser Driver over the HTTP protocol. (Every browser have an independent driver associated with them)
3. Browser Driver communicates with its respective browser and executes the commands by interpreting the JSON which was received.
4. Browser Driver receives a response(s) back from the browser and sends back the result to the client in JSON format.

### How do you invoke a browser?
By creating an instance of the specific browser’s WebDriver and calling <code>webDriver.get("url")</code> method on it. 
(Assuming the apporpriate dependencies and the web driver path have been configured successfully.)
```java
WebDriver webDriver = new ChromeDriver();
webDriver.get(“urlToGet”);
```

### Methods of a WebDriver?
 - <code>get(string)</code>
    - It takes URL as a string and tries to open it. If successful it will open the given link in the current browser window.
 - <code>getCurrentUrl()<code>
    - Returns a string represtation of the URL the driver is at.
 - <code>getTitle()</code>
    - Returns the title of the current page.
 - <code>close()</code>
    - Closes the current window. Quits the driver if it was the only window.
 - <code>findElement(By by)<code>
    - Finds the first element in the current page that matches the given identifier.
 - <code>findElements(By by)<code>
    - Finds all elements in the current page that matches the given identifier.
    
--

### Challenges of Selenium?
1. Cannot test anything besides web browser.
2. Cannot test mobile applications.
3. Limited reporting. (Work around via TestNG)
4. Dynamic Elements.
5. Page load.
6. Pop up windows.
7. Handling captcha.

---

