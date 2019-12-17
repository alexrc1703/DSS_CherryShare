package UI;

import APP.Facade;
import DB.Connect;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Connection c = Connect.connect();
        Facade facade = new Facade();
        facade.populate();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LOGIN.fxml"));
        primaryStage.setTitle("CherryShare");
        primaryStage.setScene(new Scene(loader.load()));
        LOGINController controller = loader.getController();
        controller.initCenas(facade);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
