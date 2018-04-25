
package tag3.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import tag3.logic.HighScore;
import tag3.logic.Player;

public class HighScoreFile implements HighScoreUI {

    @Override
    public void addHighscoreToFile(String file, HighScore highscore, Player player) {
        try {
            String print = highscore.getHighscoreInfo(player);
            Path path = Paths.get(file);
            Files.write(path, print.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void sortHighscoreInFile() {
        
    }
    

    
}
