package com.course_qa2020;

import com.course_qa2020.listeners.TestListener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;
import static org.apache.commons.lang3.SystemUtils.IS_OS_LINUX;

@Listeners(TestListener.class)
public abstract class BaseTest {

    private static final String DEFAULT_ENV_PROPERTIES_FILE_PATH = "src/test/resources/test.properties";
    private static final String DEFAULT_ENV_REMOTE_PROPERTIES_FILE_PATH = "src/test/resources/remote.properties";
    protected RemoteWebDriver driver = null;
    private static Properties properties;

    static {
        properties = new Properties();
        loadPropertiesFromFile(DEFAULT_ENV_PROPERTIES_FILE_PATH);
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        if (IS_OS_MAC || IS_OS_LINUX) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        } else if (IS_OS_WINDOWS) {
            System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getMainUrl());
        //TODO don't need to use toString() as method returns String already
        System.out.println("----->"+getMainUrl().toString());
    //TODO please remove empty lines


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("teardown");
    }

    protected String getMainUrl() {
        String result;
        if (getProperty("test.isLocal").equals("true")) {
            result = properties.getProperty("test.mainUrl");
        } else {
            result = properties.getProperty("test.qaUrl");
        }
        return (result != null) ? result.trim() : null;
    }

    protected String getProperty(String key) {
        String result = properties.getProperty(key);
        return (result != null) ? result.trim() : null;
    }

    private static void loadPropertiesFromFile(String propertiesFilePath) {
        try {
            InputStream propertiesStream;
            propertiesStream = new FileInputStream(new File(propertiesFilePath).getPath());
            properties.load(propertiesStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
