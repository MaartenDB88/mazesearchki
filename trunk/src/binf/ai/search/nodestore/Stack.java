package binf.ai.search.nodestore;

import java.util.ArrayList;
import java.util.List;

public class Stack implements NodeStore {

    private List<Node> list;

    public Stack() {
        this.list = new ArrayList<Node>();
    }

    public void add(Node aNode) {
        list.add(aNode);
    }

    public Node remove() {
        return list.remove(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
