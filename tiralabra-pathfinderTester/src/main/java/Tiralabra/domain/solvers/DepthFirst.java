package Tiralabra.domain.solvers;

import Tiralabra.domain.DataStructures.Stack;
import Tiralabra.domain.Node;

public class DepthFirst {

    public Node[][] labyrinth;

    public Node current;
    private Node goal;
    private Stack<Node> stack;
    
    public int steps;

    public DepthFirst(Node[][] labyrinth) {
        this.labyrinth = labyrinth;

        this.current = this.labyrinth[1][1];
        this.goal = this.labyrinth[this.labyrinth.length - 2][this.labyrinth[0].length - 2];
        this.stack = new Stack<Node>(Node.class);

        this.stack.put(this.current);
        
        this.steps = 0;
    }

    public boolean processStep() {
        this.steps++;
        
        current.value = 2;
        if (!stack.isEmpty()) {
            current = stack.pop();
        } else {
            return false;
        }
        
        current.value = 4;

        if (current.equals(goal)) {
            return true;
        }

        checkAdjacentNodes();
        
        return false;
    }

    public int markPathToCurrent() {
        int currentPathLenght = 1;
        
        current.value = 5;
        Node currentHere = current.parent;

        while (currentHere.parent != null) {
            currentPathLenght++;
            
            labyrinth[currentHere.x][currentHere.y].value = 6;
            currentHere = currentHere.parent;
        }

        currentHere.value = 6;
        
        return currentPathLenght;
    }

    private void checkAdjacentNodes() {
        if (labyrinth[current.x - 1][current.y].value == 0 || labyrinth[current.x - 1][current.y].value == 5) {
            labyrinth[current.x - 1][current.y].parent = current;
            stack.put(labyrinth[current.x - 1][current.y]);
            labyrinth[current.x - 1][current.y].value = 3;
        }

        if (labyrinth[current.x + 1][current.y].value == 0 || labyrinth[current.x + 1][current.y].value == 5) {
            labyrinth[current.x + 1][current.y].parent = current;
            stack.put(labyrinth[current.x + 1][current.y]);
            labyrinth[current.x + 1][current.y].value = 3;
        }

        if (labyrinth[current.x][current.y - 1].value == 0 || labyrinth[current.x][current.y - 1].value == 5) {
            labyrinth[current.x][current.y - 1].parent = current;
            stack.put(labyrinth[current.x][current.y - 1]);
            labyrinth[current.x][current.y - 1].value = 3;
        }

        if (labyrinth[current.x][current.y + 1].value == 0 || labyrinth[current.x][current.y + 1].value == 5) {
            labyrinth[current.x][current.y + 1].parent = current;
            stack.put(labyrinth[current.x][current.y + 1]);
            labyrinth[current.x][current.y + 1].value = 3;
        }
    }
}
