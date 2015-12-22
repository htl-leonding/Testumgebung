package at.htl.remotecontrol.packets;

import java.io.Serializable;

/**
 * @timeline Text
 * 31.10.2015: MET 003  Klasse erstellt
 */
public class ResponsePacket implements Serializable {

    private boolean value;

    public ResponsePacket(boolean value) {
        this.value = value;
    }

    //region Getter and Setter
    public boolean isValue() {
        return value;
    }
    //endregion

}
