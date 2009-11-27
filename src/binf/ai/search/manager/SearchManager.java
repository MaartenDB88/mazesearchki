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
    private boolean mazeVisible = true;

    public SearchManager(Doolhof doolhof, Problem problem, Search search, String name) {
        this.doolhof = doolhof;
        this.problem = problem;
        this.search = search;
        this.name = name;
    }

//    private List<String> createMaze(char[][] doolhof) {
//        List<String> output = new ArrayList<String>();
//
//        char[][] original = doolhof;
//        char[][] array = multiArrayCopy(original);
//
//        for (int i = 0; i < array.length; ++i) {
//            for (int j = 0; j < array[i].length; ++j) {
//                switch (array[j][i]) {
//                    case 'o':
//                        array[j][i] = ' ';
//                        break;
//                    case 'x':
//                        array[j][i] = 'X';
//                        break;
//                    case 's':
//                        array[j][i] = 'S';
//                        break;
//                    case 'g':
//                        array[j][i] = 'G';
//                        break;
//                }
//            }
//        }
//        Node node = search.getSolutionTree();
//        while (node != null) {
//            DoolhofState state = (DoolhofState) node.getState();
//            char c = array[state.getxCord()][state.getyCord()];
//            if (array[state.getxCord()][state.getyCord()] != 'S' &&
//                    array[state.getxCord()][state.getyCord()] != 'G') {
//                array[state.getxCord()][state.getyCord()] = '#';
//            }
//            node = node.getParent();
//        }
//
//        for (int i = 0; i < array.length; ++i) {
//            String s = "|";
//            for (int j = 0; j < array[i].length; ++j) {
//                s += array[j][i] + "|";
//            }
//            output.add(s);
//        }
//
//        return output;
//    }
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

//    private char[][] multiArrayCopy(char[][] source) {
//        char[][] destination = new char[source.length][];
//        for (int a = 0; a < source.length; a++) {
//            destination[a] = new char[source[a].length];
//            System.arraycopy(source[a], 0, destination[a], 0, source[a].length);
//        }
//        return destination;
//    }
    public List<String> RunManagedSearch() {
        List<String> output = new ArrayList<String>();

        output.add(name);

        long start = System.currentTimeMillis();
        output.addAll(search.search(problem));
        long end = System.currentTimeMillis();

        output.add("Execution time was " + (end - start) + " ms.");

        output.add("\nMaze : \n");

        if (mazeVisible) {
            output.addAll(createMaze(doolhof.getRawDoolhof()));
        }

        output.add("\n");

        return output;
    }

    public void printManagedSearch() {
        for (String text : RunManagedSearch()) {
            out.println(text);
        }
    }

    public boolean getMazeVisible() {
        return mazeVisible;
    }

    public void setMazeVisible(boolean mazeVisible) {
        this.mazeVisible = mazeVisible;
    }
}