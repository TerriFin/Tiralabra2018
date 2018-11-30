package Tiralabra.domain.solvers;

import Tiralabra.domain.DataStructures.Heap;
import Tiralabra.domain.DataStructures.Stack;
import Tiralabra.domain.Node;

public class AStar {

    public Node[][] labyrinth;

    public Node current;
    private Node goal;
    private Heap<Node> Heap;
    
    public int steps;

    public AStar(Node[][] labyrinth) {
        this.labyrinth = labyrinth;

        this.current = this.labyrinth[1][1];
        this.goal = this.labyrinth[this.labyrinth.length - 2][this.labyrinth[0].length - 2];
        this.Heap = new Heap<Node>(Node.class);

        this.current.shortestPath = 0;
        this.current.distanceToGoal = this.current.distanceToNode(this.goal);

        this.Heap.add(this.current);
        
        this.steps = 0;
    }

    public boolean processStep() {
        this.steps++;
        
        current.value = 2;
        if (!Heap.isEmpty()) {
            current = Heap.poll();
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
            labyrinth[current.x - 1][current.y].shortestPath = current.shortestPath + 1;
            labyrinth[current.x - 1][current.y].distanceToGoal = labyrinth[current.x - 1][current.y].distanceToNode(goal);
            Heap.add(labyrinth[current.x - 1][current.y]);
            labyrinth[current.x - 1][current.y].value = 3;
        } else if (labyrinth[current.x - 1][current.y].value == 3) {
            if (labyrinth[current.x - 1][current.y].shortestPath > current.shortestPath + 1) {
                labyrinth[current.x - 1][current.y].parent = current;
                labyrinth[current.x - 1][current.y].shortestPath = current.shortestPath + 1;
                Heap.remove(labyrinth[current.x - 1][current.y]);
                Heap.add(labyrinth[current.x - 1][current.y]);
            }
        }

        if (labyrinth[current.x + 1][current.y].value == 0 || labyrinth[current.x + 1][current.y].value == 5) {
            labyrinth[current.x + 1][current.y].parent = current;
            labyrinth[current.x + 1][current.y].shortestPath = current.shortestPath + 1;
            labyrinth[current.x + 1][current.y].distanceToGoal = labyrinth[current.x + 1][current.y].distanceToNode(goal);
            Heap.add(labyrinth[current.x + 1][current.y]);
            labyrinth[current.x + 1][current.y].value = 3;
        } else if (labyrinth[current.x + 1][current.y].value == 3) {
            if (labyrinth[current.x + 1][current.y].shortestPath > current.shortestPath + 1) {
                labyrinth[current.x + 1][current.y].parent = current;
                labyrinth[current.x + 1][current.y].shortestPath = current.shortestPath + 1;
                Heap.remove(labyrinth[current.x + 1][current.y]);
                Heap.add(labyrinth[current.x + 1][current.y]);
            }
        }

        if (labyrinth[current.x][current.y - 1].value == 0 || labyrinth[current.x][current.y - 1].value == 5) {
            labyrinth[current.x][current.y - 1].parent = current;
            labyrinth[current.x][current.y - 1].shortestPath = current.shortestPath + 1;
            labyrinth[current.x][current.y - 1].distanceToGoal = labyrinth[current.x][current.y - 1].distanceToNode(goal);
            Heap.add(labyrinth[current.x][current.y - 1]);
            labyrinth[current.x][current.y - 1].value = 3;
        } else if (labyrinth[current.x][current.y - 1].value == 3) {
            if (labyrinth[current.x][current.y - 1].shortestPath > current.shortestPath + 1) {
                labyrinth[current.x][current.y - 1].parent = current;
                labyrinth[current.x][current.y - 1].shortestPath = current.shortestPath + 1;
                Heap.remove(labyrinth[current.x][current.y - 1]);
                Heap.add(labyrinth[current.x][current.y - 1]);
            }
        }

        if (labyrinth[current.x][current.y + 1].value == 0 || labyrinth[current.x][current.y + 1].value == 5) {
            labyrinth[current.x][current.y + 1].parent = current;
            labyrinth[current.x][current.y + 1].shortestPath = current.shortestPath + 1;
            labyrinth[current.x][current.y + 1].distanceToGoal = labyrinth[current.x][current.y + 1].distanceToNode(goal);
            Heap.add(labyrinth[current.x][current.y + 1]);
            labyrinth[current.x][current.y + 1].value = 3;
        } else if (labyrinth[current.x][current.y + 1].value == 3) {
            if (labyrinth[current.x][current.y + 1].shortestPath > current.shortestPath + 1) {
                labyrinth[current.x][current.y + 1].parent = current;
                labyrinth[current.x][current.y + 1].shortestPath = current.shortestPath + 1;
                Heap.remove(labyrinth[current.x][current.y + 1]);
                Heap.add(labyrinth[current.x][current.y + 1]);
            }
        }
    }
}
