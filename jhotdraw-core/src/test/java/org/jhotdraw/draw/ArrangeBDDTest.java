package org.jhotdraw.draw;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

// Notice how we inject the three stage classes into the generic parameters
public class ArrangeBDDTest extends ScenarioTest<GivenFigures, WhenArrange, ThenFigureDepth> {

    @Test
    public void a_user_can_send_a_figure_to_the_back() {
        given().figures_on_a_drawing();
        
        when().i_send_one_to_the_back();
        
        then().that_figure_should_be_behind_the_others();
    }

    @Test
    public void a_user_can_bring_a_figure_to_the_front() {
        given().figures_on_a_drawing();
        
        when().i_bring_one_to_the_front();
        
        then().that_figure_should_be_in_front_of_the_others();
    }
}