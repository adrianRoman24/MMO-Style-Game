package angels;

import game.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LifeGiver extends Angel {
    /**Constructor .
     * @param xCoordinate is param
     * @param yCoordinate is param*/
    public LifeGiver(final int xCoordinate, final int yCoordinate) {
        getPosition().setX(xCoordinate);
        getPosition().setY(yCoordinate);
        setType("LifeGiver");
    }
    /**@param pyromancer is the hero visited.*/
    @Override
    public void visit(final Pyromancer pyromancer) {
        if (pyromancer.getHitPoints() <= 0) {
            return;
        }
        pyromancer.setHitPoints(pyromancer.getHitPoints()
                + Constants.LIFE_GIVER_PYROMANCER_HP);
        if (pyromancer.getHitPoints() > Constants.PYROMANCER_BASE_HP
                + pyromancer.getLevel() * Constants.PYROMANCER_PER_LEVEL_HP) {
            pyromancer.setHitPoints(Constants.PYROMANCER_BASE_HP
                    + pyromancer.getLevel() * Constants.PYROMANCER_PER_LEVEL_HP);
        }
        getGame().notifyAllObservers(pyromancer, this);
    }

    /**@param knight is the hero visited.*/
    @Override
    public void visit(final Knight knight) {
        if (knight.getHitPoints() <= 0) {
            return;
        }
        knight.setHitPoints(knight.getHitPoints()
                + Constants.LIFE_GIVER_KNIGHT_HP);
        if (knight.getHitPoints() > Constants.KNIGHT_BASE_HP
                + knight.getLevel() * Constants.KNIGHT_PER_LEVEL_HP) {
            knight.setHitPoints(Constants.KNIGHT_BASE_HP
                    + knight.getLevel() * Constants.KNIGHT_PER_LEVEL_HP);
        }
        getGame().notifyAllObservers(knight, this);
    }

    /**@param rogue is the hero visited.*/
    @Override
    public void visit(final Rogue rogue) {
        if (rogue.getHitPoints() <= 0) {
            return;
        }
        rogue.setHitPoints(rogue.getHitPoints()
                + Constants.LIFE_GIVER_ROGUE_HP);
        if (rogue.getHitPoints() > Constants.ROGUE_BASE_HP
                + rogue.getLevel() * Constants.ROGUE_PER_LEVEL_HP) {
            rogue.setHitPoints(Constants.ROGUE_BASE_HP
                    + rogue.getLevel() * Constants.ROGUE_PER_LEVEL_HP);
        }
        getGame().notifyAllObservers(rogue, this);
    }

    /**@param wizard is the hero visited.*/
    @Override
    public void visit(final Wizard wizard) {
        if (wizard.getHitPoints() <= 0) {
            return;
        }
        wizard.setHitPoints(wizard.getHitPoints()
                + Constants.LIFE_GIVER_WIZARD_HP);
        if (wizard.getHitPoints() > Constants.WIZARD_BASE_HP
                + wizard.getLevel() * Constants.WIZARD_PER_LEVEL_HP) {
            wizard.setHitPoints(Constants.WIZARD_BASE_HP
                    + wizard.getLevel() * Constants.WIZARD_PER_LEVEL_HP);
        }
        getGame().notifyAllObservers(wizard, this);
    }
}
