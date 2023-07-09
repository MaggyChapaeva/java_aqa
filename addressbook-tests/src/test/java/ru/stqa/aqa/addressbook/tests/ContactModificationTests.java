package ru.stqa.aqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.aqa.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() throws Exception {

        if(!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Mariya", "Kolesnikova", "MKolesnikova", "+71234568899", "test@mail.com", "test1"));
        }

        List<ContactData> before = app.getContactHelper().getContactList();

        app.getContactHelper().selectContact(0);
        app.getContactHelper().initContactModification();
        ContactData contact = new ContactData(before.get(0).getId(), "RenameMariya","Kolesnikova",
                "MKolesnikova", "+71234568800", "test@mail.com", null);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().updateContact();
        app.getNavigationsHelper().returnToHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size());

        before.remove(0);
        before.add(contact);

        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }
}
