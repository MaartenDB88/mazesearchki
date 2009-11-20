package binf.ai.search.framework;


import java.util.List;
import binf.ai.search.nodestore.*;
import binf.ai.search.problem.*;

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
		return null;
}
}
