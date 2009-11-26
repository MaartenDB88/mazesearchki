/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binf.ai.search.doolhof;

import binf.ai.search.problem.State;
import binf.ai.search.problem.Successor;
import binf.ai.search.problem.SuccessorFunction;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Elias
 */
public class DoolhofSuccessorFunction implements SuccessorFunction {

    private char[][] doolhof;

    public DoolhofSuccessorFunction(char[][] doolhof) {
        this.doolhof = doolhof;
    }

    public List<Successor> getSuccessors(State state) {
        List<Successor> successors = new LinkedList<Successor>();
        DoolhofState doolhofState = (DoolhofState) state;

        int x = doolhofState.getxCord();
        int y = doolhofState.getyCord();

        for (Action actie : Action.values()) {
            int relX = x + actie.getRelativeX();
            int relY = y + actie.getRelativeY();
            if ((relX >= 0) && (relY >= 0) &&
                 relX < doolhof.length && relY < doolhof.length &&
                 doolhof[relX][relY] != Status.OBSTACLE.getStatus()) {

                DoolhofState successorState = new DoolhofState(relX, relY, Status.BLANK);
                if(doolhof[relX][relY] == Status.GOAL.getStatus())
                    successorState.setStatus(Status.GOAL);
                if(doolhof[relX][relY] == Status.START.getStatus())
                    successorState.setStatus(Status.START);
                successors.add(new Successor(actie.toString(), successorState));
            }
        }
        return successors;
    }
}

