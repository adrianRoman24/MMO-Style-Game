package angels;

import game.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Spawner extends Angel {
    /**Constructor .
     * @param xCoordinate is param
     * @param yCoordinate is param*/
    public Spawner(final int xCoordinate, final int yCoordinate) {
        getPosition().setX(xCoordinate);
        getPosition().setY(yCoordinate);
        setType("Spawner");
    }

    /**@param pyromancer is the hero visited.*/
    @Override
    public void visit(final Pyromancer pyromancer) {
        if (pyromancer.getHitPoints() <= 0) {
            pyromancer.setHitPoints(Constants.SPAWNER_PYROMANCER_HP);
            getGame().notifyAllObservers(pyromancer, this);
        }
    }

    /**@param knight is the hero visited.*/
    @Override
    public void visit(final Knight knight) {
        if (knight.getHitPoints() <= 0) {
            knight.setHitPoints(Constants.SPAWNER_KNIGHT_HP);
            getGame().notifyAllObservers(knight, this);
        }
    }

    /**@param rogue is the hero visited.*/
    @Override
    public void visit(final Rogue rogue) {
        if (rogue.getHitPoints() <= 0) {
            rogue.setHitPoints(Constants.SPAWNER_ROGUE_HP);
            getGame().notifyAllObservers(rogue, this);
        }
    }

    /**@param wizard is the hero visited.*/
    @Override
    public void visit(final Wizard wizard) {
        if (wizard.getHitPoints() <= 0) {
            wizard.setHitPoints(Constants.SPAWNER_WIZARD_HP);
            getGame().notifyAllObservers(wizard, this);
        }
    }
}
