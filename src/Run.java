/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import binf.ai.search.doolhof.Doolhof;
import binf.ai.search.informed.AStarGraphSearch;
import binf.ai.search.informed.AStarTreeSearch;
import binf.ai.search.informed.PriorityQueueGraphSearch;
import binf.ai.search.informed.PriorityQueueTreeSearch;
import binf.ai.search.problem.Problem;
import binf.ai.search.uninformed.BreadthFirstGraphSearch;
import binf.ai.search.uninformed.BreadthFirstTreeSearch;
import binf.ai.search.uninformed.DepthFirstTreeSearchNoLimit;
import binf.ai.search.uninformed.DepthFirstTreeSearchWithLimit;
import binf.ai.search.uninformed.DepthNoLimitGraphSearch;
import binf.ai.search.uninformed.DepthWithLimitGraphSearch;
import java.io.File;

/**
 *
 * @author Stefan
 */
public class Run {

    private static final int DEFAULT_DIMENSIE = 1000;

    public static void main(String[] args) {
        Doolhof dh = new Doolhof();
        Problem problem = null;
        long start;
        long end;

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
            //problem = dh.getDoolhofVanBestand(new File("voorbeeldDoolhof.txt"));
        }
//        dh.printDoolhof();

//        start = System.currentTimeMillis();
//        System.out.println("\n");
//        System.out.println("Breedte eerst zoeken - treesearch");
//        new BreadthFirstTreeSearch(problem);
//        end = System.currentTimeMillis();
//        System.out.println("Execution time was "+(end-start)+" ms.");
//
//        start = System.currentTimeMillis();
//        System.out.println("\n");
//        System.out.println("Diepte zoeken met limiet 9 - treesearch");
//        new DepthFirstTreeSearchWithLimit(problem, 9);
//        end = System.currentTimeMillis();
//        System.out.println("Execution time was "+(end-start)+" ms.");
//
////        start = System.currentTimeMillis();
////        System.out.println("\n");
//////        Werkt niet correct zonder een limiet (Outofmemory error)
////        System.out.println("Diepte eerst zoeken zonder limiet - treesearch");
////        new DepthFirstTreeSearchNoLimit(problem);
////        end = System.currentTimeMillis();
////        System.out.println("Execution time was "+(end-start)+" ms.");
//
//        start = System.currentTimeMillis();
//        System.out.println("\n");
//        System.out.println("Kleinste kost eerst (priorityqueue) - treesearch");
//        new PriorityQueueTreeSearch(problem);
//        end = System.currentTimeMillis();
//        System.out.println("Execution time was "+(end-start)+" ms.");
//
//        start = System.currentTimeMillis();
//        System.out.println("\n");
//        System.out.println("Kleinste kost eerst (priorityqueue) - graphsearch");
//        new PriorityQueueGraphSearch(problem);
//        end = System.currentTimeMillis();
//        System.out.println("Execution time was "+(end-start)+" ms.");
//
//        start = System.currentTimeMillis();
//        System.out.println("\n");
//        System.out.println("Breedte eerst zoeken - graphsearch");
//        new BreadthFirstGraphSearch(problem);
//        end = System.currentTimeMillis();
//        System.out.println("Execution time was "+(end-start)+" ms.");
//
//        start = System.currentTimeMillis();
//        System.out.println("\n");
//        System.out.println("Diepte eerst zoeken met limit 9 - graphsearch");
//        new DepthWithLimitGraphSearch(problem, 9);
//        end = System.currentTimeMillis();
//        System.out.println("Execution time was "+(end-start)+" ms.");
//
//        start = System.currentTimeMillis();
//        System.out.println("\n");
//        System.out.println("Diepte eerst zoeken zonder limiet - graphsearch");
//        new DepthNoLimitGraphSearch(problem);
//        end = System.currentTimeMillis();
//        System.out.println("Execution time was "+(end-start)+" ms.");
//
//        start = System.currentTimeMillis();
//        System.out.println("\n");
//        System.out.println("AStarTreeSearch - treesearch");
//        new AStarTreeSearch(problem);
//        end = System.currentTimeMillis();
//        System.out.println("Execution time was "+(end-start)+" ms.");
//
        start = System.currentTimeMillis();
        System.out.println("\n");
        System.out.println("AStarGraphSearch - graphsearch");
        new AStarGraphSearch(problem);
        end = System.currentTimeMillis();
        System.out.println("Execution time was "+(end-start)+" ms.");
    }
}
