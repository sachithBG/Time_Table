/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.viewController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import lk.camp.time_table.TM.LectureMaTM;
import lk.camp.time_table.TM.TimeTableTM;
import lk.camp.time_table.TM.TimeTblCorrrectFormatTM;
import lk.camp.time_table.controller.DepartmentDeController;
import lk.camp.time_table.controller.LectureDetailsController;
import lk.camp.time_table.controller.LectureHallController;
import lk.camp.time_table.controller.LecturesController;
import lk.camp.time_table.controller.StudentsController;
import lk.camp.time_table.controller.TimeTblCorrectFormatController;
import lk.camp.time_table.controller.TimeTableController;
import lk.camp.time_table.controllerImp.DepartmentDeControllerImp;
import lk.camp.time_table.controllerImp.LectureControllerImp;
import lk.camp.time_table.controllerImp.LectureDetailsControllerImp;
import lk.camp.time_table.controllerImp.LectureHallControllerImp;
import lk.camp.time_table.controllerImp.StudentsControllerImp;
import lk.camp.time_table.controllerImp.TimeTableControllerImp;
import lk.camp.time_table.controllerImp.TimeTblCorrectFormatControllerImp;
import lk.camp.time_table.dto.DepartmentDeDTO;
import lk.camp.time_table.dto.LectureDetailsDTO;
import lk.camp.time_table.dto.LectureHallDTO;
import lk.camp.time_table.dto.TimeTableDTO;
import lk.camp.time_table.dto.TimeTblCorrectFormatDTO;
import static lk.camp.time_table.viewController.LoginController.post;

/**
 * FXML Controller class
 *
 * @author SACHI
 */
public class TimeTablesController implements Initializable {

    @FXML
    private ImageView allTbl;
    @FXML
    private JFXButton btnBack;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnBack1;
    @FXML
    private TableView<TimeTblCorrrectFormatTM> tbl1;
    @FXML
    private TableView<TimeTblCorrrectFormatTM> tbl2;
    @FXML
    private TableView<TimeTblCorrrectFormatTM> tbl3;
    @FXML
    private TableView<TimeTblCorrrectFormatTM> tbl4;
    @FXML
    private JFXTextField txtLecName;
    @FXML
    private JFXTextField txtSubName;
    @FXML
    private JFXComboBox<String> comCode;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnClear;
    @FXML
    private JFXButton btnRefresh;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnSend;
    @FXML
    private JFXTimePicker TimePick1;
    @FXML
    private JFXTimePicker TimePick2;
    @FXML
    private JFXButton RowDelete;
    @FXML
    private JFXComboBox<String> comOrderNo;
    @FXML
    private JFXComboBox<String> comSemester;
    @FXML
    private JFXComboBox<String> comDepaName;
    @FXML
    private JFXButton btnOrdMin;
    @FXML
    private JFXButton btnOrdAdd;
    @FXML
    private TabPane altbls;
    @FXML
    private Tab Tab1;
    @FXML
    private Tab Tab2;
    @FXML
    private Tab Tab3;
    @FXML
    private Tab Tab4;
    @FXML
    private Label lblDate1;
    @FXML
    private Label lblTime1;
    @FXML
    private JFXComboBox<String> comDateName;
    
