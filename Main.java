import com.google.gson.*;
import gson_objects.StoryBasicGson;

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
        Main main = new Main();
        //main.seeGoogleExample();
        main.execute();

    }

    private void execute() {

    }


    private void seeGoogleExample(){
        Gson gson = new Gson();
        Collection collection = new ArrayList();
        collection.add("hello");
        collection.add(5);
        collection.add(new Event("GREETINGS", "guest"));
        String json = gson.toJson(collection);
        System.out.println("Using Gson.toJson() on a raw collection: " + json);
        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(json).getAsJsonArray();
        String message = gson.fromJson(array.get(0), String.class);
        int number = gson.fromJson(array.get(1), int.class);
        Event event = gson.fromJson(array.get(2), Event.class);
        System.out.printf("Using Gson.fromJson() to get: %s, %d, %s", message, number, event);
    }


    static class Event {
        private String name;
        private String source;
        private Event(String name, String source) {
            this.name = name;
            this.source = source;
        }
        @Override
        public String toString() {
            return String.format("(name=%s, source=%s)", name, source);
        }
    }
}
