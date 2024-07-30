package fr.afpa;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
public class ButtonExportAll {

    @FXML
    private Button exportAllButton;

    @FXML
    private TableView<Contact> contactTableView;

    @FXML
    private void handleExportAll() {
        // Implémenter la logique d'exportation des données
        // Exemple : Exporter tous les contacts dans un fichier CSV

        // Code d'exportation à implémenter ici...
        System.out.println("Exporting all contacts...");

        // Par exemple, itérer sur tous les éléments de la TableView
        for (Contact contact : contactTableView.getItems()) {
            // Logique d'exportation, e.g., écrire dans un fichier CSV
            System.out.println(contact); // Remplacer par une logique réelle d'exportation
        }
    }
}


