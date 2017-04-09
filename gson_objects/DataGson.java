package gson_objects;

import java.io.Serializable;

/**
 *
 * Created by obrusvit on 18.2.17.
 */
public class DataGson implements Serializable{
    private boolean optionMirroring;
    private String initial;
    private boolean allowCheckpoints;

    //stitches are parsed separately

    public class EditorDataGson implements Serializable{
        String libraryVisible;
        int textSize;
        String authorName;
        String playPoint;

        public String getLibraryVisible() {
            return libraryVisible;
        }

        public int getTextSize() {
            return textSize;
        }

        public String getAuthorName() {
            return authorName;
        }

        public String getPlayPoint() {
            return playPoint;
        }
    }

    private EditorDataGson editorData;

    public boolean isOptionMirroring() {
        return optionMirroring;
    }

    public String getInitial() {
        return initial;
    }

    public boolean isAllowCheckpoints() {
        return allowCheckpoints;
    }

    public EditorDataGson getEditorData() {
        return editorData;
    }
}
