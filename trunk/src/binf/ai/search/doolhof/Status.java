package binf.ai.search.doolhof;

/**
 * is een Status van een state
 */
public enum Status {
    BLANK ('o'),
    START ('s'),
    GOAL ('g'),
    OBSTACLE ('x');

    private char status;

    private Status(char status){
        this.status=status;
    }

    @Override
    public String toString(){
        return Character.toString(status);
    }

    /**
     * geeft de status weer als een char object
     * @return char
     */
    public char getStatus() {
        return status;
    }
}
