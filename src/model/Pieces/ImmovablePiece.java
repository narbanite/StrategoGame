package model.Pieces;
/**
 * This class represents an Immovable Piece in <b>stratego</b>
 * @author Nikoletta Arvaniti
 */
public class ImmovablePiece extends model.Piece {


    /**<b>Constructor:</b> constructs a new immovable piece
     *
     * @param colour is the colour of the piece
     */
    ImmovablePiece(char colour){
        super(colour);
    }

    /**
     * <b>Constructor:</b> constructs an immovable piece, used for the forbidden pieces
     */
    ImmovablePiece(){super();} // for forbidden

}
