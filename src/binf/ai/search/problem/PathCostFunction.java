package binf.ai.search.problem;


public interface PathCostFunction {
	float calculatePathCost(State fromState, State toState, String action);
}