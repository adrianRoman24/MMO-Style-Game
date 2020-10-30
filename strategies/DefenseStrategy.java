package strategies;

import game.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class DefenseStrategy implements Strategy {
    /**instance.*/
    private static DefenseStrategy instance = null;

    /**private constructor.*/
    private DefenseStrategy() { }

    /**@return instance.*/
    public static DefenseStrategy getInstance() {
        if (instance == null) {
            return new DefenseStrategy();
        }
        return instance;
    }

    /**@param knight is the hero that will apply the strategy.*/
    @Override
    public void applyStrategy(final Knight knight) {
        if (knight.getHitPoints() <= 0) {
            return;
        }
        //defense
        knight.getAmplifiers().add(-Constants.
                    STRATEGY_KNIGHT_COEF_DECREASE);
        knight.setHitPoints(knight.getHitPoints()
                    + knight.getHitPoints() / Constants.
                    STRATEGY_KNIGHT_GAIN_HP);
    }

    /**@param pyromancer is the hero that will apply the strategy.*/
    @Override
    public void applyStrategy(final Pyromancer pyromancer) {
        if (pyromancer.getHitPoints() <= 0) {
            return;
        }
        //defense
        pyromancer.getAmplifiers().add(-Constants.
                    STRATEGY_PYROMANCER_COEF_DECREASE);
        pyromancer.setHitPoints(pyromancer.getHitPoints()
                    + pyromancer.getHitPoints() / Constants.
                    STRATEGY_PYROMANCER_GAIN_HP);
    }

    /**@param rogue is the hero that will apply the strategy.*/
    @Override
    public void applyStrategy(final Rogue rogue) {
        if (rogue.getHitPoints() <= 0) {
            return;
        }
        //defense
        rogue.getAmplifiers().add(-Constants.STRATEGY_ROGUE_COEF_DECREASE);
        rogue.setHitPoints(rogue.getHitPoints()
                    + rogue.getHitPoints() / Constants.
                    STRATEGY_ROGUE_GAIN_HP);
    }

    /**@param wizard is the hero that will apply the strategy.*/
    @Override
    public void applyStrategy(final Wizard wizard) {
        if (wizard.getHitPoints() <= 0) {
            return;
        }

        //defense
        wizard.getAmplifiers().add(-Constants.
                    STRATEGY_WIZARD_COEF_DECREASE);
        wizard.setHitPoints(wizard.getHitPoints()
                    + wizard.getHitPoints() / Constants.
                    STRATEGY_WIZARD_GAIN_HP);
    }
}
