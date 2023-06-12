package com.example.finalgradecalculate;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;



public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label display;
    @FXML
    private Hyperlink link = new Hyperlink();
    private String[] grade = {"A","B","C","D","E"};
    @FXML
    private ChoiceBox Q1 = new ChoiceBox();
    @FXML
    private ChoiceBox Q2 = new ChoiceBox();
    @FXML
    private ChoiceBox Q3 = new ChoiceBox();
    @FXML
    private ChoiceBox Q4 = new ChoiceBox();
    @FXML
    private ChoiceBox Final = new ChoiceBox();

    private Stage stage;
    private Scene scene;


    @FXML
    protected void openLink(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.hcps.org/webfiles/WebFilesHandler.ashx?id=2650"));
    }

    public void openFinalGrade(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FinalGrade.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void openHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void openGPA(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GPA.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void calculate(ActionEvent actionEvent){
        double finalGrade = 0;
        String finalLetter = "";
        ChoiceBox[] choiceList = {Q1,Q2,Q3,Q4};
        if(Q1.getValue() != null &&Q2.getValue() != null &&Q3.getValue() != null &&Q4.getValue() != null && Final.getValue() != null ){
        for(ChoiceBox choice: choiceList){
            if(choice.getValue().equals("A")){
                finalGrade += 8;
            }else if(choice.getValue().equals("B")){
                finalGrade += 6;
            }else if(choice.getValue().equals("C")){
                finalGrade += 4;
            }else if(choice.getValue().equals("D")){
                finalGrade += 2;
            }
        }
            if(Final.getValue().equals("A")){
                finalGrade += 4;
            }else if(Final.getValue().equals("B")){
                finalGrade += 3;
            }else if(Final.getValue().equals("C")){
                finalGrade += 2;
            }else if(Final.getValue().equals("D")) {
                finalGrade += 1;
            }
            finalGrade /= 9;

            if(finalGrade >= 3.5){
                finalLetter = "A";
            }else if(finalGrade >= 2.5){
                finalLetter = "B";
            }else if(finalGrade >= 1.5){
                finalLetter = "C";
            }else if(finalGrade >= 0.5){
                finalLetter = "D";
            }else{
                finalLetter = "E";
            }
            display.setText("Your final grade is " + finalLetter);
        }else{
            display.setText("Error: Select a grade for each box!");
        }
    }
}