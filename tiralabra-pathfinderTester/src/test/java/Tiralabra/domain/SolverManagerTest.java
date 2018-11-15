package Tiralabra.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SolverManagerTest {

    Node[][] labyrinth;
    SolverManager manager;

    @Before
    public void setUp() {
        labyrinth = new Node[6][6];

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

        manager = new SolverManager(labyrinth);
    }

    @Test
    public void breadthFirstFindsEnd() {
        boolean foundEnd = false;

        for (int i = 0; i < 16; i++) {
            if (manager.getNextBreadth().labyrinthSolved) {
                foundEnd = true;
            }
        }

        assertTrue(foundEnd);
    }

    @Test
    public void breadthFirstDoesNotFindEndInUnsolvableLabyrinth() {
        for (int i = 1; i < 6; i++) {
            labyrinth[3][i].value = 1;
        }
        
        manager = new SolverManager(labyrinth);
        boolean foundEnd = false;

        for (int i = 0; i < 16; i++) {
            if (manager.getNextBreadth().labyrinthSolved) {
                foundEnd = true;
            }
        }

        assertFalse(foundEnd);
    }

    @Test
    public void depthFirstFindsEnd() {
        boolean foundEnd = false;

        for (int i = 0; i < 16; i++) {
            if (manager.getNextDepth().labyrinthSolved) {
                foundEnd = true;
            }
        }

        assertTrue(foundEnd);
    }
    
    @Test
    public void depthFirstDoesNotFindEndInUnsolvableLabyrinth() {
        for (int i = 1; i < 6; i++) {
            labyrinth[3][i].value = 1;
        }

        manager = new SolverManager(labyrinth);
        boolean foundEnd = false;

        for (int i = 0; i < 16; i++) {
            if (manager.getNextDepth().labyrinthSolved) {
                foundEnd = true;
            }
        }

        assertFalse(foundEnd);
    }

    @Test
    public void starFindsEnd() {
        boolean foundEnd = false;

        for (int i = 0; i < 16; i++) {
            if (manager.getNextStar().labyrinthSolved) {
                foundEnd = true;
            }
        }

        assertTrue(foundEnd);
    }
    
    @Test
    public void starDoesNotFindEndInUnsolvableLabyrinth() {
        for (int i = 1; i < 6; i++) {
            labyrinth[3][i].value = 1;
        }

        manager = new SolverManager(labyrinth);
        boolean foundEnd = false;

        for (int i = 0; i < 16; i++) {
            if (manager.getNextStar().labyrinthSolved) {
                foundEnd = true;
            }
        }

        assertFalse(foundEnd);
    }
}
