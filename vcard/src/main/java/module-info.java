module fr.afpa {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires javafx.base;


    opens fr.afpa to javafx.fxml;
    exports fr.afpa;
}
