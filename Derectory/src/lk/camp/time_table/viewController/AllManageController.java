 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.viewController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.TranslateTransition;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import lk.camp.time_table.TM.DepartmentTM;
import lk.camp.time_table.TM.LectureHallTM;
import lk.camp.time_table.TM.LectureMaTM;
import lk.camp.time_table.TM.LectureTM;
import lk.camp.time_table.TM.StudentTM;
import lk.camp.time_table.controller.DepartmentDeController;
import lk.camp.time_table.controller.LectureDetailsController;
import lk.camp.time_table.controller.LectureHallController;
import lk.camp.time_table.controller.LecturesController;
import lk.camp.time_table.controller.StudentsController;
import lk.camp.time_table.controller.SubjectsController;
import lk.camp.time_table.controller.TimeTableController;
import lk.camp.time_table.controllerImp.DepartmentDeControllerImp;
import lk.camp.time_table.controllerImp.LectureControllerImp;
import lk.camp.time_table.controllerImp.LectureDetailsControllerImp;
import lk.camp.time_table.controllerImp.LectureHallControllerImp;
import lk.camp.time_table.controllerImp.StudentsControllerImp;
import lk.camp.time_table.controllerImp.SubjectsControllerImp;
import lk.camp.time_table.controllerImp.TimeTableControllerImp;
import lk.camp.time_table.dto.DepartmentDeDTO;
import lk.camp.time_table.dto.LectureDTO;
import lk.camp.time_table.dto.LectureDetailsDTO;
import lk.camp.time_table.dto.LectureHallDTO;
import lk.camp.time_table.dto.StudentDTO;
import lk.camp.time_table.dto.SubjectsDTO;
import static lk.camp.time_table.viewController.DashBoardAdminController.Manage;
import static lk.camp.time_table.viewController.DashBoardAdminController.Title;
import static lk.camp.time_table.viewController.DashBoardLectureController.setLecture;
import static lk.camp.time_table.viewController.LectureManageController.errorMassage;
import static lk.camp.time_table.viewController.LoginController.PassWord;

/**
 * FXML Controller class
 *
 * @author SACHI
 */
