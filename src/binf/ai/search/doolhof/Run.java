/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binf.ai.search.doolhof;

import binf.ai.search.informed.BreadthFirstGraphSearch;
import binf.ai.search.informed.DepthWithLimitGraphSearch;
import binf.ai.search.informed.PriorityQueueGraphSearch;
import binf.ai.search.problem.Problem;
import binf.ai.search.problem.State;
import binf.ai.search.uninformed.BreadthFirstTreeSearch;
import binf.ai.search.uninformed.DepthFirstTreeSearchWithLimit;
import binf.ai.search.uninformed.PriorityQueueTreeSearch;

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

        //new AStarTreeSearch(problem);
        System.out.println("Breedte eerst zoeken treesearch");
        new BreadthFirstTreeSearch(problem);

        System.out.println("Diepte zoeken met limiet 9 treesearch");
        new DepthFirstTreeSearchWithLimit(problem);

        System.out.println("TreeSearch met priorityqueue");
        new PriorityQueueTreeSearch(problem);

        System.out.println("GraphSearch met priorityqueue");
        new PriorityQueueGraphSearch(problem);

        System.out.println("Breedte eerst zoeken graphsearch");
        new BreadthFirstGraphSearch(problem);

        System.out.println("Diepte eerst zoeken met limit 9 graphsearch");
        new DepthWithLimitGraphSearch(problem);
    }
}
