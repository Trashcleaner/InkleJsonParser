package gson_objects;

import java.io.Serializable;

/**
 * Created by obrusvit on 15.2.17.
 */

public class StoryBasicGson implements Serializable{
    private String title;
    private String created_at;
    private String updated_at;
    private String url_key;

    private DataGson data;


    public String getTitle() {
        return title;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getUrl_key() {
        return url_key;
    }

    public String getDataInitial() {
        return data.getInitial();
    }

    public DataGson getData() {
        return data;
    }
}
