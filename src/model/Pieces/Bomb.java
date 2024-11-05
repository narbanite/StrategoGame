package model.Pieces;
/**
 *This class creates a new <b>Bomb</b>
 * @author Nikoletta Arvaniti
 */
public class Bomb extends ImmovablePiece {
    /**
     * <b>Constructor:</b> constructs a new instance of Bomb and via the parent class
     * ImmovablePiece sets with the command super, the colour of the bomb, name = Trap and value = 0.
     */

    public Bomb(char colour) {
        super(colour);
        super.setName("trap" + colour);
        setIcon(this.getName());
        super.setValue(0);
    }
}
