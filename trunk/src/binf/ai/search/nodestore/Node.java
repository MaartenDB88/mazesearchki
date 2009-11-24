package binf.ai.search.nodestore;

import java.util.ArrayList;
import java.util.List;

import binf.ai.search.problem.State;

public class Node {

	private State state;
	private Node parent;
	private String action;
	private float pathCost;
	private int depth;

	public Node(State state) {
		this.setState(state);
		this.setPathCost(0);
		this.setParent(null);
		this.setDepth(0);
		this.setAction("no-action");
	}

	public Node(Node parent, State state) {
		this(state);
		this.setParent(parent);
		this.setDepth(parent.getDepth() + 1);
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public void setPathCost(float pathCost) {
		this.pathCost = pathCost;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getDepth() {
		return depth;
	}

	public Node getParent() {
		return parent;
	}

	public State getState() {
		return state;
	}

	public String getAction() {
		return action;
	}

	public float getPathCost() {
		return pathCost;
	}

	private boolean isRootNode() {
		return parent == null;
	}

	public List<Node> getPathFromRoot() {
		Node currentNode = this;
		List<Node> nodesOnPathFromRoot = new ArrayList<Node>();
		while (!currentNode.isRootNode()) {
			nodesOnPathFromRoot.add(0, currentNode);
			currentNode = currentNode.getParent();
		}
		nodesOnPathFromRoot.add(0, currentNode);
		return nodesOnPathFromRoot;
	}

	public String toString() {
		String str = "Toestand:\n";
		str = str + this.getState().toString() + "\n";
		str = str + "Padkost: " + this.getPathCost() + "\n";
		str = str + "Diepte: " + this.getDepth() + "\n";
		str = str + "Actie: " + this.getAction() + "\n";
		return str;
	}
}
