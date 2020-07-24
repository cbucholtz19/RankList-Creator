package cjbb5franklistcreator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AboutController extends AbstractController implements Initializable {
        
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    @FXML
    private void handleBack() {
        switchTo("Home");
    }
    
    @FXML
    private void handleWhatIs() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("What is a RankList?");
        alert.setHeaderText("What is a RankList?");
        alert.setContentText("A RankList, simply put, is a ranked list.");
        alert.showAndWait();
    }
    
    @FXML
    private void handleWhatCan() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("What can a RankList be used for?");
        alert.setHeaderText("What can a RankList be used for?");
        alert.setContentText("A RankList can be used to rank your favorite Movies, Albums, Books, Vegetables, Toothpastes, or anything in between!");
        alert.showAndWait();
    }
    
    @FXML
    private void handleHowTo() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("How To");
        alert.setHeaderText("How To");
        alert.setContentText("First, a new RankList must be created from the main menu. Here, you can give the list a "
                + "title, scoring system, and define one or more fields. "
                + "Fields are information to be included with each entry. This might include a title or name, an artist or author " 
                + ", or any other pieces of information you wish to include. " 
                + "An example will be preloaded for you. Finally, once your list is created and saved you can view it from the main menu "
                + "and add items to it. These items will automatically be ranked for you. "
                + "Finally, be sure to save your RankList after adding or deleting items!");
        alert.showAndWait();
    }

    @FXML
    private void handleStill() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Still Confused?");
        alert.setHeaderText("Still Confused?");
        alert.setContentText("If you are still confused, a demo RankList is included with the project "
                + "that you can load into the RankList view.");
        alert.showAndWait();    
    }
}
