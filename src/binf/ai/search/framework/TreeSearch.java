package binf.ai.search.framework;

import java.util.List;
import binf.ai.search.nodestore.*;
import binf.ai.search.problem.*;
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

        while (!openList.isEmpty()) {
            Node cur = openList.remove();
            if (problem.isGoalState(cur.getState()))
                return Arrays.asList("Solution :\n" + cur.toString());
            if (cur.getDepth() <= depthLimit)
                for (Node child : NodeExpander.expandNode(problem, cur))
                    openList.add(child);
        }
        return null;
    }
}