public class AllManageController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private Label lblTitle;
    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnLogOut;
    @FXML
    private JFXTextField txtID;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnClear;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXTextField txtNIC;
    @FXML
    private JFXTextField txtDepartment;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtScode;
    @FXML
    private JFXTextField txtSubject;
    @FXML
    private TableView<LectureTM> tblAll;
    @FXML
    private TableView<LectureMaTM> tblLectureDetails;
    @FXML
    private TableView<DepartmentTM> tblDepartment;
    @FXML
    private JFXButton Refresh;
    @FXML
    private TableView<StudentTM> tblStudent;
    @FXML
    private Tab tblPaneStudent;
    @FXML
    private Tab tblPaneLectureDe;
    @FXML
    private Tab tblPaneDepartment;
    @FXML
    private Tab tblPaneAdminDetails;
    @FXML
    private JFXButton SManage;
    @FXML
    private JFXComboBox<String> comScode;
    @FXML
    private JFXComboBox<String> comDepartment;
    @FXML
    private TabPane altbl;
    @FXML
    private Tab tblPaneLectureHallDetails;
    @FXML
    private TableView<LectureHallTM> tblLectureHall;
    @FXML
    private TableColumn<StudentTM, String> tblClomRegNo;
    @FXML
    private TableColumn<DepartmentTM, String> tblColmnDepName;
    @FXML
    private TableColumn<LectureHallTM, String> tblColmnLectHallName;
    @FXML
    private TableColumn<LectureTM, String> tblColmnUserNic;
    @FXML
    private JFXComboBox<String> comNIC;
    @FXML
    private TableColumn<LectureMaTM, String> tblColmnName;
    @FXML
    private JFXTextField txtSerchScode;
    
    private boolean update = false;
    private static boolean found = false;
    private String NIC;
    private List<String> tblColumn ;
    private String loadResult;
    private boolean  result;
    private boolean radResult= false;
    private static ArrayList<String> depat;
    private String lastWord;
    private static boolean Error =false;
    String selectedtxt1,selectedtxt2,charAt,subStr;
    
    private StudentsController studentsController =new StudentsControllerImp();
    private LecturesController  lecturesController =new LectureControllerImp();
    private TimeTableController timeTableController =new TimeTableControllerImp();
    private DepartmentDeController departmentDeController = new DepartmentDeControllerImp();
    private LectureDetailsController lectureDetailsController = new LectureDetailsControllerImp();
    private LectureHallController hallController = new  LectureHallControllerImp();
    private SubjectsController subjectManageController = new  SubjectsControllerImp();
    @FXML
    private TableColumn<?, ?> tblColmnPasword;
    @FXML
    private JFXRadioButton radViewAll;
    
    
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        style();
        txtFieldTblManage();  
        tabLisner(); 
        comDepartment.setVisibleRowCount(4);
        comNIC.setVisibleRowCount(4);
        comScode.setVisibleRowCount(4);
        try { 
            comAddItems();
            comLisner();
            initFilter();
        } catch (Exception ex) {
            Logger.getLogger(AllManageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if ("Lecture".equals(setLecture)) {
            setUser();
            txtSerchScode.setVisible(false);
        }
    }   
    
//////////////////////////////////////////////////////////////////////////////////tbl
    private void setUser(){
        hideTab();
        setPromtTex("ID", "Name", "Post", "NIC No:", "", "","Search NIC");
        comDepartment.setVisible(false);
        comNIC.setVisible(false);
        comScode.setVisible(false);
    }
    private void txtFieldTblManage(){
        txtVisibility();
        tblColumn = new ArrayList<String>();
        switch(Manage){
///user          
            case "User": 
                ////////////////////////////////////////////////////////////////////////////////////////////////kl;
                if(radResult == false){
                setTabView(false);
                altbl.getTabs().add(tblPaneAdminDetails);}
                setPromtTex("ID", "Name", "Post", "NIC No:", "", "","Search Name");
                comNIC.setVisible(false);
                btnAdd.setVisible(false);
                txtScode.setVisible(false);
                txtSubject.setVisible(false);
                comDepartment.setVisible(false);
                comScode.setVisible(false);
                txtName.setDisable(false);
                txtID.setDisable(true);
                txtNIC.setDisable(true);
//                hideTab();altbl.getTabs().add(tblPaneAdminDetails);
                tblColumn.clear();
                tblColumn.add("pwd");
                tblColumn.add("nic");
                tblColumn.add("userName");
                tblColumn.add("post");              
                addTbl(tblColumn);                 
                break;
///lecture               
            case "Lecture":
                if(radResult == false){
                setTabView(false);
                altbl.getTabs().add(tblPaneLectureDe);}
                setPromtTex("ID", "NIC No:", "Name:", "Department", "Subject Code", "Subject Name","Search S code");
                txtID.setDisable(true);
                txtDepartment.setVisible(true);
                txtName.setVisible(false);
                txtNIC.setVisible(false);
                txtScode.setVisible(false);
                comNIC.setVisible(true);
                comDepartment.setVisible(true);
                comScode.setVisible(true);
//                hideTab();altbl.getTabs().add(tblPaneLectureDe);
                tblColumn.clear();
                tblColumn.add("id");
                tblColumn.add("LectureName");
                tblColumn.add("nicCode");
                tblColumn.add("DepaName");  
                tblColumn.add("scode");
                tblColumn.add("subject");
                addTbl(tblColumn); 
                break;
///student               
            case "Student":
                if(radResult == false){
                setTabView(false);
                altbl.getTabs().add(tblPaneStudent);}
                setPromtTex("Password", "Student Name", "Register No","Department", "Year And Semester","","Search Reg No");
                txtSubject.setVisible(false);
                txtName.setVisible(true);
                txtNIC.setVisible(true);
                comDepartment.setVisible(false);
                comScode.setVisible(false);
                comNIC.setVisible(false);
//                hideTab();altbl.getTabs().add(tblPaneStudent);
                tblColumn.clear();
                tblColumn.add("password");
                tblColumn.add("userName");
                tblColumn.add("regNo");
                tblColumn.add("department");
                tblColumn.add("YearAndSemester");  
                addTbl(tblColumn);
                break;
///department               
            case "Department":
                if(radResult == false){
                setTabView(false);
                altbl.getTabs().add(tblPaneDepartment);}
                comDepartment.setVisible(false);
                comScode.setVisible(false);
                comNIC.setVisible(false);
                setPromtTex("", "ID", "", "","Department Name","","Search Name");
                txtID.setVisible(false);
                txtName.setDisable(true);
                txtNIC.setVisible(false);
                txtDepartment.setVisible(false);
                txtSubject.setVisible(false);
                txtName.setVisible(true);
                txtScode.setVisible(true);
//                hideTab();altbl.getTabs().add(tblPaneDepartment);
                tblColumn.clear();
                tblColumn.add("id");
                tblColumn.add("departmentName");
                addTbl(tblColumn);
                break;
            case "Lecture Hall Details":
                if(radResult == false){
                setTabView(false);
                altbl.getTabs().add(tblPaneLectureHallDetails);}
                comNIC.setVisible(false);
                comDepartment.setVisible(false);
                comScode.setVisible(false);
                setPromtTex("", "ID", "", "","Lecture Hall Name","","Search Name");
                txtID.setVisible(false);
                txtName.setDisable(true);
                txtNIC.setVisible(false);
                txtDepartment.setVisible(false);
                txtSubject.setVisible(false);
                txtName.setVisible(true);
                txtScode.setVisible(true);
                btnAdd.setVisible(true);
//                hideTab();altbl.getTabs().add(tblPaneDepartment);
                tblColumn.clear();
                tblColumn.add("id");
                tblColumn.add("name");
                addTbl(tblColumn);
                break;
            default:
                JOptionPane.showMessageDialog(null,"System error ! ");
                break;
        }
    }
    private void addTbl(List list){                                                  //////////////add tbls & tbl Lisner
        
        switch(Manage){
///user           
            case "User":  
                for (String s : this.tblColumn) {
                tblAll.getColumns().get(list.indexOf(s)).setCellValueFactory(new PropertyValueFactory<>(s));
                }
            {
                try {
                    loadAllDetails();
                } catch (Exception ex) {
                    Logger.getLogger(AllManageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   
            tblAll.getSelectionModel().selectedItemProperty().addListener(
                    new ChangeListener<LectureTM>() {
            @Override
            public void changed(ObservableValue<? extends LectureTM> observable,
                    LectureTM oldValue, LectureTM newValue) {

            LectureTM lectureTM = observable.getValue();

            if (lectureTM == null){
                update = false;
                return;
            }                
            setTxt(lectureTM.getPwd(),lectureTM.getUserName(), 
                                   lectureTM.getPost(), NIC.substring(1),"","");
            }
            });
///lecture                
                  break;
            case "Lecture":
                
                for (String s : this.tblColumn) {
                   tblLectureDetails.getColumns().get(list.indexOf(s)).setCellValueFactory(new PropertyValueFactory<>(s));
                }   
                {
                try {
                    loadAllDetails();
                    } catch (Exception ex) {
                    Logger.getLogger(AllManageController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }   
                tblLectureDetails.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<LectureMaTM>() {
                @Override
                public void changed(ObservableValue<? extends LectureMaTM> observable,
                        LectureMaTM oldValue, LectureMaTM newValue) {

                LectureMaTM lectureMaTM = observable.getValue();

                if (lectureMaTM == null){
    //                update = false;
                    return;
                }  
                found = true;  
    //            lectureMaTM.getLectureName()
    //            for (int i = 0; i<lectureMaTM.getLectureName().length(); i++){                
    ////                char letter = passCode.charAt(i);                
    //            }
                txtID.setText(lectureMaTM.getId()+"");
                comNIC.setValue(lectureMaTM.getNicCode());
                txtDepartment.setText(lectureMaTM.getLectureName());
                comDepartment.setValue(lectureMaTM.getDepaName());                
                comScode.setValue(lectureMaTM.getScode());
                txtSubject.setText(lectureMaTM.getSubject());
                comDepartment.hide();
                comDepartment.hide();
                comDepartment.hide();
                found = false;
                }
                });
                
                break;
///student               
            case "Student":
                  for (String s : this.tblColumn) {
                   tblStudent.getColumns().get(list.indexOf(s)).setCellValueFactory(new PropertyValueFactory<>(s));
                }   
            {
                try {
                    loadAllDetails();
                    } catch (Exception ex) {
                    Logger.getLogger(AllManageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   
            tblStudent.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<StudentTM>() {
            @Override
            public void changed(ObservableValue<? extends  StudentTM> observable,
                    StudentTM oldValue, StudentTM newValue) {

            StudentTM studentTM = observable.getValue();

            if (studentTM == null){
                update = false;
                return;
            }
            setTxt(studentTM.getPassword(),studentTM.getUserName(),studentTM.getRegNo(),
                    studentTM.getDepartment(),studentTM.getYearAndSemester(), "");
            }
            }); 
                break;
///department                
            case "Department":
                for (String s : this.tblColumn) {
                   tblDepartment.getColumns().get(list.indexOf(s)).setCellValueFactory(new PropertyValueFactory<>(s));
                }   
            {
                try {
                    loadAllDetails();
                    } catch (Exception ex) {
                    Logger.getLogger(AllManageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   
                tblDepartment.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<DepartmentTM>() {
                @Override
                public void changed(ObservableValue<? extends  DepartmentTM> observable,
                    DepartmentTM oldValue, DepartmentTM newValue) {

                DepartmentTM departmentTM = observable.getValue();

                    if (departmentTM == null){
                        update = false;
                        return;
                    }
                    setTxt("",departmentTM.getId()+"","","",departmentTM.getDepartmentName(), "");
                    }
                    }); 
                break;
            case "Lecture Hall Details":
                for (String s : this.tblColumn) {
                   tblLectureHall.getColumns().get(list.indexOf(s)).setCellValueFactory(new PropertyValueFactory<>(s));
                }   
            {
                try {
                    loadAllDetails();
                    } catch (Exception ex) {
                    Logger.getLogger(AllManageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   
            tblLectureHall.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<LectureHallTM>() {
            @Override
            public void changed(ObservableValue<? extends  LectureHallTM> observable,
                   LectureHallTM oldValue, LectureHallTM newValue) {

            LectureHallTM hallTM = observable.getValue();

            if (hallTM == null){
                update = false;
                return;
            }
            setTxt("",hallTM.getId()+"","","",hallTM.getName(), "");
            }
            }); 
                break;
            default:
                JOptionPane.showMessageDialog(null,"System error ! ");
                break;
        }
    }
    private void comAddItems() throws Exception{                                 ////////////////////////com add items
        comDepartment.getItems().clear();
        comScode.getItems().clear();
        comNIC.getItems().clear();
        List<SubjectsDTO> all1 = subjectManageController.getAllSubjects();
        List<DepartmentDeDTO> all2 = departmentDeController.getAll();
        List<LectureDTO> all3 = lecturesController.getAll();
            for (SubjectsDTO subjectsDTO : all1) {  
                comScode.getItems().add(subjectsDTO.getScode());
                }                
            for (DepartmentDeDTO departmentDeDTO : all2) { 
                comDepartment.getItems().add(departmentDeDTO.getDName());                        
                }
            for (LectureDTO lectureDTO : all3) {
                comNIC.getItems().add(lectureDTO.getNic().substring(1));                        
                }
    }
    private void comLisner(){                                                    /////////  //////////////com Lisner
        
        comDepartment.getSelectionModel().selectedItemProperty().addListener(
        new ChangeListener<String>() {                
        @Override
        public void changed(ObservableValue<? extends String> observable,
            String oldValue, String newValue) {
            
            try {
                String value = observable.getValue();                        
                if (value == null || "".equals(comDepartment.getSelectionModel().getSelectedItem())){
//                        update = false;
                    loadAllDetails();
                    comDepartment.hide();
                }
                if(found){return;} 
                comScode.getSelectionModel().clearSelection();
                String selectedIt = comDepartment.getSelectionModel().getSelectedItem();
                int v =0;
                //first word
                int index = selectedIt.indexOf(" ");
                String fistString = selectedIt.substring(0, index);
                //last word
                String laststring = selectedIt.substring (selectedIt.lastIndexOf (' '), selectedIt.length()); 
                String substring = fistString.substring(0, 1)+laststring.substring(1, 2);
                List<SubjectsDTO>  all = subjectManageController.getAllSubjects(); 

                for (SubjectsDTO subjectsDTO : all) { 
                    String charAt = String.valueOf(subjectsDTO.getScode().charAt(0))+
                                             String.valueOf(subjectsDTO.getScode().charAt(1));
                    if ((substring) == null ? (charAt) == null : (substring).equals(charAt)){
                        v += 1;
                        if(v == 1){
                            comScode.getItems().clear();
                        }
                        comScode.getItems().add(subjectsDTO.getScode());              
                    }
                }        
            } catch (Exception ex) {
                Logger.getLogger(SubjectManageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
        comScode.getSelectionModel().selectedItemProperty().addListener(
        new ChangeListener<String>() {                
        @Override
        public void changed(ObservableValue<? extends String> observable,
            String oldValue, String newValue) {
            
            try {
                String value = observable.getValue();                        
                if (value == null || "".equals(comScode.getSelectionModel().getSelectedItem())){
//                        update = false;
                    txtSubject.setText(""); 
                    loadAllDetails();
                    comScode.hide();
                }  
                List<SubjectsDTO>  all = subjectManageController.getAllSubjects();  
                for (SubjectsDTO subjectsDTO : all) {                
                if (subjectsDTO.getScode().equals(value)){
                    txtSubject.setText(subjectsDTO.getSname());              
                }
                }
            } catch (Exception ex) {
                Logger.getLogger(SubjectManageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
        comNIC.getSelectionModel().selectedItemProperty().addListener(
        new ChangeListener<String>() {                
        @Override
        public void changed(ObservableValue<? extends String> observable,
            String oldValue, String newValue) {            
            try {
                String value = observable.getValue();                        
                if (value == null || "".equals(value)){
//                        update = false;
                    txtDepartment.setText(""); 
                    loadAllDetails();
                    comNIC.hide();
                }
                List<LectureDTO>  all = lecturesController.getAll();  
                for (LectureDTO lectureDTO : all) {                
                if (lectureDTO.getNic().substring(1).equals(value)){
                    txtDepartment.setText(lectureDTO.getUserName());              
                }
                }
               
            } catch (Exception ex) {
                Logger.getLogger(SubjectManageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
    }    
    private void loadAllDetails() throws SQLException, Exception{                      /////////////////////loadAll
        
        switch(Manage){
///user           
            case "User": 
                ArrayList<LectureTM> lectureTM = new ArrayList<>();
                try {  LectureDTO ldto = lecturesController.search(PassWord);
                       List<LectureDTO>  all = lecturesController.getAll();   
                       NIC = ldto.getNic(); txtID.setText(ldto.getPwd()); 
                       txtNIC.setText(NIC.substring(1));
                    for (LectureDTO lectureDTO : all) {                
                    if (lectureDTO.getNic() == null ? ldto.getNic() == null : 
                       lectureDTO.getNic().equals(ldto.getNic())) {
                       LectureTM lecture  = new LectureTM(lectureDTO.getPwd(),
                       lectureDTO.getNic().substring(1),lectureDTO.getUserName(),
                       lectureDTO.getPost());                  
                       lectureTM.add(lecture);               
                    }tblColmnPasword.setVisible(false);
                }            
                    ObservableList olCustomers = FXCollections.observableArrayList(lectureTM);
                    tblAll.setItems(olCustomers);     
                   } catch (Exception ex) {
                       loadResult = "False";
                       Logger.getLogger(AllManageController.class.getName()).log(Level.SEVERE, null, ex); 
                   }
                break;
///lecture              
            case "Lecture":
                ArrayList<LectureMaTM> lectureMaTMs = new ArrayList<>();
                try { List<LectureDetailsDTO> all1 = lectureDetailsController.getAll();
                    for (LectureDetailsDTO lectureDTO : all1) {                        
                       LectureMaTM lecture  = new LectureMaTM(lectureDTO.getId(),
                       lectureDTO.getLectureName(),lectureDTO.getNicCode(),
                       lectureDTO.getDepaName(),lectureDTO.getScode(),lectureDTO.getSubject());                  
                       lectureMaTMs.add(lecture);                         
                        }
                ObservableList olCustomers = FXCollections.observableArrayList(lectureMaTMs);
                tblLectureDetails.setItems(olCustomers);     
               } catch (Exception ex) {
                   loadResult = "False";
                   Logger.getLogger(AllManageController.class.getName()).log(Level.SEVERE, null, ex); 
               }   
                break;
            case "Student":
                ArrayList<StudentTM> studentTMs = new ArrayList<>();
                try {  
                       List<StudentDTO>  all = studentsController.getAll(); 
                    for (StudentDTO studentDTO : all) { 
                       StudentTM lecture  = new StudentTM(studentDTO.getPassword(),
                       studentDTO.getUserName(),studentDTO.getRegNo(),
                       studentDTO.getDepartment(),studentDTO.getYearAndSemester());                  
                       studentTMs.add(lecture);            
                    
                }            
                    ObservableList olCustomers = FXCollections.observableArrayList(studentTMs);
                    tblStudent.setItems(olCustomers);     
                   } catch (Exception ex) {
                       loadResult = "False";
                       Logger.getLogger(AllManageController.class.getName()).log(Level.SEVERE, null, ex); 
                   }
                break;
///department              
            case "Department":
                  ArrayList<DepartmentTM> departmentTMs = new ArrayList<>();
                try { List<DepartmentDeDTO> all2 = departmentDeController.getAll();
                    for (DepartmentDeDTO departmentDeDTO : all2) { 
                       DepartmentTM dtm  = new DepartmentTM(departmentDeDTO.getId(),
                       departmentDeDTO.getDName());                  
                       departmentTMs.add(dtm);                         
                        }
                ObservableList olCustomers = FXCollections.observableArrayList(departmentTMs);
                tblDepartment.setItems(olCustomers);     
               } catch (Exception ex) {
                   loadResult = "False";
                   Logger.getLogger(AllManageController.class.getName()).log(Level.SEVERE, null, ex); 
               }
                break;
            case "Lecture Hall Details":
                  ArrayList<LectureHallTM> lecHall = new ArrayList<>();
                try { List<LectureHallDTO> all3 = hallController.getAll();
                    for (LectureHallDTO departmentDeDTO : all3) { 
                       LectureHallTM dtm  = new LectureHallTM(departmentDeDTO.getId(),
                       departmentDeDTO.getName());                  
                       lecHall.add(dtm);                         
                        }
                ObservableList olCustomers = FXCollections.observableArrayList(lecHall);
                tblLectureHall.setItems(olCustomers);     
               } catch (Exception ex) {
                   loadResult = "False";
                   Logger.getLogger(AllManageController.class.getName()).log(Level.SEVERE, null, ex); 
               } 
                break;
            default:
                JOptionPane.showMessageDialog(null,"System error ! ");
                break;
        }
    }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////btn
    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        rootchange(event,"/lk/camp/time_table/view/DashBoardAdmin.fxml");       
    }

    @FXML
    private void btnLogOut(ActionEvent event) throws IOException {
        rootchange(event,"/lk/camp/time_table/view/Login.fxml");
    }

    @FXML
    private void btnAdd(ActionEvent event) throws IOException, Exception {
        
         try {
        switch(Manage){
            case "User":
                System.out.println("User");
                break;
            case "Lecture":  
                txtID.setText("");
                txtError();
                if (result) {
                    JOptionPane.showMessageDialog(null,"Duplicate entity found ! ,Pleace enter valid informetion"); 
                    result =false;
                    break;
                }
                LectureDetailsDTO ddto = new LectureDetailsDTO();
                ddto.setLectureName(txtDepartment.getText());
                ddto.setDepaName(comDepartment.getSelectionModel().getSelectedItem());
                ddto.setNicCode(comNIC.getSelectionModel().getSelectedItem());
                ddto.setScode(comScode.getSelectionModel().getSelectedItem());
                ddto.setSubject(txtSubject.getText());
                result = lectureDetailsController.add(ddto);
                if (result) {                    
                    setTxt("", "", "", "", "", "");
                    comClear();
                }result =false;
                break;
            case "Student":
                StudentDTO sdto = new StudentDTO();
                sdto.setPassword(txtID.getText());
                sdto.setUserName(txtName.getText());
                sdto.setRegNo(txtDepartment.getText());
                sdto.setDepartment(txtNIC.getText());
                sdto.setYearAndSemester(txtScode.getText());
                result = studentsController.add(sdto);
                if (result) {setTxt("", "", "", "", "", "");}
                result =false;
                break;
            case "Department":
                txtName.setText("");
                validateDepat(txtScode.getText());
                if (depat.size() >= 2 && "Engineering".equals(lastWord) && !Error ) {
                    DepartmentDeDTO deDTO = new DepartmentDeDTO();
                    deDTO.setDName(txtScode.getText());
                    result = departmentDeController.add(deDTO);
                    if (result) {
                        setTxt("", "", "", "", "", "");
                        comClear();
                    }   Error =false;
                        result =false;
                    break;
                }Error = false;
                JOptionPane.showMessageDialog(null,"Pleace cheque Leters or correct format of Department(Name Engineering)"); 
//                result = true;
                break;
            case "TimeTable":
                System.out.println("TimeTable");
                break;
            case "Lecture Hall Details":
                txtName.setText("");
                LectureHallDTO hallDTO = new LectureHallDTO();
                hallDTO.setName(txtScode.getText());
                result = hallController.add(hallDTO);
                if (result) {setTxt("", "", "", "", "", "");}
                result =false;
                break;
            default:
                JOptionPane.showMessageDialog(null,"System error ! ");
                break;
        }
        } catch (Exception ex) {
            loadResult = "False";            
            Logger.getLogger(AllManageController.class.getName()).log(Level.SEVERE, null, ex);
            errorMassage("Please Enter vlied information");     
        }          
         loadInterface(event, !result);    
    }
    @FXML
    private void btnUpdate(ActionEvent event) throws Exception {
        switch(Manage){
            case "User":
                LectureDTO detailsDTO = new LectureDTO(txtID.getText(), 
                txtNIC.getText(), txtName.getText(), txtDepartment.getText());
                boolean update1 = lecturesController.update(detailsDTO); 
                loadInterface(event, update1);
                if (update1) {setTxt("", "", "", "", "", "");}
                break;
            case "Lecture":
                txtError();
                if (result) {
                    JOptionPane.showMessageDialog(null,"Duplicate entity found ! ,Pleace enter valid informetion"); 
                    result =false;
                    break;
                }
                LectureDetailsDTO detailsDTO1 = new LectureDetailsDTO(Integer.parseInt(
                        txtID.getText()),
                        comNIC.getSelectionModel().getSelectedItem(),
                        comDepartment.getSelectionModel().getSelectedItem(),
                        txtDepartment.getText(),                        
                        comScode.getSelectionModel().getSelectedItem(),
                        txtSubject.getText());
                boolean update2 = lectureDetailsController.update(detailsDTO1); 
                loadInterface(event, update2); 
                if (update2) {setTxt("", "", "", "", "", "");comClear();}
                break;
            case "Student":
                StudentDTO studentDTO = new StudentDTO(txtDepartment.getText(),  
                txtName.getText(),txtNIC.getText(),txtScode.getText(),txtID.getText());
                boolean update4 = studentsController.update(studentDTO); 
                loadInterface(event, update4);
                if (update4) {setTxt("", "", "", "", "", "");}
                break;
            case "Department":
                validateDepat(txtScode.getText());
                if (!(depat.size() >= 2 && "Engineering".equals(lastWord)) && !Error ) {
                JOptionPane.showMessageDialog(null,"Pleace cheque Leters or correct format(Name Engineering)"); 
                result =false;
                Error =false;
                break;    
                }
                DepartmentDeDTO detailsDTO2 = new DepartmentDeDTO(Integer.parseInt(txtName.getText()), 
                txtScode.getText());
                boolean update3 = departmentDeController.update(detailsDTO2);
                if (update3) {setTxt("", "", "", "", "", "");comClear();}
                break;
            case "TimeTable":
                System.out.println("TimeTable");
                break;
            case "Lecture Hall Details":
                LectureHallDTO detailsDTO3 = new LectureHallDTO(Integer.parseInt(txtName.getText()), 
                txtScode.getText());
                boolean update5 = hallController.update(detailsDTO3);
                if (update5) {setTxt("", "", "", "", "", "");}
                break;
            default:
                JOptionPane.showMessageDialog(null,"System error ! ");
                break;
        }txtFieldTblManage();
    }

    @FXML
    private void btnClear(ActionEvent event) {        
        setTxt("", "", "", "", "", "");
        comClear();
    }

    @FXML
    private void btnDelete(ActionEvent event) throws Exception {
        switch(Manage){
            case "User":
                lecturesController.delete(txtID.getText());       
                loadAllDetails();
                break;
            case "Lecture":
                lectureDetailsController.delete(Integer.parseInt(txtID.getText()));       
                loadAllDetails();
                break;
            case "Student":
                studentsController.delete(txtID.getText()); 
                loadAllDetails();
                break;
            case "Department":
                boolean res =departmentDeController.delete(Integer.parseInt(txtName.getText()));       
                loadAllDetails();
                break;
            case "TimeTable":
                System.out.println("TimeTable");
                break;
            case "Lecture Hall Details":
                hallController.delete(Integer.parseInt(txtName.getText()));       
                loadAllDetails();
                break;
            default:
                JOptionPane.showMessageDialog(null,"System error ! ");
                break;
        }
         if (!("False".equals(loadResult))) {            
            JOptionPane.showMessageDialog(null,"Delete Complete ");
            loadInterface(event, true);
        }
                 
    }
    @FXML
    private void sManage(ActionEvent event) throws IOException {
//        rootchange(event,"/lk/camp/time_table/view/SubjectManage.fxml");
            Parent root1 = FXMLLoader.load(getClass().getResource("/lk/camp/time_table/view/SubjectManage.fxml")); 
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Subjects Manage");
            Scene scene = new Scene(root1);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.show();               
    }
    
    @FXML
    private void comScode(ActionEvent event) {
        comLisner();
        AutoCompleteComboBox<Object> autoCompleteComboBox = new AutoCompleteComboBox<>(comScode);
    }

    @FXML
    private void comDepartment(ActionEvent event) throws Exception {
        if(found){return;} 
        comLisner();
        AutoCompleteComboBox<Object> autoCompleteComboBox = new AutoCompleteComboBox<>(comDepartment);
    }
    @FXML
    private void comNICA(ActionEvent event) throws Exception {
        List<LectureDTO>  all = lecturesController.getAll();  
                for (LectureDTO lectureDTO : all) {                
                if (lectureDTO.getNic().substring(1).equals( comNIC.getSelectionModel().getSelectedItem())){
                    txtDepartment.setText(lectureDTO.getUserName());              
                }
                }
        comLisner();
        AutoCompleteComboBox<Object> autoCompleteComboBox = new AutoCompleteComboBox<>(comNIC);
    }
    @FXML
    private void Refresh(ActionEvent event) throws IOException, Exception {
        loadAllDetails();
        tabLisner();
        setTxt("", "", "", "", "", "");
        comDepartment.getItems().clear();
        comNIC.getItems().clear();
        comScode.getItems().clear();
        comAddItems();
        if ("False".equals(loadResult)) {            
           rootchange(event,"/lk/camp/time_table/view/AllManage.fxml");  
        }
    }
    @FXML
    private void radViewAllAction(ActionEvent event) {
        boolean isSelected = radViewAll.isSelected();
        if (isSelected) {
            radResult =true;
            setTabView(true);
        }else if(!isSelected){
            radResult = false;
            switch(Manage){
///user          
            case "User":      
                altbl.getTabs().remove(tblPaneDepartment);
                altbl.getTabs().remove(tblPaneLectureDe);
                altbl.getTabs().remove(tblPaneLectureHallDetails);
                altbl.getTabs().remove(tblPaneStudent);             
                break;
///lecture               
            case "Lecture":
                altbl.getTabs().remove(tblPaneAdminDetails);
                altbl.getTabs().remove(tblPaneDepartment);
                altbl.getTabs().remove(tblPaneLectureHallDetails);
                altbl.getTabs().remove(tblPaneStudent);
//                altbl.getTabs().add(tblPaneLectureDe);
                break;
///student               
            case "Student":
                altbl.getTabs().remove(tblPaneAdminDetails);
                altbl.getTabs().remove(tblPaneDepartment);
                altbl.getTabs().remove(tblPaneLectureDe);
                altbl.getTabs().remove(tblPaneLectureHallDetails);
//                altbl.getTabs().add(tblPaneStudent);
                break;
///department               
            case "Department":
                altbl.getTabs().remove(tblPaneAdminDetails);
                altbl.getTabs().remove(tblPaneLectureDe);
                altbl.getTabs().remove(tblPaneLectureHallDetails);
                altbl.getTabs().remove(tblPaneStudent);
//                altbl.getTabs().add(tblPaneDepartment);
                break;
            case "Lecture Hall Details":
                altbl.getTabs().remove(tblPaneAdminDetails);
                altbl.getTabs().remove(tblPaneDepartment);
                altbl.getTabs().remove(tblPaneLectureDe);
                altbl.getTabs().remove(tblPaneStudent);
//                altbl.getTabs().add(tblPaneLectureHallDetails);
                break;
            default:
                break;
            }
        }
    }   
//////////////////////////////////////////////////////////////////////////////////////////////////other  
    private void txtError(){
        
        Pattern pattern1 = Pattern.compile("^[a-zA-Z0-9 ]+$");
        if(!(pattern1.matcher(txtDepartment.getText()).matches() &&
                pattern1.matcher(txtSubject.getText()).matches()) ){
            JOptionPane.showMessageDialog(null,"Please enter a valid name");
            result = true;
//                    break;
         } 
        if (!(comNIC.getSelectionModel().getSelectedItem().trim().matches("^[0-9]{9}[vVxX]$"))) {
            JOptionPane.showMessageDialog(null,"Pleace cheque NIC No,correct format of NIC(123456789V(or v))"); 
            result = true;
//                    break;
        }
        validateDepat(comDepartment.getSelectionModel().getSelectedItem()); 
        if (!(depat.size() >= 2 && "Engineering".equals(lastWord))) {
            JOptionPane.showMessageDialog(null,"Pleace cheque Leters or correct format of Department(Name Engineering)"); 
            result = true;                
//                    break;
        }
        if (!(comScode.getSelectionModel().getSelectedItem().trim().matches("^[A-Z]{2}[0-9]{4}$"))) {
            JOptionPane.showMessageDialog(null,"Pleace cheque Leters or correct format of Subject Code(AA1234)"); 
            result = true;
//                    break;
        }
    }
    private void validateDepat(String word){
        lastWord = word.replaceAll("^.*?(\\w+)\\W*$", "$1");
            depat = new ArrayList<>();
            Pattern p = Pattern.compile("[a-zA-Z]+");
                Matcher m1 = p.matcher(word);
        while (m1.find()) {
            depat.add(m1.group());   
        } 
        switch (Manage) {
            case "Lecture":
                selectedtxt1 = comDepartment.getSelectionModel().getSelectedItem();
                selectedtxt2 = comScode.getSelectionModel().getSelectedItem();
                charAt = String.valueOf(selectedtxt2.charAt(0))+
                        String.valueOf(selectedtxt2.charAt(1));
                break;
            case "Department":
                selectedtxt1= txtScode.getText();
                break;
            default:
                return;
        } 
        if(selectedtxt1 == null || "".equals(selectedtxt1)){return;}
        //first word
        int index = selectedtxt1.indexOf(" ");
        String fistString = selectedtxt1.substring(0, index);
        //last word
        String laststring = selectedtxt1.substring (selectedtxt1.lastIndexOf (' '), selectedtxt1.length());
        //first word + last word                
        String subStr = fistString.substring(0, 1)+laststring.substring(1, 2);
        if(!(subStr.trim().matches("^[A-Z]{2}$"))){
            result =true;
        }
        ///for only lecture   
        if("Lecture".equals(Manage)){
        if(!(charAt.equals(subStr) )){
            result =true;
        }
        }
    }
    private void loadInterface(ActionEvent event,boolean b) throws Exception{
         if (b) {
                loadAllDetails();    
                }else{
                rootchange(event,"/lk/camp/time_table/view/AllManage.fxml");  
                }
    }
    private void hideTab(){ 
        altbl.getTabs().remove(tblPaneStudent);
        altbl.getTabs().remove(tblPaneLectureDe);
        altbl.getTabs().remove(tblPaneDepartment);
        altbl.getTabs().remove(tblPaneLectureHallDetails);
    }
    private void setPromtTex(String A,String B,String C,String D,String E,String F,String G){
        txtID.setPromptText(A);
        txtName.setPromptText(B); 
        txtDepartment. setPromptText(C);
        txtNIC.setPromptText(D);
        txtScode.setPromptText(E);
        txtSubject.setPromptText(F);
        txtSerchScode.setPromptText(G);
    }
    private void setTxt(String A,String B,String C,String D,String E,String F){        
        update = true;
        btnDelete.setDisable(!update);
        txtID.setText(A); 
        txtName.setText(B);
        txtDepartment.setText(C);
        txtNIC.setText(D);    
        txtScode.setText(E);
        txtSubject.setText(F); 
    }
    private void comClear(){
        comDepartment.getSelectionModel().clearSelection();
        comNIC.getSelectionModel().clearSelection();
        comScode.getSelectionModel().clearSelection();
    }
    private void tabLisner(){
        altbl.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
        @Override
        public void changed(ObservableValue<? extends Tab> observable, Tab oldTab, Tab newTab) {
            if(newTab == tblPaneStudent) {
                Manage = "Student";
                Title = "Student Manage";
            }else if(newTab == tblPaneLectureDe){
                Manage = "Lecture";
                Title = "Time Table Manage";
            }else if(newTab == tblPaneDepartment){
                Manage = "Department";
                Title = "Department Manage";
            }else if(newTab == tblPaneAdminDetails){
                Manage = "User";
                Title = "User Manage";
            }else if(newTab == tblPaneLectureHallDetails){
                Manage = "Lecture Hall Details";
                Title = "Lecture Hall Details Manage";
            }
             setTxt("", "", "", "", "", "");
             txtVisibility();
             style();
             txtFieldTblManage();   
        }
        });    
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
    private void txtVisibility(){
        txtID.setVisible(true);
        txtName.setVisible(true);
        txtDepartment.setVisible(true);
        txtNIC.setVisible(true);
        txtScode.setVisible(true);
        txtSubject.setVisible(true);
        txtNIC.setDisableAnimation(false);
        txtName.setDisableAnimation(false);
        btnAdd.setVisible(true);
    }
    private void style(){
        txtID.setStyle("-fx-text-inner-color: red;");
        txtNIC.setStyle("-fx-text-inner-color: red;");
        txtDepartment.setStyle("-fx-text-inner-color: red;");
        txtName.setStyle("-fx-text-inner-color: red;");
        txtScode.setStyle("-fx-text-inner-color: red;");
        txtSubject.setStyle("-fx-text-inner-color: red;");
        lblTitle.setAlignment(Pos.CENTER);
        lblTitle.setText(Title);
    }
    private void initFilter()throws Exception{  
        if(found){return;} 
        txtSerchScode.textProperty().addListener(new InvalidationListener() {
            @Override  
            public void invalidated(Observable observable) {               
            if(!(txtSerchScode.textProperty().get().isEmpty() || 
                                    "".equals(txtSerchScode.getText()))) {        
        try {
            switch(Manage){
                case "User":                     
                    ArrayList<LectureTM> lectureTM = new ArrayList<>();
                    if (lectureTM.isEmpty()) {
                    ArrayList<Object> scode = new ArrayList<>();
                    List<LectureDTO> sdtos = lecturesController.getAll();
                    for (LectureDTO sdto : sdtos) {
                        if(NIC.equals(sdto.getNic())){
                        LectureTM stm  = new LectureTM(sdto.getPwd(),sdto.getNic().substring(1),sdto.getUserName(),
                                sdto.getPost());
                        lectureTM.add(stm); }                   
                    }
                    ObservableList olCustomers = FXCollections.observableArrayList(lectureTM);
                    tblAll.setItems(olCustomers);  
                    }                      
                    ObservableList<LectureTM> tableItems = FXCollections.observableArrayList();
                    ObservableList<TableColumn<LectureTM, ?>> cols = tblAll.getColumns();
                    for(int i=0; i<lectureTM.size(); i++) {
                        for(int j=0; j<cols.size(); j++){
                        TableColumn col = cols.get(j);
                        String cellValue = col.getCellData(lectureTM.get(i)).toString();
                        cellValue = cellValue.toLowerCase();
                        if(cellValue.contains(txtSerchScode.textProperty().get().toLowerCase())) {
                            tableItems.add(lectureTM.get(i)); 
                            break;
                        }
                        }}
                    tblAll.setItems(tableItems);
                    break;
                case "Lecture":
                    ArrayList<LectureMaTM> lectureMaTMs = new ArrayList<>();
                    if (lectureMaTMs.isEmpty()) {
                    ArrayList<Object> scode = new ArrayList<>();
                    List<LectureDetailsDTO> sdtos1 = lectureDetailsController.getAll();
                    for (LectureDetailsDTO sdto : sdtos1) {
                        LectureMaTM stm  = new LectureMaTM(sdto.getId(),sdto.getLectureName(),sdto.getNicCode(),
                                sdto.getDepaName(),sdto.getScode(),sdto.getSubject());
                        lectureMaTMs.add(stm);                    
                    }
                    ObservableList olCustomers = FXCollections.observableArrayList(lectureMaTMs);
                    tblLectureDetails.setItems(olCustomers);  
                    }                      
                    ObservableList<LectureMaTM> tableItems1 = FXCollections.observableArrayList();
                    ObservableList<TableColumn<LectureMaTM, ?>> cols1 = tblLectureDetails.getColumns();
                    for(int i=0; i<lectureMaTMs.size(); i++) {
                        for(int j=0; j<cols1.size(); j++){
                        TableColumn col = cols1.get(j);
                        String cellValue = col.getCellData(lectureMaTMs.get(i)).toString();
                        cellValue = cellValue.toLowerCase();
                        if(cellValue.contains(txtSerchScode.textProperty().get().toLowerCase())) {
                            tableItems1.add(lectureMaTMs.get(i)); 
                            break;
                        }
                        }}
                    tblLectureDetails.setItems(tableItems1);              
                    break;
                case "Student":
                    ArrayList<StudentTM> studentTMs = new ArrayList<>();
                    if (studentTMs.isEmpty()) {
                    ArrayList<Object> scode = new ArrayList<>();
                    List<StudentDTO> sdtos2 = studentsController.getAll();
                    for (StudentDTO sdto : sdtos2) {
                        StudentTM stm  = new StudentTM(sdto.getPassword(),sdto.getUserName(),sdto.getRegNo(),
                                sdto.getDepartment(),sdto.getYearAndSemester());
                        studentTMs.add(stm);                    
                    }
                    ObservableList olCustomers = FXCollections.observableArrayList(studentTMs);
                    tblStudent.setItems(olCustomers);  
                    }                      
                    ObservableList<StudentTM> tableItems2 = FXCollections.observableArrayList();
                    ObservableList<TableColumn<StudentTM, ?>> cols2 = tblStudent.getColumns();
                    for(int i=0; i<studentTMs.size(); i++) {
                        for(int j=0; j<cols2.size(); j++){
                        TableColumn col = cols2.get(j);
                        String cellValue = col.getCellData(studentTMs.get(i)).toString();
                        cellValue = cellValue.toLowerCase();
                        if(cellValue.contains(txtSerchScode.textProperty().get().toLowerCase())) {
                            tableItems2.add(studentTMs.get(i)); 
                            break;
                        }
                        }}
                    tblStudent.setItems(tableItems2);
                    break;
                case "Department":
                    ArrayList<DepartmentTM> departmentTMs = new ArrayList<>();
                    if (departmentTMs.isEmpty()) {
                    ArrayList<Object> scode = new ArrayList<>();
                    List<DepartmentDeDTO> sdtos3 = departmentDeController.getAll();
                    for (DepartmentDeDTO sdto : sdtos3) {
                        DepartmentTM stm  = new DepartmentTM(sdto.getId(),sdto.getDName());
                        departmentTMs.add(stm);                    
                    }
                    ObservableList olCustomers = FXCollections.observableArrayList(departmentTMs);
                    tblDepartment.setItems(olCustomers);  
                    }                      
                    ObservableList<DepartmentTM> tableItems4 = FXCollections.observableArrayList();
                    ObservableList<TableColumn<DepartmentTM, ?>> cols4 = tblDepartment.getColumns();
                    for(int i=0; i<departmentTMs.size(); i++) {
                        for(int j=0; j<cols4.size(); j++){
                        TableColumn col = cols4.get(j);
                        String cellValue = col.getCellData(departmentTMs.get(i)).toString();
                        cellValue = cellValue.toLowerCase();
                        if(cellValue.contains(txtSerchScode.textProperty().get().toLowerCase())) {
                            tableItems4.add(departmentTMs.get(i)); 
                            break;
                        }
                        }}
                    tblDepartment.setItems(tableItems4);
                    break;
                case "TimeTable":
                    System.out.println("TimeTable");
                    break;
                case "Lecture Hall Details":
                    ArrayList<LectureHallTM> lectureHallTMs = new ArrayList<>();
                    if (lectureHallTMs.isEmpty()) {
                    ArrayList<Object> scode = new ArrayList<>();
                    List<LectureHallDTO> sdtos5 = hallController.getAll();
                    for (LectureHallDTO sdto : sdtos5) {
                        LectureHallTM stm  = new LectureHallTM(sdto.getId(),sdto.getName());
                        lectureHallTMs.add(stm);                    
                    }
                    ObservableList olCustomers5 = FXCollections.observableArrayList(lectureHallTMs);
                    tblLectureHall.setItems(olCustomers5);  
                    }                      
                    ObservableList<LectureHallTM> tableItems5 = FXCollections.observableArrayList();
                    ObservableList<TableColumn<LectureHallTM, ?>> cols5 = tblLectureHall.getColumns();
                    for(int i=0; i<lectureHallTMs.size(); i++) {
                        for(int j=0; j<cols5.size(); j++){
                        TableColumn col = cols5.get(j);
                        String cellValue = col.getCellData(lectureHallTMs.get(i)).toString();
                        cellValue = cellValue.toLowerCase();
                        if(cellValue.contains(txtSerchScode.textProperty().get().toLowerCase())) {
                            tableItems5.add(lectureHallTMs.get(i)); 
                            break;
                        }
                        }}
                    tblLectureHall.setItems(tableItems5);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"System error ! ");
                    break;
            
        } 
        }catch (Exception ex) {
            Logger.getLogger(AllManageController.class.getName()).log(Level.SEVERE, null, ex);
        }      
            }else{
                try {
                    loadAllDetails();
                } catch (Exception ex) {
                    Logger.getLogger(AllManageController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                }
            } 
        });
    }
    private void setTabView(boolean x){
        if(!x){
            altbl.getTabs().remove(tblPaneAdminDetails);
            altbl.getTabs().remove(tblPaneDepartment);
            altbl.getTabs().remove(tblPaneLectureDe);
            altbl.getTabs().remove(tblPaneLectureHallDetails);
            altbl.getTabs().remove(tblPaneStudent);
        }else if(x){
            switch(Manage){
///user          
            case "User":  
                altbl.getTabs().add(tblPaneDepartment);
                altbl.getTabs().add(tblPaneLectureDe);
                altbl.getTabs().add(tblPaneLectureHallDetails);
                altbl.getTabs().add(tblPaneStudent);               
                break;
///lecture               
            case "Lecture":
                altbl.getTabs().add(tblPaneAdminDetails);
                altbl.getTabs().add(tblPaneDepartment);
                altbl.getTabs().add(tblPaneLectureHallDetails);
                altbl.getTabs().add(tblPaneStudent);
                break;
///student               
            case "Student":
                altbl.getTabs().add(tblPaneAdminDetails);
                altbl.getTabs().add(tblPaneDepartment);
                altbl.getTabs().add(tblPaneLectureDe);
                altbl.getTabs().add(tblPaneLectureHallDetails);
                break;
///department               
            case "Department":
                altbl.getTabs().add(tblPaneAdminDetails);
                altbl.getTabs().add(tblPaneLectureDe);
                altbl.getTabs().add(tblPaneLectureHallDetails);
                altbl.getTabs().add(tblPaneStudent);
                break;
            case "Lecture Hall Details":
                altbl.getTabs().add(tblPaneAdminDetails);
                altbl.getTabs().add(tblPaneDepartment);
                altbl.getTabs().add(tblPaneLectureDe);
                altbl.getTabs().add(tblPaneStudent);
                break;
            default:
                break;
            }            
        }
    }
                
}