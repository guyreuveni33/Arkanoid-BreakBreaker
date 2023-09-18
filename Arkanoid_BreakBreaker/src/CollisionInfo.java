// 206398596 Guy Reuveni

/**
 * * this class create a CollisionInfo.
 *
 * @author Guy Reuveni.
 */
public class CollisionInfo {
    private Point point;
    private Collidable col;

    /**
     * this constructor insert the arguments to the CollisionInfo.
     *
     * @param point a point.
     * @param col   a collidable.
     */
    public CollisionInfo(Point point, Collidable col) {
        this.point = point;
        this.col = col;
    }


    /**
     * this return the point at which the collision occurs.
     *
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.point;
    }


    /**
     * this return the collidable object involved in the collision.
     *
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.col;
    }
}