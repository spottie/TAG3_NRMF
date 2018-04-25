
package tag3;

import tag3.logic.Controller;
import tag3.logic.Player;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        
        new Controller(new Player()).play();
    }
    
}
