/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binf.ai.search.uninformed;

import binf.ai.search.framework.TreeSearch;
import binf.ai.search.nodestore.Node;
import binf.ai.search.nodestore.NodeStore;
import binf.ai.search.nodestore.PriorityQueueNodeStore;
import binf.ai.search.problem.Problem;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Elias
 */
public class PriorityQueueTreeSearch extends TreeSearch {

    private static NodeStore getOpenList(Problem problem) {
        return new PriorityQueueNodeStore();
    }

    public PriorityQueueTreeSearch(Problem problem) {
        super(problem, getOpenList(problem));

        List<String> resultaat = this.search(problem);
        System.out.println(resultaat);
    }
}
