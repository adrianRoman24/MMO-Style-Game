package heroes;

import angels.Angel;
import game.Constants;
import strategies.DefenseStrategy;
import strategies.OffenseStrategy;

public class Wizard extends Hero {
    /**@param xCoordinate is the OX axis coord.
     *@param yCoordinate is the OY axis coord.*/
    public Wizard(final int xCoordinate, final int yCoordinate) {
        setType('W');
        setHitPoints(Constants.WIZARD_BASE_HP);
        getPosition().setX(xCoordinate);
        getPosition().setY(yCoordinate);
        setRace("Wizard");
    }

    /**Attack pyromancer on land landType.*/
    @Override
    public void attack(final Pyromancer pyromancer, final String landType) {
        if (landType.equals("Desert")) {
            setLandAmplifier(Constants.WIZARD_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //first ability
        setRaceAmplifier(Constants.DRAIN_PYROMANCER_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        float drain = (Constants.DRAIN
                + getLevel() * Constants.DRAIN_PER_LEVEL);
        drain *= Math.min(Constants.DRAIN_PERCENT * (Constants.
                PYROMANCER_BASE_HP + Constants.PYROMANCER_PER_LEVEL_HP
                        * pyromancer.getLevel()),
                pyromancer.getHitPoints() * 1f);
        drain *= getLandAmplifier();
        drain = Math.round(drain);
        drain *= getRaceAmplifier();
        drain = Math.round(drain);

        //calculate damage dealt by pyromancer
        if (landType.equals("Volcanic")) {
            setLandAmplifier(Constants.PYROANCER_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //first enemy ability
        float fireblast = Constants.FIREBLAST
                + Constants.FIREBLAST_PER_LEVEL * pyromancer.getLevel();
        fireblast *= getLandAmplifier();

        //second enemy ability
        float ignite = Constants.IGNITE
                + Constants.IGNITE_PER_LEVEL * pyromancer.getLevel();
        ignite *= getLandAmplifier();

        float totalDamage = Math.round(fireblast) + Math.round(ignite);

        if (landType.equals("Desert")) {
            setLandAmplifier(Constants.WIZARD_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //second ability
        float deflect = Math.min((Constants.DEFLECT
                + Constants.DEFLECT_PER_LEVEL
                * getLevel()), Constants.DEFLECT_MAX);

        setRaceAmplifier(Constants.DEFLECT_PYROMANCER_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        deflect *= totalDamage * getLandAmplifier();
        deflect *= getRaceAmplifier();

        setDamageDealt(Math.round(drain) + Math.round(deflect));
    }

    /**Attack knight on land landType.*/
    @Override
    public void attack(final Knight knight, final String landType) {
        if (landType.equals("Desert")) {
            setLandAmplifier(Constants.WIZARD_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //first ability
        float drain = (Constants.DRAIN + getLevel()
                * Constants.DRAIN_PER_LEVEL)
                * Math.min(Constants.DRAIN_PERCENT * (Constants.KNIGHT_BASE_HP
                        + Constants.KNIGHT_PER_LEVEL_HP
                        * knight.getLevel()), knight.getHitPoints() * 1f);
        setRaceAmplifier(Constants.DRAIN_KNIGHT_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        drain *= getLandAmplifier();
        drain *= getRaceAmplifier();

        if (landType.equals("Land")) {
            setLandAmplifier(Constants.KNIGHT_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //first enemy ability
        float execute = Constants.EXECUTE
                + Constants.EXECUTE_PER_LEVEL * knight.getLevel();
        execute *= getLandAmplifier();

        //second enemy ability
        float slam = Constants.SLAM + Constants.
                SLAM_PER_LEVEL_HP * knight.getLevel();
        slam *= getLandAmplifier();

        float totalDamage = execute + slam;

        if (landType.equals("Desert")) {
            setLandAmplifier(Constants.WIZARD_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //second ability
        float deflect = Math.min((Constants.DEFLECT
                + Constants.DEFLECT_PER_LEVEL
                * getLevel()), Constants.DEFLECT_MAX);
        setRaceAmplifier(Constants.DEFLECT_KNIGHT_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        deflect *= totalDamage * getLandAmplifier();
        deflect *= getRaceAmplifier();

        setDamageDealt(Math.round(drain) + Math.round(deflect));
    }

    /**Attack wizard on land landType.*/
    @Override
    public void attack(final Wizard wizard, final String landType) {
        if (landType.equals("Desert")) {
            setLandAmplifier(Constants.WIZARD_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //first ability
        float drain = (Constants.DRAIN + getLevel()
                * Constants.DRAIN_PER_LEVEL)
                * Math.min(Constants.DRAIN_PERCENT * (Constants.
                        WIZARD_BASE_HP + Constants.WIZARD_PER_LEVEL_HP
                        * wizard.getLevel()), wizard.getHitPoints() * 1f);
        setRaceAmplifier(Constants.DRAIN_WIZARD_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        drain *= getLandAmplifier();
        drain *= getRaceAmplifier();

        setDamageDealt(Math.round(drain));
    }

    /**Attack rogue on land landType.*/
    @Override
    public void attack(final Rogue rogue, final String landType) {
        if (landType.equals("Desert")) {
            setLandAmplifier(Constants.WIZARD_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //first ability
        float drain = (Constants.DRAIN + getLevel() * Constants.DRAIN_PER_LEVEL)
                * Math.min(Constants.DRAIN_PERCENT * (Constants.
                ROGUE_BASE_HP + Constants.ROGUE_PER_LEVEL_HP
                        * rogue.getLevel()), rogue.getHitPoints() * 1f);
        setRaceAmplifier(Constants.DRAIN_ROGUE_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        drain *= getLandAmplifier();
        drain *= getRaceAmplifier();

        if (landType.equals("Woods")) {
            setLandAmplifier(Constants.ROGUE_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //first enemy ability
        float backstab = Constants.BACKSTAB
                + Constants.BACKSTAB_PER_LEVEL * rogue.getLevel();

        backstab *= getLandAmplifier();

        //case critical hit
        if (landType.equals("Woods") && (rogue.getRound() - 1)
                % Constants.BACKSTAB_ROUND_CRITICAL == 0) {
            backstab *= Constants.BACKSTAB_BONUS_AMPLIFIER;
        }

        //second enemy ability
        float paralysis = Constants.PARALYSIS
                + Constants.PARALYSIS_PER_LEVEL * rogue.getLevel();
        paralysis *= getLandAmplifier();

        float totalDamage = Math.round(backstab) + Math.round(paralysis);

        if (landType.equals("Desert")) {
            setLandAmplifier(Constants.WIZARD_LAND_AMPLIFIER);
        } else {
            setLandAmplifier(1f);
        }

        //second ability
        float deflect = Math.min((Constants.DEFLECT
                + Constants.DEFLECT_PER_LEVEL
                * getLevel()), Constants.DEFLECT_MAX);
        setRaceAmplifier(Constants.DEFLECT_ROGUE_AMPLIFIER);
        for (float amplifier:getAmplifiers()) {
            setRaceAmplifier(getRaceAmplifier() + amplifier);
        }
        deflect *= totalDamage * getLandAmplifier();
        deflect *= getRaceAmplifier();

        setDamageDealt(Math.round(drain) + Math.round(deflect));
    }

    /**Receive damage from hero on land landType.*/
    @Override
    public void activateDamage(final Hero hero, final String landType) {
        hero.attack(this, landType);
    }

    /**Add experience if win from loser's level.*/
    @Override
    public void addExperience(final int levelLoser) {
        setExperience(getExperience() + Math.max(0, Constants.
                EXP_BONUS - (getLevel() - levelLoser) * Constants.EXP_UP1));
        while (getExperience() >= Constants.EXP_LEVEL_UP
                + getLevel() * Constants.EXP_UP2) {
            setLevel(getLevel() + 1);
            setHitPoints(Constants.WIZARD_BASE_HP
                    + getLevel() * Constants.WIZARD_PER_LEVEL_HP);
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
        int maxLevelHp = Constants.WIZARD_BASE_HP
                + getLevel() * Constants.WIZARD_PER_LEVEL_HP;
        if ((maxLevelHp / Constants.STRATEGY_WIZARD_MIN_HP)
                < getHitPoints() && getHitPoints() < (maxLevelHp
                / Constants.STRATEGY_WIZARD_MAX_HP)) {
            OffenseStrategy.getInstance().applyStrategy(this);
        } else {
            if (getHitPoints() < maxLevelHp
                    / Constants.STRATEGY_WIZARD_MIN_HP) {
                DefenseStrategy.getInstance().applyStrategy(this);
            }
        }
    }
}
