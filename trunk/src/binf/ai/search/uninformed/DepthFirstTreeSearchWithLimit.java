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
public class DepthFirstTreeSearchWithLimit extends TreeSearch {
    
    private static NodeStore openList = new Stack();
    private static int depthLimit = 9;

    public DepthFirstTreeSearchWithLimit(Problem problem){
        super(problem, openList, depthLimit);

        List<String> resultaat = this.search(problem);
        System.out.println(resultaat);
    }

}
