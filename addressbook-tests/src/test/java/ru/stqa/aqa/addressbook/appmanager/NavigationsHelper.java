package ru.stqa.aqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationsHelper {
    private WebDriver wd;

    public NavigationsHelper(WebDriver wd) {
        this.wd = wd;
    }

    //работа с группами
    public void gotoGroupPage() {
          wd.findElement(By.linkText("groups")).click();
    }
}
