/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.viewController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.mchange.v2.c3p0.impl.C3P0Defaults;
import com.sun.java.swing.plaf.windows.resources.windows;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import lk.camp.time_table.TM.SubjectsTM;
import lk.camp.time_table.controller.SubjectsController;
import lk.camp.time_table.controllerImp.SubjectsControllerImp;
import lk.camp.time_table.dto.SubjectsDTO;

/**
 * FXML Controller class
 *
 * @author SACHI
 */
public class SubjectManageController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField txtScode;
    @FXML
    private JFXTextField txtSName;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnClear;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private TableView<SubjectsTM> tblSubject;
    @FXML
    private JFXButton btnExite;
    @FXML
    private  JFXComboBox<String> comSearch;
    private ArrayList<String> scodes;
    private boolean result,found,error;
    private int id;

    private SubjectsController subjectsController= new  SubjectsControllerImp();
    @FXML
    private Label lblID;
    @FXML
    private TableColumn<SubjectsTM, String> tblColmn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblSubject.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblSubject.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("scode"));
        tblSubject.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("sname"));
        addTbl();   
        btnExite.setVisible(false);
        try {
        lisner();
        initFilter();
        } catch (Exception ex) {
                Logger.getLogger(SubjectManageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        comSearch.setVisibleRowCount(4);
        
        
    }    
    private void lisner()throws Exception{
        tblSubject.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<SubjectsTM>() {
            @Override
            public void changed(ObservableValue<? extends  SubjectsTM> observable,
                   SubjectsTM oldValue, SubjectsTM newValue) {

            SubjectsTM subjectsTM = observable.getValue();

            if (subjectsTM == null){
//                update = false;
                found=true;
                return;
            }
            found = false;
            lblID.setText(subjectsTM.getId()+"");
            txtSName.setText(subjectsTM.getSname());
            txtScode.setText(subjectsTM.getScode());
            }
            });
        comSearch.getSelectionModel().selectedItemProperty().addListener(
        new ChangeListener<String>() {                
        @Override
        public void changed(ObservableValue<? extends String> observable,
            String oldValue, String newValue) {
            try {
                String value = observable.getValue();                        
                if (value == null){
//                        update = false;
                    txtScode.setText(value);
                    txtSName.setText(value);
                    lblID.setText("");
                    comSearch.hide();
                    return;
                }
                found=true;
                txtScode.setText(value);
                setTxtFid(value);
//                initFilter();
            } catch (Exception ex) {
                Logger.getLogger(SubjectManageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
    }
    private void addTbl(){
        try {   
            ArrayList<SubjectsTM> subjectsTMs = new ArrayList<>();
            scodes = new ArrayList<>();
            List<SubjectsDTO> sdtos = subjectsController.getAllSubjects();
            for (SubjectsDTO sdto : sdtos) {
                comSearch.getItems().add(sdto.getScode());
                scodes.add(sdto.getScode());
                SubjectsTM stm  = new SubjectsTM(sdto.getId(),sdto.getScode(),sdto.getSname());
                subjectsTMs.add(stm);   
            }
            ObservableList olCustomers = FXCollections.observableArrayList(subjectsTMs);     
            tblSubject.setItems(olCustomers);
        } catch (Exception ex) {
            Logger.getLogger(SubjectManageController.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    /////////////////////////////////////////////////////////////////////////////////////////ActionEvent event
    @FXML
    private void btnAdd(ActionEvent event) throws Exception {
        error = false;
        txtError();
        if (error == true) {
        return;
        }
        for (String scode : scodes) {
        if (scode.equals(txtScode.getText())) { 
            JOptionPane.showMessageDialog(null,"duplicate entry ! ,"
                    + "Subject Code : " +txtScode.getText() +" is already exist");
            return;
          } }
        SubjectsDTO ddto = new SubjectsDTO();
        ddto.setScode(txtScode.getText());
        ddto.setSname(txtSName.getText());
        System.out.println(txtSName.getText());
        result = subjectsController.addSubjects(ddto);
        comSearch.getItems().clear();
        if (result) {
            clear();
        }
        addTbl();          
    }
    @FXML
    private void btnClear(ActionEvent event) {        
        clear();
    }

    @FXML
    private void btnUpdate(ActionEvent event) throws Exception {
        int i=0;
        txtError();
        if ((error == true)) {return;}
        List<SubjectsDTO> sdtos = subjectsController.getAllSubjects();
            for (SubjectsDTO sdto : sdtos) {
            if (sdto.getScode().equals(txtScode.getText())) { 
                if (!(sdto.getId() == Integer.parseInt(lblID.getText()))) {
                 i += 1;    
                }                                   
            } 
            }          
        if (i>0) {
            JOptionPane.showMessageDialog(null,"duplicate entry ! ,"
                    + "Subject Code : " +txtScode.getText() +" is already exist");
            return;
        } 
        id = Integer.parseInt(lblID.getText());
        SubjectsDTO subjectsDTO = new SubjectsDTO(id,txtScode.getText(),txtSName.getText());
        boolean update = subjectsController.updateSubjects(subjectsDTO);
        comSearch.getItems().clear();
        addTbl();
        if (update) {
            clear();
        }
    }

    @FXML
    private void btnDelete(ActionEvent event) throws Exception {
            txtError();
            if (error == true) {            
            return;
            }
                id = Integer.parseInt(lblID.getText());
                subjectsController.deleteSubjects(id);
                clear();
                comSearch.getItems().clear();
                addTbl();  
    }

    @FXML
    private void exiteAc(ActionEvent event) throws IOException {
        // get a handle to the stage
        Stage stage = (Stage) btnExite.getScene().getWindow();
        // do what you have to do
        stage.close();
//        rootchange(event,"/lk/camp/time_table/view/AllManage.fxml");//AllManage.fxml
    }

    @FXML
    private void comSearchA(ActionEvent event) { 
        AutoCompleteComboBox<Object> autoCompleteComboBox = new AutoCompleteComboBox<>(comSearch);
    }
    //////////////////////////////////////////////////////////////////////////////////////////others
    private void setTxtFid(String val) throws Exception{
        if ("".equals(txtScode.getText())) {
            txtSName.setText("");
            lblID.setText("");
            addTbl();            
            comSearch.hide();
        }else{
        List<SubjectsDTO> sdt = subjectsController.getAllSubjects();
            for (SubjectsDTO sdto : sdt) {
                if (sdto.getScode() == null ? val == null : sdto.getScode().equals(val)) {
                    txtScode.setText(val);
                    txtSName.setText(sdto.getSname());
                    lblID.setText(sdto.getId()+"");                    
                }             
            }
        }
    }
    private void txtError(){  
        found=true;
        Pattern pattern1 = Pattern.compile("^[a-zA-Z0-9 ]+$");
        Pattern pattern2 = Pattern.compile("^[A-Z]{2}[0-9]{4}$");
        if(!(pattern2.matcher(txtScode.getText()).matches() &&
            pattern1.matcher(txtSName.getText()).matches()) ){
            error = true;
            if((pattern1.matcher(txtSName.getText()).matches())){
            JOptionPane.showMessageDialog(null,"duplicate entry ! (Subject Code :AA1234)");
            return;
            }JOptionPane.showMessageDialog(null,"duplicate entry ! (Subject Name : null)");            
        }else{error = false;}
    }
    private void clear(){
        txtSName.setText("");
        txtScode.setText("");
        comSearch.getItems().clear();
        lblID.setText("");
        comSearch.getSelectionModel().clearSelection();
        comSearch.hide();
        found=true;
        error= false;
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
    private void initFilter()throws Exception{        
        txtScode.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if(!(txtScode.textProperty().get().isEmpty() || "".equals(txtScode.getText()))) {
                    if (!found) {
                         return;
                    }
                    try {
                        ArrayList<SubjectsTM> subjectsTMs = new ArrayList<>();
                        if (subjectsTMs.isEmpty()) {
                          scodes = new ArrayList<>();
                        List<SubjectsDTO> sdtos = subjectsController.getAllSubjects();
                        for (SubjectsDTO sdto : sdtos) {
                            scodes.add(sdto.getScode());
                            SubjectsTM stm  = new SubjectsTM(sdto.getId(),sdto.getScode(),sdto.getSname());
                            subjectsTMs.add(stm);                      
                        }
                        ObservableList olCustomers = FXCollections.observableArrayList(subjectsTMs);
                        tblSubject.setItems(olCustomers);  
                        }                       
                        ObservableList<SubjectsTM> tableItems = FXCollections.observableArrayList();
                        ObservableList<TableColumn<SubjectsTM, ?>> cols = tblSubject.getColumns();
                        for(int i=0; i<subjectsTMs.size(); i++) {
                            for(int j=0; j<cols.size(); j++) {
                                TableColumn col = cols.get(j);
                                String cellValue = col.getCellData(subjectsTMs.get(i)).toString();
                                cellValue = cellValue.toLowerCase();
                                if(cellValue.contains(txtScode.textProperty().get().toLowerCase())) {
                                    tableItems.add(subjectsTMs.get(i));
                                    break;
                                }
                            }
                            tblSubject.setItems(tableItems);
                        }            } catch (Exception ex) {
                            Logger.getLogger(SubjectManageController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }else{
                        comSearch.getItems().clear();
                        txtSName.setText("");
                        addTbl();
                }
            } 
        });
    }

       
}
