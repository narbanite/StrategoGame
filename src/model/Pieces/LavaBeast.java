package model.Pieces;

import model.Piece;

/**
 *This class creates a new <b>LavaBeast</b>
 * @author Nikoletta Arvaniti
 */
public class LavaBeast extends MovablePiece {
    /**
     * <b>Constructor:</b> constructs a new instance of LavaBeast and via the parent class
     * MovablePiece sets with the command super, name = LavaBeast and value = 5 and colour
     */

    public LavaBeast(char colour) {
        super(colour);
        super.setName("lavaBeast");
        super.setIcon(super.getName());
        super.setValue(5);
    }


}
