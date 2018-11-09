package Tiralabra.domain;

import java.util.Random;

public class LabyrinthGenerator {

    public static Node[][] generateLabyrinth(int side) {
        Node[][] labyrinth = prepareNewLabyrinth(side);

        Random random = new Random();
        PathValidator validator = new PathValidator();

        int newObsTries = (side * (side / 2));

        for (int i = 0; i < newObsTries; i++) {
            int newObsWidth = random.nextInt(side - 2) + 1;
            int newObsHeight = random.nextInt(side - 2) + 1;

            if (!(newObsWidth == 1 && newObsHeight == 1) && !(newObsWidth == labyrinth.length - 2 && newObsHeight == labyrinth[0].length - 2)) {
                labyrinth[newObsWidth][newObsHeight].value = 1;

                if (!validator.checkIfThereIsPath(labyrinth)) {
                    labyrinth[newObsWidth][newObsHeight].value = 0;
                }
            }
        }
        
        //validator.markPathToGoal(labyrinth);

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

        labyrinth[1][1].value = 4;
        labyrinth[labyrinth.length - 2][labyrinth[0].length - 2].value = 5;

        return labyrinth;
    }
}
