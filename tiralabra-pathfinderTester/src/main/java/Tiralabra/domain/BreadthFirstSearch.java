package Tiralabra.domain;

import java.util.ArrayDeque;
import java.util.HashSet;

public class BreadthFirstSearch {

    private Node current;
    private ArrayDeque<Node> queue;
    private Node goal;
    private Node[][] labyrinth;

    public BreadthFirstSearch(Node[][] labyrinth) {
        this.current = new Node(1, 1, 3, null);
        this.queue = new ArrayDeque<>();
        this.goal = new Node(labyrinth.length - 2, labyrinth[0].length - 2, 5, null);
        this.labyrinth = labyrinth;

        this.queue.add(current);
    }

    public Node[][] checkIfThereIsPath() {
        while (!queue.isEmpty()) {
            labyrinth[current.x][current.y].value = 2;

            current = queue.poll();

            if (current.equals(goal)) {
                labyrinth[current.x][current.y].value = 5;
                markPathToCurrentNode();
                return labyrinth;
            }
            
            labyrinth[current.x][current.y].value = 4;

            checkAdjacentNodes();
        }

        System.out.println("LOPPPUU");
        return labyrinth;
    }

    private void markPathToCurrentNode() {
        Node currentHere = current.parent;
        
        while(currentHere.parent != null) {
            labyrinth[currentHere.x][currentHere.y].value = 6;
            currentHere = currentHere.parent;
        }
    }
    
    private void checkAdjacentNodes() {
        if (labyrinth[current.x - 1][current.y].value == 0 || labyrinth[current.x - 1][current.y].value == 5) {
            labyrinth[current.x - 1][current.y].parent = current;
            queue.add(labyrinth[current.x - 1][current.y]);
            labyrinth[current.x - 1][current.y].value = 3;
        }

        if (labyrinth[current.x + 1][current.y].value == 0 || labyrinth[current.x + 1][current.y].value == 5) {
            labyrinth[current.x + 1][current.y].parent = current;
            queue.add(labyrinth[current.x + 1][current.y]);
            labyrinth[current.x + 1][current.y].value = 3;
        }

        if (labyrinth[current.x][current.y - 1].value == 0 || labyrinth[current.x][current.y - 1].value == 5) {
            labyrinth[current.x][current.y - 1].parent = current;
            queue.add(labyrinth[current.x][current.y - 1]);
            labyrinth[current.x][current.y - 1].value = 3;
        }

        if (labyrinth[current.x][current.y + 1].value == 0 || labyrinth[current.x][current.y + 1].value == 5) {
            labyrinth[current.x][current.y + 1].parent = current;
            queue.add(labyrinth[current.x][current.y + 1]);
            labyrinth[current.x][current.y + 1].value = 3;
        }
    }
}
