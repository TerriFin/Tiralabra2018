package Tiralabra.domain;

import Tiralabra.domain.solvers.AStar;
import Tiralabra.domain.solvers.BreadthFirst;
import Tiralabra.domain.solvers.DepthFirst;

/**
 * Handles the solvers and sends each step of their work to animator
 * 
 * @author samisaukkonen
 */
public class SolverManager {
    private BreadthFirst breadthFirst;
    private DepthFirst DepthFirst;
    private AStar AStar;

    /**
     * 
     * @param labyrinth Labyrinth that is going to be solved with the different algorithms
     */
    public SolverManager(Node[][] labyrinth) {
        this.breadthFirst = new BreadthFirst(labyrinth.clone());
    }

    /**
     * Returns next step in breadth-first algorithm, when done marks the found path and sends signal that
     * this is in fact the last output from this algorithm
     * 
     * @return returns a SolverToAnimator class object, which just contains the labyrinth and a signal
     * telling if this labyrinth is completed.
     */
    public SolverToAnimator getNextBreadth() {
        boolean isLast = breadthFirst.processStep();
        
        if (isLast) {
            breadthFirst.MarkPathToCurrent();
            return new SolverToAnimator(breadthFirst.labyrinth, isLast);
        }
        
        return new SolverToAnimator(breadthFirst.labyrinth, isLast);
    }
    
    public SolverToAnimator getNextDepth() {
        return null;
    }
    
    public SolverToAnimator getNextStar() {
        return null;
    }
}
