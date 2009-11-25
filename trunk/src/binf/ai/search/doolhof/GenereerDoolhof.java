/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binf.ai.search.doolhof;

import binf.ai.search.problem.Problem;
import binf.ai.search.problem.State;
import java.io.BufferedReader;
import java.io.File;
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
public class GenereerDoolhof {
    //int -> 0 (nul) = vrij vak; 1 = obstakel; 2 = startpositie agent, 3 = eindpositie;
    //String -> o (letter)  = vrij vak; x = obstakel; s = startpositie , g = eindpositie ;

    private State[][] vierkant;
    private int dimensie;
    private int start;
    private int einde;
    private State startBestand;
    private State eindeBestand;

    public GenereerDoolhof() {
    }
    // <editor-fold defaultstate="collapsed" desc="ouden brol">

    /*
    public Status[][] genereerDoolhof(int dim1, int dim2) {

    doolhof = new Status[dim1][dim2];

    //max 25 procent obstakels
    int maxAantalObstalkels = (dim1 * dim2) / 4;

    Random random = new Random();

    //alles leeg zetten
    for (int x = 0; x < dim1; x++) {
    for (int y = 0; y < dim2; y++) {
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
    for (int x = 0; x < dim1; x++) {
    for (int y = 0; y < dim2; y++) {
    int next = random.nextInt(3);
    if (next == 1 && doolhof[x][y] != Status.START && doolhof[x][y] != Status.GOAL && obstakel < maxAantalObstalkels) {
    obstakel++;
    doolhof[x][y] = Status.OBSTACLE;
    }
    }
    }

    return doolhof;
    }
     */
    //deze methode werkt nog niet helemaal (deze werkt als fIs.read() automatisch zijn positie zou opslaan)

          // </editor-fold>

    public State[][] leesDoolhofVanBestand() {
        try {
            File file = new File("voorbeeldDoolhof.txt");
            int dim1 = 0;
            int dim2 = 0;

            List<String> stringLijst = new ArrayList<String>();
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
                String text = null;
                while ((text = reader.readLine()) != null) {
                    text = text.trim().replaceAll("\\u0000", "");
                    text = text.trim().replaceAll("\\ufffd", "");
                    if (!text.isEmpty()) {
                        stringLijst.add(text);
                    }
                }

            } catch (FileNotFoundException ex) {
                System.out.println("Het bestand kon niet worden gevonden");
                System.exit(-1);
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            String[] dimensies = stringLijst.remove(0).split(",");
            dim1 = Integer.parseInt(dimensies[0]);           

            vierkant = new State[dim1][dim1];
            int teller = 0;
            for (String elem : stringLijst) {
                char[] chars = elem.trim().toCharArray();

                for (int i = 0; i < dim1; i++) {

                    switch (chars[i]) {
                        case 'o':
                            vierkant[i][teller] = new DoolhofState(i, teller,Status.BLANK);
                            break;
                        case 'x':
                            vierkant[i][teller] = new DoolhofState(i, teller,Status.OBSTACLE);
                            break;
                        case 's':
                             
                            vierkant[i][teller] = new DoolhofState(i, teller,Status.START);
                            startBestand = vierkant[i][teller];
                            break;
                        case 'g':
                            
                            vierkant[i][teller] = new DoolhofState(i, teller,Status.GOAL);
                            eindeBestand = vierkant[i][teller];
                            break;
                        default:

                    }
                }
                teller++;
            }

        }//end try
        catch (Exception ex) {
            System.out.println("fout:" + ex.getClass() + ex.getMessage());
            ex.printStackTrace();
        }
         addSuccesors();
        return vierkant;
    }

    public State[][] genereerDoolhof(int dimensie) {
        this.dimensie = dimensie;
        Random random = new Random();
        int maxAantalObstalkels = (dimensie * dimensie) / 4;
        vierkant = new DoolhofState[dimensie][dimensie];

        //alle status op blank
        for (int x = 0; x < dimensie; x++) {
            for (int y = 0; y < dimensie; y++) {

                vierkant[x][y] = new DoolhofState(x, y, Status.BLANK);
            }
        }

        //start
        start = random.nextInt(dimensie - 1);
        ((DoolhofState) vierkant[start][0]).setStatus(Status.START);

        //einde
        einde = random.nextInt(dimensie - 1);
        ((DoolhofState) vierkant[einde][dimensie - 1]).setStatus(Status.GOAL);

        //obstakels
        while (maxAantalObstalkels > 0) {
            int randomRij = random.nextInt(dimensie);
            int randomKolom = random.nextInt(dimensie);

            if (((DoolhofState) vierkant[randomRij][randomKolom]).getStatus() == Status.BLANK) {
                ((DoolhofState) vierkant[randomRij][randomKolom]).setStatus(Status.OBSTACLE);
                maxAantalObstalkels--;
            }
        }

        //addSuccesor

        addSuccesors();
        
        return vierkant;
    }

    public void printDoolhof() {
        for (int y = 0; y < vierkant.length; y++) {
            for (int x = 0; x < vierkant.length; x++) {

                System.out.print(((DoolhofState) vierkant[x][y]).getStatus().toString());
            }
            System.out.println();
        }
        System.out.println();

    }

    public State getGoalState() {
        return vierkant[einde][dimensie - 1];

    }

    public State getInitState() {
        return vierkant[start][0];
    }

    public Problem getGegenereerdProblem(int dimensie) {
        genereerDoolhof(dimensie);
        return new Problem(getInitState(), new DoolhofSuccessorFunction(),
                new DoolhofGoalTest(getGoalState()), new DoolhofPathCostFunction(),
                new DoolhofHeuristicFunction(getGoalState()));
    }
    
    public Problem getDoolhofVanBestand()
    {
        leesDoolhofVanBestand();
        return new Problem(startBestand, new DoolhofSuccessorFunction(),
                new DoolhofGoalTest(eindeBestand), new DoolhofPathCostFunction(),
                new DoolhofHeuristicFunction(eindeBestand));
    }

    public void addSuccesors()
    {
        for (int x = 0; x < vierkant.length; x++) {
            for (int y = 0; y < vierkant.length; y++) {
                for (Action actie : Action.values()) {
                    int relX = x + actie.getRelativeX();
                    int relY = y + actie.getRelativeY();
                    if ((relX >= 0) && (relY >= 0) &&
                            relX < vierkant.length && relY < vierkant.length &&
                            ((DoolhofState) vierkant[relX][relY]).getStatus() != Status.OBSTACLE &&
                            ((DoolhofState) vierkant[x][y]).getStatus() != Status.OBSTACLE) {
                        ((DoolhofState) vierkant[x][y]).addSuccessor(actie.toString(),
                                vierkant[relX][relY]);
                    }
                }
            }
        }

        
    }

}
