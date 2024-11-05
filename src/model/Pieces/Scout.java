package model.Pieces;

import model.Piece;

/**
 *This class creates a new <b>Scout</b>
 * @author Nikoletta Arvaniti
 */
public class Scout extends MovablePiece {
    /**
     * <b>Constructor:</b> constructs a new instance of Scout and via the parent class
     * MovablePiece sets with the command super, name = Scout and value = 2 and colour
     */

    public Scout(char colour) {
        super(colour);
        super.setName("scout" + colour);
        super.setIcon(super.getName());
        super.setValue(2);
    }



}
