package ru.stqa.aqa.addressbook.tests;
import org.openqa.selenium.By;
import org.testng.annotations.*;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() throws Exception {
        app.getNavigationsHelper().returnToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().acceptContactDeletion();
    }
}
