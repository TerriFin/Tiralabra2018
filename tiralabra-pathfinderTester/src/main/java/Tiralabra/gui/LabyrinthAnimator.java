package Tiralabra.gui;

import Tiralabra.domain.SolverManager;
import Tiralabra.domain.SolverToAnimator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Responsible for animating the labyrinth
 * Uses three different timelines, each responsible for one algorithm, when this animator
 * gets a signal from solverManager that current algorithm is done, it shows the found path for three seconds
 * and starts next algorithm. On last algorithm it stops and just shows the last found path.
 * 
 * @author samisaukkonen
 */
public class LabyrinthAnimator {

    private SolverManager solverManager;
    private Gui gui;
    private UserIO io;
    
    private boolean depthFirst;
    private boolean AStarFirst;

    public Timeline breadthTimeline;
    public Timeline depthTimeline;
    public Timeline starTimeline;

    /**
     * 
     * @param solverManager SolverManager for this animator, animator gets the half-completed
     * labyrinths from this class, and just draws them until it gets a signal to start over with a different algorithm
     * @param gui Gui that this class is nested in, needed to gain access to .setNewLabyrinth-method
     * for placing new labyrinth there
     */
    public LabyrinthAnimator(SolverManager solverManager, Gui gui, UserIO io) {
        this.solverManager = solverManager;
        this.gui = gui;
        this.io = io;
        
        this.depthFirst = true;
        this.AStarFirst = true;

        this.breadthTimeline = new Timeline(new KeyFrame(Duration.millis(40), e -> {
            SolverToAnimator input = this.solverManager.getNextBreadth();
            this.gui.updateLabyrinth(input.labyrinth, input.node);
            this.io.updateBreath(input.steps, input.pathLength);

            if (input.lastFrame) {
                this.gui.setNewLabyrinth(input.labyrinth);
                this.breadthTimeline.stop();
                this.depthTimeline.play();
            }
        }));
        
        this.depthTimeline = new Timeline(new KeyFrame(Duration.millis(40), e -> {
            if (this.depthFirst) {
                this.gui.setNewLabyrinth(solverManager.originalLabyrinth);
                this.depthFirst = false;
            }
            
            SolverToAnimator input = this.solverManager.getNextDepth();
            this.gui.updateLabyrinth(input.labyrinth, input.node);
            this.io.updateDepth(input.steps, input.pathLength);

            if (input.lastFrame) {
                this.gui.setNewLabyrinth(input.labyrinth);
                this.depthTimeline.stop();
                this.starTimeline.play();
            }
        }));
        
        this.starTimeline = new Timeline(new KeyFrame(Duration.millis(40), e -> {
            if (AStarFirst) {
                this.gui.setNewLabyrinth(solverManager.originalLabyrinth);
                AStarFirst = false;
            }
            
            SolverToAnimator input = this.solverManager.getNextStar();
            this.gui.updateLabyrinth(input.labyrinth, input.node);
            this.io.updateStar(input.steps, input.pathLength);

            if (input.lastFrame) {
                this.gui.setNewLabyrinth(input.labyrinth);
                this.starTimeline.stop();
            }
        }));
        
        this.breadthTimeline.setDelay(Duration.seconds(2));
        this.breadthTimeline.setCycleCount(Timeline.INDEFINITE);
        
        this.depthTimeline.setDelay(Duration.seconds(3));
        this.depthTimeline.setCycleCount(Timeline.INDEFINITE);
        
        this.starTimeline.setDelay(Duration.seconds(3));
        this.starTimeline.setCycleCount(Timeline.INDEFINITE);
    }

    /**
     * Starts the animation
     */
    public void startAnimation() {
        breadthTimeline.play();
    }
    
    /**
     * Stops the animation
     * 
     * --- TO DO ---
     * Check if the old timelines stay and if so how to get rid of them
     * -------------
     */
    public void stop() {
        breadthTimeline.stop();
        depthTimeline.stop();
        starTimeline.stop();
    }
}
