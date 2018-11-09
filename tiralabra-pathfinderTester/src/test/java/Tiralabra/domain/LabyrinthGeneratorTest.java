package Tiralabra.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This test is dependant on PathValidatorTest, if this does not pass check it first.
 * 
 * @author samisaukkonen
 */
public class LabyrinthGeneratorTest {
    
    PathValidator validator = new PathValidator();
    
    Node[][] smallLabyrinth;
    Node[][] bigLabyrinth;
    
    @Before
    public void setUp() {
        smallLabyrinth = LabyrinthGenerator.generateLabyrinth(10);
        bigLabyrinth = LabyrinthGenerator.generateLabyrinth(30);
    }
    
    @Test
    public void labyrinthsAreSolvable1() {
        assertEquals(true, validator.checkIfThereIsPath(smallLabyrinth));
        assertEquals(true, validator.checkIfThereIsPath(bigLabyrinth));
    }
    
    @Test
    public void labyrinthsAreSolvable2() {
        assertEquals(true, validator.checkIfThereIsPath(smallLabyrinth));
        assertEquals(true, validator.checkIfThereIsPath(bigLabyrinth));
    }
    
    @Test
    public void labyrinthsAreSolvable3() {
        assertEquals(true, validator.checkIfThereIsPath(smallLabyrinth));
        assertEquals(true, validator.checkIfThereIsPath(bigLabyrinth));
    }
}
