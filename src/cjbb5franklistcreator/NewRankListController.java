package cjbb5franklistcreator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Conrad Bucholtz <cjbb5f@mail.missouri.edu>
 */
public class NewRankListController extends AbstractController implements Initializable, Savable {
        
    @FXML
    private TextField rankListNameTextField;
    @FXML
    private ChoiceBox<String> scoringSystemChoiceBox;
    @FXML
    private TextArea fieldsTextArea;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scoringSystemChoiceBox.getItems().addAll("Tier List", "Grading Scale", "10-Point Scale", "Qualified 10-Point Scale");
    }
    
    @FXML
    private void handleCancel(ActionEvent event) {
        switchTo("Home");
    }
    
    @FXML
    private void handleCreate(ActionEvent event) {
        if (rankListNameTextField.getText().equals("")) {
            displayError("Empty Name", "Please choose a name for your RankList");
        }
        else if (scoringSystemChoiceBox.getValue() == null) {
            displayError("Empty Scoring System", "Please choose a scoring system for your RankList");
        }
        else if (fieldsTextArea.getText().equals("")) {
            displayError("Empty Fields", "Please include one or more fields for your RankList");
        }
        else {
            //Name is easy
            String name = rankListNameTextField.getText();
            
            //Convert scoring system into the enumeration
            String scoringSystem = scoringSystemChoiceBox.getValue();
            ScoreType scoreType;
            if (scoringSystem.equals("Tier List"))
                scoreType = ScoreType.TIER_LIST;
            else if (scoringSystem.equals("Grading Scale"))
                scoreType = ScoreType.GRADING_SCALE;
            else if (scoringSystem.equals("10-Point Scale"))
                scoreType = ScoreType.TEN_POINT_SCALE; 
            else if (scoringSystem.equals("Qualified 10-Point Scale"))
                scoreType = ScoreType.QUALIFIED_TEN_POINT_SCALE;
            else
                scoreType = ScoreType.TIER_LIST;
            
            //Delimit by a comma and any amount of whitespace
            String[] fields = fieldsTextArea.getText().split(",\\s*");
            
            RankList newRankList = new RankList(name, scoreType, fields);
            
            if (saveRankList(name, newRankList)) {
                switchTo("Home");
                displayAlert("RankList Created!", "Select 'View RankList' to view and add items");
            }
        }
    }
}
