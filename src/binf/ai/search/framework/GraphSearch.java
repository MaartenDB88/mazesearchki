package binf.ai.search.framework;

import java.util.List;
import binf.ai.search.nodestore.*;
import binf.ai.search.problem.*;

public class GraphSearch implements Search {

	private static int NO_DEPTH_LIMIT = -1;
	private NodeStore openList;
	private ClosedList closedList;
	private int depthLimit;

	public GraphSearch() {
	}
	
	public GraphSearch(Problem problem, NodeStore openList,	ClosedList closedList) {
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
		return null;
	}
}
