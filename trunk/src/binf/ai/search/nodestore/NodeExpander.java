package binf.ai.search.nodestore;

import java.util.List;
import binf.ai.search.problem.Problem;
import binf.ai.search.problem.Successor;
import java.util.ArrayList;

public class NodeExpander {

    public NodeExpander() {
    }

    /**
     * maakt een nieuwe Node aan voor alle successors
     * @param problem het Problem onject
     * @param node de node die uitgebreid moet worden
     * @return List van Node
     */
    public static List<Node> expandNode(Problem problem, Node node) {
        List<Node> nodeList = new ArrayList<Node>();
        List<Successor> successors = problem.getSuccessorFunction().getSuccessors(node.getState());
        for (Successor successor : successors) {
            // nooit terug naar parent gaan
            if (node.getParent()== null || !successor.getState().sameState(node.getParent().getState())) {
                // Maak de node aan
                Node cur = new Node(node, successor.getState());
                cur.setAction(successor.getAction());
                cur.setPathCost(node.getPathCost() +
                        problem.getPathCostFunction().calculatePathCost(node.getState(),
                        successor.getState(), successor.getAction()));
                cur.setDepth(node.getDepth() + 1);
                nodeList.add(cur);
            }
        }
        return nodeList;
    }
}
