/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.viewController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.camp.time_table.TM.LectureMaTM;
import lk.camp.time_table.controller.LecturesController;
import lk.camp.time_table.controllerImp.LectureDetailsControllerImp;
import lk.camp.time_table.controllerImp.LectureControllerImp;
import lk.camp.time_table.dto.LectureDetailsDTO;
import lk.camp.time_table.dto.LectureDTO;
import static lk.camp.time_table.viewController.LoginController.PassWord;
import lk.camp.time_table.controller.LectureDetailsController;

/**
 * FXML Controller class
 *
 * @author SACHI
 */
public class LectureManageController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtSCode;
    @FXML
    private JFXTextField txtDepartment;
    @FXML
    private Label lblTitle;
    @FXML
    private JFXTextField txtSName;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnClear;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private TableView<LectureMaTM> tblLecture;
    @FXML
    private JFXButton btnBack;
    private boolean update = false;
    private LecturesController  lecturesController =new LectureControllerImp();
    private LectureDetailsController lectureDetailsController = new LectureDetailsControllerImp();
    @FXML
    private Label lblId;
    private String NIC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        style();
 //////////////Add table   
        tblLecture.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Id"));
        tblLecture.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("LectureName"));
        tblLecture.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("DepaName"));
        tblLecture.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Scode"));
        tblLecture.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Subject"));
        tblLecture.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("leNICNo"));       
        try {
            loadAllDetails();
        } catch (Exception ex) {
            Logger.getLogger(LectureManageController.class.getName()).log(Level.SEVERE, null, ex);
        }      
        tblLecture.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<LectureMaTM>() {
        @Override
        public void changed(ObservableValue<? extends LectureMaTM> observable, LectureMaTM oldValue, LectureMaTM newValue) {

            LectureMaTM customer = observable.getValue();

            if (customer == null){
                update = false;
                return;
            }
            update = true;
            btnDelete.setDisable(!update);
            lblId.setText(customer.getId()+"");
            txtName.setText(customer.getLectureName());
            txtDepartment.setText(customer.getDepaName());
            txtSCode.setText(customer.getScode());
            txtSName.setText(customer.getSubject());                
        }
        });
///////////////
    } 
    @FXML
    private void btnAddAction(ActionEvent event) throws IOException {

        try {
            LectureDTO ldto = lecturesController.search(PassWord);
            LectureDetailsDTO ddto = new LectureDetailsDTO();
            ddto.setNicCode(ldto.getNic().substring(1));
            ddto.setDepaName(txtDepartment.getText());
            ddto.setLectureName(txtName.getText());
            ddto.setScode(txtSCode.getText());
            ddto.setSubject(txtSName.getText());
            lectureDetailsController.add(ddto); 
            loadAllDetails();
        } catch (Exception ex) {
            Logger.getLogger(LectureManageController.class.getName()).log(Level.SEVERE, null, ex);
            errorMassage("Please Enter vlied information");
            rootchange(event,"/lk/camp/time_table/view/LectureManage.fxml");
        }
        clear();       
    }

    @FXML
    private void btnUpdateAction(ActionEvent event) throws Exception {
        
        LectureDetailsDTO detailsDTO = new LectureDetailsDTO(Integer.parseInt(lblId.getText()), 
                NIC, txtDepartment.getText(), txtName.getText(),txtSCode.getText(),txtSName.getText());
        boolean update1 = lectureDetailsController.update(detailsDTO); 
        if (update1) {
         loadAllDetails();   
        }
        
    }

    @FXML
    private void btnClearAction(ActionEvent event) throws Exception {
        clear();
        loadAllDetails();
    }

    @FXML
    private void btnDeleteAction(ActionEvent event) throws Exception {
        boolean delete = lectureDetailsController.delete(Integer.parseInt(lblId.getText()));
        loadAllDetails();
    }

    @FXML
    private void btnBackAction(ActionEvent event) throws IOException, Exception {
        rootchange(event,"/lk/camp/time_table/view/DashBoardLecture.fxml");
        loadAllDetails();
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
    private void loadAllDetails() throws SQLException, Exception{ 
        
       List<LectureDetailsDTO>  all ;  
       LectureDetailsDTO ddto;
       ArrayList<LectureMaTM> lectureMaTMs = new ArrayList<>(); 
       LectureDTO ldto = lecturesController.search(PassWord);
       NIC  = ldto.getNic();
       try {

           all = lectureDetailsController.getAll();
           for (LectureDetailsDTO courseDescriptionDTO : all) {                
               if (courseDescriptionDTO.getNicCode() == null ? ldto.getNic() == null : 
                   courseDescriptionDTO.getNicCode().equals(ldto.getNic())) {
                   LectureMaTM lecture = new LectureMaTM(courseDescriptionDTO.getId(),
                   courseDescriptionDTO.getLectureName(),NIC.substring(1),
                   courseDescriptionDTO.getDepaName(), courseDescriptionDTO.getScode(),
                   courseDescriptionDTO.getSubject());
                   lectureMaTMs.add(lecture);
               }
           }
        ObservableList olCustomers = FXCollections.observableArrayList(lectureMaTMs);
        tblLecture.setItems(olCustomers);     
       } catch (Exception ex) {
           Logger.getLogger(LectureManageController.class.getName()).log(Level.SEVERE, null, ex);
       }
       txtName.setText(ldto.getUserName());
       txtDepartment.setText(ldto.getPost());
    }
    public static void errorMassage(String A){
            Alert error = new Alert(Alert.AlertType.ERROR, A, ButtonType.OK);
            error.setHeaderText("Duplicate Entry Found");
            error.setTitle("Duplicate Error");
            error.show();
            return;
    }
    private void clear(){
        txtSCode.setText("");
        txtSName.setText("");
    }
    private void style(){
        txtDepartment.setStyle("-fx-text-inner-color: red;");
        txtName.setStyle("-fx-text-inner-color: red;");
        txtSCode.setStyle("-fx-text-inner-color: red;");
        txtSName.setStyle("-fx-text-inner-color: red;");
    }
}
