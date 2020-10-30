package angels;

import game.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DamageAngel extends Angel {
    /**Constructor .
     * @param xCoordinate is param
     * @param yCoordinate is param*/
    public DamageAngel(final int xCoordinate, final int yCoordinate) {
        getPosition().setX(xCoordinate);
        getPosition().setY(yCoordinate);
        setType("DamageAngel");
    }

    /**@param pyromancer is the hero visited.*/
    @Override
    public void visit(final Pyromancer pyromancer) {
        if (pyromancer.getHitPoints() <= 0) {
            return;
        }
        pyromancer.getAmplifiers().add(Constants.DAMAGE_ANGEL_PYROMANCER);
        getGame().notifyAllObservers(pyromancer, this);
    }

    /**@param knight is the hero visited.*/
    @Override
    public void visit(final Knight knight) {
        if (knight.getHitPoints() <= 0) {
            return;
        }
        knight.getAmplifiers().add(Constants.DAMAGE_ANGEL_KNIGHT);
        getGame().notifyAllObservers(knight, this);
    }

    /**@param rogue is the hero visited.*/
    @Override
    public void visit(final Rogue rogue) {
        if (rogue.getHitPoints() <= 0) {
            return;
        }
        rogue.getAmplifiers().add(Constants.DAMAGE_ANGEL_ROGUE);
        getGame().notifyAllObservers(rogue, this);
    }

    /**@param wizard is the hero visited.*/
    @Override
    public void visit(final Wizard wizard) {
        if (wizard.getHitPoints() <= 0) {
            return;
        }
        wizard.getAmplifiers().add(Constants.DAMAGE_ANGEL_WIZARD);
        getGame().notifyAllObservers(wizard, this);
    }
}
