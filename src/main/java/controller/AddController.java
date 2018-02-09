package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Igor Hnes on 2/9/18.
 */
public class AddController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private TextField word;
    @FXML
    private Button btnAdd;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAdd.setOnAction(event -> add());

    }

    private void add() {
        final String text = word.getText();
        System.out.println(text);
        // todo to db
        root.getScene().getWindow().hide();
    }
}
