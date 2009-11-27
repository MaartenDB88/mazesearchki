package binf.ai.search.informed;

import binf.ai.search.framework.GraphSearch;
import binf.ai.search.nodestore.ClosedList;
import binf.ai.search.nodestore.NodeStore;
import binf.ai.search.nodestore.PriorityQueueNodeStore;
import binf.ai.search.problem.Problem;

/**
 * implementeert een prioriteit graph zoek algoritme
 */
public class PriorityQueueGraphSearch extends GraphSearch {

    // private factory die de nodestore ophaalt
    private static NodeStore getOpenList() {
        return new PriorityQueueNodeStore();
    }

    // private factory die de closedlist ophaalt
    private static ClosedList getClosedList() {
        return new ClosedList();
    }
    
    /**
     * creeert een instatie
     * @param problem het Problem object
     */
    public PriorityQueueGraphSearch(Problem problem){
        super(problem, getOpenList(), getClosedList());
    }
}
