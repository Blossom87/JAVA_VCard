package fr.afpa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Deserializer {

    public Contact load() throws IOException {

        Contact deserializedContact = null;

        try {
            FileInputStream fileInputStream = new FileInputStream("contact.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            deserializedContact = (Contact) objectInputStream.readObject();
        } catch (Exception exception) {
            System.out.println("Error Deserializer" + exception.getMessage());
        }
        return deserializedContact;
    }

    @SuppressWarnings("unchecked")
    public List<Contact> loadList() {

        ArrayList<Contact> deserializedContact = null;

        try {
            FileInputStream fileInputStream = new FileInputStream("contacts.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            deserializedContact = (ArrayList<Contact>) objectInputStream.readObject();

            objectInputStream.close();
        } catch (Exception exception) {
            System.out.println("Error Deserializer" + exception.getMessage());
        }
        return deserializedContact;
    }
}
