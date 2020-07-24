package cjbb5franklistcreator;

import static cjbb5franklistcreator.AbstractController.switchTo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author Conrad Bucholtz <cjbb5f@mail.missouri.edu>
 */
public class AddItemController extends AbstractController implements Initializable {
    
    @FXML
    private GridPane newItemGridPane;
    @FXML
    private ChoiceBox<String> scoreChoiceBox;
    
    private TextField[] fieldTextFields;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (currentRankList.getScoreType() == ScoreType.TIER_LIST) {
            scoreChoiceBox.getItems().addAll("S", "A", "B", "C", "D", "E", "F");
        }
        else if (currentRankList.getScoreType() == ScoreType.GRADING_SCALE) {
            scoreChoiceBox.getItems().addAll("A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F");
        }
        else if (currentRankList.getScoreType() == ScoreType.TEN_POINT_SCALE) {
            scoreChoiceBox.getItems().addAll("10", "9", "8", "7", "6", "5", "4", "3", "2", "1", "0");
        }
        else if (currentRankList.getScoreType() == ScoreType.QUALIFIED_TEN_POINT_SCALE) {
            scoreChoiceBox.getItems().addAll("10", "Strong 9", "Decent 9", "Light 9", "Strong 8", "Decent 8", "Light 8",
                    "Strong 7", "Decent 7", "Light 7", "Strong 6", "Decent 6", "Light 6", "Strong 5", "Decent 5", "Light 5", 
                    "Strong 4", "Decent 4", "Light 4", "Strong 3", "Decent 3", "Light 3", "Strong 2", "Decent 2", "Light 2", 
                    "Strong 1", "Decent 1", "Light 1", "0");
        }
        
        fieldTextFields = new TextField[currentRankList.getFields().length];
        
        String[] fields = currentRankList.getFields();
        for (int i=0; i<fields.length; i++) {
            Text fieldText = new Text(fields[i]);
            TextField fieldTextField = new TextField();
            fieldTextFields[i] = fieldTextField;
            newItemGridPane.addRow(i+1, fieldText, fieldTextField);
        }
    }
    
    @FXML
    private void handleCancel(ActionEvent event) {
        switchTo("RankListView");
    }
    
    @FXML
    private void handleAdd(ActionEvent event) {
        if (scoreChoiceBox.getValue() == null) {
            displayError("No Score", "Please choose a score for your item to have");
        }
        else {
            String score = scoreChoiceBox.getValue();
            String[] fieldData = new String[fieldTextFields.length];
            for (int i=0; i<fieldData.length; i++) {
                fieldData[i] = fieldTextFields[i].getText();
                if (fieldData[i].equals("")) {
                    displayError("Empty Field", "Please make sure all fields are filled in");
                    return;
                }
            }

            Item newItem = new Item(score, fieldData);
            currentRankList.addItem(newItem);
            
            switchTo("RankListView");
            displayAlert("Item Added Successfully!", "Make sure you save your RankList again before closing.");
        }
    }
}
