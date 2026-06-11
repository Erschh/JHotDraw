package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.figure.Figure;

public class WhenArrange extends Stage<WhenArrange> {

    // Expected state means this class expects these variables to already 
    // be populated by the previous "Given" stage.
    @ExpectedScenarioState
    QuadTreeDrawing drawing;

    @ExpectedScenarioState
    Figure targetFigure;

    public WhenArrange i_send_one_to_the_back() {
        drawing.sendToBack(targetFigure);
        return this;
    }

    public WhenArrange i_bring_one_to_the_front() {
        drawing.bringToFront(targetFigure);
        return this;
    }
}