## First Homework:
1.
> Setup project that has been discussed in the class. 
>Make sure you can run both tests (native and web) successfully.

Both tests are located in src/test/java/scenarios directory

2. 
>For existing native mobile autotest try to use another locator (xpath, classname, ?). 
Define these locators using Appium Inspector. Are there any difference with id version?

There are no differences except that xpath is not recommended for using by Appium itself (performance issues)
From "FirstSimpleTest.java":
```sh
        // Button locator by 
        // By buttonBy = By.id(app_package_name + "addContactButton");

        // Button locator by 
        // By buttonBy = By.xpath("//android.widget.Button[@content-desc=" +
        + "'Add Contact']");

        //Button locator by className
        By buttonBy = By.className("android.widget.Button");

        driver.findElement(buttonBy).click();
```

3. 
>Modify existing tests to run on a real device. What should be changed? 

When setting capabilities it is needed to change value of capaibility “deviceName” to phone identifier (we can find it by the help of “adb devices” command)

4.
> Connect a real device to Appium (describe required actions) and run tests. Are there any difference with run on emulator?

 To connect a real device to appium we need to do next actions:
- Turn on “Developer options” and then “USB debugging”
- Connect device to computer by USB
- Type “adb devices” command into terminal in order to be sure that device is connected & to find out its identifier
- Create or change existing capabilities set: type deviceName with the identifier of current device
- Run appium session and run modified tests (deviceName in Capabilities)

I don't have any Android device so I couldn't do it on practice

5. 
> What should be improved/changed in existing test code? Why, for what?

To improve existing code we should:
- Move driver setup to main directory - since it is a service code
- Stop using hardcoded paths – because they often change and it’s hard to find those values among the code
- Not use System.out as a way of debugging things – it is not good for code readability
- Not use Thread.sleep() 
- Change structure so that Native and Web tests were splitted
