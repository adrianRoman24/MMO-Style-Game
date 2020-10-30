package greatwizard;

import angels.Angel;
import game.Constants;
import heroes.Hero;

public class GreatWizard implements Observer {
    /**Output to write in file
     * (what the observer observes about the game.
     */
    private StringBuilder output = new StringBuilder();

    /**Function to be overloaded.*/
    @Override
    public void update() {
        output.append("\n");
    }

    /**@param hero makes update.*/
    @Override
    public void update(final Hero hero) {
        if (hero.getHitPoints() <= 0) {
            output.append("Player " + hero.getRace()
                    + " " + hero.getIndex() + " was killed by an angel\n");
            return;
        }

        output.append(hero.getRace() + " "
                + hero.getIndex() + " reached level "
                + hero.getLevel() + "\n");
    }

    /**@param angel makes update.*/
    @Override
    public void update(final Angel angel) {
        output.append("Angel " + angel.getType()
                + " was spawned at " + angel.getPosition()
                .getX() + " " + angel.getPosition().getY() + "\n");
    }

    /**@param hero1 and
     * @param hero2 make update.*/
    @Override
    public void update(final Hero hero1, final Hero hero2) {
        if (hero1.getHitPoints() <= 0 && hero2.getHitPoints() > 0) {
            output.append("Player " + hero1.getRace()
                    + " " + hero1.getIndex() + " was killed by "
                    + hero2.getRace() + " " + hero2.getIndex() + "\n");
        } else {
            if (hero2.getHitPoints() <= 0 && hero1.getHitPoints() > 0) {
                output.append("Player " + hero2.getRace()
                        + " " + hero2.getIndex() + " was killed by "
                        + hero1.getRace() + " " + hero1.getIndex() + "\n");
            } else {
                if (hero1.getHitPoints() <= 0 && hero2.getHitPoints() <= 0) {
                    output.append("Player " + hero1.getRace()
                            + " " + hero1.getIndex() + " was killed by "
                            + hero2.getRace() + " " + hero2.getIndex() + "\n");
                    output.append("Player " + hero2.getRace()
                            + " " + hero2.getIndex() + " was killed by "
                            + hero1.getRace() + " " + hero1.getIndex() + "\n");
                }
            }
        }
    }

    /**@param hero and
     * @param angel make update*/
    @Override
    public void update(final Hero hero, final Angel angel) {
        if (Constants.KIND_ANGELS.contains(angel.getType())) {
            output.append(angel.getType()
                    + " helped " + hero.getRace()
                    + " " + hero.getIndex() + "\n");
        } else {
            output.append(angel.getType()
                    + " hit " + hero.getRace() + " " + hero.getIndex() + "\n");
        }

        //case Spawner
        if (angel.getType().equals("Spawner")) {
            output.append("Player " + hero.getRace()
                    + " " + hero.getIndex()
                    + " was brought to life by an angel\n");
        }
    }

    /**@param round is param.*/
    @Override
    public void update(final int round) {
        output.append("~~ Round " + round + " ~~\n");
    }

    /**@param heroes to print status of ceach hero.*/
    @Override
    public void update(final Hero[] heroes) {
        output.append("~~ Results ~~\n");
        for (Hero hero:heroes) {
            output.append(hero.status() + "\n");
        }
    }

    /**@return all observations.*/
    public StringBuilder state() {
        return output;
    }
}
