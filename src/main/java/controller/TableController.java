package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Translate;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author Igor Hnes on 2/9/18.
 */
public class TableController implements Initializable {

    @FXML
    private Button btnAdd;
    @FXML
    private TableView<Translate> table;
    @FXML
    private TableColumn<Translate, String> columnUkr;
    @FXML
    private TableColumn<Translate, String> columnEng;

    private ObservableList<Translate> observableList = FXCollections.observableArrayList();

    public void initialize(URL location, ResourceBundle resources) {
        
        init();
        btnAdd.setOnMouseClicked(event -> {
            try {
                addWord(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void init() {
        columnUkr.setCellValueFactory(new PropertyValueFactory<>("ukr"));
        columnEng.setCellValueFactory(new PropertyValueFactory<>("eng"));
        load();
    }

    private void load() {
        observableList.clear();
        List<Translate> list = new LinkedList<>();
        list.add(new Translate("Привіт", "Hello"));
        list.add(new Translate("Мова", "Language"));
        observableList.addAll(list);
        table.setItems(observableList);
    }

    private void addWord(MouseEvent event) throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/view/add.fxml"));
        Parent parent = fxmlLoader.load();
        final Stage stage = new Stage();
        Scene value = new Scene(parent);
        stage.setScene(value);
        stage.initModality(Modality.WINDOW_MODAL);
        Window window = ((Node) event.getSource()).getScene().getWindow();
        stage.initOwner(window);
        stage.show();

        stage.setOnHiding(e -> load());
    }
}
