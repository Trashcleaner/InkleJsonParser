package gson_objects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by obrusvit on 18.2.17.
 */
public class Option implements Serializable{
    private String linkPath;
    private String option;
    private ArrayList<IfCondition> ifConditions;
    private ArrayList<NotIfCondition> notIfConditions;

    public void setLinkPath(String linkPath) {
        this.linkPath = linkPath;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setIfConditions(ArrayList<IfCondition> ifConditions) {
        this.ifConditions = ifConditions;
    }

    public void setNotIfConditions(ArrayList<NotIfCondition> notIfConditions) {
        this.notIfConditions = notIfConditions;
    }

    public String getLinkPath() {
        return linkPath;
    }

    public String getOption() {
        return option;
    }

    public ArrayList<IfCondition> getIfConditions() {
        return ifConditions;
    }

    public ArrayList<NotIfCondition> getNotIfConditions() {
        return notIfConditions;
    }

    @Override
    public String toString() {
        return "Option{" +
                "linkPath='" + linkPath + '\'' +
                ", option='" + option + '\'' +
                ", ifConditions=" + ifConditions +
                ", notIfConditions=" + notIfConditions +
                '}';
        //return "Option is \""+option+ "\" and linkPath is " +linkPath;
    }
}

