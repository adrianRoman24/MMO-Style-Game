package game;

import greatwizard.Observer;

import java.io.FileWriter;
import java.io.IOException;

public class GameOutputWriter {
    /**@param file is param where output is written.
     * @param game is the game that receives the data
     * @throws IOException */
    public void writeOutput(final String file,
                            final Game game) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (Observer observer:game.getObservers()) {
            fileWriter.write(observer.state().toString());
        }
        fileWriter.close();
    }
}
