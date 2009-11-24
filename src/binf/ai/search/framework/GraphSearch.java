package binf.ai.search.framework;

import java.util.List;
import binf.ai.search.nodestore.*;
import binf.ai.search.problem.*;
import java.util.ArrayList;

public class GraphSearch implements Search {

    private static int NO_DEPTH_LIMIT = -1;
    private NodeStore openList;
    private ClosedList closedList;
    private int depthLimit;

    public GraphSearch() {
    }

    public GraphSearch(Problem problem, NodeStore openList, ClosedList closedList) {
        this.openList = openList;
        this.closedList = closedList;
        this.depthLimit = NO_DEPTH_LIMIT;
    }

    public GraphSearch(Problem problem, NodeStore openList,
            ClosedList closedList, int depthLimit) {
        this.openList = openList;
        this.closedList = closedList;
        this.depthLimit = depthLimit;
    }

    public List<String> search(Problem problem) {
        // implementeer hier de graph search
        Node root = new Node(problem.getInitialState());
        openList.add(root);
        while (true) {
            if (openList.isEmpty()) {
                return null;
            }
            Node cur = openList.remove();
            boolean test = problem.isGoalState(cur.getState());
            if (test) {
                List<String> temp = new ArrayList<String>();
                temp.add("Solution :\n" + cur.toString());
                return temp;
            }
            if (depthLimit == -1 || cur.getDepth() <= depthLimit  ) {
                if(!closedList.containsNode(cur))
                {
                for (Node child : NodeExpander.expandNode(problem, cur)) {
                    openList.add(child);
                }
                }
            }
        }
    }
}
