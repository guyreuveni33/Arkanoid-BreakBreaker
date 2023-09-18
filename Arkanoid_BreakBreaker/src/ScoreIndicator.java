// 206398596 Guy Reuveni

import biuoop.DrawSurface;

import java.awt.Color;


/**
 * this class is a scoreIndicator.
 *
 * @author Guy Reuveni.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * this is the scoreIndicator constructor.
     *
     * @param score a score.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    /**
     * this draw the score on the surface.
     *
     * @param d a draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(370, 15, "Score: " + this.score.getValue(), 17);
    }

    /**
     * none.
     */
    public void timePassed() {
    }

    /**
     * this adds the scoreIndicator to the game.
     *
     * @param g a game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
