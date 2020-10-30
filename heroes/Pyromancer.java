package heroes;

import angels.Angel;
import game.Constants;
import strategies.DefenseStrategy;
import strategies.OffenseStrategy;

public class Pyromancer extends Hero {
    /**@param xCoordinate is the OX axis coord.
     *@param yCoordinate is the OY axis coord.*/
    public Pyromancer(final int xCoordinate, final int yCoordinate) {
        setType('P');
        setHitPoints(Constants.PYROMANCER_BASE_HP);
        getPosition().setX(xCoordinate);
        getPosition().setY(yCoordinate);
        setRace("Pyromancer");
    }

    /**Attack pyromancer on land landType.*/
    @Override
    public void attack(final Pyromancer pyromancer, final String landType) {
        // TODO
        if (landType.equals("Volcanic")) {
            setLandAmplifier(Constants.PYROANCER_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //first ability
        float fireblast = Constants.FIREBLAST + Constants.
                FIREBLAST_PER_LEVEL * getLevel();
        setRaceAmplifier(Constants.FIREBLAST_PYROMANCER_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        fireblast *= getLandAmplifier();
        fireblast = Math.round(fireblast);
        fireblast *= getRaceAmplifier();
        fireblast = Math.round(fireblast);

        //second ability
        float ignite = Constants.IGNITE + Constants.
                IGNITE_PER_LEVEL * getLevel();
        float igniteNextRound = Constants.
                IGNITE_NEXT_ROUND + Constants.
                IGNITE_NEXT_ROUND_PER_LEVEL * getLevel();
        setRaceAmplifier(Constants.IGNITE_PYROMANCER_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        ignite *= getLandAmplifier();
        ignite = Math.round(ignite);
        ignite *= getRaceAmplifier();
        ignite = Math.round(ignite);
        igniteNextRound *= getLandAmplifier();
        igniteNextRound = Math.round(igniteNextRound);
        igniteNextRound *= getRaceAmplifier();
        igniteNextRound = Math.round(igniteNextRound);

        //add ignite
        pyromancer.getBuffs().getIncapacity().clear();
        pyromancer.getBuffs().getDamageOvertime().clear();
        pyromancer.getBuffs().getDamageOvertime().
                add(Math.round(igniteNextRound));
        pyromancer.getBuffs().getDamageOvertime().
                add(Math.round(igniteNextRound));

        setDamageDealt(Math.round(fireblast) + Math.round(ignite));
    }

    /**Attack knight on land landType.*/
    @Override
    public void attack(final Knight knight, final String landType) {
        if (landType.equals("Volcanic")) {
            setLandAmplifier(Constants.PYROANCER_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //first ability
        float fireblast = Constants.FIREBLAST + Constants.
                FIREBLAST_PER_LEVEL * getLevel();
        setRaceAmplifier(Constants.FIREBLAST_KNIGHT_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        fireblast *= getLandAmplifier();
        fireblast = Math.round(fireblast);
        fireblast *= getRaceAmplifier();
        fireblast = Math.round(fireblast);

        //second ability
        float ignite = Constants.IGNITE + Constants.
                IGNITE_PER_LEVEL * getLevel();
        float igniteNextRound = Constants.IGNITE_NEXT_ROUND + Constants.
                IGNITE_NEXT_ROUND_PER_LEVEL * getLevel();
        setRaceAmplifier(Constants.IGNITE_KNIGHT_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        ignite *= getLandAmplifier();
        ignite = Math.round(ignite);
        ignite *= getRaceAmplifier();
        ignite = Math.round(ignite);
        igniteNextRound *= getLandAmplifier();
        igniteNextRound = Math.round(igniteNextRound);
        igniteNextRound *= getRaceAmplifier();
        igniteNextRound = Math.round(igniteNextRound);

        //add ignite
        knight.getBuffs().getIncapacity().clear();
        knight.getBuffs().getDamageOvertime().clear();
        knight.getBuffs().getDamageOvertime().add(Math.round(igniteNextRound));
        knight.getBuffs().getDamageOvertime().add(Math.round(igniteNextRound));

        setDamageDealt(Math.round(fireblast) + Math.round(ignite));
    }

    /**Attack wizard on land landType.*/
    @Override
    public void attack(final Wizard wizard, final String landType) {
        if (landType.equals("Volcanic")) {
            setLandAmplifier(Constants.PYROANCER_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //first ability
        float fireblast = Constants.FIREBLAST + Constants.
                FIREBLAST_PER_LEVEL * getLevel();
        setRaceAmplifier(Constants.FIREBLAST_WIZARD_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        fireblast *= getLandAmplifier();
        fireblast = Math.round(fireblast);
        fireblast *= getRaceAmplifier();
        fireblast = Math.round(fireblast);

        //second ability
        float ignite = Constants.IGNITE + Constants.
                IGNITE_PER_LEVEL * getLevel();
        float igniteNextRound = Constants.IGNITE_NEXT_ROUND + Constants.
                IGNITE_NEXT_ROUND_PER_LEVEL * getLevel();

        setRaceAmplifier(Constants.IGNITE_WIZARD_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        ignite *= getLandAmplifier();
        ignite = Math.round(ignite);
        ignite *= getRaceAmplifier();
        ignite = Math.round(ignite);
        igniteNextRound *= getLandAmplifier();
        igniteNextRound = Math.round(igniteNextRound);
        igniteNextRound *= getRaceAmplifier();
        igniteNextRound = Math.round(igniteNextRound);

        //add ignite
        wizard.getBuffs().getIncapacity().clear();
        wizard.getBuffs().getDamageOvertime().clear();
        wizard.getBuffs().getDamageOvertime().add(Math.round(igniteNextRound));
        wizard.getBuffs().getDamageOvertime().add(Math.round(igniteNextRound));

        setDamageDealt(Math.round(fireblast) + Math.round(ignite));
    }

    /**Attack rogue on land landType.*/
    @Override
    public void attack(final Rogue rogue, final String landType) {
        if (landType.equals("Volcanic")) {
            setLandAmplifier(Constants.PYROANCER_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //first ability
        float fireblast = Constants.FIREBLAST + Constants.
                FIREBLAST_PER_LEVEL * getLevel();
        setRaceAmplifier(Constants.FIREBLAST_ROGUE_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        fireblast *= getLandAmplifier();
        fireblast = Math.round(fireblast);
        fireblast *= getRaceAmplifier();
        fireblast = Math.round(fireblast);

        //second ability
        float ignite = Constants.IGNITE + Constants.
                IGNITE_PER_LEVEL * getLevel();
        float igniteNextRound = Constants.IGNITE_NEXT_ROUND + Constants.
                IGNITE_NEXT_ROUND_PER_LEVEL * getLevel();

        setRaceAmplifier(Constants.IGNITE_ROGUE_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        ignite *= getLandAmplifier();
        ignite = Math.round(ignite);
        ignite *= getRaceAmplifier();
        ignite = Math.round(ignite);
        igniteNextRound *= getLandAmplifier();
        igniteNextRound = Math.round(igniteNextRound);
        igniteNextRound *= getRaceAmplifier();
        igniteNextRound = Math.round(igniteNextRound);

        //add ignite
        rogue.getBuffs().getIncapacity().clear();
        rogue.getBuffs().getDamageOvertime().clear();
        rogue.getBuffs().getDamageOvertime().add(Math.round(igniteNextRound));
        rogue.getBuffs().getDamageOvertime().add(Math.round(igniteNextRound));

        setDamageDealt(Math.round(fireblast) + Math.round(ignite));
    }

    /**Receive damage from hero on land landType.*/
    @Override
    public void activateDamage(final Hero hero, final String landType) {
        hero.attack(this, landType);
    }

    /**Add experience if win from loser's level.*/
    @Override
    public void addExperience(final int levelLoser) {
        setExperience(getExperience() + Math.max(0, Constants.EXP_BONUS
                - (getLevel() - levelLoser) * Constants.EXP_UP1));
        while (getExperience() >= Constants.EXP_LEVEL_UP
                + getLevel() * Constants.EXP_UP2) {
            setLevel(getLevel() + 1);
            setHitPoints(Constants.PYROMANCER_BASE_HP
                    + getLevel() * Constants.PYROMANCER_PER_LEVEL_HP);
            getGame().notifyAllObservers(this);
        }
    }

    /**visited by angel.*/
    @Override
    public void accept(final Angel angel) {
        angel.visit(this);
    }

    /**hero applies @param strategy.*/
    @Override
    public void acceptStrategy() {
        int maxLevelHp = Constants.PYROMANCER_BASE_HP
                + getLevel() * Constants.PYROMANCER_PER_LEVEL_HP;
        if (getHitPoints() < maxLevelHp
                / Constants.STRATEGY_PYROMANCER_MIN_HP) {
            DefenseStrategy.getInstance().applyStrategy(this);
        } else {
            if ((maxLevelHp / Constants.STRATEGY_PYROMANCER_MIN_HP)
                    < getHitPoints() && getHitPoints()
                    < (maxLevelHp / Constants.
                    STRATEGY_PYROMANCER_MAX_HP)) {
                OffenseStrategy.getInstance().applyStrategy(this);
            }
        }
    }
}
