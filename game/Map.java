package game;

public final class Map {
    /**instance.*/
    private static Map instance = null;
    /**nr of instances for every unit.*/
    private static int mapUnitInstances = 0;
    /**actual map.*/
    private static MapUnit[][]mapUnit;

    /**@return .*/
    public MapUnit[][] getMapUnit() {
        return mapUnit;
    }

    /**setter that can be used only once.*/
    public void setMapUnit(final int rows, final int columns) {
        if (mapUnitInstances == 0) {
            mapUnitInstances++;
            mapUnit = new MapUnit[rows][columns];
        }
    }

    /**private constructor to prevent more instances.*/
    private Map() { }

    /**@return for instance.*/
    public static Map getInstance() {
        if (instance == null) {
            return new Map();
        }
        return instance;
    }
}
