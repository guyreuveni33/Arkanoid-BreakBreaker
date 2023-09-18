// 206398596 Guy Reuveni

import java.awt.Color;

/**
 * this is the level 3 class.
 *
 * @author Guy Reuveni.
 */
public class Level3 extends PrimaryLevel {
    /**
     * this is the level 3 constructor.
     */
    public Level3() {
        super();
        super.numberOfBalls();
        super.setLevelName("The Building");
        super.setPaddle(5, 150);
        for (int i = 0; i < 2; i++) {
            super.addBallToList(new Ball(335 + (i * 70), 555, 5, Color.RED));
        }
        Color[] colors = {Color.GRAY, Color.RED, Color.YELLOW, Color.BLUE, Color.WHITE};
        int blocksCounter = 10;
        for (int i = 0; i < 5; i++) {
            int height = 150 + (i * 20);
            for (int j = i; j < 10; j++) {
                super.addBlockToList(new Block(new Rectangle(new Point(730 - ((j - i) * 50), height), 50,
                        20), colors[i]));
            }
        }
        super.setBackground(new Block(new Rectangle(new Point(0, 0), 800, 600), Color.WHITE));
    }
}


