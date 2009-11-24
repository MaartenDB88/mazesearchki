/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binf.ai.search.informed;

import binf.ai.search.framework.GraphSearch;
import binf.ai.search.nodestore.ClosedList;
import binf.ai.search.nodestore.NodeStore;
import binf.ai.search.nodestore.PriorityQueueNodeStore;
import binf.ai.search.problem.Problem;
import java.util.List;

/**
 *
 * @author Elias
 */
public class PriorityQueueGraphSearch extends GraphSearch {

    private static NodeStore openList = new PriorityQueueNodeStore();
    private static ClosedList closedList = new ClosedList();

    public PriorityQueueGraphSearch(Problem problem){
        super(problem, openList, closedList);

        List<String> resultaat = this.search(problem);
        System.out.println(resultaat);
    }
}
