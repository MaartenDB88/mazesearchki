/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binf.ai.search.doolhof;

/**
 *
 * @author Elias
 */
public enum Status {
    BLANK ('o'),
    START ('s'),
    GOAL ('g'),
    OBSTACLE ('x');

    private char status;

    private Status(char status){
        this.status=status;
    }

    @Override
    public String toString(){
        return Character.toString(status);
    }
}
