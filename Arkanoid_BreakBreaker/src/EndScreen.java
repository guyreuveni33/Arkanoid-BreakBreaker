// 206398596 Guy Reuveni

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * this class of the End Screen of the game.
 *
 * @author Guy Reuveni.
 */
public class EndScreen implements Animation {

    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter scoreTracker;
    private Boolean winOrLose;

    /**
     * this is the EndScreen constructor.
     *
     * @param k            a keyboardSensor.
     * @param scoreTracker track the score of the player.
     * @param winOrLose    status of the player on the game.
     */
    public EndScreen(KeyboardSensor k, Counter scoreTracker, Boolean winOrLose) {
        this.keyboard = k;
        this.stop = false;
        this.scoreTracker = scoreTracker;
        this.winOrLose = winOrLose;
    }

    /**
     * this does the frame of the EndScreen.
     *
     * @param d a DrawSurface.
     */
    public void doOneFrame(DrawSurface d) {
        if (this.winOrLose) {
            d.drawText(330, 265, "You Win!", 30);
            d.drawText(270, 315, "Your score is " + this.scoreTracker.getValue(), 30);
        } else {
            d.drawText(330, 265, "Game Over.", 30);
            d.drawText(270, 315, "Your score is " + this.scoreTracker.getValue(), 30);
        }
        d.setColor(Color.black);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * this check if the screen should stop.
     *
     * @return true or false.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}