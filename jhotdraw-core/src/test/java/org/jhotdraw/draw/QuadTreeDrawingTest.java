package org.jhotdraw.draw;

import org.jhotdraw.draw.figure.Figure;
import org.junit.Before;
import org.junit.Test;
import java.awt.geom.Rectangle2D;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class QuadTreeDrawingTest {

    private QuadTreeDrawing drawing;
    private Figure fig1;
    private Figure fig2;
    private Figure fig3;

    @Before
    public void setUp() {
        drawing = new QuadTreeDrawing();

        fig1 = mock(Figure.class);
        fig2 = mock(Figure.class);
        fig3 = mock(Figure.class);

        // Stub out getDrawingArea() 
        when(fig1.getDrawingArea()).thenReturn(new Rectangle2D.Double());
        when(fig2.getDrawingArea()).thenReturn(new Rectangle2D.Double());
        when(fig3.getDrawingArea()).thenReturn(new Rectangle2D.Double());

        drawing.add(fig1);
        drawing.add(fig2);
        drawing.add(fig3);
    }


    @Test
    public void testBringToFrontBestCase() {
        //fig1 is at back
        drawing.bringToFront(fig1);
        
        List<Figure> children = drawing.getChildren();
        assertEquals(fig1, children.get(children.size() - 1));
        
        // Test invariants
        assert children.size() == 3 : "Invariant failed: Total number of figures changed!";
    }

    @Test
    public void testSendToBackBestCase() {
        // fig3 is at the front
        drawing.sendToBack(fig3);
        
        List<Figure> children = drawing.getChildren();
        assertEquals(fig3, children.get(0));
        
        assert children.size() == 3 : "Invariant failed: Total number of figures changed!";
    }

    @Test
    public void testBringToFrontAlreadyAtFront() {
        // fig3 is already at the front.
        drawing.bringToFront(fig3);
        
        List<Figure> children = drawing.getChildren();
        assertEquals("fig3 should remain at the end of the list", fig3, children.get(children.size() - 1));
        
        assert children.size() == 3 : "Invariant failed: Total number of figures changed!";
    }

    @Test
    public void testArrangeFigureNotContainedInDrawing() {
        //Attempting to arrange figure that's not in drawing
        Figure ghostFig = mock(Figure.class);
        when(ghostFig.getDrawingArea()).thenReturn(new Rectangle2D.Double());
        
        drawing.sendToBack(ghostFig); // Should fail safely and do nothing
        
        List<Figure> children = drawing.getChildren();
        assertFalse("Drawing should not contain the un-added figure", children.contains(ghostFig));
        
        assert children.size() == 3 : "Invariant failed: Ghost figure altered the collection size!";
    }
}