package Tiralabra.domain;

public class LabyrinthGenerator {
    public static Node[][] generateLabyrinth(int side) {
        Node[][] labyrinth = prepareNewLabyrinth(side);
        
        
        
        return labyrinth;
    }
    
    private static Node[][] prepareNewLabyrinth(int side) {
        Node[][] labyrinth = new Node[side][side];
        
        for (int x = 0; x < side; x++) {
            for (int y = 0; y < side; y++) {
                labyrinth[x][y] = new Node(x, y, 0, null);
            }
        }
        
        for (int x = 0; x < side; x++) {
            labyrinth[x][0].value = 1;
            labyrinth[x][side - 1].value = 1;
            labyrinth[0][x].value = 1;
            labyrinth[side - 1][x].value = 1;
        }
        
        labyrinth[1][1].value = 3;
        labyrinth[labyrinth.length - 2][labyrinth[0].length - 2].value = 5;
        
        return labyrinth;
    }
}
