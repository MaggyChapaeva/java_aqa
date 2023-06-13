package ru.stqa.aqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.aqa.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() throws Exception {
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("RenameMariya", "Kolesnikova", "MKolesnikova", "+71234568800", "test@mail.com"));
        app.getContactHelper().updateContact();
        app.getNavigationsHelper().returnToHomePage();
    }
}
