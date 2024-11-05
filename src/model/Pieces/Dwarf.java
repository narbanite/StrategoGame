package model.Pieces;

import model.Piece;

/**
 *This class creates a new <b>Dwarf</b>
 * @author Nikoletta Arvaniti
 */
public class Dwarf extends MovablePiece {
    /**
     * <b>Constructor:</b> constructs a new instance of Dwarf and via the parent class
     * MovablePiece sets with the command super, name = Dwarf and value = 3 and colour
     */

    public Dwarf(char colour) {
        super(colour);
        super.setName("dwarf" + colour);
        super.setIcon(super.getName());
        super.setValue(3);
    }




}
