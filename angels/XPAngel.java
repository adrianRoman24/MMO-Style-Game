package angels;

import game.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class XPAngel extends Angel {
    /**Constructor .
     * @param xCoordinate is param
     * @param yCoordinate is param*/
    public XPAngel(final int xCoordinate, final int yCoordinate) {
        getPosition().setX(xCoordinate);
        getPosition().setY(yCoordinate);
        setType("XPAngel");
    }

    /**@param pyromancer is the hero visited.*/
    @Override
    public void visit(final Pyromancer pyromancer) {
        if (pyromancer.getHitPoints() <= 0) {
            return;
        }
        getGame().notifyAllObservers(pyromancer, this);
        pyromancer.setExperience(pyromancer.
                getExperience() + Constants.XP_ANGEL_PYROMANCER_XP);
        while (pyromancer.getExperience() >= (Constants.EXP_LEVEL_UP
                + pyromancer.getLevel() * Constants.EXP_UP2)) {
            pyromancer.setLevel(pyromancer.getLevel() + 1);
            pyromancer.setHitPoints(Constants.
                    PYROMANCER_BASE_HP
                    + pyromancer.getLevel()
                    * Constants.PYROMANCER_PER_LEVEL_HP);
            getGame().notifyAllObservers(pyromancer);
        }
    }

    /**@param knight is the hero visited.*/
    @Override
    public void visit(final Knight knight) {
        if (knight.getHitPoints() <= 0) {
            return;
        }
        getGame().notifyAllObservers(knight, this);
        knight.setExperience(knight.
                getExperience() + Constants.XP_ANGEL_KNIGHT_XP);
        while (knight.getExperience() >= (Constants.EXP_LEVEL_UP
                + knight.getLevel() * Constants.EXP_UP2)) {
            knight.setLevel(knight.getLevel() + 1);
            knight.setHitPoints(Constants.KNIGHT_BASE_HP
                    + knight.getLevel() * Constants.KNIGHT_PER_LEVEL_HP);
            getGame().notifyAllObservers(knight);
        }
    }

    /**@param rogue is the hero visited.*/
    @Override
    public void visit(final Rogue rogue) {
        if (rogue.getHitPoints() <= 0) {
            return;
        }
        getGame().notifyAllObservers(rogue, this);
        rogue.setExperience(rogue.getExperience()
                + Constants.XP_ANGEL_ROGUE_XP);
        while (rogue.getExperience() >= (Constants.EXP_LEVEL_UP
                + rogue.getLevel() * Constants.EXP_UP2)) {
            rogue.setLevel(rogue.getLevel() + 1);
            rogue.setHitPoints(Constants.ROGUE_BASE_HP
                    + rogue.getLevel() * Constants.ROGUE_PER_LEVEL_HP);
            getGame().notifyAllObservers(rogue);
        }
    }

    /**@param wizard is the hero visited.*/
    @Override
    public void visit(final Wizard wizard) {
        if (wizard.getHitPoints() <= 0) {
            return;
        }
        getGame().notifyAllObservers(wizard, this);
        wizard.setExperience(wizard.
                getExperience() + Constants.XP_ANGEL_WIZARD_XP);
        while (wizard.getExperience() >= (Constants.EXP_LEVEL_UP
                + wizard.getLevel() * Constants.EXP_UP2)) {
            wizard.setLevel(wizard.getLevel() + 1);
            wizard.setHitPoints(Constants.WIZARD_BASE_HP
                    + wizard.getLevel() * Constants.WIZARD_PER_LEVEL_HP);
            getGame().notifyAllObservers(wizard);
        }
    }
}
