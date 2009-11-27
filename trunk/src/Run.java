/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import binf.ai.search.doolhof.Doolhof;
import binf.ai.search.gui.MainFrame;
import binf.ai.search.problem.Problem;
import java.io.File;

/**
 * beheert het programma, main klasse
 */
public class Run {

    private static final int DEFAULT_DIMENSIE = 8;

    /**
     * entry point
     * @param args
     */
    public static void main(String[] args) {
        Doolhof doolhof = null;
        Problem problem = null;

        if (args.length != 0) {
            try {
                doolhof = Doolhof.getProblemFromDimension(Integer.parseInt(args[0]));
                problem = doolhof.getProblem();
            } catch (Exception e) {
                System.out.println("Argument is not an Integer");
                try {
                    File file = new File(args[0]);
                    doolhof = Doolhof.getProblemFromFile(file);
                    problem = doolhof.getProblem();
                } catch (Exception ex) {
                    System.out.println("Error making file object or using diffrent dimension.");
                    System.exit(-1);
                }
            }

        } else {
            new MainFrame().setVisible(true);
//            doolhof = Doolhof.getProblemFromDimension(DEFAULT_DIMENSIE);
//            problem = doolhof.getProblem();
        }
    }
}
