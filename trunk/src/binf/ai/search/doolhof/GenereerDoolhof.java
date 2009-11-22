/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binf.ai.search.doolhof;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author Stefan
 */
public class GenereerDoolhof
{
  //int -> 0 (nul) = vrij vak; 1 = obstakel; 2 = startpositie agent, 3 = eindpositie;
  //String -> o (letter)  = vrij vak; x = obstakel; s = startpositie , g = eindpositie ;

  private int doolhof[][];
  private int obstakel = 0;

    public GenereerDoolhof()
    {
        
    }
    public int[][] genereerDoolhof(int dim1, int dim2)
    {
 
        doolhof = new int[dim1][dim2];
        
        //max 25 procent obstakels
        int maxAantalObstalkels = (dim1 * dim2) / 4;

        Random random = new Random();

        //alles leeg zetten
        for(int x = 0; x < dim1; x++ )
      {
          for(int y = 0; y < dim2; y++)
          {
              doolhof[x][y] = 0;
          }
      }
        
        //startpositie agent instellen
//        for(int x = 0; x < 1; x ++)
//        {
//            for(int y = 0; y < dim1; y++)
//            {
                int start = random.nextInt(dim2 - 1);
                doolhof[0][start] = 2;
//            }
//        }

        //uitgang instellen
//        for(int x = dim1; x > dim1 - 1; x --)
//        {
//            for(int y = 0; y < dim2; y++)
//            {
                int uitgang = random.nextInt(dim2 - 1);
                doolhof[dim2 - 1][uitgang] = 3;
//            }
//        }
        
        //obstakels instellen
        for(int x = 0; x < dim1; x ++)
        {
            for(int y = 0; y < dim2; y++)
            {
                int next = random.nextInt(3);
                if(next == 1 && doolhof[x][y] != 2 && doolhof[x][y]!= 3 && obstakel < maxAantalObstalkels)
                {
                    obstakel ++;
                    doolhof[x][y] = next;
                }
            }
        }
        
       return doolhof;
    }

    //deze methode werkt nog niet helemaal (deze werkt als fIs.read() automatisch zijn positie zou opslaan)
    public int[][] leesDoolhofVanBestand()
    {
        try
        {
        File file = new File("C:\\voorbeeldDoolhof.txt");
        FileInputStream fIs = new FileInputStream(file);
        int dim1 = 0, dim2 = 0;
        
        for(int i = 0; i <= 2; i++)
        {
            if (i == 0)
            {
                dim1 = Integer.parseInt(Character.toString((char)fIs.read()));
            }
            if(i == 2)
            {
                dim2 = Integer.parseInt(Character.toString((char)fIs.read()));
            }
        }
        //test
        System.out.println(dim1 + dim2);
        
         for(int x = 0; x < dim1; x ++)
        {
            for(int y = 0; y < dim2; y++)
            {
               
                 String next = Character.toString((char)fIs.read());

                
                 if(next.equals("o"))
                 {
                   doolhof[x][y] = 0;
                 }
                 else if(next.equals("x"))
                 {
                     doolhof[x][y] = 1;
                 }
                 else if(next.equals("s"))
                 {
                     doolhof[x][y] = 2;
                 }
                 else
                 {
                     doolhof[x][y] = 3;
                 }
            }
         }
        }//end try
        catch (Exception ex)
        {
            System.out.println("fout:" + ex.getMessage());
        }
          return doolhof;
    }
}
