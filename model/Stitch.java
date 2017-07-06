package model;


import gson_objects.*;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Representation of a stitch of a story.
 *
 * Created by obrusvit on 19.2.17.
 */
public class Stitch implements Serializable{

    /**
     * Name of the Stitch. First 16 characters of the "text" in camel syntax.
     *
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

    private ArrayList<IfCondition> ifConditions = new ArrayList<>();
    private ArrayList<NotIfCondition> notIfConditions = new ArrayList<>();



    /**
     * "Name" of the Stitch which is a seamless (not an option) continuation of the "text".
     */
    private Divert divertName;

    /**
     * If runOn is initialized and set to true,
     * then it means this Stitch is diverted.
     */
    private RunOn runOn;

    /**
     * Information about whether actual Stitch add flags to the story.
     * For example, a Stitch can grant the Story:
     *   a "visited this Stitch" token,
     *   a "picked a sword" token,
     *   gaining "bravery + 1"
     *   etc.
     *
     */
    private ArrayList<FlagName> flagNames;

    private PageLabel pageLabel;
    private PageNum pageName;

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

    public ArrayList<IfCondition> getIfConditions() {
        return ifConditions;
    }

    public void setIfConditions(ArrayList<IfCondition> ifConditions) {
        this.ifConditions = ifConditions;
    }

    public ArrayList<NotIfCondition> getNotIfConditions() {
        return notIfConditions;
    }

    public void setNotIfConditions(ArrayList<NotIfCondition> notIfConditions) {
        this.notIfConditions = notIfConditions;
    }

    public Divert getDivertName() {
        return divertName;
    }

    public void setDivertName(Divert divertName) {
        this.divertName = divertName;
    }


    public ArrayList<FlagName> getFlagNames() {
        return flagNames;
    }

    public void setFlagNames(ArrayList<FlagName> flagNames) {
        this.flagNames = flagNames;
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
                ", ifConditions=" + ifConditions +
                ", notIfConditions=" + notIfConditions +
                ", divertName=" + divertName +
                ", runOn=" + runOn +
                ", flagNames=" + flagNames +
                ", pageLabel=" + pageLabel +
                ", pageName=" + pageName +
                '}';
    }
}

