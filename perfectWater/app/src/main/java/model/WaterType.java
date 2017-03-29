package model;

import java.io.Serializable;

/**
 * Created by deepapillalamarri on 3/7/17.
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
     * @param wt String of watertype
     */

    WaterType(String wt){
        waterType = wt;
    }

    //toString Method
    public String toString(){
        return waterType;
    }
}
