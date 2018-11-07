package Tiralabra.domain;

import java.util.ArrayDeque;
import java.util.HashSet;

public class BreadthFirstSearch {
    private Node current;
    private ArrayDeque<Node> queue;
    private HashSet<Node> closed;
    private Node goal;
    private int[][] labyrinth;
    
    public BreadthFirstSearch(int[][] labyrinth) {
        this.current = new Node(1, 1, 3);
        this.queue = new ArrayDeque<>();
        this.closed = new HashSet<>();
        this.goal = new Node(labyrinth.length - 1, labyrinth[0].length - 1, 4);
        this.labyrinth = labyrinth;
        
        this.labyrinth[1][1] = 3;
        this.labyrinth[labyrinth.length - 2][labyrinth[0].length - 2] = 4;
    }
    
    public int[][] getLabyrinth() {
        return labyrinth;
    }
}
