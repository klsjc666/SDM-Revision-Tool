package org.SDM.common.mybatis.model;

import java.util.List;

public class SaveModel<T> {

    private List<T> adds;

    private List<T> edits;

    private List<T> dels;

    public List<T> getAdds() {
        return adds;
    }

    public void setAdds(List<T> adds) {
        this.adds = adds;
    }

    public List<T> getEdits() {
        return edits;
    }

    public void setEdits(List<T> edits) {
        this.edits = edits;
    }

    public List<T> getDels() {
        return dels;
    }

    public void setDels(List<T> dels) {
        this.dels = dels;
    }
}
