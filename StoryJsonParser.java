import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.internal.LinkedTreeMap;
import gson_objects.DivertGson;
import gson_objects.OptionGson;
import gson_objects.StoryBasicGson;
import model.Stitch;
import model.Story;

import java.util.ArrayList;
import java.util.Collection;

/**
        * StoryJsonParser takes care of parsing json.wwe
        * Method parseStory returns the Story to be used by BlindStory (VIEW)
        *
        * Created by obrusvit on 19.2.17.
        */
public class StoryJsonParser {

    private GsonBuilder gsonBuilder;
    private Gson gson;
    private JsonParser parser;


    public StoryJsonParser() {

        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        parser = new JsonParser();

    }

    /**
     * The most important method.
     * Parses .json into the MODEL Story
     * @param json
     * @return created MODEL Story
     */
    public Story parseStory(String json) {
        Story story = new Story();
        loadStoryObjectWithData(story, json);
        return story;
    }

    private void loadStoryObjectWithData(Story storyToLoad, String json){
        StoryBasicGson storyBasics = gson.fromJson(json, StoryBasicGson.class);
        storyToLoad.setStoryBasicData(storyBasics);

        Object o = gson.fromJson(json, Object.class);
        /*
        The following line seems like a big ****
        Object o is a LinkedTreeMap so I need to cast it thrice to get LinkedTreeMap of stitches.
         */
        LinkedTreeMap stitchesMap = (LinkedTreeMap)(((LinkedTreeMap) ((LinkedTreeMap) o).get("data")).get("stitches"));

        goThroughContents(stitchesMap, storyToLoad);


    }

    private void goThroughContents(LinkedTreeMap stitchesMap, Story storyToLoad) {
        Object[] stitchesNames = (stitchesMap.keySet().toArray());
        int max = stitchesMap.size();

        for (int i = 0; i < max; i++) {
            String nameOfTheStitch = (String)stitchesNames[i];
            LinkedTreeMap stitch = (LinkedTreeMap) stitchesMap.get(nameOfTheStitch);
            Collection content = (Collection)stitch.get("content");
            String json = gson.toJson(content);
            JsonArray array = parser.parse(json).getAsJsonArray();
            ArrayList<OptionGson> optionsToAddedStitch = new ArrayList<>();
            boolean isDiverted = false;
            String divertName = null;
            for (int j = 1; j < array.size(); j++) {
                //TADY BUDE VYUZIT TYPE ADAPTER
                /*String s = array.get(j).toString();
                if(s.contains("\"linkPath\":") && s.contains("\"option\":")){
                    OptionGson option = gson.fromJson(s, OptionGson.class);
                    optionsToAddedStitch.add(option);
                }
                if(s.contains("{\"divert\":")){
                    isDiverted = true;
                    DivertGson divert = gson.fromJson(s, DivertGson.class);
                    divertName = divert.getDivert();

                }*/
            }
            Stitch toAdd
                    = new Stitch();

            storyToLoad.addToStitchHashMap(nameOfTheStitch, toAdd);
        }
        storyToLoad.setActualStitch(storyToLoad.getStoryBasicData().getDataInitial());

    }


}
