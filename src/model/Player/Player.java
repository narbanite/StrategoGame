package model.Player;

import model.Piece;
import model.Pieces.*;
import model.collection.Collection;

import java.util.Objects;

/**
 * Contains the methods needed for creating the players of a stratego game
 * @author Nikoletta Arvaniti
 */


public class Player {

    private String name;
    private int captures,rescues, successfulAttacks, totalAttacks;

    private boolean isAlive;

    public Piece[] Pieces = new Piece[30];

    final private char colour;

    final private Collection collection;

    /**
     * <b>Constructor:</b>  constructs a new Player with a name, a collection, a colour
     * and sets all the rescues, captures, successful attacks and total attacks to zero
     * @param name is the name of the player
     * @param colour is the colour of the player #notracist
     */
    public Player(char colour, String name){
        this.colour = colour;
        this.name = name;
        collection = new Collection(colour);
        captures = 0;
        rescues = 0;
        successfulAttacks = 0;
        totalAttacks = 0;
        isAlive=true;
    }

    /**
     * <b>Accessor:</b> returns the colour of the player. #notracist
     * @return colour
     */
    public char getColour() {
        return colour;
    }

    /**
     * <b>Accessor:</b> returns the collection of pieces of the player.
     * @return collection
     */
    public Collection getCollection() {
        return collection;
    }



    /**
     * <b>Accessor:</b> returns the name of the player
     * <b>Postcondition:</b> the player's name has been returned
     * @return string name
     */
    public String getName() {
        return name;
    }

    /**
     * <b>Transformer:</b> sets the piece's name
     * <b>Postcondition:</b> the piece's name has been set
     * @param name string
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * <b>Transformer:</b> sets the player's captures
     * <b>Postcondition:</b> the player's captures has been set
     * @param captures int
     */
    public void setCaptures(int captures) {
        this.captures = captures;
    }

    /**
     * <b>Accessor:</b> returns the name of the player
     * <b>Postcondition:</b> the player's name has been returned
     * @return string name
     */
    public int getCaptures() {
        return captures;
    }

    /**
     * <b>Accessor:</b> returns the rescues of the player
     * <b>Postcondition:</b> the player's rescues has been returned
     * @return int rescues
     */
    public int getRescues() {
        return rescues;
    }

    /**
     * <b>Transformer:</b> sets the player's rescues
     * <b>Postcondition:</b> the player's rescues has been set
     * @param rescues int
     */
    public void setRescues(int rescues) {
        this.rescues = rescues;
    }

    /**
     * <b>Accessor:</b> returns the successful attacks of the player
     * <b>Postcondition:</b> the player's successful attacks has been returned
     * @return int succesfulAttacks
     */
    public int getSuccessfulAttacks() {
        return successfulAttacks;
    }

    /**
     * <b>Transformer:</b> sets the player's successful attacks
     * <b>Postcondition:</b> the player's successful attacks has been set
     * @param successfulAttacks int
     */
    public void setSuccessfulAttacks(int successfulAttacks) {
        this.successfulAttacks = successfulAttacks;
    }

    /**
     * <b>Transformer:</b> sets the player's total attacks
     * <b>Postcondition:</b> the player's total attacks has been set
     * @param totalAttacks int
     */
    public void setTotalAttacks(int totalAttacks) {
        this.totalAttacks = totalAttacks;
    }

    /**
     * <b>Accessor:</b> returns the total attacks of the player
     * <b>Postcondition:</b> the player's total attacks has been returned
     * @return int totalAttacks
     */
    public int getTotalAttacks() {
        return totalAttacks;
    }

    /**
     *<b>Calculates</b> the success percent of player
     * <b>Postcondition:</b> the percent of success is calculated
     * @return int success percent
     */
    public int percentOfSuccess() {
        return (getSuccessfulAttacks()/getTotalAttacks())*100;
    }

    /**
     * <b>Transformer:</b> adds an attack to the player's total attacks
     * <b>Postcondition:</b> an attack has been added to the player's total attacks
     */
    public void addAttack() {
        totalAttacks = totalAttacks + 1;
    }

    /**
     * <b>Transformer:</b> adds an attack to the player's successful attacks
     * <b>Postcondition:</b> an attack has been added to the player's successful attacks
     */
    public void addSuccessfulAttack() {
        successfulAttacks = successfulAttacks + 1;
    }

    /**
     * <b>Transformer:</b> sets the isAlive to true if player is alive and false otherwise
     * @param isAlive boolean
     */
    public void setIsAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

    /**
     * <b>Accessor:</b> returns the boolean isAlive, true if the player is alive and false otherwise
     * @return isAlive boolean
     */
    public boolean getIsAlive(){return isAlive;}


    /**
     * <b>Accessor:</b> returns the pieces of the player.
     * @return Pieces
     */
    public Piece[] getPieces() {
        return Pieces;
    }
}
