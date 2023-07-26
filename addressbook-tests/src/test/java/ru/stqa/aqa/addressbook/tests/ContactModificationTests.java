package ru.stqa.aqa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.aqa.addressbook.model.ContactData;
import ru.stqa.aqa.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if(app.db().contacts().size() == 0){
            app.goTo().returnToHomePage();
            app.contact().create(new ContactData().withFirstname("Mariya")
                                                  .withLastname("Kolesnikova")
                                                  .withNickname("MKolesnikova")
                                                  .withMobilePhone("+71234568899")
                                                  .withEmail("test@mail.com"));
        }
    }
    @Test
    public void testContactModification() {

        Contacts before = app.db().contacts();
        ContactData updatedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(updatedContact.getId())
                                               .withFirstname("RenameMariya")
                                               .withLastname("Kolesnikova")
                                               .withNickname("MKolesnikova")
                                               .withMobilePhone("+71234568800")
                                               .withEmail("test@mail.com");
        app.contact().update(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.replace(updatedContact, contact)));
        verifyContactListInUI();
    }
}
