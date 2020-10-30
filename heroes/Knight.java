package heroes;

import angels.Angel;
import game.Constants;
import strategies.DefenseStrategy;
import strategies.OffenseStrategy;
import strategies.Strategy;

public class Knight extends Hero {
    /**@param xCoordinate is the OX axis coord.
     *@param yCoordinate is the OY axis coord.*/
    public Knight(final int xCoordinate, final int yCoordinate) {
        setType('K');
        setHitPoints(Constants.KNIGHT_BASE_HP);
        getPosition().setX(xCoordinate);
        getPosition().setY(yCoordinate);
        setRace("Knight");
    }

    /**Attack pyromancer on land landType.*/
    @Override
    public void attack(final Pyromancer pyromancer, final String landType) {
        //case execute
        float hpLimit = (float) (Math.min(Constants.
                EXECUTE_HP_LIMIT + Constants.EXECUTE_BONUS
                * getLevel(), Constants.EXECUTE_MAX_PERCENTAGE)
                * (Constants.PYROMANCER_BASE_HP
                + Constants.PYROMANCER_PER_LEVEL_HP * pyromancer.getLevel()));

        if (Math.round(hpLimit) >= pyromancer.getHitPoints()) {
            setDamageDealt(pyromancer.getHitPoints());
            return;
        }

        if (landType.equals("Land")) {
            setLandAmplifier(Constants.KNIGHT_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //first ability
        float execute = Constants.EXECUTE
                + Constants.EXECUTE_PER_LEVEL * getLevel();
        setRaceAmplifier(Constants.EXECUTE_PYROMANCER_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        execute *= getLandAmplifier();
        execute = Math.round(execute);
        execute *= getRaceAmplifier();
        execute = Math.round(execute);

        //second ability
        float slam = Constants.SLAM + Constants.SLAM_PER_LEVEL_HP * getLevel();
        setRaceAmplifier(Constants.SLAM_PYROMANCER_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        slam *= getLandAmplifier();
        slam = Math.round(slam);
        slam *= getRaceAmplifier();
        slam = Math.round(slam);

        //add incapacity
        pyromancer.getBuffs().getDamageOvertime().clear();
        pyromancer.getBuffs().getIncapacity().clear();
        pyromancer.getBuffs().getIncapacity().add(true);

        setDamageDealt(Math.round(execute) + Math.round(slam));
    }

    /**Attack knight on land landType.*/
    @Override
    public void attack(final Knight knight, final String landType) {
        //case execute
        float hpLimit = (float) (Math.min(Constants.
                EXECUTE_HP_LIMIT + Constants.EXECUTE_BONUS
                * getLevel(), Constants.EXECUTE_MAX_PERCENTAGE) * (Constants.
                KNIGHT_BASE_HP + Constants.KNIGHT_PER_LEVEL_HP
                * knight.getLevel()));
        if (Math.round(hpLimit) >= knight.getHitPoints()) {
            setDamageDealt(knight.getHitPoints());
            return;
        }

        if (landType.equals("Land")) {
            setLandAmplifier(Constants.KNIGHT_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //first ability
        float execute = Constants.EXECUTE
                + Constants.EXECUTE_PER_LEVEL * getLevel();
        setRaceAmplifier(Constants.EXECUTE_KNIGHT_AMPLIFIER);
        execute *= getLandAmplifier();
        execute = Math.round(execute);
        execute *= getRaceAmplifier();
        execute = Math.round(execute);

        //second ability
        float slam = Constants.SLAM + Constants.SLAM_PER_LEVEL_HP * getLevel();
        setRaceAmplifier(Constants.SLAM_KNIGHT_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        slam *= getLandAmplifier();
        slam = Math.round(slam);
        slam *= getRaceAmplifier();
        slam = Math.round(slam);

        //add incapacity
        knight.getBuffs().getDamageOvertime().clear();
        knight.getBuffs().getIncapacity().clear();
        knight.getBuffs().getIncapacity().add(true);

        setDamageDealt(Math.round(execute) + Math.round(slam));
    }

    /**Attack wizard on land landType.*/
    @Override
    public void attack(final Wizard wizard, final String landType) {
        //case execute
        float hpLimit = (float) (Math.min(Constants.EXECUTE_HP_LIMIT
                + Constants.EXECUTE_BONUS * getLevel(), Constants.
                EXECUTE_MAX_PERCENTAGE) * (Constants.WIZARD_BASE_HP
                + Constants.WIZARD_PER_LEVEL_HP * wizard.getLevel()));
        if (Math.round(hpLimit) >= wizard.getHitPoints()) {
            setDamageDealt(wizard.getHitPoints());
            return;
        }

        if (landType.equals("Land")) {
            setLandAmplifier(Constants.KNIGHT_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //first ability
        float execute = Constants.EXECUTE
                + Constants.EXECUTE_PER_LEVEL * getLevel();
        setRaceAmplifier(Constants.EXECUTE_WIZARD_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        execute *= getLandAmplifier();
        execute = Math.round(execute);
        execute *= getRaceAmplifier();
        execute = Math.round(execute);

        //second ability
        float slam = Constants.SLAM + Constants.SLAM_PER_LEVEL_HP * getLevel();
        setRaceAmplifier(Constants.SLAM_WIZARD_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        slam *= getLandAmplifier();
        slam = Math.round(slam);
        slam *= getRaceAmplifier();
        slam = Math.round(slam);

        //add incapacity
        wizard.getBuffs().getDamageOvertime().clear();
        wizard.getBuffs().getIncapacity().clear();
        wizard.getBuffs().getIncapacity().add(true);

        setDamageDealt(Math.round(execute) + Math.round(slam));
    }

    /**Attack rogue on land landType.*/
    @Override
    public void attack(final Rogue rogue, final String landType) {
        //case execute
        float hpLimit = (float) (Math.min(Constants.EXECUTE_HP_LIMIT
                + Constants.EXECUTE_BONUS * getLevel(), Constants.
                EXECUTE_MAX_PERCENTAGE) * (Constants.ROGUE_BASE_HP
                + Constants.ROGUE_PER_LEVEL_HP * rogue.getLevel()));
        if (Math.round(hpLimit) >= rogue.getHitPoints()) {
            setDamageDealt(rogue.getHitPoints());
            return;
        }

        if (landType.equals("Land")) {
            setLandAmplifier(Constants.KNIGHT_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //first ability
        float execute = Constants.EXECUTE
                + Constants.EXECUTE_PER_LEVEL * getLevel();
        setRaceAmplifier(Constants.EXECUTE_ROGUE_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        execute *= getLandAmplifier();
        execute = Math.round(execute);
        execute *= getRaceAmplifier();
        execute = Math.round(execute);

        //second ability
        float slam = Constants.SLAM + Constants.SLAM_PER_LEVEL_HP * getLevel();
        setRaceAmplifier(Constants.SLAM_ROGUE_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        slam *= getLandAmplifier();
        slam = Math.round(slam);
        slam *= getRaceAmplifier();
        slam = Math.round(slam);

        //add incapacity
        rogue.getBuffs().getDamageOvertime().clear();
        rogue.getBuffs().getIncapacity().clear();
        rogue.getBuffs().getIncapacity().add(true);

        setDamageDealt(Math.round(execute) + Math.round(slam));
    }

    /**visited by angel.*/
    @Override
    public void accept(final Angel angel) {
        angel.visit(this);
    }

    /**hero applies @param strategy.*/
    @Override
    public void acceptStrategy() {
        int maxLevelHp = Constants.KNIGHT_BASE_HP
                + getLevel() * Constants.KNIGHT_PER_LEVEL_HP;
        if (getHitPoints() < maxLevelHp
                / Constants.STRATEGY_KNIGHT_MIN_HP) {
            DefenseStrategy.getInstance().applyStrategy(this);
        } else {
            if ((maxLevelHp / Constants.STRATEGY_KNIGHT_MIN_HP)
                    < getHitPoints() && getHitPoints() < (maxLevelHp
                    / Constants.STRATEGY_KNIGHT_MAX_HP)) {
                OffenseStrategy.getInstance().applyStrategy(this);
            }
        }
    }

    /**Receive damage from hero on land landType.*/
    @Override
    public void activateDamage(final Hero hero, final String landType) {
        hero.attack(this, landType);
    }

    /**Add experience if win from loser's level.*/
    @Override
    public void addExperience(final int levelLoser) {
        setExperience(getExperience()
                + Math.max(0, Constants.EXP_BONUS
                - (getLevel() - levelLoser) * Constants.EXP_UP1));
        while (getExperience() >= Constants.EXP_LEVEL_UP
                + getLevel() * Constants.EXP_UP2) {
            setLevel(getLevel() + 1);
            setHitPoints(Constants.KNIGHT_BASE_HP
                    + getLevel() * Constants.KNIGHT_PER_LEVEL_HP);
            getGame().notifyAllObservers(this);
        }
    }
}
