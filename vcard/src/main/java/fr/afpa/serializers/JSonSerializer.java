package fr.afpa.serializers;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import fr.afpa.models.Contact;

public class JSonSerializer {

    public void exportMultipleContacts(List<Contact> contacts) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Transformer chaque contact en structure JSON
            List<ObjectNode> jsonContacts = contacts.stream().map(contact -> {
                ObjectNode jsonContact = objectMapper.createObjectNode();
                jsonContact.put("firstName", contact.getFirstName().get()); // Utiliser .get() pour obtenir la
                                                                            // valeur
                                                                            // String
                jsonContact.put("lastName", contact.getLastName().get());
                jsonContact.put("surName", contact.getSurname().get());
                jsonContact.put("gender", contact.getGender().get());
                jsonContact.put("birthDate", contact.getBirthDate().toString()); // Assurez-vous que c'est une
                                                                                 // chaîne
                jsonContact.put("address", contact.getAddress().get());
                jsonContact.put("zipcode", contact.getZipCode().get());
                jsonContact.put("personalPhone", contact.getPersonalPhone().get());
                jsonContact.put("professionalPhone", contact.getProfessionalPhone().get());
                jsonContact.put("mail", contact.getMail().get());
                jsonContact.put("gitLink", contact.getGitLinks().get());
                return jsonContact;
            }).collect(Collectors.toList());

            // Écrire les données dans un fichier JSON
            objectMapper.writeValue(new File("contacts.json"), jsonContacts);
            System.out.println("Exportation done in contacts.json");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    public void exportSingleContact(Contact contact) {
    }
}
