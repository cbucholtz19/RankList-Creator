package cjbb5franklistcreator;

import java.io.Serializable;


public class Item implements Serializable {

    private String score;
    private String[] fieldData;
    
    public Item(String score, String[] fieldData) {
        this.score = score;
        this.fieldData = fieldData;
    }
    
    public String getScore() {
        return score;
    }

    public String getFieldData(int index) {
        return fieldData[index];
    }
}
