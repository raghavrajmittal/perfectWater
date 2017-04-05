package model;

import java.io.Serializable;

/**
 * Enum that represents the water condition
 */
public enum WaterCondition implements Serializable {
    WASTE("Waste"),
    TREATABLECLEAR("Treatable-Clear"),
    TREATABLEMUDDY("Treatable-Muddy"),
    POTABLE("Potable");

    private String waterCondition;

    /**
     * constructor for WaterCondition, makes WaterCondition object enum
     * @param wc String that represents water condition
     */

    WaterCondition(String wc){
        waterCondition = wc;
    }

    //toString Method
    public String toString() {
        return waterCondition;
    }

}
