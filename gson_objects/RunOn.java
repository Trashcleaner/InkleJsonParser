package gson_objects;

import java.io.Serializable;

/**
 * Created by obrusvit on 8.4.17.
 */
public class RunOn implements Serializable{

    boolean runOn;

    public void setRunOn(boolean runOn) {
        this.runOn = runOn;
    }

    public boolean isRunOn() {
        return runOn;
    }

    @Override
    public String toString() {
        return "RunOn{" +
                "runOn=" + runOn +
                '}';
    }
}
