package common;

import com.codeborne.selenide.Configuration;

public class Config {
    /**
     * Possible browsers
     * Chrome
     * FireFox
     **/
    public static String BROWSER_NAME = "chrome";//firefox opera edge ie
    static {
        Configuration.browser = BROWSER_NAME;
    }
}
