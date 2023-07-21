package ru.stqa.aqa.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.aqa.addressbook.model.ContactData;
import ru.stqa.aqa.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {

        app.goTo().returnToHomePage();

        if(app.contact().all().size() == 0){
            app.contact().create(new ContactData()
                    .withFirstname("Mariya").withLastname("Kolesnikova").withNickname("MKolesnikova")
                    .withMobilePhone("+71234568899").withEmail("test@mail.com"));
        }
    }

    @Test
    public void testContactDeletion() {

        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);

        assertThat(app.contact().count(), equalTo(before.size() - 1));

        Contacts after = app.contact().all();


        assertThat(after, equalTo(before.without(deletedContact)));
    }
}
