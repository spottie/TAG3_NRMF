
package tag3.data;

import java.util.ArrayList;

public interface HighScoreUI {
    public void addHighscoreToFile(String file, String input_highscore);
    public ArrayList<String> readHighscoreInFile(String file);
}
