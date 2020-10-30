package game;

import angels.Angel;
import angels.AngelsFactory;
import fileio.implementations.FileReader;
import heroes.Hero;
import heroes.HeroesFactory;

import java.io.IOException;
import java.util.ArrayList;

public class GameInputLoader {
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
    /**@param inputFile is param.
     * @throws IOException */
    public void load(final String inputFile) throws IOException {
        //read input
        FileReader fileReader = new FileReader(inputFile);
        mapRows = fileReader.nextInt();
        mapColumns = fileReader.nextInt();
        Map.getInstance().setMapUnit(mapRows, mapColumns);
        for (int row = 0; row < mapRows; row++) {
            String string = fileReader.nextWord();
            for (int column = 0; column < string.length(); column++) {
                Map.getInstance().getMapUnit()[row][column] = new MapUnit(string.charAt(column));
            }
        }

        nrHeroes = fileReader.nextInt();
        heroes = new Hero[nrHeroes];

        for (int nrCurrent = 0; nrCurrent < nrHeroes; nrCurrent++) {
            String type = fileReader.nextWord();
            int xCoordinate = fileReader.nextInt();
            int yCoordinate = fileReader.nextInt();
            heroes[nrCurrent] = HeroesFactory.getInstance().
                    newHero(type.charAt(0), xCoordinate, yCoordinate);
        }

        nrRounds = fileReader.nextInt();
        heroesMoves = new String[nrRounds];
        angels = new ArrayList[nrRounds];

        for (int round = 0; round < nrRounds; round++) {
            heroesMoves[round] = fileReader.nextWord();
        }

        //read angels
        for (int round = 0; round < nrRounds; round++) {
            int nrAngelsThisRound = fileReader.nextInt();
            angels[round] = new ArrayList<>();

            for (int currentAngel = 0; currentAngel
                    < nrAngelsThisRound; currentAngel++) {
                String string = fileReader.nextWord();

                int firstComma = -1;
                int secondComma = -1;
                for (int i = 0; i < string.length(); i++) {
                    if (string.charAt(i) == ',') {
                        if (firstComma == -1) {
                            firstComma = i;
                        } else {
                            secondComma = i;
                        }
                    }
                }

                int xCoordinate = Integer.parseInt(string.substring(firstComma
                        + 1, secondComma));
                int yCoordinate = Integer.parseInt(string.substring(secondComma
                        + 1, string.length()));

                String angelType = string.substring(0, firstComma);

                angels[round].add(AngelsFactory.getInstance().
                        newAngel(angelType, xCoordinate, yCoordinate));
            }
        }
        fileReader.close();
    }

    /**@param game receives the data from this class.*/
    public void loadGame(final Game game) {
        game.setHeroes(heroes);
        game.setHeroesMoves(heroesMoves);
        game.setMapColumns(mapColumns);
        game.setMapRows(mapRows);
        game.setNrHeroes(nrHeroes);
        game.setNrRounds(nrRounds);
        game.setAngels(angels);
        //keep a reference to the game
        for (Hero hero:heroes) {
            hero.setGame(game);
        }
        for (ArrayList<Angel> angel:angels) {
            for (Angel angel2:angel) {
                angel2.setGame(game);
            }
        }
    }
}
