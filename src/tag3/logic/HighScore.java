
package tag3.logic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HighScore {
    
    private long start, end, gametime;
    private SimpleDateFormat timeformat;
    private Date time;

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public void setStart() {
        this.start = System.currentTimeMillis();
    }

    public void setEnd() {
        this.end = System.currentTimeMillis();
    }

    public String getHighscoreInfo(Player player) {
        gametime = end - start;

        timeformat = new SimpleDateFormat("mm:ss:SSS");  
        
        time = new Date(gametime);
        
        return timeformat.format(time) + " " + player.getName();
    }
}
