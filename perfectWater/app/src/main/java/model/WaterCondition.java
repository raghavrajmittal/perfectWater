package model;

import java.io.Serializable;

/**
 * Created by deepapillalamarri on 3/7/17.
 */

public enum WaterCondition implements Serializable {
    WASTE("Waste"),
    TREATABLECLEAR("Treatable-Clear"),
    TREATABLEMUDDY("Treatable-Muddy"),
    POTABLE("Potable");

    private String waterCondition;

    WaterCondition(String wc){
        waterCondition = wc;
    }

    //toString Method
    public String toString() {
        return waterCondition;
    }

}
