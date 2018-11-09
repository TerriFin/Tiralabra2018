package Tiralabra.domain.solvers;

import Tiralabra.domain.Node;
import java.util.ArrayDeque;

public class BreadthFirst {

    public Node[][] labyrinth;

    private Node current;
    private Node goal;
    private ArrayDeque<Node> queue;

    public BreadthFirst(Node[][] labyrinth) {
        this.labyrinth = labyrinth;

        this.current = this.labyrinth[1][1];
        this.goal = this.labyrinth[this.labyrinth.length - 2][this.labyrinth[0].length - 2];
        this.queue = new ArrayDeque<>();

        this.queue.add(current);
    }

    public boolean processStep() {
        current.value = 2;
        current = queue.poll();
        current.value = 4;

        if (current.equals(goal)) {
            return true;
        }

        checkAdjacentNodes();
        return false;
    }

    public void MarkPathToCurrent() {
        current.value = 5;
        Node currentHere = current.parent;

        while (currentHere.parent != null) {
            labyrinth[currentHere.x][currentHere.y].value = 6;
            currentHere = currentHere.parent;
        }
        
        currentHere.value = 6;
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
