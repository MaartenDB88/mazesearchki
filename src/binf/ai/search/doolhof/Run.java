/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binf.ai.search.doolhof;

import binf.ai.search.framework.TreeSearch;
import binf.ai.search.nodestore.ClosedList;
import binf.ai.search.nodestore.NodeStore;
import binf.ai.search.nodestore.Queue;
import binf.ai.search.problem.Problem;
import binf.ai.search.problem.State;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class Run {

    public static void main(String[] args) {
        int dim1 = 8;
        int dim2 = 8;
//        int[][] doolhof = new int[dim1][dim2];

        GenereerDoolhof dh = new GenereerDoolhof();

//        doolhof = dh.genereerDoolhof(dim1, dim2);
//        for (int x = 0; x < dim1; x++)
//        {
//            for (int y = 0; y < dim2; y++)
//            {
//                if(y%8 == 0)
//                {
//                    System.out.println();
//                }
//                System.out.print(doolhof[x][y]);
//            }
//        }
//        System.out.println();

        Status[][] test = new Status[dim1][dim2];
        test = dh.leesDoolhofVanBestand();
        for (int y = 0; y < dim2; y++) {
            for (int x = 0; x < dim1; x++) {
                if (x % 8 == 0) {
                    System.out.println();
                }
                System.out.print(test[x][y]);
            }
        }
        System.out.println();


        State[][] doolhofMetStates = new State[dim1][dim2];
        State initState = null;
        State goalState = null;
        for (int x = 0; x < dim1; x++) {
            for (int y = 0; y < dim2; y++) {

                State curState = new DoolhofState(x, y, test[x][y]);
                doolhofMetStates[x][y] = curState;

                if (((DoolhofState) curState).getStatus() == Status.START) {
                    initState = curState;
                } else if (((DoolhofState) curState).getStatus() == Status.GOAL) {
                    goalState = curState;
                }
            }
        }

        for (int x = 0; x < dim1; x++) {
            for (int y = 0; y < dim2; y++) {
                for (Action actie : Action.values()) {
                    int relX = x + actie.getRelativeX();
                    int relY = y + actie.getRelativeY();
                    if ((relX >= 0) && (relY >= 0) &&
                            relX < dim1 && relY < dim2 &&
                            ((DoolhofState) doolhofMetStates[relX][relY]).getStatus() != Status.OBSTACLE &&
                            ((DoolhofState) doolhofMetStates[x][y]).getStatus() != Status.OBSTACLE) {
                        ((DoolhofState) doolhofMetStates[x][y]).addSuccessor(actie.toString(),
                                doolhofMetStates[relX][relY]);
                    }
                }
            }
        }

        Problem problem = new Problem(initState, new DoolhofSuccessorFunction(),
                new DoolhofGoalTest(goalState), new DoolhofPathCostFunction(),
                new DoolhofHeuristicFunction());

        NodeStore openlist = new Queue();
        ClosedList closedList = new ClosedList();
        int depth = 1;
        //new BreadthFirstTreeSearch(problem);
        //new AStarTreeSearch(problem);
        TreeSearch tree = new TreeSearch(problem, openlist);
        List<String> test2 = tree.search(problem);
        System.out.println(test2);
        //new TreeSearch(problem, openlist, depth).search(problem);
        //new GraphSearch(problem, openlist, closedList).search(problem);
        //new GraphSearch(problem, openlist, closedList, depth).search(problem);
    }
}
