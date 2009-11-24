/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binf.ai.search.informed;

import binf.ai.search.framework.GraphSearch;
import binf.ai.search.nodestore.ClosedList;
import binf.ai.search.nodestore.NodeStore;
import binf.ai.search.nodestore.Queue;
import binf.ai.search.problem.Problem;
import java.util.List;

/**
 *
 * @author Elias
 */
public class BreadthFirstGraphSearch extends GraphSearch {

    private static NodeStore openList = new Queue();
    private static ClosedList closedList = new ClosedList();

    public BreadthFirstGraphSearch(Problem problem){
        super(problem, openList, closedList);

        List<String> resultaat = this.search(problem);
        System.out.println(resultaat);
    }
}
