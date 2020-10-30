package game;

import angels.Angel;
import greatwizard.Observable;
import greatwizard.Observer;
import greatwizard.ObserversFactory;
import heroes.Hero;
import heroes.Rogue;

import java.util.ArrayList;

public class Game implements Observable {
    /**vector of heroes.*/
    private Hero[]heroes;
    /**vector of lists of angels for each round.*/
    private ArrayList<Angel>[] angels;
    /**.*/
    private int mapRows;
    /**.*/
    private int mapColumns;
    /**.*/
    private int nrHeroes;
    /**.*/
    private int nrRounds;
    /**the moves (directions) of every hero in every round.*/
    private String[]heroesMoves;
    /**observer list in case in the future we will extend teh program.*/
    private ArrayList<Observer> observers = new ArrayList<>();

    /**@return heroes.*/
    public Hero[] getHeroes() {
        return heroes;
    }

    /**@return observers.*/
    public ArrayList<Observer> getObservers() {
        return observers;
    }

    /**@param heroes1 .*/
    public void setHeroes(final Hero[] heroes1) {
        this.heroes = heroes1;
    }

    /**@param mapRows1 .*/
    public void setMapRows(final int mapRows1) {
        this.mapRows = mapRows1;
    }

    /**@param mapColumns1 .*/
    public void setMapColumns(final int mapColumns1) {
        this.mapColumns = mapColumns1;
    }

    /**@param nrHeroes1 .*/
    public void setNrHeroes(final int nrHeroes1) {
        this.nrHeroes = nrHeroes1;
    }

    /**@param nrRounds1 .*/
    public void setNrRounds(final int nrRounds1) {
        this.nrRounds = nrRounds1;
    }

    /**@param heroesMoves1 .*/
    public void setHeroesMoves(final String[] heroesMoves1) {
        this.heroesMoves = heroesMoves1;
    }
    /**@param angels1 .*/
    public void setAngels(final ArrayList<Angel>[] angels1) {
        this.angels = angels1;
    }

    /**unvisit all heroes.*/
    public void unvisitHeroes() {
        for (Hero hero:heroes) {
            hero.setVisited(false);
        }
    }

