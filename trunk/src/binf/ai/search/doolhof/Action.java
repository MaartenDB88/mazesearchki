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
    NOORD(1),
    NOORDOOST((float) Math.sqrt(2)),
    OOST(1),
    ZUIDOOST((float) Math.sqrt(2)),
    ZUID(1),
    ZUIDWEST((float) Math.sqrt(2)),
    WEST(1),
    NOORDWEST((float) Math.sqrt(2));

    private float cost;

    private Action(float cost){
        this.cost=cost;
    }

    public float getCost(){
        return cost;
    }
}
