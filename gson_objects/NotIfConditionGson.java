package gson_objects;

/**
 * Created by obrusvit on 8.4.17.
 */
public class NotIfConditionGson {
    String notIfCondition;

    public void setNotIfCondition(String notIfCondition) {
        this.notIfCondition = notIfCondition;
    }

    public String getNotIfCondition() {
        return notIfCondition;
    }

    @Override
    public String toString() {
        return "NotIfConditionGson{" +
                "notIfCondition='" + notIfCondition + '\'' +
                '}';
    }
}
