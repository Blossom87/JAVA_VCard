package fr.afpa;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.input.MouseEvent;

public class test {

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

    private String[] gender = { "Man", "Woman", "Other" };

    @FXML
    private DatePicker dateOfBirth;

    public void getDate(ActionEvent event) {

        LocalDate myDate = dateOfBirth.getValue();
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

        genderBox.getItems().addAll(gender);
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
        textFieldFirstName.setText(selectedContact.getFirstName().getValue());
        textFieldLastName.setText(selectedContact.getLastName().getValue());
        textFieldSurnameField.setText(selectedContact.getSurName().getValue());
        dateOfBirth.setValue(selectedContact.getBirthDate());
        if (selectedContact.getGender().getValue().equals("Man")) {
            genderBox.getSelectionModel().select(0);
        }
        textFieldAdressField.setText(selectedContact.getAdress().getValue());
        textFieldZipCodeField.setText(String.valueOf(selectedContact.getZipCode().getValue()));
        textFieldPersonalPhoneField.setText(String.valueOf(selectedContact.getPersonalPhone().getValue()));
        textFieldProfessionalPhoneField.setText(String.valueOf(selectedContact.getProfessionalPhone().getValue()));
        textFieldMail.setText(String.valueOf(selectedContact.getMail().getValue()));
        textFieldGitField.setText(String.valueOf(selectedContact.getGitLinks().getValue()));
    }
}