package Tiralabra.domain;

import Tiralabra.domain.Node;

/**
 * Needed to pass labyrinth and boolean in one return statement, 
 * now also returns taken steps and ultimately the found path length
 * 
 * @author samisaukkonen
 */
public class SolverToAnimator {
    public Node node;
    public Node[][] labyrinth;
    public boolean labyrinthSolved;
    public int steps;
    public int pathLength;
    /**
     * 
     * @param labyrinth labyrinth to return, can be "completed" with marked found path
     * @param labyrinthSolved boolean stating if this is the last (completed) labyrinth from this algorithm
     * @param steps algorithm steps taken to get the current labyrinth
     * @param pathLength final path length after one is found
     */
    public SolverToAnimator(Node node, Node[][] labyrinth, boolean labyrinthSolved, int steps, int pathLength) {
        this.node = node;
        this.labyrinth = labyrinth;
        this.labyrinthSolved = labyrinthSolved;
        this.steps = steps;
        this.pathLength = pathLength;
    }
}
