/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binf.ai.search.informed;

import binf.ai.search.framework.GraphSearch;
import binf.ai.search.nodestore.ClosedList;
import binf.ai.search.nodestore.Node;
import binf.ai.search.nodestore.NodeStore;
import binf.ai.search.nodestore.PriorityQueueNodeStore;
import binf.ai.search.problem.HeuristicFunction;
import binf.ai.search.problem.Problem;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Elias
 */
public class AStarGraphSearch extends GraphSearch {

    private static NodeStore getOpenList(Problem problem) {
        return new PriorityQueueNodeStore(getComparator(problem));
    }

    private static ClosedList getClosedList() {
        return new ClosedList();
    }

    public AStarGraphSearch(Problem problem) {
        super(problem, getOpenList(problem), getClosedList());

        List<String> resultaat = this.search(problem);
        System.out.println(resultaat);
    }

    private static Comparator<Node> getComparator(final Problem problem) {
        // dit zal je waarschijnlijk ook nodig hebben voor
        // sommige zoekmethodes (zoals A* zoeken)...
        return new Comparator<Node>() {

            public int compare(Node o1, Node o2) {
                HeuristicFunction heuristicFunction = problem.getHeuristicFunction();
                float c1 = o1.getPathCost() + heuristicFunction.getHeuristicValue(o1.getState());
                float c2 = o2.getPathCost() + heuristicFunction.getHeuristicValue(o2.getState());
                return Float.compare(c1, c2);
            }
        };
    }
}
