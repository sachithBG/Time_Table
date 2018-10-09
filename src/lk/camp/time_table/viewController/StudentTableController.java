/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.viewController;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.camp.time_table.controller.LectureDetailsController;
import lk.camp.time_table.controller.LecturesController;
import lk.camp.time_table.controller.StudentsController;
import lk.camp.time_table.controller.TimeTableController;
import lk.camp.time_table.controllerImp.LectureControllerImp;
import lk.camp.time_table.controllerImp.LectureDetailsControllerImp;
import lk.camp.time_table.controllerImp.StudentsControllerImp;
import lk.camp.time_table.controllerImp.TimeTableControllerImp;
import lk.camp.time_table.dto.StudentDTO;
import static lk.camp.time_table.viewController.LoginController.Departmet;
import static lk.camp.time_table.viewController.LoginController.Year;

/**
 * FXML Controller class
 *
 * @author SACHI
 */
public class StudentTableController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private TableView<?> tbl1;
    @FXML
    private TableView<?> tbl3;
    @FXML
    private TableView<?> tbl4;
    @FXML
    private TableView<?> tbl2;
    @FXML
    private ImageView allTbl;
    @FXML
    private Label lblYear;
    @FXML
    private Label lblSemester;
    @FXML
    private RadioButton radElec;
    @FXML
    private ToggleGroup a;
    @FXML
    private RadioButton radCivil;
    @FXML
    private RadioButton radMach;
    @FXML
    private RadioButton radSoft;
    @FXML
    private Label lblDepart;
    @FXML
    private JFXButton btnBack;
    private ActionEvent event;

    
    
    private StudentsController studentsController =new StudentsControllerImp();
    private LecturesController  lecturesController =new LectureControllerImp();
    private TimeTableController timeTableController =new TimeTableControllerImp();
    private LectureDetailsController departmentController = new LectureDetailsControllerImp();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        visibility();
        radElecAction(event);
        ArrayList YearAndSemester = new ArrayList();      
        try {
         List<StudentDTO> all = studentsController.getAll();
                        for (StudentDTO courseDescriptionDTO : all) {
                YearAndSemester.add(courseDescriptionDTO.getYearAndSemester());
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentTableController.class.getName()).log(Level.SEVERE, null, ex);
        }
////////////////////////////////////////////////////////////////////////////////////sort-cheqe
            lblDepart.setText(Departmet);
                switch (Year) {
            case 1:
                lblYear.setText("1st year");
                lblSemester.setText("Semester-1");
                tbl1.setVisible(true);
                break;
            case 2:
                lblYear.setText("2nd year");
                lblSemester.setText("Semester-3");
                tbl1.setVisible(true);
                break;
            case 3:
                lblYear.setText("3rd year");
                lblSemester.setText("Semester-5");
                tbl1.setVisible(true);
                break;
            case 4:
                lblYear.setText("4th year");
                lblSemester.setText("Semester-5");
                tbl1.setVisible(true);
                break;
            default:
//                errorMassage("Please select Post :");
                break;
        }
        // TODO
    }    
    
    private void visibility(){
        tbl1.setVisible(false);
        tbl2.setVisible(false);
        tbl3.setVisible(false);
        tbl4.setVisible(false);
    }

    @FXML
    private void radElecAction(ActionEvent event) {
        visibility();
        tbl1.setVisible(true);
    }

    @FXML
    private void radCivilAction(ActionEvent event) {
        visibility();
        tbl2.setVisible(true);
    }

    @FXML
    private void radMachAction(ActionEvent event) {
        visibility();
        tbl3.setVisible(true);
    }

    @FXML
    private void radSoftAction(ActionEvent event) {
        visibility();
        tbl4.setVisible(true);
    }

    @FXML
    private void btnBackAction(ActionEvent event) throws IOException {        
        boolean name = event.getSource() instanceof Button;
        Button btn =  (Button) event.getSource();   
          Parent root = null; 
          root = FXMLLoader.load(this.getClass().getResource("/lk/camp/time_table/view/Login.fxml"));
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
    
}
