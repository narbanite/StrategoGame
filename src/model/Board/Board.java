package model.Board;

import model.Piece;
import model.Pieces.*;

/**
 * This class is used for the board 8x10. Contains the methods needed for creating a Stratego board.
 */
public class Board {

    Piece[][] board;

    /**
     * <b>Constructor:</b> constructs a new board 8x10 for the game.
     */
    public Board() {
        board = new Piece[8][10];
        for(int i=0; i<8; i++){
            for(int k=0; k<10; k++){
                if( (i==3 || i==4)){
                    board[i][k] = new Tile();
                }
                if ((i == 3 && k == 2 )|| (i == 3 && k == 3) || (i == 4 && k == 2) || (i == 4 && k == 3) || (i == 3 && k==6) || (i == 3 && k == 7) ||( i == 4 && k == 6) || (i == 4 && k==7)){
                    board[i][k] = new Circumscribed();
                }
            }
        }

    }

    /**
     * <b>Removes</b> the piece from the board.
     * @param x the x coordinate of the hero we want to kill
     * @param y the y coordinate
     */
    public void killHero(int x, int y) {
        board[x][y] = null;
    }


    /**
     * <b>Accessor:</b> returns the board of the game.
     * @return board
     */
    public Piece[][] getBoard() {
        return board;
    }

    /**
     * <b>Sets</b> a piece at the given x and y coordinates.
     * @param p piece
     * @param x coordinate
     * @param y coordinate
     */
    public void setPiece(Piece p,int x, int y){
        board[x][y] = p;
    }

    /**
     * <b>Returns</b> true if the piece can move to coordinates we want, false otherwise.
     * @param x1 coordinate of piece
     * @param y1 coordinate of piece
     * @param x2 coordinate we want to move it to
     * @param y2 coordinate we want to move it to
     * @return boolean
     */
    public boolean isMovable(int x1, int y1, int x2, int y2){

        if(board[x1][y1] instanceof Scout){

            if (x1==x2){
                if (y2>y1) {
                    for (int i = y1 + 1; i < y2; i++) {
                        if (board[x1][i] instanceof MovablePiece || board[x1][i] instanceof Bomb || board[x1][i] instanceof Flag || board[x1][i] instanceof Circumscribed) {
                            return false;
                        }
                    }
                }else if(y1>y2){
                    for(int i=y1-1; i>y2; i--){
                        if (board[x1][i] instanceof MovablePiece || board[x1][i] instanceof Bomb || board[x1][i] instanceof Flag || board[x1][i] instanceof Circumscribed) {
                            return false;
                        }
                    }
                }
                return true;
            }else if(y1==y2){

                if (x2>x1){
                    for(int i=x1+1; i<x2; i++){
                        if (board[i][y1] instanceof MovablePiece || board[i][y1] instanceof Bomb || board[i][y1] instanceof Flag || board[i][y1] instanceof Circumscribed) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }else{
            if ( (x2 == x1-1) && (y1 == y2) && !(board[x2][y2] instanceof Circumscribed)){
                return true;
            }else if( (x1==x2) && (y2==y1-1) && !(board[x2][y2] instanceof Circumscribed)){
                return true;
            }else if( (x1==x2) && (y2 == y1+1) && !(board[x2][y2] instanceof Circumscribed)){
                return true;
            }else if( (y1==y2) && (x2 == x1+1) && !(board[x2][y2] instanceof Circumscribed)){
                return true;
            }
        }


        return false;
    }

    /**
     * <b>Returns</b> true if the piece we give is an instance of Flag, false otherwise.
     * @param p piece
     * @return boolean
     */
    public boolean isInstanceOfFlag(Piece p){
        return p instanceof Flag;
    }

    /**
     * <b>Returns</b> true if the piece we give is an instance of Tile, false otherwise.
     * @param p piece
     * @return boolean
     */
    public boolean isInstanceOfTile(Piece p){
        return p instanceof Tile;
    }

    /**
     * <b>Returns</b> true if the piece we give is an instance of Bomb, false otherwise.
     * @param p piece
     * @return boolean
     */
    public boolean isInstanceOfBomb(Piece p){
        return p instanceof Bomb;
    }

    /**
     * <b>Returns</b> true if the piece we give is an instance of Dwarf, false otherwise.
     * @param p piece
     * @return boolean
     */
    public boolean isInstanceOfDwarf(Piece p){
        return p instanceof Dwarf;
    }

    /**
     * <b>Returns</b> true if the piece we give is an instance of ImmovablePiece, false otherwise.
     * @param p piece
     * @return boolean
     */
    public boolean isInstanceOfImmovable(Piece p){
        return p instanceof ImmovablePiece;
    }

    /**
     * <b>Returns</b> true if the piece we give is an instance of Dragon, false otherwise.
     * @param p piece
     * @return boolean
     */
    public boolean isInstanceOfDragon(Piece p){
        return p instanceof Dragon;
    }

    /**
     * <b>Returns</b> true if the piece we give is an instance of Slayer, false otherwise.
     * @param p piece
     * @return boolean
     */
    public boolean isInstanceOfSlayer(Piece p){
        return p instanceof Slayer;
    }

    /**
     * <b>Sets</b> a new tile at the given coordinates.
     * @param x coordinate
     * @param y coordinate
     */
    public void setTile(int x, int y){
        board[x][y] = new Tile();
    }

    /**
     * <b>Returns</b> the piece at the given coordinates.
     * @param x coordinate
     * @param y coordinate
     * @return board[x][y]
     */
    public Piece getPiece(int x, int y){
        return board[x][y];
    }

}
