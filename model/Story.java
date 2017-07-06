package model;




import gson_objects.StoryBasicGson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * MODEL
 * Story class is a data representation of a JSON story.
 *
 * Created by obrusvit on 20.2.17.
 */
public class Story implements Serializable{

    /**
     * HashMap of all Stitches easily searchable.
     * KEYs are the names.
     * VALUEs are the POJO of the Stitches (class Stitch)
     */
    private HashMap<String, Stitch> stitchHashMap = new HashMap<>();

    /**
     * POJO containing all the very basic info.
     */
    private StoryBasicGson storyBasicData;


    /**
     * Stitch which is visible/read right now.
     * When .json is parsed for the first time,
     * it is set to initial value
     */
    private Stitch actualStitch;



    public void setActualStitch(String stitch) {
        this.actualStitch = stitchHashMap.get(stitch);
    }

    public void setActualStitch(Stitch stitch){
        this.actualStitch = stitch;
    }

    public void addToStitchHashMap(String key, Stitch value){
        stitchHashMap.put(key, value);
    }


    public void setStoryBasicData(StoryBasicGson storyBasicData) {
        this.storyBasicData = storyBasicData;
    }

    public Stitch getActualStitch(){
        return actualStitch;
    }

    public StoryBasicGson getStoryBasicData() {
        return storyBasicData;
    }

    public boolean isActualStitchDiverted() {
        return getActualStitch().getDivertName() != null;
    }




    public Stitch getStitchBasedOnKeyName(String keyName){
        return stitchHashMap.get(keyName);
    }


    public void printTheWholeStory(){
        System.out.println("Actual Stitch is: " + actualStitch);
        Collection<Stitch> values = stitchHashMap.values();
        for(Stitch stitch : values){
            System.out.println(stitch);
        }

    }



    @Override
    public String toString() {
        return "Story{" +
                "stitchHashMap=" + stitchHashMap +
                ", storyBasicData=" + storyBasicData +
                ", actualStitch=" + actualStitch +
                '}';
    }
}

