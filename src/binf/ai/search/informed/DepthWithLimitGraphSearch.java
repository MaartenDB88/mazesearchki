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

    private static NodeStore getOpenList() {
        return new Stack();
    }

    private static ClosedList getClosedList() {
        return new ClosedList();
    }

    public DepthWithLimitGraphSearch(Problem problem, int limit) {
        super(problem, getOpenList(), getClosedList(), limit);

        List<String> resultaat = this.search(problem);
        System.out.println(resultaat);
    }
}
