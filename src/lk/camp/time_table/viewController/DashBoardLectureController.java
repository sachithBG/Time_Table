/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.viewController;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import static lk.camp.time_table.viewController.DashBoardAdminController.Manage;
import static lk.camp.time_table.viewController.DashBoardAdminController.Title;

/**
 * FXML Controller class
 *
 * @author SACHI
 */
public class DashBoardLectureController implements Initializable {

    @FXML
    private ImageView root;
    @FXML
    private JFXButton btnPersonal;
    @FXML
    private JFXButton btnTable;
    @FXML
    private JFXButton btnLogOut;
    public  static String setLecture;
    @FXML
    private JFXButton btnUserManage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setLecture = "Lecture";
    }    
    @FXML
    private void personalAction(ActionEvent event) throws IOException {
        rootchange(event,"/lk/camp/time_table/view/LectureManage.fxml");
    }

    @FXML
    private void tableAction(ActionEvent event) throws IOException {
        rootchange(event,"/lk/camp/time_table/view/TimeTables.fxml");
    }

    @FXML
    private void btnLogOutAction(ActionEvent event) throws IOException {
        rootchange(event,"/lk/camp/time_table/view/Login.fxml");
    }
    
    private void  rootchange(ActionEvent event,String path) throws IOException{
        boolean name = event.getSource() instanceof Button;
        Button btn =  (Button) event.getSource();   
        Parent root = null; 
        root = FXMLLoader.load(this.getClass().getResource(path));
         if (root != null){
              Scene subScene = new Scene(root);
              Stage  primaryStage = (Stage) this.root.getScene().getWindow();
              primaryStage.setScene(subScene);
             primaryStage.centerOnScreen();

              TranslateTransition tt = new TranslateTransition(Duration.millis(350), 
                      subScene.getRoot());
              tt.setFromX(-subScene.getWidth());
              tt.setToX(0);
              tt.play();
        }
    }

    @FXML
    private void movsEnt(DragEvent event) {
        if (event.getSource() instanceof Button){
            Button btn = (Button) event.getSource();
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), btn);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play(); 
            
            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            btn.setEffect(glow);
        }
    }

    @FXML
    private void movsExt(DragEvent event) {
        if (event.getSource() instanceof Button){
            Button icon = (Button) event.getSource();
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play(); 
            
            icon.setEffect(null);
        }
    }

    @FXML
    private void btnUserManage(ActionEvent event) throws IOException {
        Manage = "User"; 
        Title = "User Manage";
        rootchange(event,"/lk/camp/time_table/view/AllManage.fxml");
    }
    
}
