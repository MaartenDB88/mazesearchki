/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binf.ai.search.manager;

import binf.ai.search.doolhof.Doolhof;
import binf.ai.search.informed.*;
import binf.ai.search.problem.Problem;

/**
 *
 * @author Simon
 */
public class InformedSearchFactory {

    private Doolhof doolhof;
    private Problem problem;

    public InformedSearchFactory(Doolhof doolhof, Problem problem) {
        this.doolhof = doolhof;
        this.problem = problem;
    }

    public SearchManager getManagedPriorityQueueTreeSearch() {
        return new SearchManager(doolhof, problem,
                new PriorityQueueTreeSearch(problem), "PriorityQueue Tree Search");
    }

    public SearchManager getManagedPriorityQueueGraphSearch() {
        return new SearchManager(doolhof, problem,
                new PriorityQueueGraphSearch(problem), "PriorityQueue Graph Search");
    }

    public SearchManager getManagedAStarTreeSearch() {
        return new SearchManager(doolhof, problem,
                new AStarTreeSearch(problem), "A* Tree Search");
    }

    public SearchManager getManagedAStarGraphSearch() {
        return new SearchManager(doolhof, problem,
                new AStarGraphSearch(problem), "A* Graph Search");
    }
}
