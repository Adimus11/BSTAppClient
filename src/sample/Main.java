package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Main class that creates JavaFX Application
 */
public class Main extends Application {
    public Socket client;
    public PrintWriter output;
    public BufferedReader input;
    public TextArea logArea = new TextArea();
    public TextArea treeArea = new TextArea();
    public String actualTree = "I";
    public String title = "BTSAppClient";

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        root.setTop(new InputBox(this));

        logArea.setMinWidth(200.0);
        logArea.setMaxWidth(200.0);
        logArea.setMinHeight(300.0);
        logArea.setMaxHeight(300.0);
        logArea.setEditable(false);

        root.setLeft(logArea);
        root.setBottom(new TreeResetButton(this));


        treeArea.setEditable(false);

        root.setRight(treeArea);


        primaryStage.setTitle(title);
        primaryStage.setScene(new Scene(root, 600, 450));
        primaryStage.show();

        connectToServer();
    }

    public void connectToServer() {
        try {
            this.client = new Socket("127.0.0.1", 2137);
            output = new PrintWriter(client.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            Thread t = new Thread(new ReceiverFromServer(this));
            t.setDaemon(true);
            t.start();
            logArea.appendText("Połączono z serwerem.\n");

        } catch (Exception e) {
            logArea.appendText("Nie można ustanowić połączenia z serwerem \n");
            logArea.appendText("Zresetuj aplikację aby spróbować ponownie \n");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
