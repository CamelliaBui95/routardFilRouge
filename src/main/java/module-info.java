module fr.routard.routardfilrouge {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.microsoft.sqlserver.jdbc;

    requires org.controlsfx.controls;
    requires java.sql;

    opens fr.routard.RoutardFilRouge to javafx.fxml;
    exports fr.routard.RoutardFilRouge;
    exports fr.routard.RoutardFilRouge.controllers;

    opens fr.routard.RoutardFilRouge.controllers to javafx.fxml;
}