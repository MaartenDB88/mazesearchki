/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binf.ai.search.doolhof;

import binf.ai.search.problem.State;

/**
 *
 * @author Elias
 */
public class DoolhofState implements State {

    private int xCord;
    private int yCord;
    private Status status;

    public DoolhofState(int xCord, int yCord, Status status) {
        this.xCord = xCord;
        this.yCord = yCord;
        this.status = status;
    }

    public boolean sameState(State state) {
        DoolhofState cur = (DoolhofState)state;
        if (this.status.equals(cur.getStatus()) &&
                this.xCord == cur.getxCord() &&
                this.yCord == cur.getyCord())
            return true;
        else return false;
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

    @Override
    public String toString(){
        return "(" + xCord + "," + yCord + ")" + " " + status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
