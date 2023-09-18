// 206398596 Guy Reuveni

/**
 * this interface indicates that objects that implement it send notifications when they are being hit.
 *
 * @author Guy Reuveni.
 */
public interface HitNotifier {

    /**
     * add hl as a listener to hit events.
     *
     * @param hl a hitlistener.
     */
    void addHitListener(HitListener hl);

    /**
     * remove hl from the list of listeners to hit events.
     *
     * @param hl a hitlistener.
     */
    void removeHitListener(HitListener hl);
}