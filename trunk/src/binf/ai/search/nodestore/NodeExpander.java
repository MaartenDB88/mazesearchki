package binf.ai.search.nodestore;

import java.util.List;
import binf.ai.search.problem.Problem;
import binf.ai.search.problem.Successor;
import java.util.ArrayList;

public class NodeExpander {

    public NodeExpander() {
    }

    // implementeer expandNode:
    // expandeer node (via successorfunctie) en keer de
    // resulterende lijst van nodes als resultaat terug
    public static List<Node> expandNode(Problem problem, Node node) {
        List<Node> nodeList = new ArrayList<Node>();
        List<Successor> successors = problem.getSuccessorFunction().getSuccessors(node.getState());
        for (Successor successor : successors) {
            if (node.getParent()== null || !successor.getState().sameState(node.getParent().getState())) {
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
