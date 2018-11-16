## Third Homework: (#hw4)
### Run:
Use test.xml to run tests, change name to "web" or "native" depending on your needs

```sh
    <run>
        <include name="native"/>
    </run>
```

1.
> Add support of appPackage and appActivity parameters for Android devices (reading from a .properties file and then setting in the DesiredCapabilities). Locally installed Appium DT has no need in these parameters, but for Appium server of Minsk Mobile Farm it’s mandatory.

"nativetests.properties":
```sh
    appPackage=com.example.android.contactmanager
    appActivity=.ContactManager
```

"Driver.java":
```sh
    APP_PACKAGE = getProperty("appPackage");
    APP_ACTIVITY = getProperty("appActivity");
    ...
    capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE);
    capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
```

2. 
> Change settings to run web test on a certain iOS device on Mobile Test Farm. Run test with your changes. Did test pass?

See in "webtests.properties" and "Driver.java"
"webtests.properties":
```sh
    platform=iOS
    udid=25ad632db73b1de523be6565f395cae349b4dd13
```

"Driver.java":
```sh
    UDID = getProperty("udid");
    ...
    capabilities.setCapability(MobileCapabilityType.UDID, UDID);
```

Yes, test passed

3. 
> Change settings to run native test on a certain/random Android device on Mobile Test Farm. Run test with your changes. Did test pass?

See in "nativetests.properties" and "Driver.java"
"nativetests.properties":
```sh
    platform=Android
    deviceName=LGE Nexus 5
```

"Driver.java":
```sh
    DEVICE_NAME = getProperty("deviceName");
    ...
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
```

Yes, test passed

4.
> What’s wrong with our code? How to fix/improve it? Implement your suggestions.

- We can use Page Objects Pattern
- We can use xml instead of .properties in order to make cross-platform tests (for now we have webtest.properties with settings for iOS and nativetests.properties for Android)
- In native tests we can use @AndroidFindBy and @iOSFindBy annotations in addition to standard @FindBy to make code cross-platform

