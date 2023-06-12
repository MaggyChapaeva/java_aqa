package ru.stqa.aqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationsHelper extends HelperBase {

    public NavigationsHelper(WebDriver wd) {
        super(wd);
    }

    //работа с группами
    public void gotoGroupPage() {
          click(By.linkText("groups"));
    }
}
