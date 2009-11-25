/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binf.ai.search.doolhof;

import binf.ai.search.problem.State;
import java.util.LinkedList;
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
        successors = new LinkedList<State>();
    }

    public boolean sameState(State state) {
        return this == state;
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

    public void addSuccessor(State state){
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
