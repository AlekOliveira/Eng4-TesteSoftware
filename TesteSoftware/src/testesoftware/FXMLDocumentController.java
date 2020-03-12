package testesoftware;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;


public class FXMLDocumentController implements Initializable {
    
    private Label label;
    private RadioButton rbInc;
    private RadioButton rbDec;
    @FXML
    private ToggleGroup grupo;
    @FXML
    private TextField valor;
    @FXML
    private RadioButton cbInc;
    @FXML
    private RadioButton cbDec;
    @FXML
    private DatePicker data;
    @FXML
    private TextArea motivo;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clkConfirmar(MouseEvent event) {
    }

    
    
}
