package model.Pieces;

import model.Piece;

/**
 *This class creates a new <b>ELf</b>
 * @author Nikoletta Arvaniti
 */
public class Elf extends MovablePiece {
    /**
     * <b>Constructor:</b> constructs a new instance of Elf and via the parent class
     * MovablePiece sets with the command super, name = Elf and value = 4 and colour
     */

    public Elf(char colour) {
        super(colour);
        super.setName("elf" + colour);
        super.setIcon(super.getName());
        super.setValue(4);
    }


}
