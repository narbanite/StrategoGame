package model.Pieces;

import model.Piece;

/**
 * This class represents a Movable Piece in <b>stratego</b>
 * @author Nikoletta Arvaniti
 */
public abstract class MovablePiece extends Piece {
    private int value,rescues;
    private String name;
    /**<b>Constructor:</b> constructs a new movable piece with zero rescues and the given colour, R or B
     *
     * @param colour R or B
     */
    public MovablePiece(char colour){
         super(colour);
        rescues = 0;
    }

    /**
     * <b>Accessor:</b> returns the value of a piece
     * @return value of piece
     */
    @Override
    public int getValue() {
        return value;
    }

    /**
     *<b>Transformer:</b> sets the value of the piece
     * @param value is the value that is going to be set
     */
    @Override
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * <b>Accessor:</b> returns the name of a piece
     * @return name of piece
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     *<b>Transformer:</b> sets the name of the piece
     * @param name is the value that is going to be set
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }



}
