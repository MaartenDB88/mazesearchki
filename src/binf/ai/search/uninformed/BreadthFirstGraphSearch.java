package binf.ai.search.uninformed;

import binf.ai.search.framework.GraphSearch;
import binf.ai.search.nodestore.ClosedList;
import binf.ai.search.nodestore.NodeStore;
import binf.ai.search.nodestore.Queue;
import binf.ai.search.problem.Problem;

/**
 * implementeert een breedte eerst graph zoek algoritme
 */
public class BreadthFirstGraphSearch extends GraphSearch {

    // private factory die de nodestore ophaalt
    private static NodeStore getOpenList() {
        return new Queue();
    }

    // private factory die de closedlist ophaalt
    private static ClosedList getClosedList() {
        return new ClosedList();
    }
    
    /**
     * creeert een instatie
     * @param problem het Problem object
     */
    public BreadthFirstGraphSearch(Problem problem){
        super(problem, getOpenList(), getClosedList());
    }
}
