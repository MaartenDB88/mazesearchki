package binf.ai.search.doolhof;

import binf.ai.search.problem.GoalTest;
import binf.ai.search.problem.State;

/**
 * kijkt of een state de goal state is
 */
public class DoolhofGoalTest implements GoalTest {

    private State goal;

    /**
     * creeert een instantie
     * @param goal goalState
     */
    public DoolhofGoalTest(State goal) {
        this.goal=goal;
    }

    /**
     * vergelijkt de parameter state met de goal state
     * @param state de state die vergeleken wordt
     * @return boolean true/false
     */
    public boolean isGoalState(State state) {
        return goal.sameState(state);
    }

}
