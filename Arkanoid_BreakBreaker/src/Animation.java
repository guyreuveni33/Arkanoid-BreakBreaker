// 206398596 Guy Reuveni

import biuoop.DrawSurface;

/**
 * this interface of the Animation.
 */
public interface Animation {
    /**
     * this creates the frame.
     *
     * @param d a DrawSurface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * this check if the frame should stop.
     *
     * @return true or false according the need for the frame.
     */
    boolean shouldStop();
}