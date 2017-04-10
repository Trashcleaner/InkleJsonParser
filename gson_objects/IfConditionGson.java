package gson_objects;

import java.io.Serializable;

/**
 * Created by obrusvit on 8.4.17.
 */
public class IfConditionGson implements Serializable{
    String ifCondition;

    public void setIfCondition(String ifCondition) {
        this.ifCondition = ifCondition;
    }

    public String getIfCondition() {
        return ifCondition;
    }

    @Override
    public String toString() {
        return "IfConditionGson{" +
                "ifCondition='" + ifCondition + '\'' +
                '}';
    }
}
