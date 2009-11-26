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
public class Doolhof {
    //int -> 0 (nul) = vrij vak; 1 = obstakel; 2 = startpositie agent, 3 = eindpositie;
    //String -> o (letter)  = vrij vak; x = obstakel; s = startpositie , g = eindpositie ;

    private char[][] vierkant;
    private State startBestand;
    private State eindeBestand;

    public Doolhof() {
    }

    private char[][] leesDoolhofVanBestand(File file) {
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
        vierkant = new char[dimensie][dimensie];
        char cStart = Status.START.getStatus();
        char cGoal = Status.GOAL.getStatus();

        int teller = 0;
        for (String elem : stringLijst) {
            char[] chars = elem.trim().toCharArray();
            for (int i = 0; i < chars.length; ++i) {
                vierkant[i][teller] = chars[i];
                if (chars[i] == cStart) startBestand = new DoolhofState(i, teller, Status.START);
                else if (chars[i] == cGoal) eindeBestand = new DoolhofState(i, teller, Status.GOAL);
            }
            teller++;
        }
        return vierkant;
    }

    public char[][] genereerDoolhof(int dimensie) {
        Random random = new Random();
        int maxAantalObstakels = (dimensie * dimensie) / 4;
        vierkant = new char[dimensie][dimensie];

        char cBlank = Status.BLANK.getStatus();
        char cStart = Status.START.getStatus();
        char cGoal = Status.GOAL.getStatus();
        char cObstacle = Status.OBSTACLE.getStatus();

        //alle status op blank
        for (int y = 0; y < dimensie; y++) {
            for (int x = 0; x < dimensie; x++) {
                vierkant[x][y] = cBlank;
            }
        }

        //start
        int start = random.nextInt(dimensie - 1);
        vierkant[start][dimensie - 1] = cStart;
        startBestand = new DoolhofState(start, dimensie - 1, Status.START);

        //einde
        int einde = random.nextInt(dimensie - 1);
        vierkant[einde][0] = cGoal;
        eindeBestand = new DoolhofState(einde, 0, Status.GOAL);

        //obstakels
        while (maxAantalObstakels > 0) {
            int randomRij = random.nextInt(dimensie);
            int randomKolom = random.nextInt(dimensie);

            if (vierkant[randomRij][randomKolom] == cBlank) {
                vierkant[randomRij][randomKolom] = cObstacle;
                maxAantalObstakels--;
            }
        }

        return vierkant;
    }

    public void printDoolhof() {
        for (int y = 0; y < vierkant.length; y++) {
            for (int x = 0; x < vierkant.length; x++) {

                System.out.print(vierkant[x][y]);

            }
            System.out.println();
        }
        System.out.println();
    }

    public Problem getGegenereerdProblem(int dimensie) {
        genereerDoolhof(dimensie);
        return new Problem(startBestand, new DoolhofSuccessorFunction(vierkant),
                new DoolhofGoalTest(eindeBestand), new DoolhofPathCostFunction(),
                new DoolhofHeuristicFunction(eindeBestand));
    }

    public Problem getDoolhofVanBestand(File file) {
        leesDoolhofVanBestand(file);
        return new Problem(startBestand, new DoolhofSuccessorFunction(vierkant),
                new DoolhofGoalTest(eindeBestand), new DoolhofPathCostFunction(),
                new DoolhofHeuristicFunction(eindeBestand));
    }
}
