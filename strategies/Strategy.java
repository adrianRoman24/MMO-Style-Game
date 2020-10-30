package strategies;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public interface Strategy {
    /**@param knight is the hero that will apply the strategy.*/
    void applyStrategy(Knight knight);
    /**@param pyromancer is the hero that will apply the strategy.*/
    void applyStrategy(Pyromancer pyromancer);
    /**@param rogue is the hero that will apply the strategy.*/
    void applyStrategy(Rogue rogue);
    /**@param wizard is the hero that will apply the strategy.*/
    void applyStrategy(Wizard wizard);
}
