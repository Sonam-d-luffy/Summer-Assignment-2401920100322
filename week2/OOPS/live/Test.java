package live;

import music.Playable;
import music.string.Veena;
import music.wind.Saxophone;

public class Test {
    public static void main(String[] args) {
    Veena veena = new Veena();
    Saxophone sexophone = new Saxophone();
    veena.play();
    sexophone.play();

    Playable p1 = new Veena();
    Playable p2 = new Saxophone();
    p1.play();
    p2.play();
    }
    
}
