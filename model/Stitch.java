package model;


import gson_objects.OptionGson;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Representation of a stitch of a story.
 * Created by obrusvit on 19.2.17.
 */
public class Stitch implements Serializable{

    private String name;

    private String text;

    private ArrayList<OptionGson> options = new ArrayList<>();

    private boolean hasDivert = false;

    private String divertName;

    //TODO: add if and notIf conditions with markers
    //TODO: add pageNum implementation

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

    public String getText() {
        return text;
    }

    public ArrayList<OptionGson> getOptions() {
        return options;
    }

    public boolean hasDivert() {
        return hasDivert;
    }

    public String getDivertName() {
        return divertName;
    }

    @Override
    public String toString() {
        return "Stitch{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", options=" + options +
                ", hasDivert=" + hasDivert +
                ", divertName='" + divertName + '\'' +
                '}';
    }
}

