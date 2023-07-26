package ru.stqa.aqa.addressbook.model;

import com.google.common.collect.ForwardingSet;
import org.testng.Assert;
import java.util.Comparator;
import java.util.List;
import java.util.*;

public class Contacts extends ForwardingSet<ContactData> {

    private Set<ContactData> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<ContactData>(contacts.delegate);
    }

    public Contacts(){
        this.delegate = new HashSet<>();
    }

    public Contacts(Collection<ContactData> contacts){
        this.delegate = new HashSet<ContactData>(contacts);
    }


    @Override
    protected Set<ContactData> delegate() {
        return delegate;
    }

    public Contacts withAdded(ContactData contact){
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }

    public Contacts without(ContactData contact){
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }

   public Contacts replace(ContactData removedContact, ContactData addedContact){
       Contacts contacts = new Contacts(this);
       contacts.remove(removedContact);
       contacts.add(addedContact);
       return contacts;
   }
}
