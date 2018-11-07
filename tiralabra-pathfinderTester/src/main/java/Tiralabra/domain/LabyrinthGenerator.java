package Tiralabra.domain;

public class LabyrinthGenerator {
    public static int[][] generateLabyrinth(int side) {
        int[][] labyrinth = fillBorders(side);
        
        
        
        return labyrinth;
    }
    
    private static int[][] fillBorders(int side) {
        int[][] labyrinth = new int[side][side];
        
        for (int x = 0; x < side; x++) {
            labyrinth[x][0] = 1;
            labyrinth[x][side - 1] = 1;
            labyrinth[0][x] = 1;
            labyrinth[side - 1][x] = 1;
        }
        
        return labyrinth;
    }
}
