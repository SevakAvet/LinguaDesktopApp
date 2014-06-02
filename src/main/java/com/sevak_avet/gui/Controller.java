package com.sevak_avet.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ToggleGroup genderToggleGroup;
    @FXML
    private RadioButton genderMale;
    @FXML
    private RadioButton genderFemale;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ChoiceBox<String> department;
    @FXML
    private ChoiceBox<String> levelEng;
    @FXML
    private ChoiceBox<String> levelRus;
    @FXML
    private VBox languagesVBox;
    @FXML
    private Button addRecord;
    @FXML
    private Button search;
    @FXML
    private TextArea engTextArea;
    @FXML
    private TextArea rusTextArea;
    @FXML
    private ListView<String> result;

    @FXML
    private TextField nameField;

    private int langControllCount = 1;

    private static final ObservableList<String> occupationList = FXCollections.observableArrayList("Гуманитарий", "ТЕХНАРЬ!", "не знаю");
    private static final ObservableList<String> languagesList = FXCollections.observableArrayList();
    private static final ObservableList<String> levelList = FXCollections.observableArrayList("Элементарное владение", "Самостоятельное владение", "Свободное владение");

    static {
        try (BufferedReader reader = new BufferedReader(new FileReader("languages"))) {
            String lang;
            while ((lang = reader.readLine()) != null) {
                languagesList.add(lang);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderMale.setToggleGroup(genderToggleGroup);
        genderFemale.setToggleGroup(genderToggleGroup);
        genderMale.setSelected(true);

        datePicker.setOnAction(e -> System.out.println(datePicker.getValue()));
        genderToggleGroup.selectedToggleProperty().addListener(e -> System.out.println(genderToggleGroup.getSelectedToggle()));

        department.setItems(occupationList);

        levelEng.setItems(levelList);
        levelRus.setItems(levelList);

        search.setOnAction(e -> {
            StringBuilder sb = new StringBuilder();
            if(!nameField.getText().replace(" ", "").isEmpty()) {
                sb.append("ans.name = ").append(nameField.getText());
            }

            if(!datePicker.getPromptText().isEmpty()) {
                sb.append("and ans.birthday = ").append(datePicker.getPromptText());
            }
        });

        addRecord.setOnAction(e -> {

        });
    }

    private void addLanguageControll() {
        HBox hBox = new HBox();
        hBox.setPrefHeight(42.0);
        hBox.setPrefWidth(143.0);

        VBox vBoxLang = new VBox();
        vBoxLang.setPrefHeight(42.0);
        vBoxLang.setPrefWidth(281.0);
        vBoxLang.setPadding(new Insets(5, 5, 0, 0));

        VBox vBoxLevel = new VBox();
        vBoxLevel.setPrefHeight(42.0);
        vBoxLevel.setPrefWidth(281.0);
        vBoxLevel.setPadding(new Insets(5, 0, 0, 5));

        ChoiceBox<String> langChoiceBox = new ChoiceBox<>();
        langChoiceBox.setPrefHeight(25.0);
        langChoiceBox.setPrefWidth(274.0);
        vBoxLang.getChildren().add(langChoiceBox);
        langChoiceBox.setItems(languagesList);

        ChoiceBox<String> levelChoiceBox = new ChoiceBox<>();
        levelChoiceBox.setPrefHeight(25.0);
        levelChoiceBox.setPrefWidth(215.0);
        vBoxLevel.getChildren().add(levelChoiceBox);
        levelChoiceBox.setItems(levelList);

        hBox.getChildren().addAll(vBoxLang, vBoxLevel);
        languagesVBox.getChildren().add(languagesVBox.getChildren().size() - 1, hBox);
    }
}
