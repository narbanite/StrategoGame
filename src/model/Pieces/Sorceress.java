package model.Pieces;

import model.Piece;

/**
 *This class creates a new <b>Sorceress</b>
 * @author Nikoletta Arvaniti
 */
public class Sorceress extends MovablePiece {
    /**
     * <b>Constructor:</b> constructs a new instance of Sorceress and via the parent class
     * MovablePiece sets with the command super, name = Sorceress and value = 6 and colour
     */

    public Sorceress(char colour) {
        super(colour);
        super.setName("sorceress" + colour);
        super.setIcon(super.getName());
        super.setValue(6);
    }

}
