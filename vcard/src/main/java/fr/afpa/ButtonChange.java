package fr.afpa;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
public class ButtonChange { @FXML
    private Button changeButton;

    @FXML
    private TableView<Kontact> contactTableView;

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
    private void handleChangeContact() {
        // Récupérer le contact sélectionné
        Kontact selectedContact = contactTableView.getSelectionModel().getSelectedItem();

        if (selectedContact != null) {
            // Mettre à jour les informations du contact
            selectedContact.setLastName(lastNameField.getText());
            selectedContact.setFirstName(firstNameField.getText());
            selectedContact.setSurname(surnameField.getText());
            selectedContact.setGender(genderComboBox.getValue());
            selectedContact.setDateOfBirth(dateOfBirthPicker.getValue());
            selectedContact.setAddress(adressField.getText());
            selectedContact.setZipCode(zipCodeField.getText());
            selectedContact.setPersonalPhone(personalPhoneField.getText());
            selectedContact.setProfessionalPhone(professionalPhoneField.getText());
            selectedContact.setEmail(mailField.getText());
            selectedContact.setGit(gitField.getText());

            // Rafraîchir la TableView pour refléter les modifications
            contactTableView.refresh();

            // Afficher un message de confirmation
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Modification réussie");
            alert.setHeaderText(null);
            alert.setContentText("Le contact a été modifié avec succès.");
            alert.showAndWait();
        } else {
            // Alerter l'utilisateur si aucun contact n'est sélectionné
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Pas de sélection");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un contact à modifier.");
            alert.showAndWait();
        }
    }
}
    

