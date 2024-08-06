package fr.afpa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javafx.collections.FXCollections;

public class Serializer {

    public void save(Contact contact) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("contact.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(contact);
        } catch (Exception exception) {
            System.out.println("Error Serializer" + exception.getMessage());
            exception.printStackTrace();
        }
    }

    public void save(List<Contact> contacts) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("contacts.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(contacts);
        } catch (Exception exception) {
            System.out.println("Error Serializers" + exception.getMessage());
            exception.printStackTrace();
        }
    }

}