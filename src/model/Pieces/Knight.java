package model.Pieces;

import model.Piece;

/**
 *This class creates a new <b>Knight</b>
 * @author Nikoletta Arvaniti
 */
public class Knight extends MovablePiece {
    /**
     * <b>Constructor:</b> constructs a new instance of Knight and via the parent class
     * MovablePiece sets with the command super, name = Knight and value = 8 and colour
     */

    public Knight(char colour) {
        super(colour);
        super.setName("knight" + colour);
        super.setIcon(super.getName());
        super.setValue(8);
    }


}
