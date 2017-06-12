package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by Michał Treter on 11.06.2017.
 */
public class InputBox extends VBox {
    Main mainAppReference;

    public InputBox(Main main) {
        mainAppReference = main;

        Label treeTypeSelected = new Label("Wybrany typ drzewa - Integer");
        treeTypeSelected.setMinWidth(600);
        treeTypeSelected.setAlignment(Pos.CENTER);

        HBox optionsPanel = new HBox();

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Integer",
                        "Double",
                        "String"
                );
        final ComboBox comboBox = new ComboBox(options);
        comboBox.getSelectionModel().selectFirst();
        comboBox.setMinWidth(450.0);

        Button selectType = new Button("Ustaw typ drzewa");
        selectType.setMinWidth(150.0);

        selectType.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                String treeType = comboBox.getValue().toString();


                if(treeType.equals("Integer")){
                    treeTypeSelected.setText("Wybrany typ drzewa - Integer");
                    mainAppReference.actualTree = "I";
                }
                else if(treeType.equals("Double")){
                    treeTypeSelected.setText("Wybrany typ drzewa - Double");
                    mainAppReference.actualTree = "D";
                }
                else if(treeType.equals("String")){
                    treeTypeSelected.setText("Wybrany typ drzewa - String");
                    mainAppReference.actualTree = "S";
                }

            }
        });

        optionsPanel.getChildren().addAll(comboBox, selectType);

        HBox addPanel = new HBox();

        TextField addInput = new TextField();
        addInput.setMinWidth(450.0);
        Button addButton = new Button("Dodaj!");
        addButton.setMinWidth(150.0);

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * Method that handle adding event
             * @param e ActionEvent parameter
             */
            @Override public void handle(ActionEvent e) {
                String value = addInput.getText();

                try {
                    if (value.length() > 0) {
                        if (mainAppReference.actualTree.equals("I")) {
                            int intValue = Integer.parseInt(value);
                            mainAppReference.logArea.appendText("Dodano: " + value + "\n");
                            addInput.setText("");

                            mainAppReference.output.println("I:A:" + value);
                        } else if (mainAppReference.actualTree.equals("D")) {
                            double doubleValue = Double.parseDouble(value);
                            mainAppReference.logArea.appendText("Dodano: " + value + "\n");
                            addInput.setText("");

                            mainAppReference.output.println("D:A:" + value);
                        } else if (mainAppReference.actualTree.equals("S")) {

                            mainAppReference.logArea.appendText("Dodano: " + value + "\n");
                            addInput.setText("");

                            mainAppReference.output.println("S:A:" + value);

                        }

                    } else {
                        mainAppReference.logArea.appendText("Brak podania wartości" + "\n");
                    }
                }
                catch (NumberFormatException ex){
                    addInput.setText("");
                    mainAppReference.logArea.appendText("Podano złą wartość" + "\n");
                }

            }
        });

        addPanel.getChildren().addAll(addInput, addButton);

        HBox searchPanel = new HBox();

        TextField searchInput = new TextField();
        searchInput.setMinWidth(450.0);
        Button searchButton = new Button("Wyszukaj!");
        searchButton.setMinWidth(150.0);

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                String value = searchInput.getText();

                try {

                    if (value.length() > 0) {
                        if (mainAppReference.actualTree.equals("I")) {
                            int intValue = Integer.parseInt(value);
                            mainAppReference.logArea.appendText("Wyszukiwanie: " + value + "\n");
                            searchInput.setText("");

                            mainAppReference.output.println("I:S:" + value);
                        } else if (mainAppReference.actualTree.equals("D")) {
                            double doubleValue = Double.parseDouble(value);
                            mainAppReference.logArea.appendText("Wyszukiwanie: " + value + "\n");
                            searchInput.setText("");

                            mainAppReference.output.println("D:S:" + value);
                        } else if (mainAppReference.actualTree.equals("S")) {

                            mainAppReference.logArea.appendText("Wyszukiwanie: " + value + "\n");
                            searchInput.setText("");

                            mainAppReference.output.println("S:S:" + value);

                        }

                    } else {
                        mainAppReference.logArea.appendText("Brak podania wartości" + "\n");
                    }
                }
                catch (NumberFormatException ex){
                    searchInput.setText("");
                    mainAppReference.logArea.appendText("Podano złą wartość" + "\n");
                }

            }
        });

        searchPanel.getChildren().addAll(searchInput, searchButton);

        HBox deletePanel = new HBox();

        TextField deleteInput = new TextField();
        deleteInput.setMinWidth(450.0);
        Button deleteButton = new Button("Usuń!");
        deleteButton.setMinWidth(150.0);

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                String value = deleteInput.getText();

                try {
                    if (value.length() > 0) {
                        if (mainAppReference.actualTree.equals("I")) {
                            int intValue = Integer.parseInt(value);
                            mainAppReference.logArea.appendText("Usuwanie: " + value + "\n");
                            deleteInput.setText("");

                            mainAppReference.output.println("I:D:" + value);
                        } else if (mainAppReference.actualTree.equals("D")) {
                            double doubleValue = Double.parseDouble(value);
                            mainAppReference.logArea.appendText("Usuwanie: " + value + "\n");
                            deleteInput.setText("");

                            mainAppReference.output.println("D:D:" + value);
                        } else if (mainAppReference.actualTree.equals("S")) {

                            mainAppReference.logArea.appendText("Usuwanie: " + value + "\n");
                            deleteInput.setText("");

                            mainAppReference.output.println("S:D:" + value);

                        }
                    } else {
                        mainAppReference.logArea.appendText("Brak podania wartości" + "\n");
                    }

                }
                catch (NumberFormatException ex){
                    deleteInput.setText("");
                    mainAppReference.logArea.appendText("Podano złą wartość" + "\n");
                }

            }
        });

        deletePanel.getChildren().addAll(deleteInput, deleteButton);

        this.getChildren().addAll(treeTypeSelected, optionsPanel, addPanel, deletePanel, searchPanel);



    }
}