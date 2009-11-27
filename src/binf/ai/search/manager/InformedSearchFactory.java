package binf.ai.search.manager;

import binf.ai.search.doolhof.Doolhof;
import binf.ai.search.informed.*;
import binf.ai.search.problem.Problem;

/**
 * is een klasse om informed zoekalgoritmen te bundelen
 */
public class InformedSearchFactory {

    private Doolhof doolhof;
    private Problem problem;

    /**
     * creeert een instantie
     * @param doolhof de doolhof
     * @param problem het Problem object
     */
    public InformedSearchFactory(Doolhof doolhof, Problem problem) {
        this.doolhof = doolhof;
        this.problem = problem;
    }

    /**
     * maakt een PriorityQueue Tree Search
     * @return SearchManager
     */
    public SearchManager getManagedPriorityQueueTreeSearch() {
        return new SearchManager(doolhof, problem,
                new PriorityQueueTreeSearch(problem), "PriorityQueue Tree Search");
    }

    /**
     * maakt een PriorityQueue Graph Search
     * @return SearchManager
     */
    public SearchManager getManagedPriorityQueueGraphSearch() {
        return new SearchManager(doolhof, problem,
                new PriorityQueueGraphSearch(problem), "PriorityQueue Graph Search");
    }

    /**
     * maakt een A* Tree Search
     * @return SearchManager
     */
    public SearchManager getManagedAStarTreeSearch() {
        return new SearchManager(doolhof, problem,
                new AStarTreeSearch(problem), "A* Tree Search");
    }

    /**
     * maakt een A* Graph Search
     * @return SearchManager
     */
    public SearchManager getManagedAStarGraphSearch() {
        return new SearchManager(doolhof, problem,
                new AStarGraphSearch(problem), "A* Graph Search");
    }
}
