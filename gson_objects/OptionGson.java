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

    public void setLinkPath(String linkPath) {
        this.linkPath = linkPath;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setIfConditions(ArrayList<IfConditionGson> ifConditions) {
        this.ifConditions = ifConditions;
    }

    public void setNotIfConditions(ArrayList<NotIfConditionGson> notIfConditions) {
        this.notIfConditions = notIfConditions;
    }

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

    @Override
    public String toString() {
        /*return "OptionGson{" +
                "linkPath='" + linkPath + '\'' +
                ", option='" + option + '\'' +
                ", ifConditions=" + ifConditions +
                ", notIfConditions=" + notIfConditions +
                '}';*/
        return "Option is \""+option+ "\" and linkPath is " +linkPath;
    }
}

