package binf.ai.search.uninformed;
//stop alle niet geinformeerde zoekmethodes in deze package

import binf.ai.search.framework.TreeSearch;
import binf.ai.search.nodestore.NodeStore;
import binf.ai.search.nodestore.Queue;
import binf.ai.search.problem.Problem;
// import ...

// voorbeeld raamwerk voor een klasse van een niet geinformeerde
// zoekmethode
public class BreadthFirstTreeSearch extends TreeSearch {

    private static NodeStore getOpenList() {
        return new Queue();
    }

    public BreadthFirstTreeSearch(Problem problem) {
        super(problem, getOpenList());
    }
}
