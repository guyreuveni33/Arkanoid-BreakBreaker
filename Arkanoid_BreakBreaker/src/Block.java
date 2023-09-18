// 206398596 Guy Reuveni

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

import biuoop.DrawSurface;

/**
 * this will create a block.
 *
 * @author Guy Reuveni.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangular;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     * this  * this constructor insert the ball the arguments.
     *
     * @param rec   rectangular.
     * @param color color of the rectangular.
     */
    public Block(Rectangle rec, Color color) {
        this.rectangular = rec;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * this will return the collision rectangle.
     *
     * @return the rectangular.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangular;
    }

    /**
     * this will add the block to the game.
     *
     * @param g the game the vlock will be added to.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * this draw the block on the given DrawSurface.
     *
     * @param d a draw surface.
     */
    public void drawOn(DrawSurface d) {
        //this will set the color
        d.setColor(this.color);
        //this will fill the rectangle in color
        d.fillRectangle((int) this.rectangular.getUpperLeft().getX(), (int) this.rectangular.getUpperRight().getY(),
                (int) this.rectangular.getWidth(), (int) this.rectangular.getHeight());
        //this will set the color black
        d.setColor(Color.BLACK);
        //this will draw the rectangle
        d.drawRectangle((int) this.rectangular.getUpperLeft().getX(), (int) this.rectangular.getUpperRight().getY(),
                (int) this.rectangular.getWidth(), (int) this.rectangular.getHeight());
    }

    /**
     * notify the sprite that time has passed, will be use in the future.
     */
    public void timePassed() {
    }


    /**
     * this will update the Velocity in case of hit.
     *
     * @param hitter          a ball.
     * @param collisionPoint  point of the collision.
     * @param currentVelocity the velocity of the ball.
     * @return the new Velocity after the hit .
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        int multipleX = 1, multipleY = 1;
        double collisionX = collisionPoint.getX();
        double collisionY = collisionPoint.getY();
        double velDx = currentVelocity.getDx();
        double velDy = currentVelocity.getDy();
        Velocity newVel = currentVelocity;
        //this check if there is collision with the rectangular and change the velocity according to
        if (Line.doubleEquals(collisionY, this.rectangular.getLowerRight().getY())) {
            //this will set the velocity to the opposite direction
            multipleY = -1;
        }
        //this check if there is collision with the rectangular and change the velocity according to
        if (Line.doubleEquals(collisionY, this.rectangular.getUpperLeft().getY())) {
            //this will set the velocity to the opposite direction
            multipleY = -1;
        }
        //this check if there is collision with the rectangular and change the velocity according to
        if (Line.doubleEquals(collisionX, this.rectangular.getLowerRight().getX())) {
            //this will set the velocity to the opposite direction
            multipleX = -1;
        }
        //this check if there is collision with the rectangular and change the velocity according to
        if (Line.doubleEquals(collisionX, this.rectangular.getUpperLeft().getX())) {
            //this will set the velocity to the opposite direction
            multipleX = -1;
        }
        newVel = new Velocity(multipleX * velDx, multipleY * velDy);
        return newVel;
    }

    /**
     * this remove block from game.
     *
     * @param game
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    /**
     * this notifies when a block hit.
     *
     * @param hitter a ball.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * Add hl as a listener to hit events.
     *
     * @param hl a hitlistener.
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl a hitlistener.
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}


