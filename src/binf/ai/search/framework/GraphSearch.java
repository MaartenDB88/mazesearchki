package binf.ai.search.framework;

import java.util.List;
import binf.ai.search.nodestore.*;
import binf.ai.search.problem.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * kan zoeken in graphs
 */
public class GraphSearch implements Search {

    private static int NO_DEPTH_LIMIT = -1;
    private NodeStore openList;
    private ClosedList closedList;
    private int depthLimit;
    private Node solution;

    /**
     * creeert een instantie
     * @param problem het Problem object
     * @param openList de open list
     * @param closedList de closed list
     */
    public GraphSearch(Problem problem, NodeStore openList, ClosedList closedList) {
        this.openList = openList;
        this.closedList = closedList;
        this.depthLimit = NO_DEPTH_LIMIT;
    }

    /**
     * creeert een instantie
     * @param problem het Problem object
     * @param openList de open list
     * @param closedList de closed list
     * @param depthLimit die maximale zoekdiepte
     */
    public GraphSearch(Problem problem, NodeStore openList,
            ClosedList closedList, int depthLimit) {
        this.openList = openList;
        this.closedList = closedList;
        this.depthLimit = depthLimit;
    }

    /**
     * voert het zoekalgoritme uit
     * @param problem het Problem object
     * @return List van String met output
     */
    public List<String> search(Problem problem) {
        // Stel de rootnode in and voeg toe aan de open lijst
        Node root = new Node(problem.getInitialState());
        openList.add(root);

        // aantal is het totale aantal nodes die de open list ingegaan zijn
        int aantal = 1;

        // Zolang er nog nodes over zijn...
        while (!openList.isEmpty()) {
            // Neem de nieuwe node
            Node cur = openList.remove();

            // Bereikten we ons doel?
            if (problem.isGoalState(cur.getState())) {
                // Bereken de output
                solution = cur;
                List<String> output = new ArrayList<String>();
                String acties = "";
                for (Node n : cur.getPathFromRoot()) {
                    acties += n.getAction() + "\n";
                }
                output.add("Solution :\n==========\n\n" +
                        "Path actions :\n" + acties + "\n" +
                        "Path cost : " + cur.getPathCost() + "\n" +
                        "Path depth : " + cur.getDepth() + "\n" +
                        "Number of nodes : " + aantal + "\n");
                return output;
            }

            // Zit de huidige node al in de closedlist?
            if (!closedList.containsNode(cur)) {
                // Voeg toe aan de closedlist
                closedList.add(cur);
                if (depthLimit == -1 || cur.getDepth() <= depthLimit) {
                    // Bereken de volgende nodes via NodeExpander
                    for (Node child : NodeExpander.expandNode(problem, cur)) {
                        // Voeg ze toe aan de lijst
                        openList.add(child);
                        aantal++;
                    }

                }
            }
        }
        // Geen uitkomst gevonden
        return Arrays.asList("No solution found");
    }

    /**
     * geeft de laatst gevonden node weer
     * @return Node de laatste (goal) node
     */
    public Node getSolutionTree() {
        if (solution != null) {
            return solution;
        }
        return null;
    }
}
