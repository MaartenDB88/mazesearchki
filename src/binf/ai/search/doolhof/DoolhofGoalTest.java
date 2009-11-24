/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binf.ai.search.doolhof;

import binf.ai.search.problem.GoalTest;
import binf.ai.search.problem.State;

/**
 *
 * @author Elias
 */
public class DoolhofGoalTest implements GoalTest {

    private State goal;

    public DoolhofGoalTest(State goal) {
        this.goal=goal;
    }

    public boolean isGoalState(State state) {
        return goal.sameState(state);
    }

}
