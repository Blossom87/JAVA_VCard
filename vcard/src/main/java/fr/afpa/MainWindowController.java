package fr.afpa;

import java.io.DataOutput;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.input.MouseEvent;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MainWindowController {

    @FXML
    private Button exportSelectionButton; // Assurez-vous que le fx:id correspond dans le fichier FXML

    @FXML
    private Button newContact;

    @FXML
    private Button exportAllButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button changeButton;

    @FXML
    private TableView<Contact> contactTableView;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textFieldLastName;

    @FXML
    private TextField textFieldFirstName;

    @FXML
    private TextField textFieldSurnameField;

    @FXML
    private ChoiceBox<String> genderBox;

    private String[] genders = { "Man", "Woman", "Other" };

    @FXML
    private DatePicker dateOfBirthPicker;

    public void getDate(ActionEvent event) {

        LocalDate myDate = dateOfBirthPicker.getValue();
    }

    @FXML
    private TextField textFieldAdressField;

    @FXML
    private TextField textFieldZipCodeField;

    @FXML
    private TextField textFieldPersonalPhoneField;

    @FXML
    private TextField textFieldProfessionalPhoneField;

    @FXML
    private TextField textFieldMail;

    @FXML
    private TextField textFieldGitField;

    @FXML
    private TableView<Contact> tableView2C;

    @FXML
    private TableColumn<Contact, String> tableCLName;

    @FXML
    private TableColumn<Contact, String> tableCFName;

    @FXML
    private ObservableList<Contact> contacts = FXCollections.observableArrayList();

    @FXML
    private Label labelErrorMSG;

    @FXML
    public void initialize() {

        LocalDate birthDate = LocalDate.of(2020, 1, 8);

        contacts.add(new Contact("Gaston", "Lagaffe", "Lagaf", "Man", birthDate, "4 Rue de la Gaffe", "11111",
                "0555055505", "0666066606", "mail", "test"));

        tableView2C.setItems(contacts);
        tableCLName.setCellValueFactory(cellData -> cellData.getValue().getLastName());
        tableCFName.setCellValueFactory(cellData -> cellData.getValue().getFirstName());
        genderBox.getItems().addAll(genders);
        deleteButton.setVisible(false);
        changeButton.setVisible(false);
    }

    @FXML
    public void tableViewClicked(MouseEvent clickEvent) {

        // Methode tableViewClicked -> Declenchement sur un clique utilisateur dans le
        // tableau(tableview).
        // Utilise un objet de la classe TableView dans lequel on récupére un objet de
        // la classe SelectionModel détenant les informations de la
        // ou les lignes selectionnées.
        // getSelectedItem (methode de SelectionModel) recupere un objet de la classe
        // contact selectionné
        Contact selectedContact = tableView2C.getSelectionModel().getSelectedItem();
        deleteButton.setVisible(true);
        changeButton.setVisible(true);
        textFieldFirstName.setText(selectedContact.getFirstName().getValue());
        textFieldLastName.setText(selectedContact.getLastName().getValue());
        textFieldSurnameField.setText(selectedContact.getSurname().getValue());
        dateOfBirthPicker.setValue(selectedContact.getBirthDate());
        if (selectedContact.getGender().getValue().equals("Man")) {
            genderBox.getSelectionModel().select(0);
        }
        textFieldAdressField.setText(selectedContact.getAddress().getValue());
        textFieldZipCodeField.setText(String.valueOf(selectedContact.getZipCode().getValue()));
        textFieldPersonalPhoneField.setText(String.valueOf(selectedContact.getPersonalPhone().getValue()));
        textFieldProfessionalPhoneField.setText(String.valueOf(selectedContact.getProfessionalPhone().getValue()));
        textFieldMail.setText(String.valueOf(selectedContact.getMail().getValue()));
        textFieldGitField.setText(String.valueOf(selectedContact.getGitLinks().getValue()));
    }

    @FXML
    private void handleChangeContact() {
        // Récupérer le contact sélectionné
        Contact selectedContact = tableView2C.getSelectionModel().getSelectedItem();

        if (selectedContact != null) {
            // Mettre à jour les informations du contact
            selectedContact.setLastName(new SimpleStringProperty(textFieldLastName.getText()));
            selectedContact.setFirstName(new SimpleStringProperty(textFieldFirstName.getText()));
            selectedContact.setSurname(new SimpleStringProperty(textFieldSurnameField.getText()));
            selectedContact.setGender(new SimpleStringProperty(genderBox.getValue()));
            selectedContact.setBirthDate(dateOfBirthPicker.getValue());
            selectedContact.setAddress(new SimpleStringProperty(textFieldAdressField.getText()));
            selectedContact.setZipCode(new SimpleStringProperty(textFieldZipCodeField.getText()));
            selectedContact.setPersonalPhone(new SimpleStringProperty(textFieldPersonalPhoneField.getText()));
            selectedContact.setProfessionalPhone(new SimpleStringProperty(textFieldProfessionalPhoneField.getText()));
            selectedContact.setMail(textFieldMail.getText());
            selectedContact.setGitLinks(textFieldGitField.getText());

            // Rafraîchir la TableView pour refléter les modifications
            tableView2C.refresh();

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

        changeButton.setVisible(false);
        deleteButton.setVisible(false);
    }

    @FXML
    private void handleDeleteContact() {
        // Récupérer le contact sélectionné
        Contact selectedContact = tableView2C.getSelectionModel().getSelectedItem();

        if (selectedContact != null) {
            // Confirmer la suppression avec l'utilisateur
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete Contact");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete the selected contact?");

            // Afficher l'alerte et attendre la réponse
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Supprimer le contact de la TableView
                tableView2C.getItems().remove(selectedContact);
                System.out.println("Contact deleted successfully.");
            }
        } else {
            // Alerter l'utilisateur si aucun contact n'est sélectionné
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select a contact to delete.");
            alert.showAndWait();
        }
    }
    @FXML
    private void handleExportAll() {
        // Récupérer les données de la TableView
        List<Contact> contacts = tableView2C.getItems();
    
        // Initialiser Jackson ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Transformer chaque contact en structure JSON
            List<ObjectNode> jsonContacts = contacts.stream().map(contact -> {
                ObjectNode jsonContact = objectMapper.createObjectNode();
                jsonContact.put("firstName", contact.getFirstName());
                jsonContact.put("lastName", contact.getLastName());
                jsonContact.put("surName", contact.getSurname());
                jsonContact.put("gender", contact.getGender());
                jsonContact.put("birthDate", contact.getBirthDate());
                jsonContact.put("address", contact.getAddress());
                jsonContact.put("zipcode", contact.getZipCode());
                jsonContact.put("personalPhone", contact.getPersonalPhone());
                jsonContact.put("professionalPhone", contact.getProfessionalPhone());
                jsonContact.put("mail", contact.getMail());
                jsonContact.put("gitLink", contact.getGitLinks());
                return jsonContact;
            }).toList();
    
            // Écrire les données dans un fichier JSON
            objectMapper.writeValue(new File("contacts.json"), jsonContacts);
            System.out.println("Exportation done in contacts.json");
    
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
    
    @FXML
    private void handleExportSelection() {
        // Récupérer les données sélectionnées de la TableView
        List<Contact> selectedContacts = tableView2C.getSelectionModel().getSelectedItems();
    
        // Vérifier s'il y a des éléments sélectionnés
        if (selectedContacts.isEmpty()) {
            System.out.println("no contacts selected.");
            return; // Sortir de la méthode si aucune sélection n'est faite
        }
    
        // Initialiser Jackson ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
    
        try {
            // Transformer chaque contact sélectionné en structure JSON
            List<ObjectNode> jsonContacts = selectedContacts.stream().map(contact -> {
                ObjectNode jsonContact = objectMapper.createObjectNode();
                jsonContact.put("firstName", contact.getFirstName());
                jsonContact.put("lastName", contact.getLastName());
                jsonContact.put("surName", contact.getSurname());
                jsonContact.put("gender", contact.getGender());
                jsonContact.put("birthDate", contact.getBirthDate());
                jsonContact.put("address", contact.getAddress());
                jsonContact.put("zipcode", contact.getZipCode());
                jsonContact.put("personalPhone", contact.getPersonalPhone());
                jsonContact.put("professionalPhone", contact.getProfessionalPhone());
                jsonContact.put("mail", contact.getMail());
                jsonContact.put("gitLink", contact.getGitLinks());
                return jsonContact;
            }).toList();
    
            // Écrire les données sélectionnées dans un fichier JSON
            objectMapper.writeValue(new File("selected_contacts.json"), jsonContacts);
            System.out.println("Exportation done in selected_contacts.json");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
    
    @FXML
    private void handleNewContact() {
        // Récupérer les valeurs des champs
        String lastName = textFieldLastName.getText();
        String firstName = textFieldFirstName.getText();
        String surname = textFieldSurnameField.getText();
        String gender = genderBox.getValue();
        LocalDate dateOfBirth = dateOfBirthPicker.getValue();
        String address = textFieldAdressField.getText();
        String zipCode = textFieldZipCodeField.getText();
        String personalPhone = textFieldPersonalPhoneField.getText();
        String professionalPhone = textFieldProfessionalPhoneField.getText();
        String email = textFieldMail.getText();
        String git = textFieldGitField.getText();

        // Créer un nouvel objet Contact
        Contact newContact = new Contact(lastName, firstName, surname, gender, dateOfBirth, address, zipCode,
                personalPhone, professionalPhone, email, git);
        // Vérification de l'instanciation des Fields Texts.
        if (newContact.getLastName().getValue().isEmpty() || 
        newContact.getFirstName().getValue().isEmpty() || 
        newContact.getGender().getValue().isEmpty() || 
        newContact.getAddress().getValue().isEmpty() || 
        newContact.getPersonalPhone().getValue().isEmpty() || 
        newContact.getMail().getValue().isEmpty() || 
        newContact.getZipCode().getValue().isEmpty()) 
        {
           throw new IllegalArgumentException("Contact format error.");
        };

        // Ajouter le nouveau contact à la TableView
        tableView2C.getItems().add(newContact);

        // Réinitialiser les champs du formulaire
        textFieldLastName.clear();
        textFieldFirstName.clear();
        textFieldSurnameField.clear();
        genderBox.getSelectionModel().clearSelection();
        dateOfBirthPicker.setValue(null);
        textFieldAdressField.clear();
        textFieldZipCodeField.clear();
        textFieldPersonalPhoneField.clear();
        textFieldProfessionalPhoneField.clear();
        textFieldMail.clear();
        textFieldGitField.clear();
    }

}