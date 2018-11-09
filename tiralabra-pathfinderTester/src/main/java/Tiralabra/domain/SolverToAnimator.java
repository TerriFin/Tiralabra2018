package Tiralabra.domain;

import Tiralabra.domain.Node;

/**
 * Needed to pass labyrinth and boolean if this labyrinth is done in one return statement
 * 
 * @author samisaukkonen
 */
public class SolverToAnimator {
    public Node[][] labyrinth;
    public boolean lastFrame;
    
    /**
     * 
     * @param labyrinth labyrinth to return, can be "completed" with marked found path
     * @param lastFrame boolean stating if this is the last (completed) labyrinth from this algorithm
     */
    public SolverToAnimator(Node[][] labyrinth, boolean lastFrame) {
        this.labyrinth = labyrinth;
        this.lastFrame = lastFrame;
    }
}
