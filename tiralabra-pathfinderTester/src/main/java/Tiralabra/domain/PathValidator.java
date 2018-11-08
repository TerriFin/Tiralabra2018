package Tiralabra.domain;

import java.util.ArrayDeque;
import java.util.HashSet;

public class PathValidator {

    private Node current;
    private Node goal;
    private ArrayDeque<Node> queue;
    private HashSet<Node> closed;

    public boolean checkIfThereIsPath(Node[][] labyrinth) {
        this.current = labyrinth[1][1];
        this.goal = labyrinth[labyrinth.length - 2][labyrinth[0].length - 2];
        this.queue = new ArrayDeque<>();
        this.closed = new HashSet<>();

        this.queue.add(current);
        this.closed.add(current);
        
        // Start the actual algorithm
        while (!queue.isEmpty()) {
            current = queue.poll();

            if (current.equals(goal)) {
                return true;
            }

            checkAdjacentNodes(labyrinth);
        }

        return false;
    }

    public void markPathToGoal(Node[][] labyrinth) {
        checkIfThereIsPath(labyrinth);
        
        Node currentHere = current.parent;
        
        while(currentHere.parent != null) {
            labyrinth[currentHere.x][currentHere.y].value = 6;
            currentHere = currentHere.parent;
        }
    }
    
    private void checkAdjacentNodes(Node[][] labyrinth) {
        if (labyrinth[current.x - 1][current.y].value != 1 && !closed.contains(labyrinth[current.x - 1][current.y])) {
            labyrinth[current.x - 1][current.y].parent = current;
            queue.add(labyrinth[current.x - 1][current.y]);
            closed.add(labyrinth[current.x - 1][current.y]);
        }

        if (labyrinth[current.x + 1][current.y].value != 1 && !closed.contains(labyrinth[current.x + 1][current.y])) {
            labyrinth[current.x + 1][current.y].parent = current;
            queue.add(labyrinth[current.x + 1][current.y]);
            closed.add(labyrinth[current.x + 1][current.y]);
        }

        if (labyrinth[current.x][current.y - 1].value != 1 && !closed.contains(labyrinth[current.x][current.y - 1])) {
            labyrinth[current.x][current.y - 1].parent = current;
            queue.add(labyrinth[current.x][current.y - 1]);
            closed.add(labyrinth[current.x][current.y - 1]);
        }

        if (labyrinth[current.x][current.y + 1].value != 1 && !closed.contains(labyrinth[current.x][current.y + 1])) {
            labyrinth[current.x][current.y + 1].parent = current;
            queue.add(labyrinth[current.x][current.y + 1]);
            closed.add(labyrinth[current.x][current.y + 1]);
        }
    }
}
