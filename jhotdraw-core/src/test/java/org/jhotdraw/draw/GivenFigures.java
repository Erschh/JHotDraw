package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.figure.Figure;
import java.awt.geom.Rectangle2D;
import org.mockito.Mockito;

public class GivenFigures extends Stage<GivenFigures> {

    @ProvidedScenarioState
    QuadTreeDrawing drawing;

    @ProvidedScenarioState
    Figure targetFigure;

    public GivenFigures figures_on_a_drawing() {
        drawing = new QuadTreeDrawing();

        Figure figure1 = Mockito.mock(Figure.class);
        targetFigure = Mockito.mock(Figure.class); 
        Figure figure3 = Mockito.mock(Figure.class);

        Mockito.when(figure1.getDrawingArea()).thenReturn(new Rectangle2D.Double());
        Mockito.when(targetFigure.getDrawingArea()).thenReturn(new Rectangle2D.Double());
        Mockito.when(figure3.getDrawingArea()).thenReturn(new Rectangle2D.Double());

        drawing.add(figure1);
        drawing.add(targetFigure);
        drawing.add(figure3);

        return this;
    }
}