package gson_objects;

import java.io.Serializable;

/**
 * Created by obrusvit on 18.2.17.
 */
public class Divert implements Serializable{
    String divert;

    public void setDivert(String divert) {
        this.divert = divert;
    }

    public String getDivert() {
        return divert;
    }

    @Override
    public String toString() {
        return "Divert{" +
                "divert='" + divert + '\'' +
                '}';
    }
}
