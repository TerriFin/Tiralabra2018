package Tiralabra.gui;

import Tiralabra.domain.SolverManager;
import Tiralabra.domain.SolverToAnimator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class LabyrinthAnimator {

    private SolverManager solverManager;
    private Gui gui;

    public Timeline breadthTimeline;
    public Timeline depthTimeline;
    public Timeline starTimeline;

    public LabyrinthAnimator(SolverManager solverManager, Gui gui) {
        this.solverManager = solverManager;
        this.gui = gui;

        this.breadthTimeline = new Timeline(new KeyFrame(Duration.millis(80), e -> {
            SolverToAnimator input = this.solverManager.getNextBreadth();
            this.gui.setNewLabyrinth(input.labyrinth);

            if (input.lastFrame) {
                this.breadthTimeline.stop();
                this.depthTimeline.play();
            }
        }));
        
        this.depthTimeline = new Timeline(new KeyFrame(Duration.millis(80), e -> {
            SolverToAnimator input = this.solverManager.getNextDepth();
            this.gui.setNewLabyrinth(input.labyrinth);

            if (input.lastFrame) {
                this.depthTimeline.stop();
                this.starTimeline.play();
            }
        }));
        
        this.starTimeline = new Timeline(new KeyFrame(Duration.millis(80), e -> {
            SolverToAnimator input = this.solverManager.getNextStar();
            this.gui.setNewLabyrinth(input.labyrinth);

            if (input.lastFrame) {
                this.starTimeline.stop();
            }
        }));
        
        this.breadthTimeline.setDelay(Duration.seconds(1));
        this.breadthTimeline.setCycleCount(Timeline.INDEFINITE);
        
        this.depthTimeline.setDelay(Duration.seconds(3));
        this.depthTimeline.setCycleCount(Timeline.INDEFINITE);
        
        this.starTimeline.setDelay(Duration.seconds(3));
        this.starTimeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void startAnimation() {
        breadthTimeline.play();
    }
    
    public void stop() {
        breadthTimeline.stop();
        depthTimeline.stop();
        starTimeline.stop();
    }
}
