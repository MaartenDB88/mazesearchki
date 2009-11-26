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

public class Doolhof {
    //String -> o (letter)  = vrij vak; x = obstakel; s = startpositie , g = eindpositie ;

    private Problem problem;

    private char[][] data;
    private State initialState;
    private State goalState;

    public Doolhof(File file) {
        problem = leesDoolhofUitBestand(file);
    }

    public Doolhof(int dimensie) {
        problem = genereerDoolhof(dimensie);
    }

    private Problem leesDoolhofUitBestand(File file) {
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
        data = new char[dimensie][dimensie];
        char cStart = Status.START.getStatus();
        char cGoal = Status.GOAL.getStatus();

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

        return new Problem(initialState, new DoolhofSuccessorFunction(data),
                new DoolhofGoalTest(goalState), new DoolhofPathCostFunction(),
                new DoolhofHeuristicFunction(goalState));
    }

    private Problem genereerDoolhof(int dimensie) {
        Random random = new Random();
        int maxAantalObstakels = (dimensie * dimensie) / 4;
        data = new char[dimensie][dimensie];

        char cBlank = Status.BLANK.getStatus();
        char cStart = Status.START.getStatus();
        char cGoal = Status.GOAL.getStatus();
        char cObstacle = Status.OBSTACLE.getStatus();

        //alle status op blank
        for (int y = 0; y < dimensie; y++) {
            for (int x = 0; x < dimensie; x++) {
                data[x][y] = cBlank;
            }
        }

        //start
        int start = random.nextInt(dimensie - 1);
        data[start][dimensie - 1] = cStart;
        initialState = new DoolhofState(start, dimensie - 1, Status.START);

        //einde
        int einde = random.nextInt(dimensie - 1);
        data[einde][0] = cGoal;
        goalState = new DoolhofState(einde, 0, Status.GOAL);

        //obstakels
        while (maxAantalObstakels > 0) {
            int randomRij = random.nextInt(dimensie);
            int randomKolom = random.nextInt(dimensie);

            if (data[randomRij][randomKolom] == cBlank) {
                data[randomRij][randomKolom] = cObstacle;
                maxAantalObstakels--;
            }
        }

        return new Problem(initialState, new DoolhofSuccessorFunction(data),
                new DoolhofGoalTest(goalState), new DoolhofPathCostFunction(),
                new DoolhofHeuristicFunction(goalState));
    }

    public Problem getProblem() {
        return problem;
    }

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

    public static Doolhof getProblemFromDimension(int dimensie) {
        return new Doolhof(dimensie);
        
    }

    public static Doolhof getProblemFromFile(File file) {
        return new Doolhof(file);
    }
}
