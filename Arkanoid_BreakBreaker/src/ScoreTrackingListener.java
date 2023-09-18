// 206398596 Guy Reuveni

/**
 * this class track the score.
 *
 * @author Guy Reuveni.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * this is the scoreTrackingListener constructor.
     *
     * @param scoreCounter a counter for the score.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * this count the hits.
     *
     * @param beingHit a block.
     * @param hitter   a ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}