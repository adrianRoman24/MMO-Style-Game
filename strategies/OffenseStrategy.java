package strategies;

import game.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class OffenseStrategy implements Strategy {
    /**instance.*/
    private static OffenseStrategy instance = null;

    /**private constructor.*/
    private OffenseStrategy() { }

    /**@return instance.*/
    public static OffenseStrategy getInstance() {
        if (instance == null) {
            return new OffenseStrategy();
        }
        return instance;
    }

    /**@param knight is the hero that will apply the strategy.*/
    @Override
    public void applyStrategy(final Knight knight) {
        if (knight.getHitPoints() <= 0) {
            return;
        }
        int maxLevelHp = Constants.KNIGHT_BASE_HP
                + knight.getLevel() * Constants.KNIGHT_PER_LEVEL_HP;

        //attack
        if ((maxLevelHp / Constants.STRATEGY_KNIGHT_MIN_HP)
                < knight.getHitPoints() && knight.getHitPoints() < (maxLevelHp
                / Constants.STRATEGY_KNIGHT_MAX_HP)) {
            knight.setHitPoints(knight.getHitPoints()
                    - knight.getHitPoints() / Constants.
                    STRATEGY_KNIGHT_DELETE_HP);
            knight.getAmplifiers().add(Constants.STRATEGY_KNIGHT_COEF_INCREASE);
            return;
        }
    }

    /**@param pyromancer is the hero that will apply the strategy.*/
    @Override
    public void applyStrategy(final Pyromancer pyromancer) {
        if (pyromancer.getHitPoints() <= 0) {
            return;
        }
        int maxLevelHp = Constants.PYROMANCER_BASE_HP
                + pyromancer.getLevel() * Constants.PYROMANCER_PER_LEVEL_HP;

        //attack
        pyromancer.setHitPoints(pyromancer.getHitPoints()
                    - pyromancer.getHitPoints() / Constants.
                    STRATEGY_PYROMANCER_DELETE_HP);
        pyromancer.getAmplifiers().add(Constants.
                    STRATEGY_PYROMANCER_COEF_INCREASE);
    }

    /**@param rogue is the hero that will apply the strategy.*/
    @Override
    public void applyStrategy(final Rogue rogue) {
        if (rogue.getHitPoints() <= 0) {
            return;
        }
        //attack
        rogue.setHitPoints(rogue.getHitPoints()
                    - rogue.getHitPoints() / Constants.
                    STRATEGY_ROGUE_DELETE_HP);
        rogue.getAmplifiers().add(Constants.STRATEGY_ROGUE_COEF_INCREASE);
    }

    /**@param wizard is the hero that will apply the strategy.*/
    @Override
    public void applyStrategy(final Wizard wizard) {
        if (wizard.getHitPoints() <= 0) {
            return;
        }

        //attack
        wizard.setHitPoints(wizard.getHitPoints()
                    - wizard.getHitPoints() / Constants.
                    STRATEGY_WIZARD_DELETE_HP);
        wizard.getAmplifiers().add(Constants.STRATEGY_WIZARD_COEF_INCREASE);
    }
}
