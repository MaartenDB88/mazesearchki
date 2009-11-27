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
    private Node solution;

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
        int aantal=1;

        while (!openList.isEmpty()) {
            Node cur = openList.remove();
            if (problem.isGoalState(cur.getState())) {
                solution = cur;
                List<String> temp = new ArrayList<String>();
                String acties = "";
                for (Node n : cur.getPathFromRoot())
                    acties += n.getAction() + "\n";
//                temp.add(cur.getPathFromRoot().toString());
                temp.add("Solution :\n==========\n\n" +
                        "Path actions :\n" + acties + "\n" +
                        "Path cost : " + cur.getPathCost() + "\n" +
                        "Path depth : " + cur.getDepth() + "\n" +
                        "Number of nodes : " + aantal + "\n");
                return temp;
            }

            if (!closedList.containsNode(cur)) {
                 closedList.add(cur);
                if (depthLimit == -1 || cur.getDepth() <= depthLimit) {

                    for (Node child : NodeExpander.expandNode(problem, cur)) {
                        openList.add(child);
                        aantal++;
                    }
                   
                }
            }
        }
        return null;
    }

    public Node getSolutionTree() {
        if(solution != null)
            return solution;
        return null;
    }
}
