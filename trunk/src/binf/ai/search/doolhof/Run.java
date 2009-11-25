/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binf.ai.search.doolhof;

import binf.ai.search.informed.AStarGraphSearch;
import binf.ai.search.informed.AStarTreeSearch;
import binf.ai.search.informed.BreadthFirstGraphSearch;
import binf.ai.search.informed.DepthNoLimitGraphSearch;
import binf.ai.search.informed.DepthWithLimitGraphSearch;
import binf.ai.search.informed.PriorityQueueGraphSearch;
import binf.ai.search.problem.Problem;
import binf.ai.search.uninformed.BreadthFirstTreeSearch;
import binf.ai.search.uninformed.DepthFirstTreeSearchWithLimit;
import binf.ai.search.uninformed.PriorityQueueTreeSearch;
import java.io.File;

/**
 *
 * @author Stefan
 */
public class Run {

    private static final int DEFAULT_DIMENSIE = 8;

    public static void main(String[] args) {
        GenereerDoolhof dh = new GenereerDoolhof();
        Problem problem = null;

        if (args.length != 0) {
            try {
                problem = dh.getGegenereerdProblem(Integer.parseInt(args[0]));
            } catch (Exception e) {
                System.out.println("Argument is not an Integer");
                try {
                    File file = new File(args[0]);
                    problem = dh.getDoolhofVanBestand(file);
                } catch (Exception ex) {
                    System.out.println("Error making file object or using diffrent dimension.");
                    System.exit(-1);
                }
            }

        } else {
            problem = dh.getGegenereerdProblem(DEFAULT_DIMENSIE);
        }
        dh.printDoolhof();

        System.out.println("\n");
        System.out.println("Breedte eerst zoeken - treesearch");
        new BreadthFirstTreeSearch(problem);

        System.out.println("\n");
        System.out.println("Diepte zoeken met limiet 9 - treesearch");
        new DepthFirstTreeSearchWithLimit(problem, 9);

//        System.out.println("\n");
//      Werkt niet correct zonder een limiet (Outofmemory error)
//        System.out.println("Diepte eerst zoeken zonder limiet - treesearch");
//        new DepthFirstTreeSearchNoLimit(problem);

        System.out.println("\n");
        System.out.println("Kleinste kost eerst (priorityqueue) - treesearch");
        new PriorityQueueTreeSearch(problem);

        System.out.println("\n");
        System.out.println("Kleinste kost eerst (priorityqueue) - graphsearch");
        new PriorityQueueGraphSearch(problem);

        System.out.println("\n");
        System.out.println("Breedte eerst zoeken - graphsearch");
        new BreadthFirstGraphSearch(problem);

        System.out.println("\n");
        System.out.println("Diepte eerst zoeken met limit 9 - graphsearch");
        new DepthWithLimitGraphSearch(problem, 9);

        System.out.println("\n");
        System.out.println("Diepte eerst zoeken zonder limiet - graphsearch");
        new DepthNoLimitGraphSearch(problem);

        System.out.println("\n");
        System.out.println("AStarTreeSearch - treesearch");
        new AStarTreeSearch(problem);

        System.out.println("\n");
        System.out.println("AStarGraphSearch - graphsearch");
        new AStarGraphSearch(problem);
    }
}
