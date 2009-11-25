/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binf.ai.search.doolhof;

import binf.ai.search.informed.AStarTreeSearch;
import binf.ai.search.informed.BreadthFirstGraphSearch;
import binf.ai.search.informed.DepthNoLimitGraphSearch;
import binf.ai.search.informed.DepthWithLimitGraphSearch;
import binf.ai.search.informed.PriorityQueueGraphSearch;
import binf.ai.search.problem.Problem;
import binf.ai.search.uninformed.BreadthFirstTreeSearch;
import binf.ai.search.uninformed.DepthFirstTreeSearchNoLimit;
import binf.ai.search.uninformed.DepthFirstTreeSearchWithLimit;
import binf.ai.search.uninformed.PriorityQueueTreeSearch;

/**
 *
 * @author Stefan
 */
public class Run {

    public static void main(String[] args) {

        GenereerDoolhof dh = new GenereerDoolhof();

        Problem problem = dh.getDoolhofVanBestand();
        dh.printDoolhof();

        System.out.println("Breedte eerst zoeken treesearch");
        new BreadthFirstTreeSearch(problem);

        System.out.println("Diepte zoeken met limiet 9 treesearch");
        new DepthFirstTreeSearchWithLimit(problem, 9);

//      Werkt niet correct zonder een limiet (Outofmemory error)
//        System.out.println("Diepte eerst zonder limiet treesearch");
//        new DepthFirstTreeSearchNoLimit(problem);

        System.out.println("TreeSearch met priorityqueue");
        new PriorityQueueTreeSearch(problem);

        System.out.println("GraphSearch met priorityqueue");
        new PriorityQueueGraphSearch(problem);

        System.out.println("Breedte eerst zoeken graphsearch");
        new BreadthFirstGraphSearch(problem);

        System.out.println("Diepte eerst zoeken met limit 9 graphsearch");
        new DepthWithLimitGraphSearch(problem, 9);

        System.out.println("Diepte eerst zonder limiet graphsearch");
        new DepthNoLimitGraphSearch(problem);

        System.out.println("AStarTreeSearch");
        new AStarTreeSearch(problem);
    }
}
