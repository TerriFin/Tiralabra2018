package Tiralabra.domain;

import Tiralabra.domain.solvers.AStar;
import Tiralabra.domain.solvers.BreadthFirst;
import Tiralabra.domain.solvers.DepthFirst;

public class SolverManager {
    private BreadthFirst breadthFirst;
    private DepthFirst DepthFirst;
    private AStar AStar;

    public SolverManager(Node[][] labyrinth) {
        this.breadthFirst = new BreadthFirst(labyrinth.clone());
    }

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
