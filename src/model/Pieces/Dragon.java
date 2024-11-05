package model.Pieces;

import model.Piece;

/**
 *This class creates a new <b>Dragon</b>
 * @author Nikoletta Arvaniti
 */
public class Dragon extends MovablePiece {
    /**
     * <b>Constructor:</b> constructs a new instance of Dragon and via the parent class
     * MovablePiece sets with the command super, name = Dragon and value = 10 and colour
     */

    public Dragon(char colour) {
        super(colour);
        super.setName("dragon" + colour);
        super.setIcon(super.getName());
        super.setValue(10);
    }





}
