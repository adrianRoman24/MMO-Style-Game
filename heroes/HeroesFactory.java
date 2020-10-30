package heroes;

public final class HeroesFactory {
    /**initiate instance with null.*/
    private static HeroesFactory instance = null;

    /**index that memorizes the number of heroes created.*/
    private static int indexAll = 0;

    /**@return instance of the class
     * create instance if it doesn't exist. */
    public static HeroesFactory getInstance() {
        if (instance == null) {
            return new heroes.HeroesFactory();
        }
        return instance;
    }

    /**@param type is a letter that reminds us
     * what type of hero he is
     * @param xCoordinate initial OX coordinate
     * @param yCoordinate initial OY coordinate.
     * @return new Hero of specified type.*/
    public Hero newHero(final char type, final int xCoordinate,
                        final int yCoordinate) {
        switch (type) {
            case 'K':
                Knight knight = new Knight(xCoordinate, yCoordinate);
                knight.setIndex(indexAll++);
               return knight;
            case 'P':
                Pyromancer pyromancer = new Pyromancer(xCoordinate,
                        yCoordinate);
                pyromancer.setIndex(indexAll++);
                return pyromancer;
            case 'R':
                Rogue rogue = new Rogue(xCoordinate, yCoordinate);
                rogue.setIndex(indexAll++);
                return rogue;
            case 'W':
                Wizard wizard = new Wizard(xCoordinate, yCoordinate);
                wizard.setIndex(indexAll++);
                return wizard;
            default:
                break;
        }
        return null;
    }
}
