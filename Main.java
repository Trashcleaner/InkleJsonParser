import com.google.gson.*;
import com.google.gson.internal.LinkedTreeMap;
import gson_objects.StoryBasicGson;
import model.Stitch;
import model.Story;

import java.util.*;

/**
 * Created by obrusvit on 17.2.17.
 */
public class Main {

    /**
     * Basic data about story.
     * Does not contain Stitches.
     */
    private static StoryBasicGson story;


    public static void main(String[] args) {

        StoryJsonParser parser = new StoryJsonParser();
        Story story = parser.parseStory(ConstantTestJsons.jsonMusgrave);

        story.printTheWholeStory();

    }

    
}
