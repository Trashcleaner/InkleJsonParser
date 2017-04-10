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
    private ArrayList<Option> options = new ArrayList<>();

    private IfCondition ifCondition;
    private NotIfCondition notIfCondition;

    /**
     * "Name" of the Stitch which is a seamless (not an option) continuation of the "text".
     */
    private Divert divertName;
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
    private FlagName flagName;

    private PageLabel pageLabel;
    private PageNum pageName;
    private RunOn runOn;

    public Stitch(){

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

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }

    public IfCondition getIfCondition() {
        return ifCondition;
    }

    public void setIfCondition(IfCondition ifCondition) {
        this.ifCondition = ifCondition;
    }

    public NotIfCondition getNotIfCondition() {
        return notIfCondition;
    }

    public void setNotIfCondition(NotIfCondition notIfCondition) {
        this.notIfCondition = notIfCondition;
    }

    public Divert getDivertName() {
        return divertName;
    }

    public void setDivertName(Divert divertName) {
        this.divertName = divertName;
    }

    public boolean hasDivert() {
        return hasDivert;
    }

    public void setHasDivert(boolean hasDivert) {
        this.hasDivert = hasDivert;
    }

    public FlagName getFlagName() {
        return flagName;
    }

    public void setFlagName(FlagName flagName) {
        this.flagName = flagName;
    }

    public PageLabel getPageLabel() {
        return pageLabel;
    }

    public void setPageLabel(PageLabel pageLabel) {
        this.pageLabel = pageLabel;
    }

    public PageNum getPageName() {
        return pageName;
    }

    public void setPageName(PageNum pageName) {
        this.pageName = pageName;
    }

    public RunOn getRunOn() {
        return runOn;
    }

    public void setRunOn(RunOn runOn) {
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

