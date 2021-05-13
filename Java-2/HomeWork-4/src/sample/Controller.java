package sample;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {

    @FXML
    TextArea chatHistory;

    @FXML
    TextField msgField;

    @FXML
    Button sendButton;

    int count = 0;
    String tempText = "";

    public void sendMessage(javafx.event.ActionEvent actionEvent) {
        if(msgField.getText() != "") {
            if (!msgField.getText().equals(tempText)){
                tempText = msgField.getText();
                count = 0;
            }else{
                count++;
            }
            if (count > 2){
                Alert alertEmptyMessage = new Alert(Alert.AlertType.ERROR);
                alertEmptyMessage.setTitle("Error");
                alertEmptyMessage.setHeaderText("Нельзя отправить одинаковое сообщение больше 3 раз");
                alertEmptyMessage.showAndWait();
                count = 0;
            }else {
                chatHistory.appendText(msgField.getText() + "\n");
                msgField.setText("");
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Нельзя отправить пустое сообщение");
            alert.showAndWait();
        }
    }
}
