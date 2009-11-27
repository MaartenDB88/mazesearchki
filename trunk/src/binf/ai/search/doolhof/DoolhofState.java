package binf.ai.search.doolhof;

import binf.ai.search.problem.State;

/**
 * is een state van de doolhof
 */
public class DoolhofState implements State {

    private int xCord;
    private int yCord;
    private Status status;

    /**
     * creeert een instantie
     * @param xCord x coordinaat van de state
     * @param yCord y coordinaat van de state
     * @param status de status van de staat
     */
    public DoolhofState(int xCord, int yCord, Status status) {
        this.xCord = xCord;
        this.yCord = yCord;
        this.status = status;
    }

    /**
     * berekent of een state gelijk is aan deze state
     * @param state de state die met deze state vergeleken wordt
     * @return boolean
     */
    public boolean sameState(State state) {
        DoolhofState cur = (DoolhofState)state;
        if (this.status.equals(cur.getStatus()) &&
                this.xCord == cur.getxCord() &&
                this.yCord == cur.getyCord())
            return true;
        else return false;
    }

    /**
     * geeft de status weer
     * @return Status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * geeft de x coordinaat weer
     * @return int
     */
    public int getxCord() {
        return xCord;
    }

    /**
     * geeft de y coordinaat weer
     * @return int
     */
    public int getyCord() {
        return yCord;
    }

    @Override
    public String toString(){
        return "(" + xCord + "," + yCord + ")" + " " + status;
    }

    /**
     * stelt de status in
     * @param status de nieuwe status van deze state
     */
    public void setStatus(Status status) {
        this.status = status;
    }
}
