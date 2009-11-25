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
    private State startBestand;
    private State eindeBestand;

    public GenereerDoolhof() {
    }
    
    private State[][] leesDoolhofVanBestand(File file) {
        try {
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
            int dimensie = Integer.parseInt(dimensies[0]);

            vierkant = new State[dimensie][dimensie];
            int teller = 0;
            for (String elem : stringLijst) {
                char[] chars = elem.trim().toCharArray();

                for (int i = 0; i < dimensie; i++) {

                    switch (chars[i]) {
                        case 'o':
                            vierkant[i][teller] = new DoolhofState(i, teller, Status.BLANK);
                            break;
                        case 'x':
                            vierkant[i][teller] = new DoolhofState(i, teller, Status.OBSTACLE);
                            break;
                        case 's':
                            vierkant[i][teller] = new DoolhofState(i, teller, Status.START);
                            startBestand = vierkant[i][teller];
                            break;
                        case 'g':
                            vierkant[i][teller] = new DoolhofState(i, teller, Status.GOAL);
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
        Random random = new Random();
        int maxAantalObstakels = (dimensie * dimensie) / 4;
        vierkant = new DoolhofState[dimensie][dimensie];

        //alle status op blank
        for (int y = 0; y < dimensie; y++) {
            for (int x = 0; x < dimensie; x++) {
                vierkant[x][y] = new DoolhofState(x, y, Status.BLANK);
            }
        }

        //start
        int start = random.nextInt(dimensie - 1);
        ((DoolhofState) vierkant[start][0]).setStatus(Status.START);
        startBestand = vierkant[start][0];

        //einde
        int einde = random.nextInt(dimensie - 1);
        ((DoolhofState) vierkant[einde][dimensie - 1]).setStatus(Status.GOAL);
        eindeBestand = vierkant[einde][dimensie - 1];

        //obstakels
        while (maxAantalObstakels > 0) {
            int randomRij = random.nextInt(dimensie);
            int randomKolom = random.nextInt(dimensie);

            if (((DoolhofState) vierkant[randomRij][randomKolom]).getStatus() == Status.BLANK) {
                ((DoolhofState) vierkant[randomRij][randomKolom]).setStatus(Status.OBSTACLE);
                maxAantalObstakels--;
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

    public Problem getGegenereerdProblem(int dimensie) {
        genereerDoolhof(dimensie);
        return new Problem(startBestand, new DoolhofSuccessorFunction(),
                new DoolhofGoalTest(eindeBestand), new DoolhofPathCostFunction(),
                new DoolhofHeuristicFunction(eindeBestand));
    }

    public Problem getDoolhofVanBestand(File file) {
        leesDoolhofVanBestand(file);
        return new Problem(startBestand, new DoolhofSuccessorFunction(),
                new DoolhofGoalTest(eindeBestand), new DoolhofPathCostFunction(),
                new DoolhofHeuristicFunction(eindeBestand));
    }

    public void addSuccesors() {
        for (int x = 0; x < vierkant.length; x++) {
            for (int y = 0; y < vierkant.length; y++) {
                for (Action actie : Action.values()) {
                    int relX = x + actie.getRelativeX();
                    int relY = y + actie.getRelativeY();
                    if ((relX >= 0) && (relY >= 0) &&
                            relX < vierkant.length && relY < vierkant.length &&
                            ((DoolhofState) vierkant[relX][relY]).getStatus() != Status.OBSTACLE &&
                            ((DoolhofState) vierkant[x][y]).getStatus() != Status.OBSTACLE) {
                        ((DoolhofState) vierkant[x][y]).addSuccessor(vierkant[relX][relY]);
                    }
                }
            }
        }


    }
}
