package greatwizard;

import angels.Angel;
import heroes.Hero;

public interface Observer {
    /**function that will be overloaded
     * with different types of parameters
     * (angels and heroes or both).
     */
    void update();
    /**@param hero makes update.*/
    void update(Hero hero);

    /**@param angel makes update.*/
    void update(Angel angel);

    /**@param hero1 and
     * @param hero2 make update.*/
    void update(Hero hero1, Hero hero2);

    /**@param hero and
     * @param angel make update*/
    void update(Hero hero, Angel angel);

    /**@param round is param.*/
    void update(int round);

    /**@param heroes is param.*/
    void update(Hero[] heroes);

    /**@return all observations.*/
    StringBuilder state();
}
