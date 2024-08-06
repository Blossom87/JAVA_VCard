package fr.afpa;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class VCardSerializer {

    /**
     * Méthode de sérialisation vCard d'un objet de la classe "Contact"
     * 
     * @param contact
     */
    public String serialize(Contact contact) {

        /// 1 construire la chaîne de caractères correspondant au contenu vCard
        String vCardContent = "BEGIN:VCARD\nVERSION:4.0";

        // Construction du nom
        vCardContent = vCardContent + "N:" + contact.getLastName().get() + ";" + contact.getFirstName().get() + ";"
                + contact.getGender().get() + "\n";

        // Construction du "full name"
        vCardContent = vCardContent + "FN:" + contact.getFirstName().get() + " " + contact.getLastName().get() + "\n";
        vCardContent = vCardContent + "ADR:" + contact.getAddress().get() + ";" + contact.getZipCode().get() + "\n";
        vCardContent = vCardContent + "EMAIL:" + contact.getMail().get() + "\n";
        vCardContent = vCardContent + "TEL:" + contact.getPersonalPhone().get() + ";" + contact.getProfessionalPhone().get() + "\n";
        vCardContent = vCardContent + "ORG:" + contact.getGitLinks().get() + "\n";
        vCardContent = vCardContent + "END:VCARD" + "\n";
        vCardContent = vCardContent + "\n";

        return vCardContent;
    }

    public void exportMultipleContacts(List<Contact> contacts) {
        String vCardContent = "";
        for (Contact contact : contacts) {
            vCardContent += this.serialize(contact);
        }

         // 2 écrire cette chaîne dans un fichier
         File file = new File("contacts"+LocalDate.now().toString()+".vcard");
         FileWriter fileWriter = null;
         try {
             // instanciation du FileWriter
             fileWriter = new FileWriter(file);
 
             // éciture de la chaîne de caractères
             fileWriter.write(vCardContent);
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             try {
                 fileWriter.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
    }

    public void exportSingleContact(Contact contact) {
        String vCardContent =this.serialize(contact);

        // 2 écrire cette chaîne dans un fichier
        File file = new File(contact.getFirstName().get()+contact.getLastName().get()+".vcard");
        FileWriter fileWriter = null;
        try {
            // instanciation du FileWriter
            fileWriter = new FileWriter(file);

            // écriture de la chaîne de caractères
            fileWriter.write(vCardContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}