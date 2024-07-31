package fr.afpa;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.io.File;
import java.util.List;
public class ButtonExportSelection {
    @FXML
    private Button exportSelectionButton; // Assurez-vous que le fx:id correspond dans le fichier FXML

    @FXML
    private TableView<Kontact> contactTableView;

    @FXML
    private void handleExportSelection() {
        // Récupérer les données sélectionnées de la TableView
        List<Kontact> selectedContacts = contactTableView.getSelectionModel().getSelectedItems();

        // Vérifier s'il y a des éléments sélectionnés
        if (selectedContacts.isEmpty()) {
            System.out.println("no contacts selected.");
            return; // Sortir de la méthode si aucune sélection n'est faite
        }

        // Initialiser Jackson ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Écrire les données sélectionnées dans un fichier JSON
        objectMapper.writeValue(new File("selected_contacts.json"), selectedContacts);
        System.out.println("Exportation done in selected_contacts.json");
    }
}

