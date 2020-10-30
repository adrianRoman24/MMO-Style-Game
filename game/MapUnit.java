package game;

import java.util.ArrayList;

public class MapUnit {
    /**type of the unit map.*/
    private char type;
    /**.*/
    private String landType;
    /**Indexes of heroes who are currently on this land.*/
    private ArrayList<Integer> heroesIndex = new ArrayList<>();

    /** @return .*/
    public String getLandType() {
        return landType;
    }

    /**@param type1 is param.*/
    public MapUnit(final char type1) {
        this.type = type1;
        switch (type) {
            case 'L':
                landType = "Land";
                break;
            case 'V':
                landType = "Volcanic";
                break;
            case 'D':
                landType = "Desert";
                break;
            case 'W':
                landType = "Woods";
                break;
            default:
                break;
        }
    }

    /** @return .*/
    public char getType() {
        return type;
    }

    /** @return .*/
    public ArrayList<Integer> getHeroesIndex() {
        return heroesIndex;
    }
}
