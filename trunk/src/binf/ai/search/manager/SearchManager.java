package binf.ai.search.manager;

import binf.ai.search.doolhof.Doolhof;
import binf.ai.search.doolhof.DoolhofState;
import binf.ai.search.framework.Search;
import binf.ai.search.nodestore.Node;
import binf.ai.search.problem.Problem;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SearchManager {

    private Search search;
    private final Doolhof doolhof;
    private final Problem problem;
    private final String name;
    private PrintStream out = System.out;
    private int visibleLimit = 100;

    public SearchManager(Doolhof doolhof, Problem problem, Search search, String name) {
        this.doolhof = doolhof;
        this.problem = problem;
        this.search = search;
        this.name = name;
    }

    private List<String> createMaze(char[][] doolhof) {
        List<String> output = new ArrayList<String>();
        char[][] array = doolhof;
        Node node = search.getSolutionTree();

        for (int i = 0; i < array.length; ++i) {
            String s = "|";
            for (int j = 0; j < array[i].length; ++j) {
                char c = array[j][i];
                switch (c) {
                    case 'o':
                        c = ' ';
                        break;
                    case 'x':
                        c = 'X';
                        break;
                    case 's':
                        c = 'S';
                        break;
                    case 'g':
                        c = 'G';
                        break;
                }

                DoolhofState state;
                if (node.getParent() != null && c != 'S' && c != 'G') {
                    state = (DoolhofState) node.getParent().getState();
                    if (state.getxCord() == j && state.getyCord() == i) {
                        c = '#';
                        node = node.getParent();
                    }
                }

                s += c + "|";
            }
            output.add(s);
        }

        return output;
    }

    public List<String> RunManagedSearch() {
        if (search != null) {
            List<String> output = new ArrayList<String>();

            output.add(name);

            long start = System.currentTimeMillis();
            output.addAll(search.search(problem));
            long end = System.currentTimeMillis();

            output.add("Execution time was " + (end - start) + " ms.");

            output.add("\nMaze : \n");

            if (visibleLimit > doolhof.getRawDoolhof().length) {
                output.addAll(createMaze(doolhof.getRawDoolhof()));
            }

            output.add("\n");

            search = null;

            return output;
        }
        return null;
    }

    public void printManagedSearch() {
        for (String text : RunManagedSearch()) {
            out.println(text);
        }
    }

    public int getVisibleLimit() {
        return visibleLimit;
    }

    public void setVisibleLimit(int visibleLimit) {
        this.visibleLimit = visibleLimit;
    }
}
