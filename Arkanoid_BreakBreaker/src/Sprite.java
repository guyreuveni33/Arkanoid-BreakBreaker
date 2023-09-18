import biuoop.DrawSurface;

/**
 * this interface responsible for the sprite of the game.
 *
 * @author Guy Reuveni.
 */
public interface Sprite {

    /**
     * draw the sprite to the screen.
     *
     * @param d a draw surface.
     */
    void drawOn(DrawSurface d);

    /**
     * this notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * this added the sprite to the game.
     *
     * @param g a game.
     */
    void addToGame(GameLevel g);
}