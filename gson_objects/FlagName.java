package gson_objects;

import java.io.Serializable;

/**
 * Created by obrusvit on 8.4.17.
 */
public class FlagName implements Serializable{

    String flagName;

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }

    public String getFlagName() {
        return flagName;
    }

    @Override
    public String toString() {
        return "FlagName{" +
                "flagName='" + flagName + '\'' +
                '}';
    }
}
