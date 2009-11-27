package binf.ai.search.doolhof;

/**
 * enumereert de richtingen en laat toe padkost in die richting te berekenen
 */
public enum Action {

    NOORD(1, 0, -1),
    NOORDOOST((float) Math.sqrt(2), 1, -1),
    OOST(1, 1, 0),
    ZUIDOOST((float) Math.sqrt(2), 1, 1),
    ZUID(1, 0, 1),
    ZUIDWEST((float) Math.sqrt(2), -1, 1),
    WEST(1, -1, 0),
    NOORDWEST((float) Math.sqrt(2), -1, -1);
    private float cost;
    private int x, y;

    private Action(float cost, int x, int y) {
        this.cost = cost;
        this.x = x;
        this.y = y;
    }

    /**
     * geeft de kost van deze actie weer
     * @return float
     */
    public float getCost() {
        return cost;
    }

    /**
     * geeft de horizontale offset weer voor deze actie
     * @return int positie
     */
    public int getRelativeX() {
        return x;
    }

    /**
     * geeft de verticale offset weer voor deze actie
     * @return int positie
     */
    public int getRelativeY() {
        return y;
    }
}
