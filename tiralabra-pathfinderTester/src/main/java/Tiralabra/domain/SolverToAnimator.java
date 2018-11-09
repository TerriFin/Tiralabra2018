package Tiralabra.domain;

import Tiralabra.domain.Node;

public class SolverToAnimator {
    public Node[][] labyrinth;
    public boolean lastFrame;
    
    public SolverToAnimator(Node[][] labyrinth, boolean lastFrame) {
        this.labyrinth = labyrinth;
        this.lastFrame = lastFrame;
    }
}
