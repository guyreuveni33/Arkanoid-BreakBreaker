// 206398596 Guy Reuveni

/**
 * this interface is a HitListener.
 *
 * @author Guy Reuveni.
 */
public interface HitListener {

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit a block.
     * @param hitter   a ball.
     */
    void hitEvent(Block beingHit, Ball hitter);
}