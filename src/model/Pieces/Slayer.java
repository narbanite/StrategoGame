package model.Pieces;

import model.Piece;

/**
 *This class creates a new <b>Slayer</b>
 * @author Nikoletta Arvaniti
 */
public class Slayer extends MovablePiece {
    /**
     * <b>Constructor:</b> constructs a new instance of Slayer and via the parent class
     * MovablePiece sets with the command super, name = Slayer and value = 1 and colour
     */

    public Slayer(char colour) {
        super(colour);
        super.setName("slayer" + colour);
        super.setIcon(super.getName());
        super.setValue(1);
    }


}
