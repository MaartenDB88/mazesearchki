/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binf.ai.search.doolhof;

import binf.ai.search.problem.HeuristicFunction;
import binf.ai.search.problem.State;

/**
 *
 * @author Simon
 */
public class DoolhofHeuristicFunction implements HeuristicFunction {

    private State goal;

    public DoolhofHeuristicFunction(State goal) {
        this.goal = goal;
    }

    public float getHeuristicValue(State state) {
        int xDifference = ((DoolhofState)goal).getxCord()
                - ((DoolhofState)state).getxCord();
        int yDifference = ((DoolhofState)goal).getyCord()
                - ((DoolhofState)state).getyCord();

        return xDifference*xDifference + yDifference*yDifference;
    }
}
