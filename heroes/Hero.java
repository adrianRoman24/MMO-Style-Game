package heroes;

import angels.Angel;
import game.Game;
import game.Point2D;

import java.util.ArrayList;

public abstract class Hero {
    /**hero hp (will be modified when a sub class
     * is created.*/
    private int hitPoints;
    /**hero experience.*/
    private int experience;
    /**hero level.*/
    private int level;
    /**hero type.*/
    private char type;
    /**damage dealt in a fight (will be
     * calculated each fight.*/
    private int damageDealt;
    /**will be modified in every fight.*/
    private float raceAmplifier;
    /**will be modified in every fight.*/
    private float landAmplifier;
    /**damage over time or incapacity this hero has.*/
    private Buffs buffs = new Buffs();
    /**current coordinated.*/
    private Point2D position = new Point2D();
    /**hero type.*/
    private String race;
    /**hero index.*/
    private int index;
    /**reference to game used for observer.*/
    private Game game;
    /**memorize if hero was visited by angel.*/
    private boolean visited = false;
    /**all amplifiers received.*/
    private ArrayList<Float> amplifiers = new ArrayList<Float>();

    /**@param pyromancer is opponent .
     * @param landType is the battle zone*/
    public void attack(final Pyromancer pyromancer, final String landType) { }
    /**@param knight is opponent .
     * @param landType is the battle zone*/
    public void attack(final Knight knight, final String landType) { }
    /**@param wizard is opponent .
     * @param landType is the battle zone*/
    public void attack(final Wizard wizard, final String landType) { }
    /**@param rogue is opponent .
     * @param landType is the battle zone*/
    public void attack(final Rogue rogue, final String landType) { }

    /**@return .*/
    public boolean isVisited() {
        return visited;
    }

    /**@param visited1 is param.*/
    public void setVisited(final boolean visited1) {
        this.visited = visited1;
    }

    /**@return .*/
    public ArrayList<Float> getAmplifiers() {
        return amplifiers;
    }

    /**@return .*/
    public Game getGame() {
        return game;
    }

    /**@param game1 is the game in which the hero plays.*/
    public void setGame(final Game game1) {
        this.game = game1;
    }

    /**@return .*/
    public Point2D getPosition() {
        return position;
    }

    /**@return .*/
    public int getHitPoints() {
        return hitPoints;
    }

    /**@return .*/
    public String getRace() {
        return race;
    }

    /**@param race1 setter .*/
    public void setRace(final String race1) {
        this.race = race1;
    }

    /**@return .*/
    public int getExperience() {
        return experience;
    }

    /**@param experience1 setter .*/
    public void setExperience(final int experience1) {
        this.experience = experience1;
    }

    /**@param level1 setter .*/
    public void setLevel(final int level1) {
        this.level = level1;
    }

    /**@param type1 setter .*/
    public void setType(final char type1) {
        this.type = type1;
    }

    /**@param damageDealt1 setter .*/
    public void setDamageDealt(final int damageDealt1) {
        this.damageDealt = damageDealt1;
    }

    /**@return .*/
    public float getRaceAmplifier() {
        return raceAmplifier;
    }

    /**@param raceAmplifier1 setter .*/
    public void setRaceAmplifier(final float raceAmplifier1) {
        this.raceAmplifier = raceAmplifier1;
    }

    /**@return .*/
    public float getLandAmplifier() {
        return landAmplifier;
    }

    /**@param landAmplifier1 setter .*/
    public void setLandAmplifier(final float landAmplifier1) {
        this.landAmplifier = landAmplifier1;
    }

    /**@return .*/
    public Buffs getBuffs() {
        return buffs;
    }

    /**@param hitPoints1 is the new hp.*/
    public void setHitPoints(final int hitPoints1) {
        this.hitPoints = hitPoints1;
    }

    /**@return .*/
    public int getLevel() {
        return level;
    }

    /**@return .*/
    public int getDamageDealt() {
        return damageDealt;
    }

    /**@return .*/
    public char getType() {
        return type;
    }

    /**@return .*/
    public int getIndex() {
        return index;
    }

    /**@param index1 is param.*/
    public void setIndex(final int index1) {
        this.index = index1;
    }

    /**@param angel gives buff to this hero.*/
    public abstract void accept(Angel angel);

    /**apply strategy depending on hp.*/
    public abstract void acceptStrategy();

    /**@param hero deals damage to the current hero.
     * @param landType is where the type takes place*/
    public void activateDamage(final Hero hero, final String landType) { }

    /**activate incapacity or damage over time received from previous rounds.*/
    public void activateBuffs() {
        //activate damage overtime if exists
        if (buffs.getDamageOvertime().size() > 0) {
            hitPoints -= buffs.getDamageOvertime().get(0);
            buffs.getDamageOvertime().remove(0);
        }
    }

    /**@return .*/
    public String status() {
        if (hitPoints <= 0) {
            return type + " dead";
        }

        return type + " " + level + " " + experience + " " + hitPoints + " "
                + position.getX() + " " + position.getY();
    }

    /**@param direction is where the hero will move
     * in the current round.*/
    public void move(final char direction) {
        //case dead hero
        if (hitPoints <= 0) {
            return;
        }

        //case incapacity active
        if (buffs.getIncapacity().size() > 0) {
            buffs.getIncapacity().remove(0);
            return;
        }

        switch (direction) {
            case 'U':
                position.setX(position.getX() - 1);
                break;
            case 'D':
                position.setX(position.getX() + 1);
                break;
            case 'L':
                position.setY(position.getY() - 1);
                break;
            case 'R':
                position.setY(position.getY() + 1);
                break;
            case '_':
                //do nothing
                break;
            default:
                break;
        }
    }

    /**@param levelLoser will be level on which the
     * new experience will be calculated*/
    public abstract void addExperience(int levelLoser);
}
