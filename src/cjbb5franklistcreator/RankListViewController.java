package cjbb5franklistcreator;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class RankListViewController extends AbstractController implements Initializable, Savable, Openable {
    
    @FXML
    private Text titleText;
    @FXML
    private GridPane rankListGridPane;
        
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        titleText.setText(currentRankList.getName());
        
        if (currentRankList.getItems().size() > 0) {
            rankListGridPane.getChildren().clear();
            
            //Add Headers            
            rankListGridPane.add(new Text("Row"), 0, 0);
            rankListGridPane.add(new Text("Score"), 1, 0);
            for (int i=0; i<currentRankList.getFields().length; i++) {
                Text fieldHeader = new Text(currentRankList.getFields()[i]);
                rankListGridPane.add(fieldHeader, i+2, 0);
            }
            
            //Add Items
            for (int i=0; i<currentRankList.getItems().size(); i++) {
                Item item = currentRankList.getItems().get(i);
                Text row = new Text("" + (i+1));
                rankListGridPane.add(row, 0, i+1);
                Text score = new Text(item.getScore());
                rankListGridPane.add(score, 1, i+1);
                
                for (int j=0; j<currentRankList.getFields().length; j++) {
                    Text field = new Text(item.getFieldData(j));
                    rankListGridPane.add(field, j+2, i+1);
                }
            }
        }
    }
 
    @FXML
    private void handleHome(ActionEvent event) {
        switchTo("Home");
    }
    
    @FXML
    private void handleLoad(ActionEvent event) {
        openRankList();
    }
    
    @FXML
    private void handleSave(ActionEvent event) {
        saveRankList(currentRankList.getName(), currentRankList);
        displayAlert("Saved!", "RankList saved successfully!");
    }
     
    @FXML
    private void handleAddItem(ActionEvent event) {
        switchTo("AddItem");
    }
    
    @FXML
    private void handleDelete(ActionEvent event) {
        TextInputDialog deleteItemDialog = new TextInputDialog();
        deleteItemDialog.setTitle("Delete Item");
        deleteItemDialog.setHeaderText("Delete Item");
        deleteItemDialog.setContentText("Enter the row of the item you wish to delete");
        Optional<String> result = deleteItemDialog.showAndWait();
        if (result.isPresent()) {
            try {
                int row = Integer.parseInt(result.get());
                currentRankList.getItems().remove(row-1);
                switchTo("RankListView");
            }
            catch (NumberFormatException e) {
                displayError("Number Format Error", "Your input could not be evaulated as a row number.");
            }
            catch (IndexOutOfBoundsException e) {
                displayError("Out Of Bounds Index", "Your input was either too large or too small");
            }
        }    
    }
}
