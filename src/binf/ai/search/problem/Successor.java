package binf.ai.search.problem;


public class Successor {

	private String action;
	private State state;

	public Successor(String action, State state) {
		this.action = action;
		this.state = state;
	}

	public String getAction() {
		return action;
	}

	public State getState() {
		return state;
	}
}