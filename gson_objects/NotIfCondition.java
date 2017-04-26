package gson_objects;

import java.io.Serializable;

/**
 * Created by obrusvit on 8.4.17.
 */
public class NotIfCondition implements Serializable{
    String notIfCondition;

    public void setNotIfCondition(String notIfCondition) {
        this.notIfCondition = notIfCondition;
    }

    public String getNotIfCondition() {
        return notIfCondition;
    }

    @Override
    public String toString() {
        return "NotIfCondition{" +
                "notIfCondition='" + notIfCondition + '\'' +
                '}';
    }
}
