package binf.ai.search.uninformed;

import binf.ai.search.framework.GraphSearch;
import binf.ai.search.nodestore.ClosedList;
import binf.ai.search.nodestore.NodeStore;
import binf.ai.search.nodestore.Stack;
import binf.ai.search.problem.Problem;

/**
 * implementeert een diepte eerst graph zoek algoritme met limiet
 */
public class DepthWithLimitGraphSearch extends GraphSearch {

    // private factory die de nodestore ophaalt
    private static NodeStore getOpenList() {
        return new Stack();
    }

    // private factory die de closedlist ophaalt
    private static ClosedList getClosedList() {
        return new ClosedList();
    }

    /**
     * creeert een instatie
     * @param problem het Problem object
     * @param limit de diepte limiet
     */
    public DepthWithLimitGraphSearch(Problem problem, int limit) {
        super(problem, getOpenList(), getClosedList(), limit);
    }
}
