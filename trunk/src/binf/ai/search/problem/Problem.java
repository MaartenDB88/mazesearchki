package binf.ai.search.problem;

public class Problem {

	State initialState;
	SuccessorFunction successorFunction;
	GoalTest goalTest;
	PathCostFunction pathCostFunction;
	HeuristicFunction heuristicFunction;

	public Problem(State initialState, SuccessorFunction successorFunction,
			GoalTest goalTest) {
		this.initialState = initialState;
		this.successorFunction = successorFunction;
		this.goalTest = goalTest;
	}

	public Problem(State initialState, SuccessorFunction successorFunction,
			GoalTest goalTest, PathCostFunction pathCostFunction) {
		this(initialState, successorFunction, goalTest);
		this.pathCostFunction = pathCostFunction;
	}

	public Problem(State initialState, SuccessorFunction successorFunction,
			GoalTest goalTest, HeuristicFunction heuristicFunction) {
		this(initialState, successorFunction, goalTest);
		this.heuristicFunction = heuristicFunction;
	}

	public Problem(State initialState, SuccessorFunction successorFunction,
			GoalTest goalTest, PathCostFunction pathCostFunction,
			HeuristicFunction heuristicFunction) {
		this(initialState, successorFunction, goalTest, pathCostFunction);
		this.heuristicFunction = heuristicFunction;
	}

	public State getInitialState() {
		return initialState;
	}

	public boolean isGoalState(State state) {
		return goalTest.isGoalState(state);
	}

	public PathCostFunction getPathCostFunction() {
		return pathCostFunction;
	}

	public SuccessorFunction getSuccessorFunction() {
		return successorFunction;
	}

	public HeuristicFunction getHeuristicFunction() {
		return heuristicFunction;
	}
}