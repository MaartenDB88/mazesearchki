package binf.ai.search.framework;

import java.util.List;
import binf.ai.search.nodestore.*;
import binf.ai.search.problem.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TreeSearch implements Search {

    private static int NO_DEPTH_LIMIT = Integer.MAX_VALUE;
    private NodeStore openList;
    private int depthLimit;

    public TreeSearch(Problem problem, NodeStore openList) {
        this.openList = openList;
        this.depthLimit = NO_DEPTH_LIMIT;
    }

    public TreeSearch(Problem problem, NodeStore openList, int depthLimit) {
        this.openList = openList;
        this.depthLimit = depthLimit;
    }

    public List<String> search(Problem problem) {
        // implementeer hier de tree search
        // the initial state
        Node root = new Node(problem.getInitialState());
        openList.add(root);
        int aantal = 1;

        while (!openList.isEmpty()) {
            Node cur = openList.remove();
            if (problem.isGoalState(cur.getState())){
                List<String> temp = new ArrayList<String>();
                temp.add(cur.getPathFromRoot().toString());
                temp.add("Solution :\n" +
                        "Number of nodes : " + aantal +
                        "\n" + cur.toString());
                return temp;
            }
            if (cur.getDepth() < depthLimit)
                for (Node child : NodeExpander.expandNode(problem, cur)){
                    openList.add(child);
                    aantal++;
                }
        }
        return Arrays.asList("No solution");
    }
}
