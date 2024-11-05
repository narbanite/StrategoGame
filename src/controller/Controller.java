package controller;

import model.Piece;
import model.Player.Player;
import model.Board.Board;
import model.Pieces.*;

/**
 * Controller is the master of the game and controls all the executions
 * @author Nikoletta Arvaniti
 */


public class Controller {
    private Player fire,ice;
    private boolean GameOver;

    public Board board ;

    private int PlayerTurn=0;


    /**
     * <b>Constructs:</b> constructs a new game with a board, two players.
     */
    public Controller(String name1, String name2 ){
        board = new Board();
        fire = new Player('R', name1);
        ice =  new Player('B', name2);
        GameOver = false;
    }

    /**
     * <b>Transformer:</b> sets the variable GameOver to true when the game is over
     * <b>Precondition:</b> the game is not over
     * <b>Postcondition:</b> The game is over
     */
    public void setGameOver(){GameOver = true;}

    /**
     * <b>Accessor:</b> returns true if the game is over and false otherwise
     * @return the variable GameOver to let us know if the game is over or not
     */
    public boolean getGameOver(){return GameOver;}

    /**
     * <b>Rescues</b> a piece and brings it back to the game
     * <b>Precondition:</b> the piece that is going to be rescued is NOT from the enemy player
     * <b>Postcondition:</b> the piece is brought back to life
     * @param p is the piece going to be rescued
     * @param x the coordinate x that we want to put it to
     * @param y the coordinate y that we want to put it to
     */
    public void rescue(Piece p, int x, int y){

    }


    /**
     * <b>Sets</b> the turn to the next player
     * <b>Precondition:</b> the game is not over
     * <b>Postcondition:</b> the turn has changed
     */

    public void setPlayerTurn(){
        if (PlayerTurn == 0){
            PlayerTurn = 1;
        }else{
            PlayerTurn = 0;
        }
    }

    /**
     * <b>Accessor:</b> returns the int PlayerTurn that shows which player is playing
     * @return player turn
     */
    public int getPlayerTurn() {
        return PlayerTurn;
    }

    /**
     * <b>Accessor:</b> returns which player is playing
     * @param p is the player turn
     * @return fire is p=0 and ice if p=1
     */
    public Player getPlayer(int p){
        if (p==0){
            return fire;
        }else if (p==1){
            return ice;
        }
        return null;
    }


    /**
     * <b>Accessor:</b> returns the board of the game
     * @return board 8x10
     */
    public Board getBoard() {
        return board;
    }

}

