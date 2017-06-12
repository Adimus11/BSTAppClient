package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Created by Michał Treter on 12.06.2017.
 */
public class TreeResetButton extends Button{
    Main mainAppReference;

    public TreeResetButton(Main app){
        super("Resetuj drzewo!");

        this.setMinWidth(600.0);
        mainAppReference = app;

        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                mainAppReference.logArea.appendText("Aktualne drzewo zostało wyczyszczone!" + "\n");
                mainAppReference.output.println(mainAppReference.actualTree + ":R:0");

            }
        });
    }
}