    private static int year=1,Start,End,Re,OrdNo=4;
    private static String Deptmnt,Sem;
    private boolean update = true,result = false;
    private static ArrayList<String> DListInTbl;
    private static ArrayList<LectureMaTM> lectureMa;
    private static ArrayList<TimeTableTM> timeTableTMs;
    private static ArrayList<String> LeName;
    private static ArrayList<String> DList;
    private static ArrayList<String> Scodes;
    private static ArrayList<String> ScodesTTbl;
    private static ArrayList<String> SName;
    private static ArrayList<String> LectHall;
    private static ArrayList<String> StringVal;
    private ArrayList<String> tblColumn;
    private ArrayList<Integer> tblOrder;

    
    private StudentsController studentsController =new StudentsControllerImp();
    private LecturesController  lecturesController =new LectureControllerImp();
    private TimeTableController timeTableController =new TimeTableControllerImp();
    private DepartmentDeController departmentDeController = new DepartmentDeControllerImp();
    private LectureDetailsController lectureDetailsController = new LectureDetailsControllerImp();
    private LectureHallController hallController = new  LectureHallControllerImp();
    private TimeTblCorrectFormatController formatController = new TimeTblCorrectFormatControllerImp();
    @FXML
    private JFXComboBox<String> comLectureHall;
    private static String selectedVal1,CurrentDate,CurrentTime;
    private static String selectedVal2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ColumnOrder(OrdNo);
        setDateTime();
        tabLisner();
        setDate();
        setColmnTbl();
        
//        getAll();        
    } 

    public TimeTablesController() {
//        setDateTime();
    }
    private void setDateTime(){
        lblDate1.setAlignment(Pos.CENTER_LEFT);
        lblTime1.setAlignment(Pos.CENTER_RIGHT);
        LocalDateTime today = LocalDateTime.now();
        CurrentTime = today.getHour()+"- "+today.getMinute()+"- "+today.getSecond();
        CurrentDate = today.getDayOfMonth()+"- "+today.getMonth()+"- "+today.getYear();
        lblDate1.setText("Current Date = "+CurrentDate);
        lblTime1.setText("Current Time = "+CurrentTime);
    }
    private void tabLisner(){
        Re =0;
        altbls.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
        @Override
        public void changed(ObservableValue<? extends Tab> observable, Tab oldTab, Tab newTab) {
            Re = 1;
            if(newTab == Tab1) {
                year = 1;
                Start = 1;
                End = 3;
            }else if(newTab == Tab2){
                year = 2;
                Start = 3;
                End = 5;
            }else if(newTab == Tab3){
                year = 3;
                Start = 5;
                End = 7;
            }else if(newTab == Tab4){
                year = 4;
                Start = 7;
                End = 9;
            }                                    
                semester(Start, End); 
                comLisner();
        }        
        });   
            if(Re == 0){                
                year = 1;
                Start = 1;
                End = 3;  
                semester(Start, End); 
                comLisner();                
            }           
    }
    private void setColmnTbl(){
        tblColumn = new ArrayList<>();
        tblColumn.clear();
//        tblColumn.add("id"); 
        tblColumn.add("timePeriod");
        tblColumn.add("sortOrder");
        tblColumn.add("Monday");
        tblColumn.add("Tuesday");
        tblColumn.add("Wednesday"); 
        tblColumn.add("Thursday");
        tblColumn.add("Friday");
        tblColumn.add("Saturday");
        switch (year) {
            case 1:
                addTbl(tblColumn, tbl1);
                break;
            case 2:
                addTbl(tblColumn, tbl2);
                break;
            case 3:
                addTbl(tblColumn, tbl3);
                break;
            case 4:
                addTbl(tblColumn, tbl4);
                break;
            default:
                break;
        }
        
    }
    private void addTbl(ArrayList list,TableView<TimeTblCorrrectFormatTM> tbl){                  //////////////////////////////Add Tbl
        for (String s : this.tblColumn) {
                tbl.getColumns().get(list.indexOf(s)).setCellValueFactory(new PropertyValueFactory<>(s));
                }
            {
                try {
                    getAll();
                } catch (Exception ex) {
                    Logger.getLogger(AllManageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   
                tbl.getSelectionModel().selectedItemProperty().addListener(
                    new ChangeListener<TimeTblCorrrectFormatTM>() {
            @Override
            public void changed(ObservableValue<? extends TimeTblCorrrectFormatTM> observable,
                    TimeTblCorrrectFormatTM oldValue, TimeTblCorrrectFormatTM newValue) {

            TimeTblCorrrectFormatTM tableTM = observable.getValue();

            if (tableTM == null){
                update = false;
                return;
            }
//                setTxt(lectureTM.getPwd(),lectureTM.getUserName(), 
//                                       lectureTM.getPost(), NIC,"","");
            }
            });
    }
    private void getAll(){                                                      ////////////////////////////get All
        try {
                timeTableTMs = new ArrayList<>();
                tblOrder = new ArrayList<>();
                ScodesTTbl = new ArrayList<>();
                List<TimeTableDTO> all1 = timeTableController.getAll();
                for (TimeTableDTO tableDTO : all1) {
                    ScodesTTbl.add(tableDTO.getSubject());
                    tblOrder.add(tableDTO.getTblOrder());
                    TimeTableTM tableTM = new TimeTableTM(tableDTO.getSucode(),
                            tableDTO.getTblOrder(),tableDTO.getSubject(),
                            tableDTO.getYear(),tableDTO.getSemester(),tableDTO.getLecture(),
                            tableDTO.getDate(),tableDTO.getTime(),tableDTO.getLatestUpdatedTime()); 
                    timeTableTMs.add(tableTM);                    
                }
            } catch (Exception ex) {
                Logger.getLogger(TimeTablesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
                DListInTbl = new ArrayList<>();
                List<DepartmentDeDTO> dTOs = departmentDeController.getAll();
                for (DepartmentDeDTO dddto : dTOs) {
                    DListInTbl.add(dddto.getDName());
                    comDepaName.getItems().add(dddto.getDName());
                    System.out.println("Department : "+ dddto.getDName());
                }
            } catch (Exception ex) {
                Logger.getLogger(TimeTablesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
            lectureMa = new ArrayList<>();                
            DList = new ArrayList<>();
            LeName = new ArrayList<>();
            Scodes = new ArrayList<>();
            SName = new ArrayList<>();
            List<LectureDetailsDTO> all1 = lectureDetailsController.getAll();
            for (LectureDetailsDTO lectureDTO : all1) {                    
                LectureMaTM lectureMaTM  = new LectureMaTM(lectureDTO.getId(),
                   lectureDTO.getLectureName(),lectureDTO.getNicCode(),
                   lectureDTO.getDepaName(),lectureDTO.getScode(),lectureDTO.getSubject());                  
                   lectureMa.add(lectureMaTM);
                DList.add(lectureDTO.getDepaName());
                LeName.add(lectureDTO.getLectureName());
                Scodes.add(lectureDTO.getScode());
                comCode.getItems().add(lectureDTO.getScode());
                SName.add(lectureDTO.getSubject());                   
                }
            } catch (Exception ex) {
                Logger.getLogger(TimeTablesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
                LectHall = new ArrayList<>();
                List<LectureHallDTO> dTOs = hallController.getAll();
                for (LectureHallDTO dddto : dTOs) {
                    LectHall.add(dddto.getName());
                    comLectureHall.getItems().add(dddto.getName());                     
                }
            } catch (Exception ex) {
                Logger.getLogger(TimeTablesController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    private void comLisner(){                                                   ///////////////////////////com Lisner
            comSemester.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<String>() {                
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                    String value = observable.getValue();                    
                    if (value == null){                        
                        update = false;
                        return;
                    }
                   Pattern pattern1 = Pattern.compile(".*[^0-9].*");
                   Pattern pattern2 = Pattern.compile(".*\\D.*");
                   validet(value, pattern1, pattern2);
                   if (!(selectedVal1 == null)) {
                        Sem = value;
                   }
                   System.out.println(selectedVal1 +" and "+selectedVal2);                           
            }
            }); 
            comOrderNo.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<String>() {                
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                    String value = observable.getValue();                    
                    if (value == null){                        
                        update = false;
                        return;
                    }
            }
            }); 
            comDepaName.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<String>() {                
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                    String value = observable.getValue();                    
                    if (value == null){                        
                        update = false;
                        return;
                    }  
                    String lastWord = value.replaceAll("^.*?(\\w+)\\W*$", "$1");
                    Pattern p = Pattern.compile("[a-zA-Z]+");
                    Matcher m1 = p.matcher(value);
                    while (m1.find()) {
                        System.out.println(m1.group());                        
                    }System.out.println(lastWord);
                    Pattern pattern1 = Pattern.compile(".*[^0-9].*");
                    Pattern pattern2 = Pattern.compile(".*\\D.*");
                    for (LectureMaTM s : lectureMa) {
                        if(s.getDepaName() == value){
                            validet(value, pattern1, pattern2);
                        }
                    }                                    
                    if (!(selectedVal1 == null || selectedVal2 == null)) {
                        Deptmnt = selectedVal1+selectedVal2; 
                   }
            }
            }); 
            comCode.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<String>() {                
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                    String value = observable.getValue();                    
                    if (value == null){                        
                        update = false;
                        return;
                    }
                    for (LectureMaTM s : lectureMa) {
                        if(s.getScode() == value){
                           txtLecName.setText(s.getLectureName());
                           txtSubName.setText(s.getSubject());
                        }
                   }
            }
            });    
            comLectureHall.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<String>() {                
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                    String value = observable.getValue();                    
                    if (value == null){                        
                        update = false;
                        return;
                    }                   
            }
            }); 
    }
    private void comUpdate(){
          
    }
    private void setVal(){
         
    }
    private void ColumnOrder(int j){        
        for (int i = 0; i < j; i++) {
          comOrderNo.getItems().add(i+"");  
        }   
        comOrderNo.setVisibleRowCount(3);
    }
    private void semester(int s,int e){  
        comSemester.getItems().clear();
        for ( int i = s; i < e; i++) {
        comSemester.getItems().add("Semester - " +i);                          
        }         
    }
    private void setDate(){
//        comDateName.getItems().add("Sunday");
        comDateName.getItems().add("Monday");
        comDateName.getItems().add("Tuesday");
        comDateName.getItems().add("Wednesday");
        comDateName.getItems().add("Thursday");
        comDateName.getItems().add("Friday");
        comDateName.getItems().add("Saturday");  
        comDateName.setVisibleRowCount(3);
    }
    @FXML
    private void btnBackAction(ActionEvent event) throws IOException {
        if ("lecture".equals(post)) {
            rootchange(event,"/lk/camp/time_table/view/DashBoardLecture.fxml");
        }else if ("Admin".equals(post)) {
            rootchange(event,"/lk/camp/time_table/view/DashBoardAdmin.fxml");
        }   
    }
    
    @FXML
    private void btnLogOutAction(ActionEvent event) throws IOException {
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

    @FXML
    private void btnAddA(ActionEvent event) throws Exception { 
    
    /////////
    txtTest();
    tabLisner();
    setDateTime();                                  /////////////////////////////////////////////////Time
    String Time1,Time2;
    LocalTime value1 = TimePick1.getValue(); 
    LocalTime value2 = TimePick1.getValue();
    int hour1 = value1.getHour(); 
    int hour2 = value2.getHour();
    if(hour1 <= 12){
    Time1 = value1+" AM";}else{Time1 = value1+" PM";}
    if(hour2 <= 12){
    Time2 = value2+" AM";}else{Time2 = value2+" PM";}        
    ///////////////add TimeTableDTO
    String Scode1 = comCode.getSelectionModel().getSelectedItem();
    TimeTableDTO ddto = new TimeTableDTO();
    ddto.setSucode(Scode1);
    ddto.setTblOrder(Integer.parseInt(comOrderNo.getSelectionModel().getSelectedItem()));
    ddto.setSubject(txtSubName.getText());
    ddto.setYear(year+"");
    ddto.setSemester(selectedVal1);
    ddto.setLecture(txtLecName.getText());
    ddto.setDate(comDateName.getSelectionModel().getSelectedItem());
    ddto.setTime(Time1+" - " +Time2);
    ddto.setLatestUpdatedTime(CurrentDate+" - "+CurrentTime);
    ////////////////add TimeTbl CorectFormat DTO
    TimeTblCorrectFormatDTO ddtoDTO = new TimeTblCorrectFormatDTO();
        ddtoDTO.setTimePeriod(CurrentDate+" - "+CurrentTime);
        ddtoDTO.setSortOrder(Integer.parseInt(comOrderNo.getSelectionModel().getSelectedItem()));
        String ComDatName = comDateName.getSelectionModel().getSelectedItem();
//        ddtoDTO.setMonday(comCode.getSelectionModel().getSelectedItem());
    int selectedOrderNo = Integer.parseInt(comOrderNo.getSelectionModel().getSelectedItem());
    ////////////////////////load after use getAll();
                tblOrder = new ArrayList<>();
                List<TimeTableDTO> all3 = timeTableController.getAll();
                for (TimeTableDTO tableDTO : all3) {
                    tblOrder.add(tableDTO.getTblOrder());               
                }
    ///////////////cheque Scode
        String selectedItm = comCode.getSelectionModel().getSelectedItem();
        int r = 0;System.out.println("TBL ORDER "+tblOrder);
        for (int i: tblOrder) { System.out.println("vvv..............................."+i+selectedOrderNo);
            if (i == selectedOrderNo) {
                System.out.println("NO...............................");
        List<TimeTblCorrectFormatDTO> all1 = formatController.getAllTimeTbl();
        for (TimeTblCorrectFormatDTO tableDTO : all1) {
            if(selectedOrderNo == tableDTO.getSortOrder()){
                ddtoDTO.setId(tableDTO.getId());
                switch(ComDatName){
                case "Monday":
                    ddtoDTO.setTuesday(tableDTO.getTuesday()+" N"); 
                    ddtoDTO.setWednesday(tableDTO.getWednesday()+" N"); 
                    ddtoDTO.setThursday(tableDTO.getThursday()+" N"); 
                    ddtoDTO.setFriday(tableDTO.getFriday()+ "N "); 
                    ddtoDTO.setSaturday(tableDTO.getSaturday()+" N"); 
                    ddtoDTO.setMonday(Scode1);             
                    break;
                case "Tuesday":
                    ddtoDTO.setMonday(tableDTO.getMonday()+"N "); 
                    ddtoDTO.setWednesday(tableDTO.getWednesday()+" N"); 
                    ddtoDTO.setThursday(tableDTO.getThursday()+" N"); 
                    ddtoDTO.setFriday(tableDTO.getFriday()+ "N "); 
                    ddtoDTO.setSaturday(tableDTO.getSaturday()+" N"); 
                    ddtoDTO.setTuesday(Scode1);
                    break;
                case "Wednesday":
                    ddtoDTO.setMonday(tableDTO.getMonday()+"N "); 
                    ddtoDTO.setTuesday(tableDTO.getTuesday()+" N"); 
                    ddtoDTO.setThursday(tableDTO.getThursday()+" N"); 
                    ddtoDTO.setFriday(tableDTO.getFriday()+ "N "); 
                    ddtoDTO.setSaturday(tableDTO.getSaturday()+" N"); 
                    ddtoDTO.setWednesday(Scode1);
                    break;
                case "Thursday":
                    ddtoDTO.setMonday(tableDTO.getMonday()+"N "); 
                    ddtoDTO.setTuesday(tableDTO.getTuesday()+" N"); 
                    ddtoDTO.setWednesday(tableDTO.getWednesday()+" N"); 
                    ddtoDTO.setFriday(tableDTO.getFriday()+ "N "); 
                    ddtoDTO.setSaturday(tableDTO.getSaturday()+" N"); 
                    ddtoDTO.setThursday(Scode1);
                    break;
                case "Friday":
                    ddtoDTO.setMonday(tableDTO.getMonday()+"N "); 
                    ddtoDTO.setTuesday(tableDTO.getTuesday()+" N"); 
                    ddtoDTO.setWednesday(tableDTO.getWednesday()+" N"); 
                    ddtoDTO.setThursday(tableDTO.getThursday()+" N"); 
                    ddtoDTO.setSaturday(tableDTO.getSaturday()+" N"); 
                    ddtoDTO.setFriday(Scode1);
                    break;
                case "Saturday":
                    ddtoDTO.setMonday(tableDTO.getMonday()+"N "); 
                    ddtoDTO.setTuesday(tableDTO.getTuesday()+" N"); 
                    ddtoDTO.setWednesday(tableDTO.getWednesday()+" N"); 
                    ddtoDTO.setThursday(tableDTO.getThursday()+" N"); 
                    ddtoDTO.setFriday(tableDTO.getFriday()+ "N "); 
                    ddtoDTO.setSaturday(Scode1);
                    break;
                default:
                    break;
                }}
            r += 1;
            result = formatController.updateTimeTbl(ddtoDTO);  
            result = timeTableController.update(ddto);
                
            }return; }          
        }if(r==1){return;}
        ////////////////onother
            System.out.println("OK............kkkk..................................");
            switch(ComDatName){
                case "Monday":
                    ddtoDTO.setTuesday("emty"); 
                    ddtoDTO.setWednesday("emty"); 
                    ddtoDTO.setThursday("emty"); 
                    ddtoDTO.setFriday("emty"); 
                    ddtoDTO.setSaturday("emty"); 
                    ddtoDTO.setMonday(comCode.getSelectionModel().getSelectedItem());             
                    break;
                case "Tuesday":
                    ddtoDTO.setMonday("emty"); 
                    ddtoDTO.setWednesday("emty"); 
                    ddtoDTO.setThursday("emty"); 
                    ddtoDTO.setFriday("emty"); 
                    ddtoDTO.setSaturday("emty"); 
                    ddtoDTO.setTuesday(comCode.getSelectionModel().getSelectedItem());
                    break;
                case "Wednesday":
                    ddtoDTO.setMonday("emty"); 
                    ddtoDTO.setTuesday("emty"); 
                    ddtoDTO.setThursday("emty"); 
                    ddtoDTO.setFriday("emty"); 
                    ddtoDTO.setSaturday("emty"); 
                    ddtoDTO.setWednesday(comCode.getSelectionModel().getSelectedItem());
                    break;
                case "Thursday":
                    ddtoDTO.setMonday("emty"); 
                    ddtoDTO.setTuesday("emty"); 
                    ddtoDTO.setWednesday("emty"); 
                    ddtoDTO.setFriday("emty"); 
                    ddtoDTO.setSaturday("emty"); 
                    ddtoDTO.setThursday(comCode.getSelectionModel().getSelectedItem());
                    break;
                case "Friday":
                    ddtoDTO.setMonday("emty"); 
                    ddtoDTO.setTuesday("emty"); 
                    ddtoDTO.setWednesday("emty"); 
                    ddtoDTO.setThursday("emty"); 
                    ddtoDTO.setSaturday("emty"); 
                    ddtoDTO.setFriday(comCode.getSelectionModel().getSelectedItem());
                    break;
                case "Saturday":
                    ddtoDTO.setMonday("emty"); 
                    ddtoDTO.setTuesday("emty"); 
                    ddtoDTO.setWednesday("emty"); 
                    ddtoDTO.setThursday("emty"); 
                    ddtoDTO.setFriday("emty"); 
                    ddtoDTO.setSaturday(comCode.getSelectionModel().getSelectedItem());
                    break;
                default:
                    break;
                }
            result = timeTableController.add(ddto);
            result = formatController.addTimeTbl(ddtoDTO);
//            JOptionPane.showMessageDialog(null,"Duplicate Entity! Subject already exist");

        if (result == !true) {
          JOptionPane.showMessageDialog(null,"Duplicate Entity,,,! ");   
        }
    }
    private void validet(String word,Pattern pattern1,Pattern pattern2){
        StringVal = new ArrayList<>();
//        String lastWord = word.replaceAll("^.*?(\\w+)\\W*$", "$1");
        if ((word.trim().matches("^[A-Z]{2}[0-9]{4}$"))) {
            }
        
        for (int cha = 0; cha < word.length(); ++cha) {
               String c = Character.toString(word.charAt(cha));
               StringVal.add(c);
            }
        for (String string : StringVal) {
            if (!pattern1.matcher(string).matches()) {
              selectedVal1 = string; 
            }
            if (!pattern2.matcher(string).matches()) { 
              selectedVal2 = string; 
            }            
        }     
    }
    @FXML
    private void btnUpdateA(ActionEvent event) {
    }

    @FXML
    private void btnClearA(ActionEvent event) {
    }

    @FXML
    private void btnRefreshA(ActionEvent event) {
    }

    @FXML
    private void btnDeleteA(ActionEvent event) {
    }

    @FXML
    private void btnSaveA(ActionEvent event) {
    }

    @FXML
    private void btnSendA(ActionEvent event) {
    }

    @FXML
    private void DateNameA(ActionEvent event) {
    }


    @FXML
    private void comCodeA(ActionEvent event) {
    }


    @FXML
    private void rowDeleteA(ActionEvent event) {
    }

    @FXML
    private void OrderNoA(ActionEvent event) {
    }

    @FXML
    private void comsemesterA(ActionEvent event) {
    }

    @FXML
    private void comDepaNameA(ActionEvent event) {
    }

    @FXML
    private void btnOrdMinActoin(ActionEvent event) {
        comOrderNo.getItems().clear();
        OrdNo = OrdNo-1;
        ColumnOrder(OrdNo);
        comOrderNo.setValue(OrdNo-1+"");
    }

    @FXML
    private void btnOrdAddActoin(ActionEvent event) {
        comOrderNo.getItems().clear();
        OrdNo = OrdNo+1;
        ColumnOrder(OrdNo);
        comOrderNo.setValue(OrdNo-1+"");
    }

    @FXML
    private void SemesterClickEvent(MouseEvent event) {
        if (Re == 0) {
           JOptionPane.showMessageDialog(null,"Please Select a year of below Table to update the semesters "); 
        }
    } 
    private void txtTest(){
//        Date dat1 = parseDate(dat.getEditor().getText());
        if(txtLecName.getText() == null || txtSubName.getText() == null ||
                TimePick1.getEditor().getText()== null || TimePick2.getEditor().getText()== null ){
            update = false;            
        }  
    }
    private Date parseDate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");       
        try {
            return sdf.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(TimeTablesController.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return null;
    }

    @FXML
    private void AnchorPln(MouseEvent event) {
        setDateTime();
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
    private void TimePick1(ActionEvent event) {
    }

    @FXML
    private void TimePick2(ActionEvent event) {
    }
}
