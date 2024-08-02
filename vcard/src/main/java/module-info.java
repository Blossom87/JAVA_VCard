module fr.afpa {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens fr.afpa to javafx.fxml;
    exports fr.afpa;
}
