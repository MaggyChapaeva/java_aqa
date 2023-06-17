package ru.stqa.aqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class HelperBase {

    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void type(By locator, String text) {
        click(locator);
        if(text != null){
            String existingText = wd.findElement(locator).getAttribute("value");
            if(!text.equals(existingText)){ //проверяет, если поле заполнено другим значением
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }  //если переданные данные будут содержать null, то метод sendKeys не вызывается и поле проосто останется пустым
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void acceptAlert() { wd.switchTo().alert().accept(); }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
