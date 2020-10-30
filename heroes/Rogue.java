package heroes;

import angels.Angel;
import game.Constants;
import strategies.DefenseStrategy;
import strategies.OffenseStrategy;

public class Rogue extends Hero {
    /**round in which backsab was applied.*/
    private int round;

    /**@return round.*/
    public int getRound() {
        return round;
    }

    /**@param round1 is param.*/
    public void setRound(final int round1) {
        this.round = round1;
    }

    /**@param xCoordinate is the OX axis coord.
     *@param yCoordinate is the OY axis coord.*/
    public Rogue(final int xCoordinate, final int yCoordinate) {
        setType('R');
        setHitPoints(Constants.ROGUE_BASE_HP);
        getPosition().setX(xCoordinate);
        getPosition().setY(yCoordinate);
        setRace("Rogue");
    }

    /**Attack pyromancer on land landType.*/
    @Override
    public void attack(final Pyromancer pyromancer, final String landType) {
        if (landType.equals("Woods")) {
            setLandAmplifier(Constants.ROGUE_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //first ability
        float backstab = Constants.BACKSTAB + Constants.
                BACKSTAB_PER_LEVEL * getLevel();

        setRaceAmplifier(Constants.BACKSTAB_PYROMANCER_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        backstab *= getLandAmplifier();
        backstab = Math.round(backstab);
        backstab *= getRaceAmplifier();
        backstab = Math.round(backstab);

        //case critical hit
        if (landType.equals("Woods") && round % Constants.
                BACKSTAB_ROUND_CRITICAL == 0) {
            backstab *= Constants.BACKSTAB_BONUS_AMPLIFIER;
        }

        //second ability
        float paralysis = Constants.PARALYSIS
                + Constants.PARALYSIS_PER_LEVEL * getLevel();
        setRaceAmplifier(Constants.PARALYSIS_PYROMANCER_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        paralysis *= getLandAmplifier();
        paralysis = Math.round(paralysis);
        paralysis *= getRaceAmplifier();
        paralysis = Math.round(paralysis);

        //add damage over time
        pyromancer.getBuffs().getDamageOvertime().clear();
        pyromancer.getBuffs().getIncapacity().clear();
        int nrRoundsOvertime = Constants.PARALYSIS_DURATION;
        if (landType.equals("Woods")) {
            nrRoundsOvertime += Constants.PARALYSIS_DURATION;
        }

        for (int nrParalysis = 0; nrParalysis
                < nrRoundsOvertime; nrParalysis++) {
            pyromancer.getBuffs().getIncapacity().add(true);
            pyromancer.getBuffs().getDamageOvertime().
                    add(Math.round(paralysis));
        }

        setDamageDealt(Math.round(backstab) + Math.round(paralysis));
        round++;
    }

    /**Attack knight on land landType.*/
    @Override
    public void attack(final Knight knight, final String landType) {
        if (landType.equals("Woods")) {
            setLandAmplifier(Constants.ROGUE_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //first ability
        float backstab = Constants.BACKSTAB
                + Constants.BACKSTAB_PER_LEVEL * getLevel();

        setRaceAmplifier(Constants.BACKSTAB_KNIGHT_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        backstab *= getLandAmplifier();
        backstab = Math.round(backstab);
        backstab *= getRaceAmplifier();
        backstab = Math.round(backstab);

        //case critical hit
        if (landType.equals("Woods") && round
                % Constants.BACKSTAB_ROUND_CRITICAL == 0) {
            backstab *= Constants.BACKSTAB_BONUS_AMPLIFIER;
        }

        //second ability
        float paralysis = Constants.PARALYSIS
                + Constants.PARALYSIS_PER_LEVEL * getLevel();
        setRaceAmplifier(Constants.PARALYSIS_KNIGHT_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        paralysis *= getLandAmplifier();
        paralysis = Math.round(paralysis);
        paralysis *= getRaceAmplifier();
        paralysis = Math.round(paralysis);

        //add damage over time
        knight.getBuffs().getDamageOvertime().clear();
        knight.getBuffs().getIncapacity().clear();
        int nrRoundsOvertime = Constants.PARALYSIS_DURATION;

        if (landType.equals("Woods")) {
            nrRoundsOvertime += Constants.PARALYSIS_DURATION;
        }

        for (int nrParalysis = 0; nrParalysis
                < nrRoundsOvertime; nrParalysis++) {
            knight.getBuffs().getIncapacity().add(true);
            knight.getBuffs().getDamageOvertime().add(Math.round(paralysis));
        }

        setDamageDealt(Math.round(backstab) + Math.round(paralysis));
        round++;
    }

    /**Attack wizard on land landType.*/
    @Override
    public void attack(final Wizard wizard, final String landType) {
        if (landType.equals("Woods")) {
            setLandAmplifier(Constants.ROGUE_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //first ability
        float backstab = Constants.BACKSTAB
                + Constants.BACKSTAB_PER_LEVEL * getLevel();

        setRaceAmplifier(Constants.BACKSTAB_WIZARD_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        backstab *= getLandAmplifier();
        backstab = Math.round(backstab);
        backstab *= getRaceAmplifier();
        backstab = Math.round(backstab);

        //case critical hit
        if (landType.equals("Woods") && round
                % Constants.BACKSTAB_ROUND_CRITICAL == 0) {
            backstab *= Constants.BACKSTAB_BONUS_AMPLIFIER;
        }

        //second ability
        float paralysis = Constants.PARALYSIS
                + Constants.PARALYSIS_PER_LEVEL * getLevel();
        setRaceAmplifier(Constants.PARALYSIS_WIZARD_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        paralysis *= getLandAmplifier();
        paralysis = Math.round(paralysis);
        paralysis *= getRaceAmplifier();
        paralysis = Math.round(paralysis);

        //add damage over time
        wizard.getBuffs().getDamageOvertime().clear();
        wizard.getBuffs().getIncapacity().clear();
        int nrRoundsOvertime = Constants.PARALYSIS_DURATION;
        if (landType.equals("Woods")) {
            nrRoundsOvertime += Constants.PARALYSIS_DURATION;
        }

        for (int nrParalysis = 0; nrParalysis
                < nrRoundsOvertime; nrParalysis++) {
            wizard.getBuffs().getIncapacity().add(true);
            wizard.getBuffs().getDamageOvertime().add(Math.round(paralysis));
        }

        setDamageDealt(Math.round(backstab) + Math.round(paralysis));
        round++;
    }

    /**Attack rogue on land landType.*/
    @Override
    public void attack(final Rogue rogue, final String landType) {
        if (landType.equals("Woods")) {
            setLandAmplifier(Constants.ROGUE_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //first ability
        float backstab = Constants.BACKSTAB
                + Constants.BACKSTAB_PER_LEVEL * getLevel();

        setRaceAmplifier(Constants.BACKSTAB_ROGUE_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        backstab *= getLandAmplifier();
        backstab = Math.round(backstab);
        backstab *= getRaceAmplifier();
        backstab = Math.round(backstab);

        //case critical hit
        if (landType.equals("Woods") && round
                % Constants.BACKSTAB_ROUND_CRITICAL == 0) {
            backstab *= Constants.BACKSTAB_BONUS_AMPLIFIER;
        }

        //second ability
        float paralysis = Constants.PARALYSIS
                + Constants.PARALYSIS_PER_LEVEL * getLevel();
        setRaceAmplifier(Constants.PARALYSIS_ROGUE_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        paralysis *= getLandAmplifier();
        paralysis = Math.round(paralysis);
        paralysis *= getRaceAmplifier();
        paralysis = Math.round(paralysis);

        //add damage over time
        rogue.getBuffs().getDamageOvertime().clear();
        rogue.getBuffs().getIncapacity().clear();
        int nrRoundsOvertime = Constants.PARALYSIS_DURATION;
        if (landType.equals("Woods")) {
            nrRoundsOvertime += Constants.PARALYSIS_DURATION;
        }

        for (int nrParalysis = 0; nrParalysis
                < nrRoundsOvertime; nrParalysis++) {
            rogue.getBuffs().getIncapacity().add(true);
            rogue.getBuffs().getDamageOvertime().add(Math.round(paralysis));
        }

        setDamageDealt(Math.round(backstab) + Math.round(paralysis));
        round++;
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
            setHitPoints(Constants.ROGUE_BASE_HP
                    + getLevel() * Constants.ROGUE_PER_LEVEL_HP);
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
        int maxLevelHp = Constants.ROGUE_BASE_HP
                + getLevel() * Constants.ROGUE_PER_LEVEL_HP;
        if (getHitPoints() < maxLevelHp
                / Constants.STRATEGY_ROGUE_MIN_HP) {
            DefenseStrategy.getInstance().applyStrategy(this);
        } else {
            if ((maxLevelHp / Constants.STRATEGY_ROGUE_MIN_HP)
                    < getHitPoints() && getHitPoints() < (maxLevelHp
                    / Constants.STRATEGY_ROGUE_MAX_HP)) {
                OffenseStrategy.getInstance().applyStrategy(this);
            }
        }
    }
}
