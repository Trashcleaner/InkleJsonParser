package gson_objects;

import java.io.Serializable;

/**
 * Created by obrusvit on 8.4.17.
 */
public class PageNumGson implements Serializable{

    int pageNum;


    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageNum() {
        return pageNum;
    }

    @Override
    public String toString() {
        return "PageNumGson{" +
                "pageNum=" + pageNum +
                '}';
    }
}
