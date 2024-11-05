package model.Pieces;

import model.Piece;

/**
 *This class creates a new <b>BeastRider
 * </b>
 * @author Nikoletta Arvaniti
 */
public class BeastRider extends MovablePiece {
    /**
     * <b>Constructor:</b> constructs a new instance of BeastRider and via the parent class
     * MovablePiece sets with the command super, colour, name = Beast Rider and value = 7.
     */

    public BeastRider(char colour) {
        super(colour);
        super.setName("beastRider"+ colour);
        super.setIcon(super.getName());
        super.setValue(7);
    }



}
