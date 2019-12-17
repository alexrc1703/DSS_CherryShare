package UI;

import APP.Facade;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

public class MUSICController {
    private Facade facade;

    @FXML
    private ImageView music_back;

    @FXML
    private ListView<?> music_list;

    @FXML
    private Button logout;

    @FXML
    private Button settings;

    @FXML
    private Button playlists;

    @FXML
    private Button friends;

    @FXML
    private Button videos;

    @FXML
    private Button music;

    @FXML
    private Button sort;

    public void initCenas(Facade facade){
        this.facade=facade;
        //observableList
    }

}

