package sample;

import javafx.application.Platform;

import java.io.IOException;

/**
 * Created by Michał Treter on 11.06.2017.
 */
public class ReceiverFromServer implements Runnable {
    Main mainAppReference;

    public ReceiverFromServer(Main app) {
        mainAppReference = app;
    }

    /**
     *  Ovverriden method that will start thread
     */
    @Override
    public void run() {
        String receivedData;

        try {
            while (true) {
                while ((receivedData = mainAppReference.input.readLine()) != null) {

                    if (receivedData.charAt(0) == 'S') {
                        if (receivedData.charAt(1) == '1') {
                            Platform.runLater(() -> mainAppReference.logArea.appendText("Wartość znajduje sie w drzewie" + "\n") );

                        } else {
                            Platform.runLater(() -> mainAppReference.logArea.appendText("Wartość nie znajduje sie w drzewie" + "\n"));
                        }
                    } else {
                        String[] tree = receivedData.split("_");
                        String completedTree = "";

                        for(int i = 0; i < tree.length; i++){
                            completedTree += tree[i];
                            completedTree += "\n";
                        }

                        final String readyToPrint = completedTree;


                        Platform.runLater(() -> mainAppReference.treeArea.setText(readyToPrint));
                    }

                }
            }
        } catch (IOException e) {

        } catch (NullPointerException e) {
            System.out.println("out of xd");
        }
    }

}

