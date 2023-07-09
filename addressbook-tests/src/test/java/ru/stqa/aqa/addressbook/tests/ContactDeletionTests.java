package ru.stqa.aqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.aqa.addressbook.model.ContactData;
import java.util.List;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() throws Exception {

        app.getNavigationsHelper().returnToHomePage();

        if(!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Mariya", "Kolesnikova", "MKolesnikova", "+71234568899", "test@mail.com", null));
        }

        List<ContactData> before = app.getContactHelper().getContactList();

        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().acceptContactDeletion();

        app.getNavigationsHelper().returnToHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);

        Assert.assertEquals(before, after);
    }
}
