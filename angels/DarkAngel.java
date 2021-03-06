package angels;

import game.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DarkAngel extends Angel {
    /**Constructor .
     * @param xCoordinate is param
     * @param yCoordinate is param*/
    public DarkAngel(final int xCoordinate, final int yCoordinate) {
        getPosition().setX(xCoordinate);
        getPosition().setY(yCoordinate);
        setType("DarkAngel");
    }

    /**@param pyromancer is the hero visited.*/
    @Override
    public void visit(final Pyromancer pyromancer) {
        if (pyromancer.getHitPoints() <= 0) {
            return;
        }
        pyromancer.setHitPoints(pyromancer.getHitPoints()
                - Constants.DARK_ANGEL_PYROMANCER);
        getGame().notifyAllObservers(pyromancer, this);
        if (pyromancer.getHitPoints() <= 0) {
            getGame().notifyAllObservers(pyromancer);
        }
    }

    /**@param knight is the hero visited.*/
    @Override
    public void visit(final Knight knight) {
        if (knight.getHitPoints() <= 0) {
            return;
        }
        knight.setHitPoints(knight.getHitPoints()
                - Constants.DARK_ANGEL_KNIGHT);
        getGame().notifyAllObservers(knight, this);
        if (knight.getHitPoints() <= 0) {
            getGame().notifyAllObservers(knight);
        }
    }

    /**@param rogue is the hero visited.*/
    @Override
    public void visit(final Rogue rogue) {
        if (rogue.getHitPoints() <= 0) {
            return;
        }
        rogue.setHitPoints(rogue.getHitPoints() - Constants.DARK_ANGEL_ROGUE);
        getGame().notifyAllObservers(rogue, this);
        if (rogue.getHitPoints() <= 0) {
            getGame().notifyAllObservers(rogue);
        }
    }

    /**@param wizard is the hero visited.*/
    @Override
    public void visit(final Wizard wizard) {
        if (wizard.getHitPoints() <= 0) {
            return;
        }
        wizard.setHitPoints(wizard.getHitPoints()
                - Constants.DARK_ANGEL_WIZARD);
        getGame().notifyAllObservers(wizard, this);
        if (wizard.getHitPoints() <= 0) {
            getGame().notifyAllObservers(wizard);
        }
    }
}
