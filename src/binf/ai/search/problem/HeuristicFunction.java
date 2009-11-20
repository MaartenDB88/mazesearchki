package binf.ai.search.problem;


public interface HeuristicFunction {
	float getHeuristicValue(State state);
}