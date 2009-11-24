/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binf.ai.search.doolhof;

import binf.ai.search.problem.PathCostFunction;
import binf.ai.search.problem.State;

/**
 *
 * @author Elias
 */
public class DoolhofPathCostFunction implements PathCostFunction {

    public float calculatePathCost(State fromState, State toState, String action) {
        if (!((DoolhofState)fromState).sameState((DoolhofState)toState)){
            return Action.valueOf(action).getCost();
        } else {
            return 0;
        }
    }

}
