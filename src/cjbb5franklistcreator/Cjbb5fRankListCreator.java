package cjbb5franklistcreator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Cjbb5fRankListCreator extends Application {
    
    private static final String TITLE = "RankList Creator";
    
    @Override
    public void start(Stage stage) throws Exception {        
        AnchorPane root = new AnchorPane();
        root.setPrefSize(600, 400);
        
        
        Scene scene = new Scene(root);
        
        AbstractController.stage = stage;
        AbstractController.scene = scene;
        AbstractController.switchTo("Home");
        
        stage.setTitle(TITLE);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
