package com.yrvoration.workmanagerjava;

import connection.ConnectMysql;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Sample {
    @FXML
    private TextField edifamilya;

    @FXML
    private TextField ediism;
    @FXML
    private Label txtlabel;
    @FXML
    private Label txtismfam;

    @FXML
    void btnsave(ActionEvent event) throws SQLException {
        String ismi = ediism.getText(),
                familyasi = edifamilya.getText();
        Window owner = ediism.getScene().getWindow();
        ConnectMysql ulanish = new ConnectMysql();
        java.sql.Connection connection = ulanish.getConnection();
        Statement statement = connection.createStatement();

        String query1 = "SELECT id, ism FROM work;";
        ResultSet rs1 = statement.executeQuery(query1);
        txtismfam.setText(rs1.toString());
        while (rs1.next())
        {
            int id = rs1.getInt("id");
            String ism = rs1.getString("ism");
            //String fam = rs1.getString("familya");

            txtismfam.setText(id+" "+ ism+" ");
        }
        //statement.close();

        InetAddress ip;
        try {

            ip = InetAddress.getLocalHost();
            txtlabel.setText("IP adress: "+ ip.getHostAddress());
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

            byte[] mac = network.getHardwareAddress();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            String macc = txtlabel.getText().toString();
            txtlabel.setText(macc+"\n"+"MAC adress: "+sb.toString());

        } catch (UnknownHostException | SocketException e) {

            e.printStackTrace();

        }
        if (ismi.isEmpty()){
            ediism.setPromptText("empty");
            ediism.getParent().requestFocus();
            showAlert(Alert.AlertType.ERROR, owner, "exxxx!",
                    "iltimossss ismni kirittt ✍\uD83C\uDFFC✍\uD83C\uDFFF✊\uD83C\uDFFF");
            return;
        }
        if (familyasi.isEmpty()){
            edifamilya.setPromptText("empty");
            edifamilya.getParent().requestFocus();
            showAlert(Alert.AlertType.ERROR, owner, "exxxx!",
                    "iltimossss ismni kirittt ✍\uD83C\uDFFC✍\uD83C\uDFFF✊\uD83C\uDFFF");
            return;
        }
        new Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        edifamilya.setText("bo`lgin endi");
                    }
                },
                2000
        );
        String sql = "INSERT INTO `work`(`ism`, `familya`) VALUES ('"+ismi+"','"+familyasi+"')";
        statement.execute(sql);
    }

    @FXML
    void initialize() {

    }
    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
