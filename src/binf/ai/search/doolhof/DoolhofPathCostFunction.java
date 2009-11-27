package binf.ai.search.doolhof;

import binf.ai.search.problem.PathCostFunction;
import binf.ai.search.problem.State;


/**
 * is een functie die padkost kan berekenen
 */
public class DoolhofPathCostFunction implements PathCostFunction {

    /**
     * berekent de padkost voor een state
     * @param fromState de begin state
     * @param toState de state waarnaar een actie wordt uitgevoerd
     * @param action
     * @return float vergelijking
     */
    public float calculatePathCost(State fromState, State toState, String action) {
        if (!((DoolhofState)fromState).sameState((DoolhofState)toState)){
            return Action.valueOf(action).getCost();
        } else {
            return 0;
        }
    }

}
