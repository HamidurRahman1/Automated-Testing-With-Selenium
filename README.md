# Automated-Testing-With-Selenium

### Copyright disclaimer: Most of the explanations are organized from multiple internet sources for better understanding the tools and concepts. I do not own nor wrote majority portion of the original explanations.

This repository is to help me understand and learn more about Selenium and TestNG.

Content:
* [Selenium](#Selenium)
* [TestNG](#TestNG)
* [Maven](#Maven)


---

# Selenium

### Q: What is Selenium?
 - Selenium is a free, open-source User Interface automation testing tool used to validate web applications across different 
browsers and platforms. It is used exclusively for web-based applications. Selenium is composed of multiple tools. 
It works with all major platforms has support for all major browsers as well. Selenium has integration with popular 
languages like Java, C#, Python, etc.

### Q: Components of Selenium?
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

### Q: What is Selenium WebDriver Architecture?
1. All Test classes or suites are converted to JSON format as soon as they are being run.
2. All JSON generated in step 1 will be sent to Browser Driver over the HTTP protocol. (Every browser have an independent driver associated with them)
3. Browser Driver communicates with its respective browser and executes the commands by interpreting the JSON which was received.
4. Browser Driver receives a response(s) back from the browser and sends back the result to the client in JSON format.

### Q: How do you invoke a browser?
 - By creating an instance of the specific browser’s WebDriver and calling <code>webDriver.get("url")</code> method on it. 
(Assuming the apporpriate dependencies and the web driver path have been configured successfully.)
```java
WebDriver webDriver = new ChromeDriver();
webDriver.get(“urlToGet”);
```

### Q: Methods of a WebDriver?
 - ```get(String)```
    - It takes a URL as a string and tries to open it. If successful it will open the given link in the current browser 
      window.
 - ```getCurrentUrl()```
    - Returns a string representation of the URL the driver is at.
 - ```getTitle()```
    - Returns the title of the current page.
 - ```close()```
    - Closes the current window. Quits the driver if it was the only window.
 - ```findElement(By by)```
    - Finds the first element in the current page that matches the given identifier.
 - ```findElements(By by)```
    - Finds all elements in the current page that matches the given identifier.
 - ```findElements(By by)```
    - Finds all elements in the current page that matches the given identifier.
 - ```quit()```
   - Quits the driver and closes all window associated with it.
 - ```getWindowHandle()```
   - It returns a ```String``` representation of the window is in focus by the driver. The value can be used to switch to multiple windows.
 - ```getWindowHandles()```
   - It returns a ```Set<String>``` which can be iterated over to switch between windows.
 - ```manage()```
   - a 
 - ```navigate()```
   - As name suggests, it used it context of going back and/or forward in the browser's history or visited page. It returns
   a ```Navigation``` object which has these methods:
     - ```to(String)```
         - It takes a ```String``` as a URL and loads that url.
     - ```to(URL)```
         - It takes a ```URL``` as a URL and loads that url.
     - ```back()```
         - It takes back the previously visited page, if there is any.
     - ```forward()```
         - It takes the ```webdriver``` to 1 page forward, if there is any.
     - ```refresh()```
         - Refresh the current web page.
 - ```switchTo()```
   - a

### Q: What is a Locator?
 - A locator is a command that selenium identifies and using that it interacts with elements. Locators are instance of ```By```
   interface in Java.
 - <b>Types of Locators:</b>
    - ```id(String)```: Locating elements on the page using ID is the fastest way to interact with elements since ID are 
      unique. Ex. ```By.id(String)```
    - ```linkText(String)```: It is used to interact with elements (<a> tags). It takes the text that is visible for any
      given link. Ex. ```By.linkText(completeTextOfTheLink)```. The specified text is the exact text that is available on
      the webpage.
    - ```partialLinkText(String)```: It is used to interact with elements (<a> tags). It takes the text that partially matches
      any link on the web page. Ex. ```By.linkText(partialLinkText)```.
    - ```name(String)```: It locates elements on the page using HTML name attribute value given to the function. Ex. ```By.name(string)```
    - ```className(String)```: Class Name locator gives the element which matches the values specified in the HTML attribute
      name "class".
    - ```tagName(String)```: Tag Name locator is used to find the elements matching the specified HTML Tag Name. Ex. ```By.name(string)```
    - ```cssSelector(String)```: CSS Selectors in Selenium are string patterns used to identify an element based on a 
      combination of HTML tag, id, class, attributes, inner text, and child.
    - ```xpath(String)```: XPath is the language used when locating XML nodes. Since HTML can be thought of as an 
      implementation of XML, we can also use XPath in locating HTML elements.
        - Advantage: It can access almost any element, even those without class, name, or id attributes.
        - Disadvantage: It is the most complicated method of identifying elements because of too many rules and 
          considerations.
        - Tools like SelectorsHub, ChroPath, Firebug etc. can automatically generate XPath for elements on the page.

--

### Q: Challenges of Selenium?
1. Cannot test anything besides web browser.
2. Cannot test mobile applications.
3. Limited reporting. (Work around via TestNG)
4. Dynamic Elements.
5. Page load.
6. Pop up windows.
7. Handling captcha.

---

