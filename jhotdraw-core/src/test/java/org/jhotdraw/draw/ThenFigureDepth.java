package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.figure.Figure;
import static org.assertj.core.api.Assertions.assertThat;

public class ThenFigureDepth extends Stage<ThenFigureDepth> {

    @ExpectedScenarioState
    QuadTreeDrawing drawing;

    @ExpectedScenarioState
    Figure targetFigure;

    public ThenFigureDepth that_figure_should_be_behind_the_others() {
        assertThat(drawing.getChildren().indexOf(targetFigure))
            .as("The figure should be moved behind everything else")
            .isZero();
        
        return this;
    }

    public ThenFigureDepth that_figure_should_be_in_front_of_the_others() {
        int frontIndex = drawing.getChildren().size() - 1;
        
        assertThat(drawing.getChildren().indexOf(targetFigure))
            .as("The figure should be moved in front of everything else")
            .isEqualTo(frontIndex);
            
        return this;
    }
}