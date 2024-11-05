package model.Pieces;

import model.Piece;

public class Yeti extends MovablePiece{
    /**
     * <b>Constructor:</b> constructs a new movable piece Yeti, and via the parent class
     * MovablePiece sets with the command super, name = Yeti and value = 5 and colour
     */
    public Yeti(char colour) {
        super(colour);
        super.setName("yeti");
        super.setIcon(super.getName());
        super.setValue(5);
    }

}
