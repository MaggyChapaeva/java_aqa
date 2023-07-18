package ru.stqa.aqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Browser;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private String browser;
    WebDriver wd;
    private NavigationHelper navigationsHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(Browser.FIREFOX.browserName())) {
            wd = new FirefoxDriver();
        } else if (browser.equals(Browser.CHROME.browserName())) {
            wd = new ChromeDriver();
        } else if (browser.equals(Browser.IE.browserName())) {
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //увеличить таймаут при нестабильности приложения, при медленной загрузке элемента
        wd.get("http://localhost/addressbook/index.php");
        sessionHelper = new SessionHelper(wd);
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        navigationsHelper = new NavigationHelper(wd);
        sessionHelper.login("admin", "secret");
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
