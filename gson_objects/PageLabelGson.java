package gson_objects;

import java.io.Serializable;

/**
 * Created by obrusvit on 8.4.17.
 */
public class PageLabelGson implements Serializable {

    String pageLabel;

    public void setPageLabel(String pageLabel) {
        this.pageLabel = pageLabel;
    }

    public String getPageLabel() {
        return pageLabel;
    }

    @Override
    public String toString() {
        return "PageLabelGson{" +
                "pageLabel='" + pageLabel + '\'' +
                '}';
    }
}
