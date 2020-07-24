package cjbb5franklistcreator;

import static cjbb5franklistcreator.AbstractController.stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class HomeController extends AbstractController implements Initializable, Openable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    @FXML
    private void handleViewRankList(ActionEvent event) {
        if (openRankList()) {
            switchTo("RankListView");
        }
    }
    
    @FXML
    private void handleNewRankList(ActionEvent event) {
        switchTo("NewRankList");
    }
    
    @FXML
    private void handleAbout(ActionEvent event) {
        switchTo("About");
    }
    
    @FXML
    private void handleQuit(ActionEvent event) {
        stage.close();
    }
}
