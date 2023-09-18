// 206398596 Guy Reuveni

import java.util.List;
import java.util.ArrayList;

import biuoop.DrawSurface;

/**
 * this class create a SpriteCollection.
 *
 * @author Guy Reuveni.
 */
public class SpriteCollection {
    private List<Sprite> list;

    /**
     * the constructor create a new list of sprite.
     */
    public SpriteCollection() {
        this.list = new ArrayList<>();
    }

    /**
     * this add a sprite to the sprite list.
     *
     * @param s a sprite.
     */
    public void addSprite(Sprite s) {
        list.add(s);
    }

    /**
     * this remove a sprite from the sprite list.
     *
     * @param s a sprite.
     */
    public void removeSprite(Sprite s) {
        list.remove(s);
    }

    /**
     * this call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).timePassed();
        }
    }

    /**
     * this call drawOn(d) on all sprites.
     *
     * @param d a draw surface.
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).drawOn(d);
        }
    }
}