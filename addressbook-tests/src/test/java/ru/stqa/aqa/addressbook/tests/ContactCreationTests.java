package ru.stqa.aqa.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.aqa.addressbook.model.ContactData;
import ru.stqa.aqa.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/image.jpg");
        ContactData contact = new ContactData()
                .withFirstname("Mariya").withLastname("Kolesnikova").withNickname("MKolesnikova")
                .withPhoto(photo).withMobilePhone("+71234568899").withEmail("test@mail.com");
        app.contact().create(contact);

        assertThat(app.contact().count(), equalTo(before.size() + 1));

        Contacts after = app.contact().all();

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    /*@Test
    public void testCurrentDir(){
        File currentDir = new File("");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/image.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }*/

}
