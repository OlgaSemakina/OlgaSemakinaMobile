package enums;

import java.util.Properties;

public enum PropertyFile {

    WEB("webtests"), NATIVE("nativetests");

    private String currentAppType;

    PropertyFile(String current) {
        this.currentAppType = current;
    }

    public String getName() {
        return currentAppType + ".properties";
    }

}
