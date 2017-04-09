package model;


import gson_objects.*;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Representation of a stitch of a story.
 * Created by obrusvit on 19.2.17.
 */
public class Stitch implements Serializable{

    /**
     * Name of the Stitch. First 16 characters of the "text" in camel syntax.
     */
    private String name;

    /**
     * Actual text content of the Stitch. e.g. part of the story.
     */
    private String text;

    /**
     * List of options, one to be chosen to continue the story.
     */
    private ArrayList<OptionGson> options = new ArrayList<>();

    private IfConditionGson ifCondition;
    private NotIfConditionGson notIfCondition;

    /**
     * "Name" of the Stitch which is a seamless (not an option) continuation of the "text".
     */
    private String divertName;
    private boolean hasDivert = false;

    /**
     * Information about whether actual Stitch add flag to the story.
     * For example, a Stitch can grant the Story:
     *   a "visited this Stitch" token,
     *   a "picked a sword" token,
     *   gaining "bravery + 1"
     *   etc.
     *
     */
    private FlagNameGson flagName;

    private PageLabelGson pageLabel;
    private PageNameGson pageName;
    private RunOnGson runOn;

    public Stitch(){

    }


    public Stitch(String name, String text, ArrayList<OptionGson> options) {
        this(name, text, options, false, null);
    }

    /**
     * Use when stitch is diverted into more texts.
     * @param name
     * @param text
     * @param options
     * @param hasDivert
     * @param divertName
     */
    public Stitch(String name, String text, ArrayList<OptionGson> options, boolean hasDivert, String divertName) {
        this.name = name;
        this.text = text;
        this.options = options;
        this.hasDivert = hasDivert;
        this.divertName = divertName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<OptionGson> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<OptionGson> options) {
        this.options = options;
    }

    public IfConditionGson getIfCondition() {
        return ifCondition;
    }

    public void setIfCondition(IfConditionGson ifCondition) {
        this.ifCondition = ifCondition;
    }

    public NotIfConditionGson getNotIfCondition() {
        return notIfCondition;
    }

    public void setNotIfCondition(NotIfConditionGson notIfCondition) {
        this.notIfCondition = notIfCondition;
    }

    public String getDivertName() {
        return divertName;
    }

    public void setDivertName(String divertName) {
        this.divertName = divertName;
    }

    public boolean hasDivert() {
        return hasDivert;
    }

    public void setHasDivert(boolean hasDivert) {
        this.hasDivert = hasDivert;
    }

    public FlagNameGson getFlagName() {
        return flagName;
    }

    public void setFlagName(FlagNameGson flagName) {
        this.flagName = flagName;
    }

    public PageLabelGson getPageLabel() {
        return pageLabel;
    }

    public void setPageLabel(PageLabelGson pageLabel) {
        this.pageLabel = pageLabel;
    }

    public PageNameGson getPageName() {
        return pageName;
    }

    public void setPageName(PageNameGson pageName) {
        this.pageName = pageName;
    }

    public RunOnGson getRunOn() {
        return runOn;
    }

    public void setRunOn(RunOnGson runOn) {
        this.runOn = runOn;
    }


    @Override
    public String toString() {
        return "Stitch{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", options=" + options +
                ", ifCondition=" + ifCondition +
                ", notIfCondition=" + notIfCondition +
                ", divertName='" + divertName + '\'' +
                ", hasDivert=" + hasDivert +
                ", flagName=" + flagName +
                ", pageLabel=" + pageLabel +
                ", pageName=" + pageName +
                ", runOn=" + runOn +
                '}';
    }
}

