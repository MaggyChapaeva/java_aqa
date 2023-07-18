package ru.stqa.aqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.aqa.addressbook.model.ContactData;
import java.util.List;

public class ContactDeletionTests extends TestBase{

    @Test(enabled = false)
    public void testContactDeletion() throws Exception {

        app.goTo().returnToHomePage();

        if(!app.contact().isThereAContact()){
            app.contact().createContact(new ContactData("Mariya", "Kolesnikova", "MKolesnikova", "+71234568899", "test@mail.com", null));
        }

        List<ContactData> before = app.contact().getContactList();

        app.contact().selectContact(before.size() - 1);
        app.contact().deleteSelectedContact();
        app.contact().acceptContactDeletion();

        app.goTo().returnToHomePage();

        List<ContactData> after = app.contact().getContactList();

        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);

        Assert.assertEquals(before, after);
    }
}
