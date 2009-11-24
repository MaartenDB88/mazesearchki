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
    BLANK (0,'o'),
    START (2,'s'),
    GOAL (3,'g'),
    OBSTACLE (1,'x');

    private int nummer;
    private char status;

    private Status(int nummer, char status){
        this.nummer=nummer;
        this.status=status;
    }

    public String toString(){
        return Character.toString(status);
    }

    public int getNummer(){
        return nummer;
    }
}
