package fr.afpa;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import java.util.Optional;
public class ButtonDelete {
    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Kontact> contactTableView;

    @FXML
    private void handleDeleteContact() {
        // Récupérer le contact sélectionné
        Kontact selectedContact = contactTableView.getSelectionModel().getSelectedItem();

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
                contactTableView.getItems().remove(selectedContact);
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
}   

