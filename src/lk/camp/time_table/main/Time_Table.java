/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.main;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

/**
 *
 * @author sachith
 */
public class Time_Table extends Application{
   
    @Override
    public void start(Stage stage) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("/lk/camp/time_table/view/Login.fxml"));  //Start.fxml,Login.fxml
        Scene scene = new Scene(root);   
        stage.setTitle("Acadamic time table");
        stage.setResizable(false);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.DECORATED);   
//        stage.setResizable(true);
//        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch(args);
     
    }
    
}
