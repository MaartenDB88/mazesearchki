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
 * Genereert een doolhof en laat dan toe de bijbehorende Problem klasse op te vragen
 */
public class Doolhof {
    private Problem problem;

    // 2-dimensionale array van chars
    // Weergave van de doolhof
    private char[][] data;

    // Start van de doolhof
    private State initialState;

    // Einddoel
    private State goalState;

    private Doolhof(File file) {
        problem = leesDoolhofUitBestand(file);
    }

    private Doolhof(int dimensie) {
        problem = genereerDoolhof(dimensie);
    }

    // Genereer doolhof uit bestand
    private Problem leesDoolhofUitBestand(File file) {
        // Zet het bestand om naar een stringlijst, lijn per lijn
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

        // Eerste lijn geeft de dimensie
        String[] dimensies = stringLijst.remove(0).split(",");
        int dimensie = Integer.parseInt(dimensies[0]);

        // Maak de data array en stel start en eindstate in
        data = new char[dimensie][dimensie];
        char cStart = Status.START.getStatus();
        char cGoal = Status.GOAL.getStatus();

        // Zet om naar characters, vul de data array
        // Maak de begin en eind State objecten
        int teller = 0;
        for (String elem : stringLijst) {
            char[] chars = elem.trim().toCharArray();
            for (int i = 0; i < chars.length; ++i) {
                data[i][teller] = chars[i];
                if (chars[i] == cStart) initialState = new DoolhofState(i, teller, Status.START);
                else if (chars[i] == cGoal) goalState = new DoolhofState(i, teller, Status.GOAL);
            }
            teller++;
        }

        // Maak het correcte Problem object aan
        return new Problem(initialState, new DoolhofSuccessorFunction(data),
                new DoolhofGoalTest(goalState), new DoolhofPathCostFunction(),
                new DoolhofHeuristicFunction(goalState));
    }

    // Genereer nieuw doolhof
    private Problem genereerDoolhof(int dimensie) {
        // Maak de data array en stel het
        // maximum aantal obstakels in op 25%
        Random random = new Random();
        int maxAantalObstakels = (dimensie * dimensie) / 4;
        data = new char[dimensie][dimensie];

        // De mogelijke statussen van een State
        char cBlank = Status.BLANK.getStatus();
        char cStart = Status.START.getStatus();
        char cGoal = Status.GOAL.getStatus();
        char cObstacle = Status.OBSTACLE.getStatus();

        // Zet alle vakjes op leeg
        for (int y = 0; y < dimensie; y++) {
            for (int x = 0; x < dimensie; x++) {
                data[x][y] = cBlank;
            }
        }

        // Maak de start State aan
        int start = random.nextInt(dimensie - 1);
        data[start][dimensie - 1] = cStart;
        initialState = new DoolhofState(start, dimensie - 1, Status.START);

        // Maak de eind State aan
        int einde = random.nextInt(dimensie - 1);
        data[einde][0] = cGoal;
        goalState = new DoolhofState(einde, 0, Status.GOAL);

        // Bereken de obstakels en stel ze in
        while (maxAantalObstakels > 0) {
            int randomRij = random.nextInt(dimensie);
            int randomKolom = random.nextInt(dimensie);

            if (data[randomRij][randomKolom] == cBlank) {
                data[randomRij][randomKolom] = cObstacle;
                maxAantalObstakels--;
            }
        }

        // Maak het correcte Problem object aan
        return new Problem(initialState, new DoolhofSuccessorFunction(data),
                new DoolhofGoalTest(goalState), new DoolhofPathCostFunction(),
                new DoolhofHeuristicFunction(goalState));
    }

    /**
     * Geeft de Problem terug van het probleem
     * @return Problem
     */
    public Problem getProblem() {
        return problem;
    }

    // Geeft text versie van de doolhof weer
    @Override
    public String toString() {
        String output = "";
        for (int y = 0; y < data.length; y++) {
            for (int x = 0; x < data.length; x++)
                output += data[x][y];
            output += "\n";
        }

        return output;
    }

    /**
     * Genereert een doolhof met de gespecifieerde dimensie
     * @param dimensie de dimensie van de doolhof
     * @return Doolhof
     */
    public static Doolhof getProblemFromDimension(int dimensie) {
        return new Doolhof(dimensie);
    }
    /**
     * Genereert een doolhof uit het gespecifieerde bestand
     * @param file het bestand met daarin de doolhof
     * @return Doolhof
     */
    public static Doolhof getProblemFromFile(File file) {
        return new Doolhof(file);
    }
}
