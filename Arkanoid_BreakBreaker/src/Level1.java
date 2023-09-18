// 206398596 Guy Reuveni


import java.awt.Color;

/**
 * this is the level 1 class.
 *
 * @author Guy Reuveni.
 */
public class Level1 extends PrimaryLevel {
    /**
     * this is the level 1 constructor.
     */
    public Level1() {
        super();
        super.numberOfBalls();
        super.setLevelName("Direct Hit");
        super.setPaddle(5, 150);
        super.addBallToList(new Ball(400, 550, 5, Color.WHITE));
        super.addBlockToList(new Block(new Rectangle(new Point(385, 200), 30, 30), Color.RED));
        super.setBackground(new Block(new Rectangle(new Point(0, 0), 800, 600), Color.BLACK));

    }
}
