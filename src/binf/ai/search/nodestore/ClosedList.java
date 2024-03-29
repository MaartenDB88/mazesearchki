package binf.ai.search.nodestore;

import java.util.ArrayList;
import java.util.List;

public class ClosedList implements NodeStore {

    private List<Node> list;

    public ClosedList() {
        list = new ArrayList<Node>();
    }

    public void add(Node aNode) {
        list.add(aNode);
    }

    public Node remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public boolean containsNode(Node node) {
        for (Node n : list) {
            if (n.getState().sameState(node.getState())) {
                return true;
            }
        }
        return false;
    }
}
