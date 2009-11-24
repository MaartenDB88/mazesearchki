package binf.ai.search.uninformed;
//stop alle niet geinformeerde zoekmethodes in deze package

import binf.ai.search.framework.TreeSearch;
import binf.ai.search.nodestore.NodeStore;
import binf.ai.search.nodestore.Queue;
import binf.ai.search.problem.Problem;
import java.util.List;
// import ...

// voorbeeld raamwerk voor een klasse van een niet geinformeerde
// zoekmethode
public class BreadthFirstTreeSearch extends TreeSearch {

    // of ander soort openlist
    private static NodeStore openlist = new Queue();

    public BreadthFirstTreeSearch(Problem problem) {
        super(problem, openlist);
        // instantieer een TreeSearch met de correcte parameters
        List<String> resultaat = this.search(problem);
        System.out.println(resultaat);
    }
}
