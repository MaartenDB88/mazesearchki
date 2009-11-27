/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binf.ai.search.uninformed;

import binf.ai.search.framework.TreeSearch;
import binf.ai.search.nodestore.NodeStore;
import binf.ai.search.nodestore.Stack;
import binf.ai.search.problem.Problem;
import java.util.List;

/**
 *
 * @author Elias
 */
public class DepthFirstTreeSearchNoLimit extends TreeSearch {

    private static NodeStore getOpenList() {
        return new Stack();
    }

    public DepthFirstTreeSearchNoLimit(Problem problem) {
        super(problem, getOpenList());
    }
}
