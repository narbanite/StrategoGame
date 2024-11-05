package model.Pieces;

/**
 *This class creates a new <b>Flag</b>
 * @author Nikoletta Arvaniti
 */
public class Flag extends ImmovablePiece {
    /**
     * <b>Constructor:</b> constructs a new instance of Flag and via the parent class
     * ImmovablePiece sets with the command super, name = Flag and value = 0 and colour
     */

    public Flag(char colour) {
        super(colour);
        super.setName("flag" + colour);
        super.setIcon(this.getName());
        super.setValue(0);
    }
}
