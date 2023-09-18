// 206398596 Guy Reuveni

/**
 * this class remove block from the game.
 *
 * @author Guy Reuveni.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * this is the ball remover constructor.
     *
     * @param game            a game.
     * @param remainingBlocks the numbers of blocks remain.
     */
    public BlockRemover(GameLevel game, Counter remainingBlocks) {
        this.game = game;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * this remove the block from the game.
     *
     * @param beingHit the block that got a hit.
     * @param hitter   a ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.game);
        remainingBlocks.decrease(1);
    }
}