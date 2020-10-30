package angels;

import game.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class GoodBoy extends Angel {
    /**Constructor .
     * @param xCoordinate is param
     * @param yCoordinate is param*/
    public GoodBoy(final int xCoordinate, final int yCoordinate) {
        getPosition().setX(xCoordinate);
        getPosition().setY(yCoordinate);
        setType("GoodBoy");
    }

    /**@param pyromancer is the hero visited.*/
    @Override
    public void visit(final Pyromancer pyromancer) {
        if (pyromancer.getHitPoints() <= 0) {
            return;
        }
        pyromancer.getAmplifiers().add(Constants.GOOD_BOY_PYROMANCER_DMG);
        pyromancer.setHitPoints(pyromancer.getHitPoints()
                + Constants.GOOD_BOY_PYROMANCER_HP);
        getGame().notifyAllObservers(pyromancer, this);
    }

    /**@param knight is the hero visited.*/
    @Override
    public void visit(final Knight knight) {
        if (knight.getHitPoints() <= 0) {
            return;
        }
        knight.getAmplifiers().add(Constants.GOOD_BOY_KNIGHT_DMG);
        knight.setHitPoints(Constants.GOOD_BOY_KNIGHT_HP
                + knight.getHitPoints());
        getGame().notifyAllObservers(knight, this);
    }

    /**@param rogue is the hero visited.*/
    @Override
    public void visit(final Rogue rogue) {
        if (rogue.getHitPoints() <= 0) {
            return;
        }
        rogue.getAmplifiers().add(Constants.GOOD_BOY_ROGUE_DMG);
        rogue.setHitPoints(Constants.GOOD_BOY_ROGUE_HP + rogue.getHitPoints());
        getGame().notifyAllObservers(rogue, this);
    }

    /**@param wizard is the hero visited.*/
    @Override
    public void visit(final Wizard wizard) {
        if (wizard.getHitPoints() <= 0) {
            return;
        }
        wizard.getAmplifiers().add(Constants.GOOD_BOY_WIZARD_DMG);
        wizard.setHitPoints(wizard.getHitPoints()
                + Constants.GOOD_BOY_WIZARD_HP);
        getGame().notifyAllObservers(wizard, this);
    }
}
