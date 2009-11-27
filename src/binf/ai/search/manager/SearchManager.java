package binf.ai.search.manager;

import binf.ai.search.doolhof.Doolhof;
import binf.ai.search.framework.Search;
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

    public SearchManager(Doolhof doolhof, Problem problem, Search search, String name) {
        this.doolhof = doolhof;
        this.problem = problem;
        this.search = search;
        this.name = name;
    }

    public List<String> RunManagedSearch() {
        List<String> output = new ArrayList<String>();

        output.add(name);

        long start = System.currentTimeMillis();
        output.addAll(search.search(problem));
        long end = System.currentTimeMillis();

        output.add("Execution time was "+(end-start)+" ms.");

        //TODO add visual output

        output.add("\n");

        return output;
    }

    public void printManagedSearch() {
        for (String text : RunManagedSearch())
            out.println(text);
    }
}
