/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import binf.ai.search.doolhof.Doolhof;
import binf.ai.search.gui.MainFrame;
import binf.ai.search.problem.Problem;
import binf.ai.search.manager.UninformedSearchFactory;
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

//        InformedSearchFactory informedSearchFactory =
//                new InformedSearchFactory(doolhof, problem);
//
//        informedSearchFactory.getManagedAStarTreeSearch().printManagedSearch();
//        informedSearchFactory.getManagedPriorityQueueTreeSearch().printManagedSearch();
//        informedSearchFactory.getManagedAStarGraphSearch().printManagedSearch();
//        informedSearchFactory.getManagedPriorityQueueGraphSearch().printManagedSearch();
//
//        UninformedSearchFactory uninformedSearchFactory =
//                new UninformedSearchFactory(doolhof, problem);
//
<<<<<<< .mine
//        uninformedSearchFactory.getManagedBreadthFirstTreeSearch().printManagedSearch();
//        uninformedSearchFactory.getManagedDepthFirstTreeSearchNoLimit().printManagedSearch();
//        uninformedSearchFactory.getManagedDepthFirstTreeSearchWithLimit(9).printManagedSearch();
//        uninformedSearchFactory.getManagedBreadthFirstGraphSearch().printManagedSearch();
//        uninformedSearchFactory.getManagedDepthFirstGraphSearchNoLimit().printManagedSearch();
//        uninformedSearchFactory.getManagedDepthFirstGraphSearchWithLimit(9).printManagedSearch();
=======
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

//        InformedSearchFactory informedSearchFactory =
//                new InformedSearchFactory(doolhof, problem);
//
//        informedSearchFactory.getManagedAStarTreeSearch().printManagedSearch();
//        informedSearchFactory.getManagedPriorityQueueTreeSearch().printManagedSearch();
>>>>>>> .r57
    }
}
