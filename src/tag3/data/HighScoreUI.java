
package tag3.data;

import tag3.logic.HighScore;
import tag3.logic.Player;

public interface HighScoreUI {
    public void addHighscoreToFile(String file, HighScore highscore, Player player);
    public void sortHighscoreInFile();
}
