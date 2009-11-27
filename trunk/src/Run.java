/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import binf.ai.search.doolhof.Doolhof;
import binf.ai.search.problem.Problem;
import bing.ai.search.manager.InformedSearchFactory;
import java.io.File;

/**
 *
 * @author Stefan
 */
public class Run {

    private static final int DEFAULT_DIMENSIE = 8;

    public static void main(String[] args) {
        Doolhof doolhof = null;
        Problem problem = null;
        long start;
        long end;

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
//            new MainFrame().setVisible(true);
            doolhof = Doolhof.getProblemFromDimension(DEFAULT_DIMENSIE);
            problem = doolhof.getProblem();
        }

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
//        start = System.currentTimeMillis();
//        System.out.println("\n");
//        System.out.println("AStarGraphSearch - graphsearch");
//        new AStarGraphSearch(problem);
//        end = System.currentTimeMillis();
//        System.out.println("Execution time was "+(end-start)+" ms.");

        InformedSearchFactory informedSearchFactory =
                new InformedSearchFactory(doolhof, problem);

        informedSearchFactory.getManagedAStarTreeSearch().printManagedSearch();
        informedSearchFactory.getManagedPriorityQueueTreeSearch().printManagedSearch();
    }
}
