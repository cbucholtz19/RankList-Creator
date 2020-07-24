package cjbb5franklistcreator;

import static cjbb5franklistcreator.AbstractController.currentRankList;
import static cjbb5franklistcreator.AbstractController.displayError;
import static cjbb5franklistcreator.AbstractController.stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javafx.stage.FileChooser;

public interface Openable {
    
    public default boolean openRankList() {                   
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Serialized Object (*.ser)", "*.ser"));
        File file = fileChooser.showOpenDialog(stage);
        
        if (file != null) {
            FileInputStream fileIn; 
            try {
                fileIn = new FileInputStream(file.getPath());
                ObjectInputStream in = new ObjectInputStream(fileIn); 
                
                currentRankList = (RankList) in.readObject();
                
                in.close(); 
                fileIn.close(); 
                
            } catch (FileNotFoundException ex) { 
                displayError("File Not Found", "File not found exception occured while opening " + file.getPath()); 
                return false;
                
            } catch (IOException ex) {
                displayError("IO Exception", "IO exception occured while opening " + file.getPath());
                return false;
                
            } catch (ClassNotFoundException ex) { 
                displayError("Class Not Found", "Class not found exception occured while opening " + file.getPath()); 
                return false;
            }
        }
        else {
            displayError("Null File", "Please try again.");
            return false;
        }
        
        return true;
    }
}
