package binf.ai.search.framework;

import binf.ai.search.nodestore.Node;
import java.util.List;

import binf.ai.search.problem.Problem;

public interface Search {
	List<String> search(Problem p);
        Node getSolutionTree();
}