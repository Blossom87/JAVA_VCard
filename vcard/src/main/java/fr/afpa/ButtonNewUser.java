package fr.afpa;

import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ComboBox;

public class ButtonNewUser {

    @FXML
    private TableView<Contact> contactTableView;
    
    // Champs du formulaire
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField surnameField;
    @FXML
    private ComboBox<String> genderComboBox;
    @FXML
    private DatePicker dateOfBirthPicker;
    @FXML
    private TextField adressField;
    @FXML
    private TextField zipCodeField;
    @FXML
    private TextField personalPhoneField;
    @FXML
    private TextField professionalPhoneField;
    @FXML
    private TextField mailField;
    @FXML
    private TextField gitField;

    @FXML
    private void handleNewContact() {
        // Récupérer les valeurs des champs
        String lastName = lastNameField.getText();
        String firstName = firstNameField.getText();
        String surname = surnameField.getText();
        String gender = genderComboBox.getValue();
        LocalDate dateOfBirth = dateOfBirthPicker.getValue();
        String address = adressField.getText();
        String zipCode = zipCodeField.getText();
        String personalPhone = personalPhoneField.getText();
        String professionalPhone = professionalPhoneField.getText();
        String email = mailField.getText();
        String git = gitField.getText();

        // Créer un nouvel objet Contact
        Contact newContact = new Contact(lastName, firstName, surname, gender, dateOfBirth, address, zipCode, personalPhone, professionalPhone, email, git);

        // Ajouter le nouveau contact à la TableView
        contactTableView.getItems().add(newContact);

        // Réinitialiser les champs du formulaire
        lastNameField.clear();
        firstNameField.clear();
        surnameField.clear();
        genderComboBox.getSelectionModel().clearSelection();
        dateOfBirthPicker.setValue(null);
        adressField.clear();
        zipCodeField.clear();
        personalPhoneField.clear();
        professionalPhoneField.clear();
        mailField.clear();
        gitField.clear();
    }
}

    


