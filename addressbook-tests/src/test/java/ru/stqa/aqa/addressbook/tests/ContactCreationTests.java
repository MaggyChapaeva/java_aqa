package ru.stqa.aqa.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.aqa.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {

        List<ContactData> before = app.getContactHelper().getContactList();

        ContactData contact = new ContactData("Mariya", "Kolesnikova", "MKolesnikova", "+71234568899", "test@mail.com", null);
        app.getContactHelper().createContact(contact);

        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size() + 1);

        contact.setId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId());

        before.add(contact);

        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);

        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }
}
