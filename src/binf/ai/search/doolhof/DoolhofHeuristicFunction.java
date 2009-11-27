package binf.ai.search.doolhof;

import binf.ai.search.problem.HeuristicFunction;
import binf.ai.search.problem.State;


/**
 * is een functie die de heuristiek kan berekenen
 */
public class DoolhofHeuristicFunction implements HeuristicFunction {

    private State goal;

    /**
     * creeert een instantie
     * @param goal de goal state
     */
    public DoolhofHeuristicFunction(State goal) {
        this.goal = goal;
    }

    /**
     * berekent de heuristiek voor de huidige state
     * @param state de huidige state
     * @return float
     */
    public float getHeuristicValue(State state) {
        // bereken het verschil in x en y
        int xDifference = ((DoolhofState)goal).getxCord()
                - ((DoolhofState)state).getxCord();
        int yDifference = ((DoolhofState)goal).getyCord()
                - ((DoolhofState)state).getyCord();

        // (heuristiek)^2 = (verschil in x)^2 + (verschil in y)^2
        // Pythagoras
        return (float) Math.sqrt(xDifference*xDifference + yDifference*yDifference);
    }
}
