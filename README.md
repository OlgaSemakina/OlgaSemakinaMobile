## Second Homework: (#hw3)
### Run:
Use test.xml to run tests, change name to "web" or "native" depending on your needs

```sh
    <run>
        <include name="native"/>
    </run>
```

1.
> Rewrite (complete) Driver using “singleton” pattern. Are there any advantages?

If we use “singleton” pattern for Driver we have only one instance of it for the whole program. Therefore it’s not going to happen so that we use different instances of driver, staying attached to this particular driver 

2. 
> Suggest improvements for .properties reading. What are the purposes?

- We need property file in order to easy change capabilities for different kind of devices
- We split properties into two parts: for web and native tests. 
- We use enum PropertyFIle so that we don’t have hardcoded values of properties path
- We keep string that contains current property file and read data from it

3. 
> Add checks of other fields and their titles (Contact Name, Contact phone) in “native” test

Example from "SimpleNativeTest.java":
```sh
        // Check title "Target Account"
        buttonBy = By.xpath("//android.widget.TextView[@content-desc='Target Account']");
        assertEquals(driver().findElement(buttonBy).getText(), "Target Account");

        // Check text field for "Target Account" is displayed
        buttonBy = By.id(app_package_name + "accountSpinner");
        assertTrue(driver().findElement(buttonBy).isDisplayed());
```
Other checks are in "SimpleNativeTest.java"

4.
> **Optional**: Add keyboard presence check  in “native” test.

I have found out that we have an exception if the keyboard is hidden and we try to hide it with driver().hideKeyboard(), but couldn't do it properly

5. 
> Which checks would you place in the “web” test?

I would check title, url and http-code.

6. 
> Implement checks for “web” test in code and try to use.

In "SimpleWebTests.java"
