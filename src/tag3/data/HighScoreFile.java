package tag3.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class HighScoreFile implements HighScoreUI {

    @Override
    public void addHighscoreToFile(String file, String input_highscore) {
        try {
            ArrayList<String> arrHighscore = readHighscoreInFile(file);

            if (arrHighscore.isEmpty()) {
                PrintWriter out = new PrintWriter(file);
                out.println(input_highscore);
                out.flush();
                out.close();
            } else {
                arrHighscore.add(input_highscore);
                Collections.sort(arrHighscore);
                PrintWriter out = new PrintWriter(file);
                for (String line : arrHighscore) {
                    out.println(line);
                    out.flush();

                }
                out.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<String> readHighscoreInFile(String file) {
        try {
            Path path = Paths.get(file);
            ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(path);
            return lines;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
