/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.viewController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import lk.camp.time_table.controller.DepartmentDeController;
import lk.camp.time_table.controller.LecturesController;
import lk.camp.time_table.controller.StudentsController;
import lk.camp.time_table.controller.TimeTableController;
import lk.camp.time_table.controllerImp.LectureDetailsControllerImp;
import lk.camp.time_table.controllerImp.LectureControllerImp;
import lk.camp.time_table.controllerImp.StudentsControllerImp;
import lk.camp.time_table.controllerImp.TimeTableControllerImp;
import lk.camp.time_table.dto.LectureDTO;
import lk.camp.time_table.dto.StudentDTO;
import lk.camp.time_table.controller.LectureDetailsController;
import lk.camp.time_table.controllerImp.DepartmentDeControllerImp;
import lk.camp.time_table.dto.DepartmentDeDTO;

/**
 * FXML Controller class
 *
 * @author sachith
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField txtRegNu;
    @FXML
    private JFXPasswordField txtPwd;
    @FXML
    private Label lblLog;
    @FXML
    private Hyperlink pwdLink;
    @FXML
    private JFXButton btnLogIn;
    @FXML
    private Label lblSign;
    @FXML
    private JFXButton btnSignin;
    @FXML
    private Label lblPlease;
    @FXML
    private JFXButton btnLog;
    @FXML
    private JFXButton btnSignUp;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private Label clos;
    @FXML
    private AnchorPane root;

    private StudentsController studentsController =new StudentsControllerImp();
    private LecturesController  lecturesController =new LectureControllerImp();
    private TimeTableController timeTableController =new TimeTableControllerImp();
    private LectureDetailsController departmentController = new LectureDetailsControllerImp();
    private DepartmentDeController departmentController1 = new DepartmentDeControllerImp();
    @FXML
    private JFXComboBox<String> comDepartment;
    @FXML
    private JFXRadioButton radStu;
    @FXML
    private JFXRadioButton radLec;
    @FXML
    private JFXRadioButton radAdm;
    @FXML
    private ToggleGroup redStu;
    private int X;
    @FXML
    private JFXTextField txtUserName1;
    @FXML
    private JFXTextField txtpwd1;
    @FXML
    private JFXTextField txtCode;
    private int ValidetionResult;
    public static String Departmet; 
    public static int Year;
    public static int Semester;
    public static String PassWord;
    public static String post;
    @FXML
    private JFXComboBox<String> comYearAndSemester;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        style();
        yearSemester();     
        try {
            btnLog.setVisible(false);
            visibility1();      
                List<DepartmentDeDTO> all = departmentController1.getAll();
            for (DepartmentDeDTO courseDescriptionDTO : all) {
                comDepartment.getItems().add(courseDescriptionDTO.getDName());
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
           }
//        String selectedItem = comYearAndSemester.getSelectionModel().getSelectedItem(); 
        
    }
    @FXML
    private void SignUpbtn(ActionEvent event) {
        
        switch (X) {
            case 1:
                visibility1();
                btnLog.setVisible(true);
                txtUserName.setVisible(true);
                txtRegNu.setVisible(true);
                txtPwd.setVisible(true);
                comYearAndSemester.setVisible(true);
                visibility3(true,false);
                break;
            case 2:
                txtCode.setVisible(true);
                visibility3(true,false);
                comDepartment.setVisible(false);
                break;
            case 3:
                txtCode.setVisible(true);
                visibility3(true,false);
                break;
            default:
                errorMassage("Please select Post :");
                break;
        }
        Clear();
        
    }
    
    @FXML
    private void Logbtn(ActionEvent event) {
        
                switch (X) {
            case 1:
                visibility1();
                lblPlease.setVisible(true);
                btnSignUp.setVisible(true);
                txtUserName.setVisible(true);
                txtPwd.setVisible(true);
                visibility3(false,true);
                break;
            case 2:
                txtCode.setVisible(false);
                visibility3(false,true);
                break;
            case 3:
                txtCode.setVisible(false);
                visibility3(false,true);
                break;
            default:
                errorMassage("Please select Post :");
                break;
        }
        Clear();
    }

    @FXML
    private void radStudent(ActionEvent event) {
        X= 1;
       lblLog.setVisible(true);
       txtUserName.setVisible(true);
       txtPwd.setVisible(true);
       visibility3(false,true);
       visibility2(false);
    }

    @FXML
    private void radLecture(ActionEvent event) {
        X=2;
        visibility1();
        lblLog.setVisible(true);
        visibility3(false,true);
        visibility2(true);
        txtCode.setVisible(false);
        post = "Admin";
    }

    @FXML
    private void radAdmin(ActionEvent event) {
        X=3;
        visibility1();
        lblLog.setVisible(true);
        visibility3(false,true);
        visibility2(true);
        txtCode.setVisible(false);
        post = "lecture";
    }
    
/////////////////////////////////////////////////////////////////////////////////LogIn & SignIn    
    @FXML
    private void LogInbtnAction(ActionEvent event) throws IOException{
    switch (X) {
            case 1:
                try {
                    StudentDTO sdto1 = studentsController.search(txtPwd.getText());
                    yearSemester(sdto1.getYearAndSemester());
                    if((sdto1.getPassword() == null ? txtPwd.getText() == null :
                            sdto1.getPassword().equals(txtPwd.getText())) || 
                            (sdto1.getUserName() == null ? txtUserName.getText() == null :
                            sdto1.getUserName().equals(txtUserName.getText()))){
                            PassWord = sdto1.getPassword(); 
                            rootchange(event,"/lk/camp/time_table/view/Table1.fxml");
                    }else{
                        errorMassage("Please Enter valid information");
                        Clear();
                    }
                    } catch (Exception ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        errorMassage("Please Enter valid information");
                        rootchange(event,"/lk/camp/time_table/view/Login.fxml");
                    }
                break;
            case 2: 
                try {
                    LectureDTO sdto1 = lecturesController.search("AD"+txtpwd1.getText());
                    if((sdto1.getPwd() == null ? txtpwd1.getText() == null :
                        sdto1.getPwd().equals("AD"+txtpwd1.getText())) && 
                        (sdto1.getUserName() == null ? txtUserName1.getText() == null :
                        sdto1.getUserName().equals(txtUserName1.getText()))){   
                        PassWord = sdto1.getPwd();
                        rootchange(event,"/lk/camp/time_table/view/DashBoardAdmin.fxml");
                    }else{
                        errorMassage("Please Enter valid information");
                        Clear();
                    }
                    } catch (Exception ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        errorMassage("Please Enter valid information");
                        rootchange(event,"/lk/camp/time_table/view/Login.fxml");
                    }
                System.out.println("Admin..."+X);
                break;
                
            case 3: 
                try {
                    LectureDTO sdto1 = lecturesController.search("LE"+txtpwd1.getText());
                    if((sdto1.getPwd() == null ? txtpwd1.getText() == null :
                            sdto1.getPwd().equals("LE"+txtpwd1.getText())) && 
                            (sdto1.getUserName() == null ? txtUserName1.getText() == null :
                            sdto1.getUserName().equals(txtUserName1.getText()))){ 
                            PassWord = sdto1.getPwd();
                          rootchange(event,"/lk/camp/time_table/view/DashBoardLecture.fxml");
                    }else{
                        errorMassage("Please Enter valid information");
                        Clear();
                    }
                    } catch (Exception ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        errorMassage("Please Enter valid information");
                        rootchange(event,"/lk/camp/time_table/view/Login.fxml");
                    }
                break;
            default:
                errorMassage("Please select Post :");
                break;
        }
        
    }
    private void yearSemester(String A){
        ArrayList<String> arrayList = new ArrayList<String>();
        String selectedItem = A;
        selectedItem = selectedItem.replaceAll("[.,]", ""); // Replace dots, etc (optional)
        
        for(String s : selectedItem.split(" ")){
            arrayList.add(s.charAt(0)+"");
        }
        Year = Integer.parseInt(arrayList.get(2));Semester = Integer.parseInt(arrayList.get(6));
    }
    @FXML
    private void SigninbtnAction(ActionEvent event) throws IOException{       
    switch (X) {
        case 1:
            try {
                Departmet = comDepartment.getSelectionModel().getSelectedItem();
                String YearAndSemester = comYearAndSemester.getSelectionModel().getSelectedItem();
                yearSemester(YearAndSemester); 
                StudentDTO rdto =new StudentDTO();
                rdto.setRegNo(txtRegNu.getText());
                rdto.setUserName(txtUserName.getText());
                rdto.setDepartment(Departmet);
                rdto.setYearAndSemester(YearAndSemester);
                rdto.setPassword(txtPwd.getText());
                studentsController.add(rdto);
                PassWord = txtPwd.getText();
                rootchange(event,"/lk/camp/time_table/view/StudentTable.fxml");   
                } catch (Exception ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    rootchange(event,"/lk/camp/time_table/view/Login.fxml");
                    }
            break;
        case 2:   
//            validation("A"+txtCode.getText(), "A" , "V", 0, 10, 2, 9 );

            if ((txtCode.getText().trim().matches("^[0-9]{9}[vVxX]$"))) {
                try {
                    System.out.println("Admin");
                    LectureDTO rdto =new LectureDTO();
                    rdto.setPwd("AD" + txtpwd1.getText());
                    rdto.setNic("A"+txtCode.getText());
                    rdto.setUserName(txtUserName1.getText());
                    rdto.setPost("Admin");
                    lecturesController.add(rdto);
                    PassWord = "AD" + txtpwd1.getText();
                    rootchange(event,"/lk/camp/time_table/view/DashBoardAdmin.fxml");

                    } catch (Exception ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                            rootchange(event,"/lk/camp/time_table/view/Login.fxml");
                            }
            }else{JOptionPane.showMessageDialog(null,"Invalid NIC "); }
            visibility3(false,true);
            break;
        case 3:
            validation("L"+txtCode.getText(), "L" , "V", 0, 10, 2, 9 );
            if (ValidetionResult == 1) {
                try {
                    LectureDTO rdto =new LectureDTO();
                    rdto.setPwd("LE"+txtpwd1.getText());
                    rdto.setNic("L"+txtCode.getText());
                    rdto.setUserName(txtUserName1.getText());
                    rdto.setPost(comDepartment.getSelectionModel().getSelectedItem());
                    lecturesController.add(rdto);
                    PassWord = "LE"+txtpwd1.getText();
                    rootchange(event,"/lk/camp/time_table/view/DashBoardLecture.fxml");
                    } catch (Exception ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        rootchange(event,"/lk/camp/time_table/view/Login.fxml");
                    }  
            } 
            break;
        default:
            JOptionPane.showMessageDialog(null,"Please select Post : ");
            break;
        }
    }

/////////////////////////////////////////////////////////////////////////////////Public
    private void visibility1(){
//        btnLog.setVisible(false);
        lblSign.setVisible(false);
        btnSignin.setVisible(false);
        lblLog.setVisible(false);
        btnLogIn.setVisible(false);
        pwdLink.setVisible(false);
        txtRegNu.setVisible(false);
        txtPwd.setVisible(false);
        txtUserName.setVisible(false);
        visibility2(false);
        clos.setVisible(false);
        comDepartment.setVisible(false);
        comYearAndSemester.setVisible(false);
        
    }
    private void visibility2(boolean T){
        txtUserName1.setVisible(T);
        txtCode.setVisible(T);
        txtpwd1.setVisible(T);
    }
    private void visibility3(boolean F,boolean T){
        btnLog.setVisible(F);
        lblPlease.setVisible(T);
        lblSign.setVisible(F);
        lblLog.setVisible(T);
        btnSignUp.setVisible(T);
        btnLogIn.setVisible(T);
        btnSignin.setVisible(F);
        pwdLink.setVisible(T);
        comDepartment.setVisible(F);
        
    }
    public static void errorMassage(String A){
            Alert error = new Alert(Alert.AlertType.ERROR, A, ButtonType.OK);
            error.setHeaderText("Duplicate Entry Found");
            error.setTitle("Duplicate Error");
            error.show();
            return;
    }
    
    private void validation(String code,String x,String y,int indeOf_X,int indeOf_Y,int upCount,int digit){
        
    //Word Scanner 
       int DigitCount = 0,up_Count = 0 ;
       Scanner scanner = new Scanner(code);
       String s = scanner.nextLine();
             
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))){
                DigitCount++;
            }else if(Character.isUpperCase(s.charAt(i))){
                up_Count ++;
            }
        }     
    //Get Letter
        
        int N1 = code.indexOf(x);
        int N2 = code.indexOf(y);
        
        if ((DigitCount == digit) && (up_Count == upCount) && (N1 == indeOf_X) && (N2 == indeOf_Y)) {
                ValidetionResult = 1;
        }else{
            JOptionPane.showMessageDialog(null,"Duplicate Entry Found");
                ValidetionResult = 0;
        }
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
    
    private void Clear(){
            txtPwd.setText("");
            txtRegNu.setText("");
            txtUserName .setText("");
    //        Dat.getEditor().clear();
            comYearAndSemester.getSelectionModel().clearSelection();
            comDepartment.getSelectionModel().clearSelection();
    //        comPAY.getSelectionModel().clearSelection();
    }
    private void style(){
        txtRegNu.setStyle("-fx-text-inner-color: red;");
        txtPwd.setStyle("-fx-text-inner-color: red;");
        txtUserName.setStyle("-fx-text-inner-color: red;");
        txtCode.setStyle("-fx-text-inner-color: red;");
        txtUserName1.setStyle("-fx-text-inner-color: red;");
        txtpwd1.setStyle("-fx-text-inner-color: red;");
        comYearAndSemester.setStyle("-fx-text-inner-color: red;");
        comDepartment.setStyle("-fx-text-inner-color: red;");
    }
    private void yearSemester(){  
        int j;int k =1;
        for (int i = 1; i < 5; i++) {
            for ( j = k; j < 9; j++) {
             comYearAndSemester.getItems().add("Year - "+i+" & Semester - " +j);   
                if (j%2 == 0) {
                    k=j+1;
                    break;
                }
            }            
        }        
    }
            
/////////////////////////////////////////////////////////////////////////////////window style    
    @FXML
    private void windowClose(MouseEvent event) {
        System.exit(0);
//        System.
    }
}
