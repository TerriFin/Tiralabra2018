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
    public Node[][] originalLabyrinth;
    
    private final BreadthFirst breadthFirst;
    private final DepthFirst DepthFirst;
    private final AStar AStar;
    
    public Node[][] solvedBreadthLabyrinth;
    public Node[][] solvedDepthLabyrinth;
    public Node[][] solvedStarLabyrinth;

    /**
     * @param labyrinth Labyrinth that is going to be solved with the different algorithms
     */
    public SolverManager(Node[][] labyrinth) {
        this.originalLabyrinth = deepClone(labyrinth);
        
        this.breadthFirst = new BreadthFirst(deepClone(labyrinth));
        this.DepthFirst = new DepthFirst(deepClone(labyrinth));
        this.AStar = new AStar(deepClone(labyrinth));
    }

    /**
     * Returns next step in breadth-first algorithm, when done marks the found path and sends signal that
     * this is in fact the last output from this algorithm also always passes steps taken in this algorithm and final path length
     * 
     * @return returns a SolverToAnimator class object, which just contains the labyrinth and a signal
     * telling if this labyrinth is completed.
     */
    public SolverToAnimator getNextBreadth() {
        boolean isLast = breadthFirst.processStep();
        
        if (isLast) {
            solvedBreadthLabyrinth = breadthFirst.labyrinth;
            return new SolverToAnimator(breadthFirst.current, breadthFirst.labyrinth, isLast, breadthFirst.steps, breadthFirst.MarkPathToCurrent());
        }
        
        return new SolverToAnimator(breadthFirst.current, breadthFirst.labyrinth, isLast, breadthFirst.steps, 0);
    }
    
    /**
     * Returns next step in depth-first algorithm, when done marks the found path and sends signal that
     * this is in fact the last output from this algorithm also always passes steps taken in this algorithm and final path length
     * 
     * @return returns a SolverToAnimator class object, which just contains the labyrinth and a signal
     * telling if this labyrinth is completed.
     */
    public SolverToAnimator getNextDepth() {
        boolean isLast = DepthFirst.processStep();
        
        if (isLast) {
            solvedDepthLabyrinth = DepthFirst.labyrinth;
            return new SolverToAnimator(DepthFirst.current, DepthFirst.labyrinth, isLast, DepthFirst.steps, DepthFirst.markPathToCurrent());
        }
        
        return new SolverToAnimator(DepthFirst.current, DepthFirst.labyrinth, isLast, DepthFirst.steps, 0);
    }
    
    /**
     * Returns next step in star-first algorithm, when done marks the found path and sends signal that
     * this is in fact the last output from this algorithm also always passes steps taken in this algorithm and final path length
     * 
     * @return returns a SolverToAnimator class object, which just contains the labyrinth and a signal
     * telling if this labyrinth is completed.
     */
    public SolverToAnimator getNextStar() {
        boolean isLast = AStar.processStep();
        
        if (isLast) {
            solvedStarLabyrinth = AStar.labyrinth;
            return new SolverToAnimator(AStar.current, AStar.labyrinth, isLast, AStar.steps, AStar.markPathToCurrent());
        }
        
        return new SolverToAnimator(AStar.current, AStar.labyrinth, isLast, AStar.steps, 0);
    }
    
    private Node[][] deepClone(Node[][] labyrinth) {
        Node[][] newLabyrinth = new Node[labyrinth.length][labyrinth[0].length];
        
        for (int x = 0; x < labyrinth.length; x++) {
            for (int y = 0; y < labyrinth[0].length; y++) {
                newLabyrinth[x][y] = new Node(labyrinth[x][y].x, labyrinth[x][y].y, labyrinth[x][y].value, null);
            }
        }
        
        return newLabyrinth;
    }
}
