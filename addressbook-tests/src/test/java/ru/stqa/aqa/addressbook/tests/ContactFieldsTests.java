package ru.stqa.aqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.aqa.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactFieldsTests extends TestBase{

    @Test(enabled = false)
    public void testContactFields(){
        app.goTo().returnToHomePage();

        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    }
    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .collect(Collectors.joining("\n"));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactFieldsTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone){
        return phone.replaceAll("[^+0-9]", "");
    }
}
