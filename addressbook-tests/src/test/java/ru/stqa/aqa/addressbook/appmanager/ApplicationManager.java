package ru.stqa.aqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.aqa.addressbook.model.ContactData;
import ru.stqa.aqa.addressbook.model.GroupData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private WebDriver wd;

    public void init() {
        System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/index.php");
        login("admin", "secret");
    }

    private void login(String username, String pass) {
      wd.findElement(By.name("user")).click();
      wd.findElement(By.name("pass")).clear();
      wd.findElement(By.name("pass")).sendKeys(pass);
      wd.findElement(By.name("user")).clear();
      wd.findElement(By.name("user")).sendKeys(username);
      wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    //работа с группами
    public void gotoGroupPage() {
          wd.findElement(By.linkText("groups")).click();
    }

    public void returnToGroupPage() {
      wd.findElement(By.linkText("group page")).click();
    }

    public void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public void fillGroupForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());

    }

    public void submitGroupCreation() {
      wd.findElement(By.name("submit")).click();
    }

    public void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void deleteSelectedGroup() {
        wd.findElement(By.name("delete")).click();
    }

    //работа с контактами
    public void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void fillContactForm(ContactData contactData){
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
    }

    public void submitContactCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void returnToHomePage() {
        wd.findElement(By.linkText("home")).click();
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

    public boolean isAlertPresent() {
      try {
        wd.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }
}
