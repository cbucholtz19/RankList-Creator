package cjbb5franklistcreator;

import static cjbb5franklistcreator.AbstractController.displayError;
import static cjbb5franklistcreator.AbstractController.stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javafx.stage.FileChooser;

public interface Savable {
    
    public default boolean saveRankList(String name, RankList rankList) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName(name);
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Serialized Object (*.ser)", "*.ser"));
        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            try {
                FileOutputStream fileOut = new FileOutputStream(file.getPath());
                ObjectOutputStream out = new ObjectOutputStream(fileOut);   
                out.writeObject(rankList);


            } catch (FileNotFoundException ex) { 
                displayError("File Not Found", "File not found exception occured while saving to " + file.getPath());
                return false;

            } catch (IOException ex) {
                displayError("IOException", "IOException occured while saving to " + file.getPath());
                return false;

            }
        }
        else {
            displayError("No File Selected", "Please try again");
            return false;
        }
        
        return true;
    }
}
