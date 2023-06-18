package ru.stqa.aqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationsHelper extends HelperBase {

    public NavigationsHelper(WebDriver wd) {
        super(wd);
    }

    //работа с группами
    public void gotoGroupPage() {
        if(isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        } else{
            click(By.linkText("groups"));
        }

    }

    public void returnToHomePage() {
        if(isElementPresent(By.id("maintable"))){
            return;
        }
        wd.findElement(By.linkText("home")).click();
    }

}
