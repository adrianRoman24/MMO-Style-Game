package angels;

import game.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LevelUpAngel extends Angel {
    /**Constructor .
     * @param xCoordinate is param
     * @param yCoordinate is param*/
    public LevelUpAngel(final int xCoordinate, final int yCoordinate) {
        getPosition().setX(xCoordinate);
        getPosition().setY(yCoordinate);
        setType("LevelUpAngel");
    }

    /**@param pyromancer is the hero visited.*/
    @Override
    public void visit(final Pyromancer pyromancer) {
        if (pyromancer.getHitPoints() <= 0) {
            return;
        }
        getGame().notifyAllObservers(pyromancer, this);
        pyromancer.getAmplifiers().add(Constants.LEVEL_UP_ANGEL_PYROMANCER_DMG);
        pyromancer.setExperience(Constants.EXP_LEVEL_UP
                + pyromancer.getLevel() * Constants.EXP_UP2);
        pyromancer.setLevel(pyromancer.getLevel() + 1);
        pyromancer.setHitPoints(Constants.PYROMANCER_BASE_HP
                + pyromancer.getLevel() * Constants.PYROMANCER_PER_LEVEL_HP);
        getGame().notifyAllObservers(pyromancer);
    }

    /**@param knight is the hero visited.*/
    @Override
    public void visit(final Knight knight) {
        if (knight.getHitPoints() <= 0) {
            return;
        }
        getGame().notifyAllObservers(knight, this);
        knight.getAmplifiers().add(Constants.LEVEL_UP_ANGEL_KNIGHT_DMG);
        knight.setExperience(Constants.EXP_LEVEL_UP
                + knight.getLevel() * Constants.EXP_UP2);
        knight.setLevel(knight.getLevel() + 1);
        knight.setHitPoints(Constants.KNIGHT_BASE_HP
                + knight.getLevel() * Constants.KNIGHT_PER_LEVEL_HP);
        getGame().notifyAllObservers(knight);
    }

    /**@param rogue is the hero visited.*/
    @Override
    public void visit(final Rogue rogue) {
        if (rogue.getHitPoints() <= 0) {
            return;
        }
        getGame().notifyAllObservers(rogue, this);
        rogue.getAmplifiers().add(Constants.LEVEL_UP_ANGEL_ROGUE_DMG);
        rogue.setExperience(Constants.EXP_LEVEL_UP
                + rogue.getLevel() * Constants.EXP_UP2);
        rogue.setLevel(rogue.getLevel() + 1);
        rogue.setHitPoints(Constants.ROGUE_BASE_HP
                + rogue.getLevel() * Constants.ROGUE_PER_LEVEL_HP);
        getGame().notifyAllObservers(rogue);
    }

    /**@param wizard is the hero visited.*/
    @Override
    public void visit(final Wizard wizard) {
        if (wizard.getHitPoints() <= 0) {
            return;
        }
        getGame().notifyAllObservers(wizard, this);
        wizard.getAmplifiers().add(Constants.LEVEL_UP_ANGEL_WIZARD_DMG);
        wizard.setExperience(Constants.EXP_LEVEL_UP
                + wizard.getLevel() * Constants.EXP_UP2);
        wizard.setLevel(wizard.getLevel() + 1);
        wizard.setHitPoints(Constants.WIZARD_BASE_HP
                + wizard.getLevel() * Constants.WIZARD_PER_LEVEL_HP);
        getGame().notifyAllObservers(wizard);
    }
}
