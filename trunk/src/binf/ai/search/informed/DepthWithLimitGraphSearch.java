/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binf.ai.search.informed;

import binf.ai.search.framework.GraphSearch;
import binf.ai.search.nodestore.ClosedList;
import binf.ai.search.nodestore.NodeStore;
import binf.ai.search.nodestore.Stack;
import binf.ai.search.problem.Problem;
import java.util.List;

/**
 *
 * @author Elias
 */
public class DepthWithLimitGraphSearch extends GraphSearch {

    private static NodeStore openList = new Stack();
    private static ClosedList closedList = new ClosedList();

    public DepthWithLimitGraphSearch(Problem problem, int limit){
        super(problem, openList, closedList, limit);

        List<String> resultaat = this.search(problem);
        System.out.println(resultaat);
    }
}
