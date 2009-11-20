package binf.ai.search.problem;
import java.util.List;


public interface SuccessorFunction {
	List<Successor> getSuccessors(State state);
}