package angels;

import game.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Dracula extends Angel {
    /**Constructor .
     * @param xCoordinate is param
     * @param yCoordinate is param*/
    public Dracula(final int xCoordinate, final int yCoordinate) {
        getPosition().setX(xCoordinate);
        getPosition().setY(yCoordinate);
        setType("Dracula");
    }

    /**@param pyromancer is the hero visited.*/
    @Override
    public void visit(final Pyromancer pyromancer) {
        if (pyromancer.getHitPoints() <= 0) {
            return;
        }
        pyromancer.setHitPoints(pyromancer.getHitPoints()
                - Constants.DRACULA_PYROMANCER_HP);
        pyromancer.getAmplifiers().add(Constants.DRACULA_PYROMANCER_DMG);
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
                - Constants.DRACULA_KNIGHT_HP);
        knight.getAmplifiers().add(Constants.DRACULA_KNIGHT_DMG);
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
        rogue.setHitPoints(rogue.getHitPoints() - Constants.DRACULA_ROGUE_HP);
        rogue.getAmplifiers().add(Constants.DRACULA_ROGUE_DMG);
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
                - Constants.DRACULA_WIZARD_HP);
        wizard.getAmplifiers().add(Constants.DRACULA_WIZARD_DMG);
        getGame().notifyAllObservers(wizard, this);
        if (wizard.getHitPoints() <= 0) {
            getGame().notifyAllObservers(wizard);
        }
    }
}
