package ru.stqa.aqa.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.aqa.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() throws Exception {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("Mariya", "Kolesnikova", "MKolesnikova", "+71234568899", "test@mail.com"));
        app.getContactHelper().submitContactCreation();
        app.getNavigationsHelper().returnToHomePage();
    }
}
