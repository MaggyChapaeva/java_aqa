package ru.stqa.aqa.addressbook.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.aqa.addressbook.model.ContactData;


import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    //работа с контактами
    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData, boolean creation){
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());

        if(creation){
            if (contactData.getGroup()!=null) {
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void selectContact(int index) { wd.findElements(By.name("selected[]")).get(index).click(); }

    public void deleteSelectedContact() { click(By.xpath("//input[@value='Delete']")); }

    public void acceptContactDeletion() { acceptAlert(); }

    public void initContactModification() { click(By.xpath("//img[@alt='Edit']")); }

    public void updateContact() { click(By.name("update")); }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactForm(contact, true);
        submitContactCreation();
        returnToContactPage();
    }

    private void returnToContactPage() {
        wd.findElement(By.linkText("home")).click();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() throws InterruptedException {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[position() > 1]"));

        for (WebElement element : elements) {
            String firstname = element.findElement(By.xpath("./td[3]")).getText();
            String lastname = element.findElement(By.xpath("./td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.xpath("./td[1]/input")).getAttribute("value"));
            ContactData contact = new ContactData(id, firstname, lastname, null, null, null, null);
            contacts.add(contact);
        }

        return contacts;
    }
}
