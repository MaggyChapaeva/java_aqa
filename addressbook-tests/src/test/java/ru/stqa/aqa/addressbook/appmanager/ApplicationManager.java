package ru.stqa.aqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Browser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private final Properties properties;
    private String browser;
    WebDriver wd;
    private NavigationHelper navigationsHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;

    public ApplicationManager(String browser){
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        if (browser.equals(Browser.FIREFOX.browserName())) {
            wd = new FirefoxDriver();
        } else if (browser.equals(Browser.CHROME.browserName())) {
            wd = new ChromeDriver();
        } else if (browser.equals(Browser.IE.browserName())) {
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //увеличить таймаут при нестабильности приложения, при медленной загрузке элемента
        wd.get(properties.getProperty("web.baseUrl"));
        sessionHelper = new SessionHelper(wd);
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        navigationsHelper = new NavigationHelper(wd);
        sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
    }


    public void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    public void stop() {
        logout();
        wd.quit();
    }

    public boolean isElementPresent(By by) {
      try {
        wd.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }



    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationsHelper;
    }

    public ContactHelper contact(){ return contactHelper; }
}
