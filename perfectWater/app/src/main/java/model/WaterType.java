package model;

import java.io.Serializable;

/**
 * Enum that represents the type of water
 */
public enum WaterType implements Serializable {
    BOTTLED("Bottled"),
    WELL("Well"),
    STREAM("Stream"),
    LAKE("Lake"),
    SPRING("Spring"),
    OCEAN("Ocean");

    private String waterType;

    /**
     * makes WaterType object
     * @param wt String of water type
     */

    WaterType(String wt){
        waterType = wt;
    }

    //toString Method
    public String toString(){
        return waterType;
    }
}
