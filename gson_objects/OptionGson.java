package gson_objects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by obrusvit on 18.2.17.
 */
public class OptionGson implements Serializable{
    private String linkPath;
    private String option;
    private ArrayList<IfConditionGson> ifConditions;
    private ArrayList<NotIfConditionGson> notIfConditions;


    public String getLinkPath() {
        return linkPath;
    }

    public String getOption() {
        return option;
    }

    public ArrayList<IfConditionGson> getIfConditions() {
        return ifConditions;
    }

    public ArrayList<NotIfConditionGson> getNotIfConditions() {
        return notIfConditions;
    }
}

