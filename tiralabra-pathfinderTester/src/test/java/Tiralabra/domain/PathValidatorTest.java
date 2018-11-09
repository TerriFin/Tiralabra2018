package Tiralabra.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PathValidatorTest {

    PathValidator validator;
    Node[][] labyrinth;

    @Before
    public void setUp() {
        validator = new PathValidator();
        labyrinth = new Node[10][10];
        
        // Set up a new labyrinth by initializing all nodes, and making them of value 1 (wall)
        // if they are on the edge (first 4 if-statements)
        for (int x = 0; x < labyrinth.length; x++) {
            for (int y = 0; y < labyrinth[0].length; y++) {
                if (x == 0) {
                    labyrinth[x][y] = new Node(x, y, 1, null);
                } else if (x == labyrinth.length - 1) {
                    labyrinth[x][y] = new Node(x, y, 1, null);
                } else if (y == 0) {
                    labyrinth[x][y] = new Node(x, y, 1, null);
                } else if (y == labyrinth[0].length - 1) {
                    labyrinth[x][y] = new Node(x, y, 1, null);
                } else {
                    labyrinth[x][y] = new Node(x, y, 0, null);
                }
            }
        }
    }

    @Test
    public void canSolveEmptyLabyrinth() {
        assertTrue(validator.checkIfThereIsPath(labyrinth));
    }
    
    @Test
    public void cannotSolveWalledLabyrinth() {
        for (int i = 1; i < labyrinth[0].length - 1; i++) {
            labyrinth[5][i].value = 1;
        }
        
        assertFalse(validator.checkIfThereIsPath(labyrinth));
    }
    
    @Test
    public void markPathToGoalWorks() {
        validator.markPathToGoal(labyrinth);
        
        assertEquals(6, labyrinth[1][1].value);
        assertEquals(5, labyrinth[labyrinth.length - 2][labyrinth[0].length - 2].value);
    }
}
