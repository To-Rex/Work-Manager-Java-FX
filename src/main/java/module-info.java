module com.yrvoration.workmanagerjava {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.yrvoration.workmanagerjava to javafx.fxml;
    exports com.yrvoration.workmanagerjava;
}