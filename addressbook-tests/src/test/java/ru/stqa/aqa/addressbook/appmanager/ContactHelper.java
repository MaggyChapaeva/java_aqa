package ru.stqa.aqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.aqa.addressbook.model.ContactData;
public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    //работа с контактами
    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData){
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void selectContact() { click(By.name("selected[]")); }

    public void deleteSelectedContact() { click(By.xpath("//input[@value='Delete']")); }

    public void acceptContactDeletion() { acceptAlert(); }

    public void initContactModification() { click(By.xpath("//img[@alt='Edit']")); }

    public void updateContact() { click(By.name("update")); }
}
