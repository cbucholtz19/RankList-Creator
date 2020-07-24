package cjbb5franklistcreator;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public abstract class AbstractController {
    public static Stage stage;
    public static Scene scene;
    
    public static RankList currentRankList;
    
    private Parent root;
    
    public static void switchTo(String name) {
        try {

            FXMLLoader loader = new FXMLLoader(AbstractController.class.getResource(name + ".fxml"));
            Parent root = loader.load(); 
            scene.setRoot(root);

        } catch (IOException ex) {
            Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error loading " + name + ".fxml \n\n " + ex); 
        }

    }
    
    public static void displayError(String name, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("An Error Occurred");
        alert.setHeaderText(name);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static void displayAlert(String name, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(name);
        alert.setContentText(message);
        alert.showAndWait();
    }
}