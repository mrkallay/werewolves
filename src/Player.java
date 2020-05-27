/**
 * Created by briankallay on 5/8/20.
 */
public class Player
{
    private String name;

    private int turn;

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    Character character;
    private boolean isDoppelganger;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isDoppelganger()
    {
        return isDoppelganger;
    }

    public void setDoppelganger(boolean doppelganger)
    {
        isDoppelganger = doppelganger;
    }
}
