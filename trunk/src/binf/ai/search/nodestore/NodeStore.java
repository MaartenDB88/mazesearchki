package binf.ai.search.nodestore;

public interface NodeStore {
	public void add(Node aNode);
	public Node remove();
	public boolean isEmpty();
	public int size();
}