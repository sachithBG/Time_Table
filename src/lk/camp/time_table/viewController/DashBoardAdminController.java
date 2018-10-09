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
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author SACHI
 */
public class DashBoardAdminController implements Initializable {

    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnUser;
    @FXML
    private Label lblWelcome;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnLecManage;
    @FXML
    private JFXButton btnStuManage;
    @FXML
    private JFXButton btnDepartment;
    @FXML
    private JFXButton btnTimeTbl;
    @FXML
    private Label lblManage;
    public static String Manage,Managefserch;
    public static String Title;
    @FXML
    private JFXButton btnLectureHall;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              lblWelcome.setAlignment(Pos.CENTER);
    }    
//////////////////////////////////////////////////////////////////////////////////btn Event
    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        rootchange(event,"/lk/camp/time_table/view/Login.fxml");
    }

    @FXML
    private void btnUser(ActionEvent event) throws IOException { 
        Manage = "User"; 
        Title = "User Manage";
        Managefserch = "Admin";
        rootchange(event,"/lk/camp/time_table/view/AllManage.fxml");
    }

    @FXML
    private void btnLecture(ActionEvent event) throws IOException {
        Manage = "Lecture";
        Title = "Time Table Manage";
        rootchange(event,"/lk/camp/time_table/view/AllManage.fxml");
    }

    @FXML
    private void btnStudent(ActionEvent event) throws IOException {
        Manage = "Student";
        Title = "Student Manage";
        rootchange(event,"/lk/camp/time_table/view/AllManage.fxml");
    }

    @FXML
    private void btnDepartment(ActionEvent event) throws IOException {
        Manage = "Department";
        Title = "Department Manage";
        rootchange(event,"/lk/camp/time_table/view/AllManage.fxml");
    }

    @FXML
    private void btnTimeTbl(ActionEvent event) throws IOException {
        Manage = "TimeTable";
        Title = "Time Table Manage";
        rootchange(event,"/lk/camp/time_table/view/TimeTables.fxml");
    }
    @FXML
    private void LectureHall(ActionEvent event) throws IOException {
        Manage = "Lecture Hall Details";
        Title = "Lecture Hall Details Manage";
        rootchange(event,"/lk/camp/time_table/view/AllManage.fxml");
    }
//////////////////////////////////////////////////////////////////////////////////mouse Eent
    @FXML
    private void UserManageExite(MouseEvent event) {
        mouseExite(event, "Welcome to Admin Controller", "");
    }

    @FXML
    private void UserManageEnter(MouseEvent event) {       
        mouseEnter(event, "User Manage", 
                "Please Click one of below main operations to proceed");
    }

    @FXML
    private void LectureManageExite(MouseEvent event) {
        mouseExite(event, "Welcome to Admin Controller", "");
    }
    
    @FXML
    private void  LectureManageEnter(MouseEvent event){
        mouseEnter(event, "Lecture Manage", 
                   "Please Click one of below main operations to proceed");
    }

    @FXML
    private void StudentManageExite(MouseEvent event) {
        mouseExite(event, "Welcome to Admin Controller", "");
    }

    @FXML
    private void StudentManageEnter(MouseEvent event) {
        mouseEnter(event, "Student Manage", 
                  "Please Click one of below main operations to proceed");
    }

    @FXML
    private void DepartmentManageExite(MouseEvent event) {
        mouseExite(event, "Welcome to Admin Controller", "");
    }

    @FXML
    private void DepartmentManageEnter(MouseEvent event) {
        mouseEnter(event, "Department Manage", 
                  "Please Click one of below main operations to proceed");
    }

    @FXML
    private void TimeTblManageExite(MouseEvent event) {
        mouseExite(event, "Welcome to Admin Controller", "");
    }

    @FXML
    private void TimeTblManageEnter(MouseEvent event) {
        mouseEnter(event, "Time Table Manage", 
                  "Please Click one of below main operations to proceed");
    }
    @FXML
    private void LectureHallExit(MouseEvent event) {
        mouseExite(event, "Welcome to Admin Controller", "");
    }

    @FXML
    private void LectureHallEnter(MouseEvent event) {
        mouseEnter(event, "Lecture Hall Manage", 
                  "Please Click one of below main operations to proceed");
    }
/////////////////////////////////////////////////////////////////////////////////////public    
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
    
    private void mouseEnter( MouseEvent event,String Title,String Description){
        
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
            lblWelcome.setText(Title);
            lblManage.setText(Description);
        }
    }
    
    private void mouseExite(MouseEvent event,String Title,String Description){
        
        if (event.getSource() instanceof Button){
            Button icon = (Button) event.getSource();
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play(); 
            
            icon.setEffect(null);
            lblWelcome.setText(Title);
            lblManage.setText(Description);
        }
    }
}
