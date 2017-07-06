import com.google.gson.*;
import com.google.gson.internal.LinkedTreeMap;
import model.Stitch;
import model.Story;


/**
 * StoryJsonParser takes care of parsing json.wwe
 * Method parseStory returns the Story to be used by BlindStory (VIEW)
 * <p>
 * Created by obrusvit on 19.2.17.
 */
public class StoryJsonParser {

    public StoryJsonParser() {
    }


    /**
     * The most important method.
     * Parses .json into the MODEL Story
     * @param json json String to parse
     * @param story Story object to be loaded
     * @return parsed and ready Story
     */
    public Story parseStory(String json, Story story) {
        loadStoryObjectWithData(story, json, new Gson());
        return story;
    }

    private void loadStoryObjectWithData(Story storyToLoad, String json, Gson gson) {
        /*
        Object o is a LinkedTreeMap so I need to cast it thrice to get LinkedTreeMap of stitches.
         */
        Object o = gson.fromJson(json, Object.class);
        LinkedTreeMap stitchesMap =
                (LinkedTreeMap)
                        (((LinkedTreeMap)
                                ((LinkedTreeMap) o).get("data")).get("stitches"));
        Object[] keys = stitchesMap.keySet().toArray();

        /*
        Preparation of Gson with specialization to InkleStitches
         */
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Stitch.class, new StitchTypeAdapter());
        Gson stitchGson = gsonBuilder.create();

        for (Object key : keys) {
            //TypeAdapter was prepared to consume .json with one actual stitch.
            //So it needs to be in correct .json format with just one stitch
            //This is why I add the curly braces
            String jsonStitchToParse = "{" + key.toString() + ":" + gson.toJson(stitchesMap.get(key)) + "}";
            Stitch stitchToAdd = stitchGson.fromJson(jsonStitchToParse, Stitch.class);
            storyToLoad.addToStitchHashMap(key.toString(), stitchToAdd);
        }

    }
}
