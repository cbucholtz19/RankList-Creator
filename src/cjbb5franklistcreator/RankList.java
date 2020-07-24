package cjbb5franklistcreator;

import java.io.Serializable;
import java.util.ArrayList;

public class RankList implements Serializable {
    private String name;
    private final ScoreType SCORE_TYPE;
    private final String[] FIELDS;
    private ArrayList<Item> items;

    RankList(String name, ScoreType scoreType, String[] fields) {
        this.name = name;
        this.SCORE_TYPE = scoreType;
        this.FIELDS = fields;
        items = new ArrayList<>();
    }
    
    public void addItem(Item item) {
        int i=0;
        while (true) {
            if (i == items.size()) {
                items.add(item);
                return;
            }
            else if (compareScores(item.getScore(), items.get(i).getScore())) {
                items.add(i, item);
                return;
            }
            else {
                i = i+1;
            }
        }
    }
    
    //Returns true if x >= y
    private boolean compareScores(String x, String y) {
        double xVal = getValue(x);
        double yVal = getValue(y);
        
        return (xVal >= yVal);
    }
    
    //This method converts all ranks into numerical values to be compared
    private double getValue(String s) {
        
        //Tier List and Grading Values
        if (s.equals("S"))
            return 10.0;
        else if (s.equals("A+"))
            return 9.3;
        else if (s.equals("A"))
            return 9.2;
        else if (s.equals("A-"))
            return 9.1;
        else if (s.equals("B+"))
            return 8.3;
        else if (s.equals("B"))
            return 8.2;
        else if (s.equals("B-"))
            return 8.1;
        else if (s.equals("C+"))
            return 7.3;
        else if (s.equals("C"))
            return 7.2;
        else if (s.equals("C-"))
            return 7.1;
        else if (s.equals("D+"))
            return 6.3;
        else if (s.equals("D"))
            return 6.2;
        else if (s.equals("D-"))
            return 6.1;
        else if (s.equals("E"))
            return 5.0;
        else if (s.equals("F"))
            return 4.0;
        
        //Ten Point Scale Values
        else if (s.equals("10"))
            return 10.0;
        else if (s.equals("Strong 9"))
            return 9.3;
        else if (s.equals("Decent 9"))
            return 9.2;
        else if (s.equals("Light 9"))
            return 9.1;
        else if (s.equals("9"))
            return 9.0;
        else if (s.equals("Strong 8"))
            return 8.3;
        else if (s.equals("Decent 8"))
            return 8.2;
        else if (s.equals("Light 8"))
            return 8.1;
        else if (s.equals("8"))
            return 8.0;
        else if (s.equals("Strong 7"))
            return 7.3;
        else if (s.equals("Decent 7"))
            return 7.2;
        else if (s.equals("Light 7"))
            return 7.1;
        else if (s.equals("7"))
            return 7.0;
        else if (s.equals("Strong 6"))
            return 6.3;
        else if (s.equals("Decent 6"))
            return 6.2;
        else if (s.equals("Light 6"))
            return 6.1;
        else if (s.equals("6"))
            return 6.0;
        else if (s.equals("Strong 5"))
            return 5.3;
        else if (s.equals("Decent 5"))
            return 5.2;
        else if (s.equals("Light 5"))
            return 5.1;
        else if (s.equals("5"))
            return 5.0;
        else if (s.equals("Strong 4"))
            return 4.3;
        else if (s.equals("Decent 4"))
            return 4.2;
        else if (s.equals("Light 4"))
            return 4.1;
        else if (s.equals("4"))
            return 4.0;
        else if (s.equals("Strong 3"))
            return 3.3;
        else if (s.equals("Decent 3"))
            return 3.2;
        else if (s.equals("Light 3"))
            return 3.1;
        else if (s.equals("3"))
            return 3.0;
        else if (s.equals("Strong 2"))
            return 2.3;
        else if (s.equals("Decent 2"))
            return 2.2;
        else if (s.equals("Light 2"))
            return 2.1;
        else if (s.equals("2"))
            return 2.0;
        else if (s.equals("Strong 1"))
            return 1.3;
        else if (s.equals("Decent 1"))
            return 1.2;
        else if (s.equals("Light 1"))
            return 1.1;
        else if (s.equals("1"))
            return 1.0;
        else if (s.equals("0"))
            return 0.0;
        
        return 0.0;
    }
    
    public ArrayList<Item> getItems() {
        return items;
    }
    
    public String getName() {
        return name;
    }

    public ScoreType getScoreType() {
        return SCORE_TYPE;
    }
    
    public String[] getFields() {
        return FIELDS;
    }
}