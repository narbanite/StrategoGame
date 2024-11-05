package model;

import javax.swing.*;

/**
 * Contains the methods needed for creating the pieces of a stratego game
 * @author Nikoletta Arvaniti
 */


public abstract class Piece {
    private String name;
    private int value;

    private char colour;
    private Icon icon;

    /**
     * <b>Constructor</b>: constructs a new Piece with the given colour
     * <b>Postcondition:</b> colour: R(Red) or B(Blue)
     * @param colour
     */
    public Piece(char colour) {
        this.colour=colour;
    }

    /**
     * <b>Constructor:</b> constructs a new simple piece, used for the forbidden.
     */
    public Piece(){};

    /**
     * <b>Accessor:</b> returns the colour of the piece.
     * @return colour
     */
    public char getColour() {
        return colour;
    }

    /**
     * <b>Transformer:</b> sets the Icon with the correct icon
     * @param icon
     */
    public void setIcon(String icon) {
        if (colour == 'R'){
            this.icon= new ImageIcon("./images/RedPieces/" + icon + ".png");
        }else if( colour == 'B'){
            this.icon= new ImageIcon("./images/bluePieces/" + icon + ".png");
        }

    }

    /**
     * <b>Transformer:</b> sets the colour of the piece.
     * @param colour colour R or B
     */
    public void setColour(char colour) {
        this.colour = colour;
    }

    /**
     * <b>Accessor:</b> returns the icon of the piece.
     * @return icon
     */
    public Icon getIcon() {
        return icon;
    }



    /**
     * <b>Accessor:</b> returns the value of the piece
     * <b>Postcondition:</b> the value of the piece has been returned
     *
     * @return int value
     */
    public int getValue(){
        return value;
    }

    /**
     *<b>Transformer:</b> sets the piece's value
     * <b>Postcondition:</b> the piece's value has been set
     * @param value int
     */
    public void setValue(int value){
        this.value = value;
    }

    /**
     * <b>Accessor:</b> returns the name of the piece
     * <b>Postcondition:</b> the piece's name has been returned
     * @return string name
     */
    public String getName(){
        return name;
    }

    /**
     * <b>Transformer:</b> sets the piece's name
     * <b>Postcondition:</b> the piece's name has been set
     * @param name string
     */
    public void setName(String name){
        this.name = name;
    }


}
