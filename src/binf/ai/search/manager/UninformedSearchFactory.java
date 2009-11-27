/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binf.ai.search.manager;

import binf.ai.search.doolhof.Doolhof;
import binf.ai.search.uninformed.*;
import binf.ai.search.problem.Problem;

/**
 *
 * @author Simon
 */
public class UninformedSearchFactory {

    private Doolhof doolhof;
    private Problem problem;

    public UninformedSearchFactory(Doolhof doolhof, Problem problem) {
        this.doolhof = doolhof;
        this.problem = problem;
    }

    public SearchManager getManagedBreadthFirstTreeSearch() {
        return new SearchManager(doolhof, problem,
                new BreadthFirstTreeSearch(problem), "Breadth First Tree Search");
    }

    public SearchManager getManagedDepthFirstTreeSearchNoLimit() {
        return new SearchManager(doolhof, problem,
                new DepthFirstTreeSearchNoLimit(problem), "Depth First Tree Search - No Limit");
    }

    public SearchManager getManagedDepthFirstTreeSearchWithLimit(int limit) {
        return new SearchManager(doolhof, problem,
                new DepthFirstTreeSearchWithLimit(problem, limit), "Depth First Tree Search - Limit: " + limit);
    }

    public SearchManager getManagedBreadthFirstGraphSearch() {
        return new SearchManager(doolhof, problem,
                new BreadthFirstGraphSearch(problem), "Breadth First Graph Search");
    }

    public SearchManager getManagedDepthFirstGraphSearchNoLimit() {
        return new SearchManager(doolhof, problem,
                new DepthNoLimitGraphSearch(problem), "Depth First Graph Search - No Limit");
    }

    public SearchManager getManagedDepthFirstGraphSearchWithLimit(int limit) {
        return new SearchManager(doolhof, problem,
                new DepthWithLimitGraphSearch(problem, limit), "Depth First Graph Search - Limit: " + limit);
    }
}
