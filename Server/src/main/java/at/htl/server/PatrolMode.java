package at.htl.server;

import at.htl.common.io.FileUtils;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.apache.logging.log4j.Level;


/**
 * @timeline Text
 * 10.03.2016: PON 060  Patrol Mode: Switcht alle Schüler durch
 * 14.04.2016: PHI 050  fixed bug
 */
public class PatrolMode extends Thread {

    volatile boolean running = false;
    private ListView<Button> lv;
    private int actualPos = 0;

    public void setLv(ListView<Button> lv) {
        this.lv = lv;
    }

    public void stopIt() {
        running = false;
    }

    public void run() {
        running = true;
        while (running) {

            try {
                Platform.runLater(() -> {
                    lv.getSelectionModel().select(actualPos);
                });

                Thread.sleep(5000L);

                if(actualPos >= lv.getItems().size() - 1) {
                    actualPos = 0;
                } else {
                    actualPos++;
                }
            } catch (Exception e) {
                FileUtils.log(Level.ERROR, e.getMessage());
            }

        }

    }
}