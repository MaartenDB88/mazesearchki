/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binf.ai.search.doolhof;

/**
 *
 * @author Elias
 */
public enum Action {
    NOORD(1, 0, -1),
    NOORDOOST((float) Math.sqrt(2), 1, -1),
    OOST(1, 1, 0),
    ZUIDOOST((float) Math.sqrt(2), 1, 1),
    ZUID(1, 0, 1),
    ZUIDWEST((float) Math.sqrt(2), -1, 1),
    WEST(1, -1, 0),
    NOORDWEST((float) Math.sqrt(2), -1, -1);

    private float cost;
    private int x,y;

    private Action(float cost, int x, int y){
        this.cost=cost;
        this.x=x;
        this.y=y;
    }

    public float getCost(){
        return cost;
    }

    public int getRelativeX() {
        return x;
    }

    public int getRelativeY() {
        return y;
    }
}
