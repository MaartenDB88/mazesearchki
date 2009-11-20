package binf.ai.search.informed;

import java.util.Comparator;
import binf.ai.search.framework.TreeSearch;
import binf.ai.search.nodestore.Node;
import binf.ai.search.problem.Problem;

// voorbeeld raamwerk klasse voor geinformeerde zoekmethode
// stop alle geinformeerde zoekmethodes in deze package

public class AStarTreeSearch extends TreeSearch{

	public AStarTreeSearch(Problem problem) {
		// instantieer hier een TreeSearch met correcte parameters...
		}
	
	private static Comparator<Node> getComparator(final Problem problem) {
		// dit zal je waarschijnlijk ook nodig hebben voor
		// sommige zoekmethodes (zoals A* zoeken)...
	}
}