    /**this method is where the game actually takes place.*/
    public void play() {
        //add observer
        addObserver(ObserversFactory.newGreatWizard());

        //play each round
        for (int currentRound = 0; currentRound < nrRounds; currentRound++) {
            //memorize if angels were spawned
            boolean spawned = false;

            //start round
            notifyAllObservers(currentRound + 1);

            for (int currentHero = 0; currentHero < nrHeroes; currentHero++) {
                //move hero if he is not dead
                if (heroes[currentHero].getHitPoints() <= 0) {
                    continue;
                }

                int incapacity = heroes[currentHero].getBuffs().
                        getIncapacity().size();

                //move hero
                heroes[currentHero].move(heroesMoves[currentRound].
                        charAt(currentHero));

                //activate damage over time
                heroes[currentHero].activateBuffs();

                //apply strategy
                if (incapacity == 0) {
                    heroes[currentHero].acceptStrategy();
                }

                //add hero to map
                if (heroes[currentHero].getHitPoints() > 0) {
                    if (heroes[currentHero].getPosition().getY() != -1) {
                        Map.getInstance().
                                getMapUnit()[heroes[currentHero].
                                getPosition().getX()]
                                [heroes[currentHero].getPosition().getY()].
                                getHeroesIndex().add(currentHero);
                    }
                }
            }

            //search for battles battles if exist
            for (int firstHero = 0; firstHero < heroes.length; firstHero++) {
                for (int secondHero = firstHero + 1; secondHero
                        < heroes.length; secondHero++) {
                    if (heroes[firstHero].getPosition().
                            equals(heroes[secondHero].getPosition())
                            && heroes[firstHero].getHitPoints() > 0
                            && heroes[secondHero].getHitPoints() > 0) {

                        int row = heroes[firstHero].getPosition().getX();
                        int column = heroes[secondHero].getPosition().getY();
                        Hero hero1 = heroes[Map.getInstance().
                                getMapUnit()[row][column].
                                getHeroesIndex().get(0)];
                        Hero hero2 = heroes[Map.getInstance().
                                getMapUnit()[row][column].
                                getHeroesIndex().get(1)];

                        //hero1 attacks hero2
                        /*case rogue vs wizard needed to
                        memorize when to apply critical hit.*/
                        if (hero2.getType() == 'R'
                                && Map.getInstance().
                                getMapUnit()[row][column].getType() == 'W') {
                            ((Rogue) (hero2)).setRound(((Rogue)
                                    (hero2)).getRound() + 1);
                            hero2.activateDamage(hero1,
                                    Map.getInstance().
                                            getMapUnit()[row][column].
                                            getLandType());
                            ((Rogue) (hero2)).
                                    setRound(((Rogue)
                                            (hero2)).getRound() - 1);
                        } else {
                            hero2.activateDamage(hero1,
                                    Map.getInstance().
                                            getMapUnit()[row][column].
                                            getLandType());
                        }
                        //hero2 attacks hero1
                        hero1.activateDamage(hero2,
                                Map.getInstance().
                                        getMapUnit()[row][column].
                                        getLandType());

                        //set damage received
                        hero2.setHitPoints(hero2.getHitPoints() - hero1.
                                getDamageDealt());
                        hero1.setHitPoints(hero1.getHitPoints() - hero2.
                                getDamageDealt());

                        //check winner
                        int hero2HitPoints = hero2.getHitPoints();
                        int hero2Level = hero2.getLevel();

                        //notify after fight
                        notifyAllObservers(hero2, hero1);

                        //case hero1 dies
                        if (hero1.getHitPoints() <= 0 && hero2.
                                getHitPoints() > 0) {
                            hero2.addExperience(hero1.getLevel());
                        }

                        //case hero2 dies
                        if (hero2HitPoints <= 0
                                && hero1.getHitPoints() > 0) {
                            hero1.addExperience(hero2Level);
                        }
                    }
                }
            }

            //spawn angels and free map
            for (int row = 0; row < mapRows; row++) {
                for (int column = 0; column < mapColumns; column++) {
                    //activate angels
                    for (Angel angel:angels[currentRound]) {
                        if (!spawned) {
                            notifyAllObservers(angel);
                        }
                        for (Hero hero:heroes) {
                            if (hero.getPosition().
                                    equals(angel.getPosition())) {
                                if (!hero.isVisited()) {
                                    hero.accept(angel);
                                }
                            }
                        }
                    }
                    for (Hero hero:heroes) {
                        hero.setVisited(true);
                    }
                    spawned = true;
                    //free map
                    Map.getInstance().
                            getMapUnit()[row][column].getHeroesIndex().clear();
                }
            }
            //end round
            notifyAllObservers();
            unvisitHeroes();
        }
        //end play
        notifyAllObservers(heroes);
    }

    /**@param observer is added to list.*/
    @Override
    public void addObserver(final Observer observer) {
        observers.add(observer);
    }

    /**method to be overloaded.*/
    @Override
    public void notifyAllObservers() {
        for (Observer observer:observers) {
            observer.update();
        }
    }

    /**@param hero is param.*/
    public void notifyAllObservers(final Hero hero) {
        for (Observer observer:observers) {
            observer.update(hero);
        }
    }

    /**@param angel is param.*/
    public void notifyAllObservers(final Angel angel) {
        for (Observer observer:observers) {
            observer.update(angel);
        }
    }

    /**@param hero and
     * @param angel are params.*/
    public void notifyAllObservers(final Hero hero, final Angel angel) {
        for (Observer observer:observers) {
            observer.update(hero, angel);
        }
    }

    /**@param hero1 and
     * @param hero2 are params.*/
    public void notifyAllObservers(final Hero hero1, final Hero hero2) {
        for (Observer observer:observers) {
            observer.update(hero1, hero2);
        }
    }

    /**@param round is round to be written in output.*/
    public void notifyAllObservers(final int round) {
        for (Observer observer:observers) {
            observer.update(round);
        }
    }

    /**@param heroes1 to write status of every hero.*/
    public  void notifyAllObservers(final Hero[]heroes1) {
        for (Observer observer:observers) {
            observer.update(heroes1);
        }
    }
}
