package com.yrvoration.workmanagerjava;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Objects;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField edilogin;

    @FXML
    private TextField edipassword;

    @FXML
    void btnnext(ActionEvent event) {
        String loginn = edilogin.getText().trim();
        String  password= edipassword.getText().trim();
        if (Objects.equals(loginn,"1") && Objects.equals(password,"")){
            Platform.exit();
        }
        if (Objects.equals(loginn,"1") && Objects.equals(password,"1")){

            Stage stage = new Stage();
            Parent root = null;

            Scene scene = ((Button)event.getSource()).getScene();
            if( scene != null ) {
                Window w = scene.getWindow();
                if (w != null) {
                    w.hide();
                }
            }
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("sample Panel");
            if (root != null) {
                stage.setScene(new Scene(root));

            }
            //stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) (event.getSource())).getScene().getWindow());
            stage.show();

        }else {
            welcomeText.setText("login yoki parol xato");
        }
    }

    @FXML
    void initialize() {

    }
}