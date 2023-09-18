// 206398596 Guy Reuveni

import java.awt.Color;

/**
 * this is the level 4 class.
 *
 * @author Guy Reuveni.
 */
public class Level4 extends PrimaryLevel {
    /**
     * this is the level 4 constructor.
     */
    public Level4() {
        super();
        super.numberOfBalls();
        super.setLevelName("The Road");
        super.setPaddle(5, 150);
        for (int i = 0; i < 3; i++) {
            super.addBallToList(new Ball(335 + (i * 43), 555, 5, Color.BLUE));
        }
        Color[] colors = {Color.GRAY, Color.RED, Color.YELLOW, Color.GREEN, Color.WHITE, Color.PINK, Color.CYAN};
        int blocksCounter = 15;
        for (int i = 0; i < 7; i++) {
            int height = 230 - (i * 20);
            for (int j = 0; j < 15; j++) {
                super.addBlockToList(new Block(new Rectangle(new Point(25 + (j * 50), height), 50,
                        20), colors[i]));
            }
        }
        super.setBackground(new Block(new Rectangle(new Point(0, 0), 800, 600), Color.BLUE));
    }
}
