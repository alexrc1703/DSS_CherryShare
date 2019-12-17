package UI;

import APP.Facade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LOGINController {

    private Facade facade;

    @FXML
    private AnchorPane screen;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginGuest;

    public void initCenas(Facade fac){
        this.facade=fac;
    }

    public void guestButton() throws IOException {
    }

    public void enter(KeyEvent keyEvent) {
        if(keyEvent.getCode().toString().equals("ENTER")){

            if(this.facade.login(userName.getText(), password.getText())){
                FXMLLoader loaderMc = new FXMLLoader(getClass().getResource("MUSIC.fxml"));
                Stage window = (Stage) ((Node) keyEvent.getSource()).getScene().getWindow();
                try {
                    window.setScene(new Scene(loaderMc.load()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                MUSICController mc = loaderMc.getController();
                mc.initCenas(this.facade);
                window.show();
            } else {
                System.out.println("Nothing happens.");
            }
        }
    }
}
