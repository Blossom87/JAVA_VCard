package fr.afpa;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.io.File;
import java.util.List;

public class ButtonExportAll {

    @FXML
    private Button exportAllButton;

    @FXML
    private TableView<Kontact> contactTableView;

    @FXML
    private void handleExportAll() {
        // Récupérer les données de la TableView
        List<Kontact> contacts = contactTableView.getItems();

        // Initialiser Jackson ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Écrire les données dans un fichier JSON
        objectMapper.writeValue(new File("contacts.json"), contacts);
        System.out.println("Exportation done in contacts.json");
    }
}



