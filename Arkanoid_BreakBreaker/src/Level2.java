// 206398596 Guy Reuveni

import java.awt.Color;

/**
 * this is the level 2 class.
 *
 * @author Guy Reuveni.
 */
public class Level2 extends PrimaryLevel {
    /**
     * this is the level 2 constructor.
     */
    public Level2() {
        super();
        super.numberOfBalls();
        super.setLevelName("Circus");
        super.setPaddle(5, 500);
        for (int i = 0; i < 10; i++) {
            super.addBallToList(new Ball(160 + (i * 48), 552, 5, Color.GRAY.brighter()));
        }
        Color[] colors = {Color.CYAN, Color.CYAN, Color.PINK, Color.PINK, Color.BLUE, Color.BLUE, Color.GREEN,
                Color.GREEN, Color.GREEN, Color.YELLOW, Color.YELLOW, Color.ORANGE, Color.ORANGE, Color.RED, Color.RED};
        for (int i = 0; i < 15; i++) {
            super.addBlockToList(new Block(new Rectangle(new Point(25 + (i * 50), 270), 50,
                    20), colors[i]));
        }
        super.setBackground(new Block(new Rectangle(new Point(0, 0), 800, 600), Color.BLUE.brighter()));
    }
}


