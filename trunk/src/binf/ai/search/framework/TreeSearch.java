package binf.ai.search.framework;

import java.util.List;
import binf.ai.search.nodestore.*;
import binf.ai.search.problem.*;
import java.util.ArrayList;

public class TreeSearch implements Search {

    private static int NO_DEPTH_LIMIT = -1;
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

        while (true) {
            if (openList.isEmpty()) return new ArrayList<String>();
            Node cur = openList.remove();
            if (problem.isGoalState(cur.getState())) {
                List<String> temp = new ArrayList<String>();
                temp.add("Solution :\n" + cur.toString());
                return temp;
            }
            for (Node child : NodeExpander.expandNode(problem, root)){
                openList.add(child);
            }
        }
    }
}
