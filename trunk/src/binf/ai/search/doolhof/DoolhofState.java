/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binf.ai.search.doolhof;

import binf.ai.search.problem.State;
import binf.ai.search.problem.Successor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elias
 */
public class DoolhofState implements State {

    private int xCord;
    private int yCord;
    private Status status;
    private List<State> successors;

    public DoolhofState(int xCord, int yCord, Status status) {
        this.xCord = xCord;
        this.yCord = yCord;
        this.status = status;
        successors = new ArrayList<State>();
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

    public Status getStatus() {
        return status;
    }

    public int getxCord() {
        return xCord;
    }

    public int getyCord() {
        return yCord;
    }

    public void addSuccessor(String action, State state){
        successors.add(state);
    }

    @Override
    public String toString(){
        return "(" + xCord + "," + yCord + ")" + " " + status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    List<State> getSuccessors() {
        return successors;
    }
}
