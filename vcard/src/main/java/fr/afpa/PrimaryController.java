package fr.afpa;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        // Changement de scène
        App.setRoot("secondary");
    }
}
