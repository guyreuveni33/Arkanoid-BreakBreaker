// 206398596 Guy Reuveni

/**
 * this class remove ball from the game.
 *
 * @author Guy Reuveni.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * this is the ball remover constructor.
     *
     * @param game           a game.
     * @param remainingBalls the numbers of ball remain.
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    /**
     * this remove the ball from the game.
     *
     * @param beingHit the block that got a hit.
     * @param hitter   a ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        remainingBalls.decrease(1);
    }
}