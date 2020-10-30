package angels;

import game.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class SmallAngel extends Angel {
    /**Constructor .
     * @param xCoordinate is param
     * @param yCoordinate is param*/
    public SmallAngel(final int xCoordinate, final int yCoordinate) {
        getPosition().setX(xCoordinate);
        getPosition().setY(yCoordinate);
        setType("SmallAngel");
    }

    /**@param pyromancer is the hero visited.*/
    @Override
    public void visit(final Pyromancer pyromancer) {
        if (pyromancer.getHitPoints() <= 0) {
            return;
        }
        pyromancer.getAmplifiers().add(Constants.SMALL_ANGEL_PYROMANCER_DMG);
        pyromancer.setHitPoints(Constants.SMALL_ANGEL_PYROMANCER_HP
                + pyromancer.getHitPoints());
        getGame().notifyAllObservers(pyromancer, this);
    }

    /**@param knight is the hero visited.*/
    @Override
    public void visit(final Knight knight) {
        if (knight.getHitPoints() <= 0) {
            return;
        }
        knight.setHitPoints(knight.getHitPoints()
                + Constants.SMALL_ANGEL_KNIGHT_HP);
        knight.getAmplifiers().add(Constants.SMALL_ANGEL_KNIGHT_DMG);
        getGame().notifyAllObservers(knight, this);
    }

    /**@param rogue is the hero visited.*/
    @Override
    public void visit(final Rogue rogue) {
        if (rogue.getHitPoints() <= 0) {
            return;
        }
        rogue.setHitPoints(rogue.getHitPoints()
                + Constants.SMALL_ANGEL_ROGUE_HP);
        rogue.getAmplifiers().add(Constants.SMALL_ANGEL_ROGUE_DMG);
        getGame().notifyAllObservers(rogue, this);
    }

    /**@param wizard is the hero visited.*/
    @Override
    public void visit(final Wizard wizard) {
        if (wizard.getHitPoints() <= 0) {
            return;
        }
        wizard.setHitPoints(wizard.getHitPoints()
                + Constants.SMALL_ANGEL_WIZARD_HP);;
        wizard.getAmplifiers().add(Constants.SMALL_ANGEL_WIZARD_DMG);
        getGame().notifyAllObservers(wizard, this);
    }
}
