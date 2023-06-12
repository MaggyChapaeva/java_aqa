package ru.stqa.aqa.addressbook;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() throws Exception {
        initContactCreation();
        fillContactForm(new ContactData("Mariya", "Kolesnikova", "MKolesnikova", "+71234568899", "test@mail.com"));
        submitContactCreation();
        returnToHomePage();
    }
}
