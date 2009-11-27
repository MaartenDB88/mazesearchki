package binf.ai.search.manager;

import binf.ai.search.doolhof.Doolhof;
import binf.ai.search.uninformed.*;
import binf.ai.search.problem.Problem;

/**
 * is een klasse om uninformed zoekalgoritmen te bundelen
 */
public class UninformedSearchFactory {

    private Doolhof doolhof;
    private Problem problem;

    /**
     * creeert een instantie
     * @param doolhof de doolhof
     * @param problem het Problem object
     */
    public UninformedSearchFactory(Doolhof doolhof, Problem problem) {
        this.doolhof = doolhof;
        this.problem = problem;
    }

    /**
     * maakt een Breadth First Tree Search
     * @return SearchManager
     */
    public SearchManager getManagedBreadthFirstTreeSearch() {
        return new SearchManager(doolhof, problem,
                new BreadthFirstTreeSearch(problem), "Breadth First Tree Search");
    }

    /**
     * maakt een Depth First Tree Search - No Limit
     * @return SearchManager
     */
    public SearchManager getManagedDepthFirstTreeSearchNoLimit() {
        return new SearchManager(doolhof, problem,
                new DepthFirstTreeSearchNoLimit(problem), "");
    }

    /**
     * maakt een Depth First Tree Search - Limit
     * @param limit de diepte limiet
     * @return SearchManager
     */
    public SearchManager getManagedDepthFirstTreeSearchWithLimit(int limit) {
        return new SearchManager(doolhof, problem,
                new DepthFirstTreeSearchWithLimit(problem, limit), "Depth First Tree Search - Limit" + limit);
    }

    /**
     * maakt een Breadth First Graph Search
     * @return SearchManager
     */
    public SearchManager getManagedBreadthFirstGraphSearch() {
        return new SearchManager(doolhof, problem,
                new BreadthFirstGraphSearch(problem), "Breadth First Graph Search");
    }

    /**
     * maakt een Depth First Graph Search - No Limit
     * @return SearchManager
     */
    public SearchManager getManagedDepthFirstGraphSearchNoLimit() {
        return new SearchManager(doolhof, problem,
                new DepthNoLimitGraphSearch(problem), "Depth First Graph Search - No Limit");
    }

    /**
     * maakt een Depth First Graph Search - Limit
     * @param limit de diepte limiet
     * @return SearchManager
     */
    public SearchManager getManagedDepthFirstGraphSearchWithLimit(int limit) {
        return new SearchManager(doolhof, problem,
                new DepthWithLimitGraphSearch(problem, limit), "Depth First Graph Search - Limit: " + limit);
    }
}
