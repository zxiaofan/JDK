/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.sun.javafx.charts;

import java.util.HashMap;
import java.util.Map;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.chart.Axis;

/**
 * Runs any number of animations of KeyFrames calling requestLayout on the given node for every frame while one of
 * those animations is running.
 */
public final class ChartLayoutAnimator extends AnimationTimer implements EventHandler<ActionEvent> {
    private Parent nodeToLayout;
    private final Map<Object,Animation> activeTimeLines = new HashMap<Object, Animation>();
    private final boolean isAxis;

    public ChartLayoutAnimator(Parent nodeToLayout) {
        this.nodeToLayout = nodeToLayout;
        isAxis = nodeToLayout instanceof Axis;
    }

    @Override public void handle(long l) {
        if(isAxis) {
            ((Axis<?>)nodeToLayout).requestAxisLayout();
        } else {
            nodeToLayout.requestLayout();
        }
    }

    @Override public void handle(ActionEvent actionEvent) {
        activeTimeLines.remove(actionEvent.getSource());
        if(activeTimeLines.isEmpty()) stop();
        // cause one last re-layout to make sure final values were used
        handle(0l);
    }

    /**
     * Stop the animation with the given ID
     *
     * @param animationID The id of the animation to stop
     */
    public void stop(Object animationID) {
        Animation t = activeTimeLines.remove(animationID);
        if(t!=null) t.stop();
        if(activeTimeLines.isEmpty()) stop();
    }

    /**
     * Play a animation containing the given keyframes.
     *
     * @param keyFrames The keyframes to animate
     * @return A id reference to the animation that can be used to stop the animation if needed
     */
    public Object animate(KeyFrame...keyFrames) {
        Timeline t = new Timeline();
        t.setAutoReverse(false);
        t.setCycleCount(1);
        t.getKeyFrames().addAll(keyFrames);
        t.setOnFinished(this);
        // start animation timer if needed
        if(activeTimeLines.isEmpty()) start();
        // get id and add to map
        activeTimeLines.put(t, t);
        // play animation
        t.play();
        return t;
    }

    /**
     * Play a animation containing the given keyframes.
     *
     * @param animation The animation to play
     * @return A id reference to the animation that can be used to stop the animation if needed
     */
    public Object animate(Animation animation) {
        SequentialTransition t = new SequentialTransition();
        t.getChildren().add(animation);
        t.setOnFinished(this);
        // start animation timer if needed
        if(activeTimeLines.isEmpty()) start();
        // get id and add to map
        activeTimeLines.put(t, t);
        // play animation
        t.play();
        return t;

    }
}
