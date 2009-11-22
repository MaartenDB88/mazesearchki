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

  private int dimensie;
  private int doolhof[][];
  private int obstakel = 0;


    public int[][] genereerDoolhof(int dim)
    {
        this.dimensie = dim;
        doolhof = new int[dimensie][dimensie];
        
        //max 25 procent obstakels
        int maxAantalObstalkels = (dimensie * dimensie) / 4;

        Random random = new Random();

        //alles leeg zetten
        for(int x = 0; x < dimensie; x++ )
      {
          for(int y = 0; y < dimensie; y++)
          {
              doolhof[x][y] = 0;
          }
      }
        
        //startpositie agent instellen
        for(int x = 0; x < 1; x ++)
        {
            for(int y = 0; y < dimensie; y++)
            {
                int next = random.nextInt(dimensie - 1);
                doolhof[0][next] = 2;
            }
        }

        //uitgang instellen
        for(int x = dimensie; x > dimensie - 1; x --)
        {
            for(int y = 0; y < dimensie; y++)
            {
                int next = random.nextInt(dimensie - 1);
                doolhof[dimensie][next] = 2;
            }
        }
        
        //obstakels instellen
        for(int x = 0; x < dimensie; x ++)
        {
            for(int y = 0; y < dimensie; y++)
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

    //deze methode werkt nog niet helemaal (kan nog geen dimensies lezen)
    public int[][] leesDoolhofVanBestand()
    {
        try
        {
        File file = new File("voorbeeldDoolhof.txt");
        FileInputStream fIs = new FileInputStream(file);
        String n;
        

         for(int x = 0; x < dimensie; x ++)
        {
            for(int y = 0; y < dimensie; y++)
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
            System.out.println(ex.getMessage());
        }
          return doolhof;
    }

}
