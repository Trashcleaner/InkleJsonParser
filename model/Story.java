package model;



import gson_objects.OptionGson;
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

    private HashMap<String, Stitch> stitchHashMap = new HashMap<>();
    private Stitch actualStitch;
    private StoryBasicGson storyBasicData;


    private List<Stitch> stitchDivertList = new ArrayList<>();
    private int actualDivert = 0;



    public void setActualStitch(String stitch) {

        this.actualStitch = stitchHashMap.get(stitch);

    }

    public void setActualStitch(Stitch stitch){

        this.actualStitch = stitch;

    }

    public void previousDivert(){
        if(actualDivert > 0) {
            setActualStitch(stitchDivertList.get(--actualDivert));
        }
    }

    public void nextDivert(){
        if(actualDivert < (stitchDivertList.size())) {
            setActualStitch(stitchDivertList.get(++actualDivert));
        }
    }

    public void loadDivertList(){
        Stitch firstStitch = actualStitch;
        while (actualStitch.hasDivert()){
            stitchDivertList.add(actualStitch);
            setActualStitch(actualStitch.getDivertName());
        }
        stitchDivertList.add(actualStitch); //last one which already has options
        setActualStitch(firstStitch);
    }

    public void cleanDivertList(){
        stitchDivertList.clear();
        actualDivert = 0;
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

    public boolean isActualStitchDiverted(){
        return getActualStitch().hasDivert();
    }

    public Stitch getDivertedPartOfActualStitch(){
        return stitchHashMap.get(getActualStitch().getDivertName());
    }

    public ArrayList<OptionGson> getActualStitchOption(){
        if(!isActualStitchDiverted()) {
            return getActualStitch().getOptions();
        }else{
            return null;
        }
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


}

