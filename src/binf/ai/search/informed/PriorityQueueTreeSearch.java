package binf.ai.search.informed;

import binf.ai.search.framework.TreeSearch;
import binf.ai.search.nodestore.NodeStore;
import binf.ai.search.nodestore.PriorityQueueNodeStore;
import binf.ai.search.problem.Problem;

/**
 * implementeert een prioriteit graph zoek algoritme
 */
public class PriorityQueueTreeSearch extends TreeSearch {

    // private factory die de nodestore ophaalt
    private static NodeStore getOpenList() {
        return new PriorityQueueNodeStore();
    }

    /**
     * creeert een instatie
     * @param problem het Problem object
     */
    public PriorityQueueTreeSearch(Problem problem) {
        super(problem, getOpenList());
    }
}
