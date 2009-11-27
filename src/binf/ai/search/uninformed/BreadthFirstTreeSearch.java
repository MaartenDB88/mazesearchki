package binf.ai.search.uninformed;

import binf.ai.search.framework.TreeSearch;
import binf.ai.search.nodestore.NodeStore;
import binf.ai.search.nodestore.Queue;
import binf.ai.search.problem.Problem;

/**
 * implementeert een breedte eerst tree zoek algoritme
 */
public class BreadthFirstTreeSearch extends TreeSearch {

    // private factory die de nodestore ophaalt
    private static NodeStore getOpenList() {
        return new Queue();
    }

    /**
     * creeert een instatie
     * @param problem het Problem object
     */
    public BreadthFirstTreeSearch(Problem problem) {
        super(problem, getOpenList());
    }
}
