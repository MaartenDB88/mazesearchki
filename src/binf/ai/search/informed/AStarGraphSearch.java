package binf.ai.search.informed;

import binf.ai.search.framework.GraphSearch;
import binf.ai.search.nodestore.ClosedList;
import binf.ai.search.nodestore.Node;
import binf.ai.search.nodestore.NodeStore;
import binf.ai.search.nodestore.PriorityQueueNodeStore;
import binf.ai.search.problem.HeuristicFunction;
import binf.ai.search.problem.Problem;
import java.util.Comparator;

/**
 * implementeert een greedy first A* graph zoek algoritme
 */
public class AStarGraphSearch extends GraphSearch {

    // private factory die de nodestore ophaalt
    private static NodeStore getOpenList(Problem problem) {
        return new PriorityQueueNodeStore(getComparator(problem));
    }

    // private factory die de closedlist ophaalt
    private static ClosedList getClosedList() {
        return new ClosedList();
    }

    /**
     * creeert een instatie
     * @param problem het Problem object
     */
    public AStarGraphSearch(Problem problem) {
        super(problem, getOpenList(problem), getClosedList());
    }

    // Een custom comparator voor de heuristiek te gebruiken in priority queue
    private static Comparator<Node> getComparator(final Problem problem) {
        return new Comparator<Node>() {

            public int compare(Node o1, Node o2) {
                // vergelijk de padkost + heuristiek
                HeuristicFunction heuristicFunction = problem.getHeuristicFunction();
                float c1 = o1.getPathCost() + heuristicFunction.getHeuristicValue(o1.getState());
                float c2 = o2.getPathCost() + heuristicFunction.getHeuristicValue(o2.getState());
                return Float.compare(c1, c2);
            }
        };
    }
}
