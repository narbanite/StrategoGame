package model.Pieces;

import model.Piece;

/**
 *This class creates a new <b>Mage</b>
 * @author Nikoletta Arvaniti
 */
public class Mage extends MovablePiece {
    /**
     * <b>Constructor:</b> constructs a new instance of Mage and via the parent class
     * MovablePiece sets with the command super, name = Mage and value = 9 and colour
     */

    public Mage(char colour) {
        super(colour);
        super.setName("mage" + colour);
        super.setIcon(super.getName());
        super.setValue(9);
    }


}
