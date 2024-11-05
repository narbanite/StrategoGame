package model.collection;

import model.Pieces.*;
import model.Piece;

/**
 * Contains all the initial pieces of a player
 * Depending on what colour we will give to it,
 * it will construct the pieces
 */
public class Collection {
    private Piece[] Piece = new Piece[30];
    private int[] Quantity = new int[30];

    /**
     * <b>Constructor:</b> constructs a new collection of pieces
     * <b>Precondition:</b> The only colour which can take is R(Red)) or B(Blue)
     * @param colour char
     */
    public Collection(char colour) {

        Piece[0] = new Dragon(colour);

        Piece[1] = new Mage(colour);

        Piece[2] = new Slayer(colour);

        Piece[3] = new Flag(colour);

        Piece[4] = new Knight(colour);
        Piece[5] = new Knight(colour);

        Piece[6] = new Sorceress(colour);
        Piece[7] = new Sorceress(colour);

        Piece[8] = new Elf(colour);
        Piece[9] = new Elf(colour);


        Piece[10] = new BeastRider(colour);
        Piece[11] = new BeastRider(colour);
        Piece[12] = new BeastRider(colour);


        Piece[13] = new Scout(colour);
        Piece[14] = new Scout(colour);
        Piece[15] = new Scout(colour);
        Piece[16] = new Scout(colour);


        Piece[17] = new Dwarf(colour);
        Piece[18] = new Dwarf(colour);
        Piece[19] = new Dwarf(colour);
        Piece[20] = new Dwarf(colour);
        Piece[21] = new Dwarf(colour);


        Piece[22] = new Bomb(colour);
        Piece[23] = new Bomb(colour);
        Piece[24] = new Bomb(colour);
        Piece[25] = new Bomb(colour);
        Piece[26] = new Bomb(colour);
        Piece[27] = new Bomb(colour);


        if(colour == 'R') {
            Piece[28] = new LavaBeast(colour);
            Piece[29] = new LavaBeast(colour);
        } else {
            Piece[28] = new Yeti(colour);
            Piece[29] = new Yeti(colour);
        }

        for(int i=0; i<30; i++){
            Quantity[i]=1;
        }

    }

    /**
     * <b>Observer:</b> Returns true if there isn't quantity, or false different
     * @return false for empty quantity, true different
     * @param i
     */
    public boolean isEmpty(int i) {
        return Quantity[i] == 0;
    }

    /**
     * <b>Observer:</b> Returns false if there is at least a piece, or true different
     * <b>Postcondition:</b> There is at least 1 quantity of piece i
     * @return true for empty collection, false different
     */
    public boolean isEmptyCollection() {
        for(int i = 0; i < 30; i++) {
            if(Quantity[i] != 0) return false;
        }
        return true;
    }

    /**
     * <b>Accessor:</b> returns the quantity of piece in position i
     * <b>Postcondition:</b> i >= 0 && i < 30
     * @return the quantity of piece i
     * @param i
     */
    public int getQuantity(int i) {
        return Quantity[i];
    }

    /**
     * <b>Accessor:</b> returns the piece in position i
     * <b>Postcondition:</b> i >= 0 && i < 30
     * @return the piece in position i
     * @param i
     */
    public Piece getPiece(int i) {
        return Piece[i];
    }

   /**
     * <b>Transformer:</b> Rise the quantity of piece i.
     * <b>Precondition:</b> the piece is dead, and we use the rescue option
     * <b>Postcondition:</b> i >= 0 && i < 30
     * @param i
     */
    public void setPiece(int i) {
        Quantity[i]++;
    }

    /**
     * <b>Returns</b> the position of the given piece inside the Piece array.
     * @param p piece
     * @return int position
     */
    public int returnPos(Piece p){
        for(int i=0; i<30; i++){
            if (Piece[i] == p){
                return i;
            }
        }
        return 35;
    }

}
