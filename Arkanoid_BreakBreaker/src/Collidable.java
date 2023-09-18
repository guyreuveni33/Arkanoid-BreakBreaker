// 206398596 Guy Reuveni

/**
 * this interface of the collidable of the game.
 *
 * @author Guy Reuveni.
 */
public interface Collidable {
    /**
     * this return the "collision shape" of the object.
     *
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();


    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param hitter          a ball.
     * @param collisionPoint  a collision point.
     * @param currentVelocity a velocity.
     * @return is the new velocity expected after the hit.
     */

    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
