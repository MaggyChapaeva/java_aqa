package ru.stqa.aqa.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.datafaker.Faker;
import ru.stqa.aqa.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    @Parameter(names = "-c", description = "Contacts count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex){
            jCommander.usage();
            return;
        }
        generator.run();
    }
    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if(format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Urecognized format");
        }
    }
    private void saveAsJson(List<ContactData> groups, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(groups);
        try (Writer writer = new FileWriter(file)){
            writer.write(json);
        }
    }
    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        File photo = new File("src/test/resources/image.jpg");
        Faker faker = new Faker();
        for (int i = 0; i < count; i++){
            contacts.add(new ContactData().withFirstname(faker.name().firstName())
                                          .withLastname(faker.name().lastName())
                                          .withNickname(faker.name().username())
                                          .withPhoto(photo)
                                          .withMobilePhone(faker.phoneNumber().phoneNumber())
                                          .withEmail(faker.address().mailBox()));
        }
        return contacts;
    }
}
