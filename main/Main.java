package main;

import game.Game;
import game.GameInputLoader;
import game.GameOutputWriter;

import java.io.IOException;

public final class Main {
    private Main() { }
    /**@param args are the input and output files.
     * @throws IOException */
    public static void main(final String[] args) throws IOException {
        GameInputLoader gameInputLoader = new GameInputLoader();
        gameInputLoader.load(args[0]);
        Game game = new Game();
        gameInputLoader.loadGame(game);
        game.play();
        GameOutputWriter gameOutputWriter = new GameOutputWriter();
        gameOutputWriter.writeOutput(args[1], game);
    }
}
