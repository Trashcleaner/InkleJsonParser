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

        /*StoryJsonParser parser = new StoryJsonParser();
        Story story = parser.parseStory(ConstantTestJsons.jsonMusgrave);

        story.printTheWholeStory();*/
        new Main().execute();

    }

    private void execute() {

        //String test = "{hello:yes|no}";
        String test = "{hello:yes}";

        if(test.contains("{")){
            String s = test.substring(test.indexOf("{") + 1, test.indexOf("}"));
            String[] parts = s.split(":",2);
            String flag = parts[0];

            String[] textOptions = parts[1].split("\\|",2);
            String chosenTextOption;
            if(textOptions.length == 2) {
                chosenTextOption = test.contains("hello") ? textOptions[0] : textOptions[1];
            }else{
                chosenTextOption = test.contains("hello") ? textOptions[0] : "";
            }

            String finalS = test.replace("{"+s+"}", chosenTextOption);
            System.out.println(finalS);
        }
    }


}
