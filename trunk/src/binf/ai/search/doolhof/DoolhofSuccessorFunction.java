/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binf.ai.search.doolhof;

import binf.ai.search.problem.State;
import binf.ai.search.problem.Successor;
import binf.ai.search.problem.SuccessorFunction;
import java.util.List;

/**
 *
 * @author Elias
 */
public class DoolhofSuccessorFunction implements SuccessorFunction {

    public List<Successor> getSuccessors(State state) {
        DoolhofState doolhofState = (DoolhofState)state;
//        doolhofState.getxCord();
//        List<Successor> successors = new ArrayList<Successor>();
//        for (Action action : Action.values()){
//            if (doolhofState.getSuccessor(action.toString()) != null)
//                successors.add(doolhofState.getSuccessor(action.toString()));
//        }
//        return successors;
        return doolhofState.getSuccessors();
    }

}
