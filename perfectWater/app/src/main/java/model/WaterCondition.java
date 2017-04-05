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

    /**
     * constructor for WaterCondition, makes WaterCondition object enum
     * @param wc String of watercondition
     */

    WaterCondition(String wc){
        waterCondition = wc;
    }

    //toString Method
    public String toString() {
        return waterCondition;
    }

}
