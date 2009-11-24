<<<<<<< .mine
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binf.ai.search.doolhof;

/**
 *
 * @author Stefan
 */
public class Run {
    public static void main(String[] args)
    {
        int [][] doolhof = new int[8][8];
        GenereerDoolhof dh = new GenereerDoolhof();
        //dh.leesDoolhofVanBestand();
//        doolhof = dh.genereerDoolhof(8, 8);
//        for (int x = 0; x < 8; x++)
//        {
//            for (int y = 0; y < 8; y++)
//            {
//                if(y%8 == 0)
//                {
//                    System.out.println();
//                }
//                System.out.print(doolhof[x][y]);
//            }
//        }
//        System.out.println();
            int[][] test = new int[8][8];
            test = dh.leesDoolhofVanBestand();
            for (int x = 0; x < 8; x++)
            {
                for (int y = 0; y < 8; y++)
                {
                    if(y%8 == 0)
                    {
                        System.out.println();
                    }
                System.out.print(test[x][y]);
                }
            }
            System.out.println();
   }
}
=======
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binf.ai.search.doolhof;

/**
 *
 * @author Stefan
 */
public class Run {
    public static void main(String[] args)
    {
        int [][] doolhof = new int[8][8];
        GenereerDoolhof dh = new GenereerDoolhof();
        //dh.leesDoolhofVanBestand();
        doolhof = dh.genereerDoolhof(8, 8);
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                System.out.println(doolhof[x][y]);
            }
        }
    }

}
>>>>>>> .r13
