module design_inscription {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens design_inscription to javafx.fxml;
    exports design_inscription;
    opens design_inscription.controller to javafx.fxml;
    exports design_inscription.entities;
}
