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

    public List<Successor> getSuccessors(State state) {
        List<Successor> successors = new LinkedList<Successor>();
        DoolhofState doolhofState = (DoolhofState) state;

        int x = doolhofState.getxCord();
        int y = doolhofState.getyCord();
        for (State stateSuccessor : doolhofState.getSuccessors()) {
            int xSuc = ((DoolhofState) stateSuccessor).getxCord();
            int ySuc = ((DoolhofState) stateSuccessor).getyCord();
            if (x == xSuc) {
                if (y == ySuc + 1) {
                    successors.add(new Successor(Action.ZUID.toString(), stateSuccessor));
                } else if (y == ySuc - 1) {
                    successors.add(new Successor(Action.NOORD.toString(), stateSuccessor));
                }
            } else if (x == xSuc - 1) {
                if (y == ySuc + 1) {
                    successors.add(new Successor(Action.ZUIDWEST.toString(), stateSuccessor));
                } else if (y == ySuc) {
                    successors.add(new Successor(Action.WEST.toString(), stateSuccessor));
                } else if (y == ySuc - 1) {
                    successors.add(new Successor(Action.NOORDWEST.toString(), stateSuccessor));
                }
            } else if (x == xSuc + 1) {
                if (y == ySuc + 1) {
                    successors.add(new Successor(Action.ZUIDOOST.toString(), stateSuccessor));
                } else if (y == ySuc) {
                    successors.add(new Successor(Action.OOST.toString(), stateSuccessor));
                } else if (y == ySuc - 1) {
                    successors.add(new Successor(Action.NOORDOOST.toString(), stateSuccessor));
                }
            }
        }
        return successors;
    }
}

