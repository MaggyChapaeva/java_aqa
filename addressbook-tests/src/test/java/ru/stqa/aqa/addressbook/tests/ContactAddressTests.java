package ru.stqa.aqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.aqa.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase{

    @Test
    public void testContactAddress(){

        app.goTo().returnToHomePage();

        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        System.out.println(contact.getAddress());
        System.out.println(contact.getFirstname());
        System.out.println(contactInfoFromEditForm.getAddress());
        System.out.println(contactInfoFromEditForm.getFirstname());
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    }
}
