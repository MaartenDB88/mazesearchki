/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binf.ai.search.doolhof;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Stefan
 */
public class GenereerDoolhof
{
  //int -> 0 (nul) = vrij vak; 1 = obstakel; 2 = startpositie agent, 3 = eindpositie;
  //String -> o (letter)  = vrij vak; x = obstakel; s = startpositie , g = eindpositie ;

  private Status[][] doolhof;
  private int obstakel = 0;

    public GenereerDoolhof()
    {
        
    }
    public Status[][] genereerDoolhof(int dim1, int dim2)
    {
 
        doolhof = new Status[dim1][dim2];
        
        //max 25 procent obstakels
        int maxAantalObstalkels = (dim1 * dim2) / 4;

        Random random = new Random();

        //alles leeg zetten
        for(int x = 0; x < dim1; x++ )
      {
          for(int y = 0; y < dim2; y++)
          {
              doolhof[x][y] = Status.BLANK;
          }
      }
        
        //startpositie agent instellen
                int start = random.nextInt(dim1 - 1);
                doolhof[start][0] = Status.START;

        //uitgang instellen

                int uitgang = random.nextInt(dim1 - 1);
                doolhof[uitgang][dim2 - 1] = Status.GOAL;

        //obstakels instellen
        for(int x = 0; x < dim1; x ++)
        {
            for(int y = 0; y < dim2; y++)
            {
                int next = random.nextInt(3);
                if(next == 1 && doolhof[x][y] != Status.START
                        && doolhof[x][y]!= Status.GOAL
                        && obstakel < maxAantalObstalkels)
                {
                    obstakel ++;
                    doolhof[x][y] = Status.OBSTACLE;
                }
            }
        }
        
       return doolhof;
    }

    //deze methode werkt nog niet helemaal (deze werkt als fIs.read() automatisch zijn positie zou opslaan)
    public Status[][] leesDoolhofVanBestand()
    {
        try
        {
        int dim1 = 0;
        int dim2 = 0;
        
        List<String> stringLijst = new ArrayList<String>();
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader("C:\\voorbeeldDoolhof.txt"));
            String text = null;
            while ((text = reader.readLine()) != null)
            {
                stringLijst.add(text);
            }

        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Het bestand kon niet worden gevonden");
            System.exit(-1);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        String[] dimensies = stringLijst.get(0).split(",");
        List<String> doolhofStrings = new ArrayList<String>();
        
        dim1 = Integer.parseInt(dimensies[0].trim());
        dim2 = Integer.parseInt(dimensies[1].trim());

        for(int i = 0; i < stringLijst.size(); i++)
        {
            if(i > 0 && i%2 == 0) //het gaat niet over de dimensies, en enkel op de even regels staat inhoud omdat hij telkens een witte regel tussenvoegt
            {
                doolhofStrings.add(stringLijst.get(i));
               // System.out.println(i + stringLijst.get(i));
            }
        }
        for(String e: stringLijst)
        {
            //System.out.println(e);
        }
  
        doolhof = new Status[dim1][dim2];
        int teller = 0;
      
        for(String elem: doolhofStrings)
        {
            char[] chars = elem.trim().toCharArray();
            List<Character> charsList = new ArrayList<Character>();
          
            for(int i = 0; i < chars.length; i++)
            {
                System.out.println("before: " + i + " :" + chars[i]);
                if(i%2 == 0)
                {
                    charsList.add(chars[i]);
                }
                
            }
           
            for (int i = 0; i < dim1; i++)
            {
               
                switch (charsList.get(i))
                 {
                    case 'o':
                        doolhof[teller][i] = Status.BLANK;
                        break;
                    case 'x':
                        doolhof[teller][i] = Status.OBSTACLE;
                        break;
                    case 's':
                        doolhof[teller][i] = Status.START;
                        break;
                    case 'g':
                        doolhof[teller][i] = Status.GOAL;
                        break;
                    default:
                        ;
                 }
            }
             teller ++;
        }
        
        }//end try
        catch (Exception ex)
        {
            System.out.println("fout:" + ex.getClass() + ex.getMessage());
            ex.printStackTrace();
        }
          return doolhof;
    }
}