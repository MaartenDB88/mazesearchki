package binf.ai.search.framework;

import binf.ai.search.nodestore.Node;
import java.util.List;

import binf.ai.search.problem.Problem;

/**
 * beschrijft een zoekalgoritme
 */
public interface Search {
    /**
     * laat het zoekalgoritme zoeken in het probleem
     * @param p the Problem object
     * @return List van String de output
     */
    List<String> search(Problem p);

    /**
     * geeft de laatst gevonden node weer
     * @return Node de laatste (goal) node
     */
    Node getSolutionTree();
}