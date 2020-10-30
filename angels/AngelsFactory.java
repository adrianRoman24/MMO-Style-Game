package angels;

public class AngelsFactory {
    /**initiate instance with null.*/
    private static AngelsFactory instance = null;

    /**@return instance of the class
     * create instance if it doesn't exist. */
    public static AngelsFactory getInstance() {
        if (instance == null) {
            return new AngelsFactory();
        }
        return instance;
    }

    /**@param type is the angel's race or type
     * @param xCoordinate initial OX coordinate
     * @param yCoordinate initial OY coordinate.
     * @return new Hero of specified type.*/
    public Angel newAngel(final String type, final int
            xCoordinate, final int yCoordinate) {
        switch (type) {
            case "DamageAngel":
                return new DamageAngel(xCoordinate, yCoordinate);
            case "DarkAngel":
                return new DarkAngel(xCoordinate, yCoordinate);
            case "Dracula":
                return new Dracula(xCoordinate, yCoordinate);
            case "GoodBoy":
                return new GoodBoy(xCoordinate, yCoordinate);
            case "LevelUpAngel":
                return new LevelUpAngel(xCoordinate, yCoordinate);
            case "LifeGiver":
                return new LifeGiver(xCoordinate, yCoordinate);
            case "SmallAngel":
                return new SmallAngel(xCoordinate, yCoordinate);
            case "Spawner":
                return new Spawner(xCoordinate, yCoordinate);
            case "TheDoomer":
                return new TheDoomer(xCoordinate, yCoordinate);
            case "XPAngel":
                return new XPAngel(xCoordinate, yCoordinate);
            default:
                break;
        }
        return null;
    }
}
