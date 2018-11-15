package Tiralabra.gui;

import Tiralabra.domain.Node;
import Tiralabra.domain.SolverManager;
import Tiralabra.domain.SolverToAnimator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Responsible for animating the labyrinth
 * Uses three different timelines, each responsible for one algorithm, when this animator
 * gets a signal from solverManager that current algorithm is done, it shows the found path for four seconds
 * and then starts next algorithm. On last algorithm it stops and just shows the last found path
 * 
 * @author samisaukkonen
 */
public class LabyrinthAnimator {
    private Gui gui;
    private UserIO io;
    
    private boolean depthFirst;
    private boolean starFirst;
    
    private SolverManager solverManager;

    public Timeline breadthTimeline;
    public Timeline depthTimeline;
    public Timeline starTimeline;

    /**
     * @param labyrinth Labyrinth that is going to be animated, is going to be passed on to a new SolverManager
     * that is going to be destroyed when stop() is called.
     * @param gui Gui that this class is nested in, needed to gain access to .setNewLabyrinth and .updateLabyrinth -methods
     */
    public LabyrinthAnimator(Node[][] labyrinth, UserIO io, Gui gui) {
        this.gui = gui;
        this.io = io;
        
        this.depthFirst = true;
        this.starFirst = true;
        
        this.solverManager = new SolverManager(labyrinth);

        this.breadthTimeline = new Timeline(new KeyFrame(Duration.millis(40), e -> {
            SolverToAnimator input = this.solverManager.getNextBreadth();
            this.gui.updateLabyrinth(input.labyrinth, input.node);
            this.io.updateBreath(input.steps, input.pathLength);

            if (input.labyrinthSolved) {
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

            if (input.labyrinthSolved) {
                this.gui.setNewLabyrinth(input.labyrinth);
                this.depthTimeline.stop();
                this.starTimeline.play();
            }
        }));
        
        this.starTimeline = new Timeline(new KeyFrame(Duration.millis(40), e -> {
            if (starFirst) {
                this.gui.setNewLabyrinth(solverManager.originalLabyrinth);
                starFirst = false;
            }
            
            SolverToAnimator input = this.solverManager.getNextStar();
            this.gui.updateLabyrinth(input.labyrinth, input.node);
            this.io.updateStar(input.steps, input.pathLength);

            if (input.labyrinthSolved) {
                this.gui.setNewLabyrinth(input.labyrinth);
                this.starTimeline.stop();
            }
        }));
        
        this.breadthTimeline.setDelay(Duration.seconds(2));
        this.breadthTimeline.setCycleCount(Timeline.INDEFINITE);
        
        this.depthTimeline.setDelay(Duration.seconds(4));
        this.depthTimeline.setCycleCount(Timeline.INDEFINITE);
        
        this.starTimeline.setDelay(Duration.seconds(4));
        this.starTimeline.setCycleCount(Timeline.INDEFINITE);
    }

    /**
     * Starts the animation
     */
    public void startAnimation() {
        breadthTimeline.play();
    }
    
    /**
     * Stops and destroys generated resources, hopefully freeing them
     */
    public void stop() {
        breadthTimeline.stop();
        depthTimeline.stop();
        starTimeline.stop();
        
        breadthTimeline = null;
        depthTimeline = null;
        starTimeline = null;
        
        solverManager = null;
    }
}
