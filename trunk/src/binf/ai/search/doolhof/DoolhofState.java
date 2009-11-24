/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binf.ai.search.doolhof;

import binf.ai.search.problem.State;
import binf.ai.search.problem.Successor;
import java.util.Map;

/**
 *
 * @author Elias
 */
public class DoolhofState implements State {

    private int xCord;
    private int yCord;
    private String status;
    private Map<String, Successor> successors;

    public DoolhofState(int xCord, int yCord, String status, Map<String, Successor> successors) {
        this.xCord = xCord;
        this.yCord = yCord;
        this.status = status;
        this.successors=successors;
    }

    public boolean sameState(State state) {
        DoolhofState curState = (DoolhofState)state;
        if (xCord == curState.getxCord() &&
                yCord == curState.getyCord() &&
                status.equals(curState.getStatus())){
            return true;             
        } else {
            return false;
        }
    }

    public String getStatus() {
        return status;
    }

    public int getxCord() {
        return xCord;
    }

    public int getyCord() {
        return yCord;
    }

    public Successor getSuccessor(String action){
        return successors.get(action);
    }

    public void addSuccessor(String action, State state){
        successors.put(action, new Successor(action, state));
    }
}
