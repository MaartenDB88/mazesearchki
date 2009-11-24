/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binf.ai.search.doolhof;

import binf.ai.search.problem.State;

/**
 *
 * @author Stefan
 */
public class Run {

    public static void main(String[] args) {
        int dim1 = 8;
        int dim2 = 8;
//        int[][] doolhof = new int[dim1][dim2];

        GenereerDoolhof dh = new GenereerDoolhof();

//        doolhof = dh.genereerDoolhof(dim1, dim2);
//        for (int x = 0; x < dim1; x++)
//        {
//            for (int y = 0; y < dim2; y++)
//            {
//                if(y%8 == 0)
//                {
//                    System.out.println();
//                }
//                System.out.print(doolhof[x][y]);
//            }
//        }
//        System.out.println();

        Status[][] test = new Status[dim1][dim2];
        test = dh.leesDoolhofVanBestand();
        for (int x = 0; x < dim1; x++) {
            for (int y = 0; y < dim2; y++) {
                if (y % 8 == 0) {
                    System.out.println();
                }
                System.out.print(test[x][y]);
            }
        }
        System.out.println();


        State[][] doolhofMetStates = new State[dim1][dim2];
        for (int x = 0; x < dim1; x++) {
            for (int y = 0; y < dim2; y++) {
                doolhofMetStates[x][y] = new DoolhofState(x, y, test[x][y]);
            }
        }
    }
}
