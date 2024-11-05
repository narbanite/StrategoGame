package view;

import java.util.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

import controller.Controller;

/**
 *
 * @author Nikoletta Arvaniti
 */
public class Graphs extends JFrame {
    private boolean iconSelected;
    private JButton first;// to prwto koumpi pou epilegoume
    int x1,y1;// suntetagmenes tou prwtou koumpiou
    public int k=0;
    public JButton[][] board;

    Controller c = new Controller("nikol","hehe");
    int playerTurn = c.getPlayerTurn();
    boolean gameOver = c.getGameOver();
    List<Integer> numbers = new ArrayList<Integer>(30);
   // List<JButton> blueButtons = new ArrayList<>(30);
   // List<JButton> redButtons = new ArrayList<>(30);

    /**
     * <b>Constructor:</b> constructs a new game, sets the pieces and JButtons, Mouselisteners
     * @throws IOException exception
     */
    public Graphs() throws IOException {
        this.setTitle("Stratego");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        CardListener cl = new CardListener();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 10));
        int j,n;
        for (j = 0; j < 30; j++)
            numbers.add(j);
        Collections.shuffle(numbers); //vazw ta noumera apo 0-30 se ena arraylist kai ta kanw shuffle gia na ulopoihsw to random
        j = 0;
        n = 0;
        board = new JButton[8][10];
        int random = 0;
        for (int i = 0; i < 8; i++) {
            for(int k = 0; k < 10; k++){
                board[i][k] = new JButton();
                if (i < 3) { // initialize board
                    random = numbers.get(j); // vazei se random theseis ta pionia kathe fora
                    j++;
                    board[i][k].setIcon(getHiddenImageCard(playerTurn));// prwta paizei o kokkinos ara kruvw ta pionia tou mple
                    board[i][k].setName(cardname);
                    board[i][k].addMouseListener(cl);
                    c.getBoard().setPiece(c.getPlayer(1).getCollection().getPiece(random),i,k );
                } else if ((i == 3 && k == 2 )|| (i == 3 && k == 3) || (i == 4 && k == 2) || (i == 4 && k == 3) || (i == 3 && k==6) || (i == 3 && k == 7) ||( i == 4 && k == 6) || (i == 4 && k==7)) { //  set forbidden
                    board[i][k].setBorderPainted(false);
                    board[i][k].setFocusPainted(false);
                    board[i][k].setBackground(Color.blue); // ta kanw forbidden ston constructor tou board
                }else if(i>4){
                    random = numbers.get(n);
                    n++;
                    board[i][k].setIcon(getImageCard(random, "RedPieces"));
                    c.getBoard().setPiece(c.getPlayer(0).getCollection().getPiece(random),i,k);
                    board[i][k].setName(cardname);
                    board[i][k].addMouseListener(cl);
                }else {
                    board[i][k].addMouseListener(cl); // ta upoloipa ta kanw apla tiles ston constructor tou board
                }
                board[i][k].setBorder(BorderFactory.createLineBorder(Color.black));

                panel.add(board[i][k]);
            }
            add(panel);
            iconSelected = false;

        }
    }

    /**
     * <b>Returns</b> the icon that should be in the Jbutton when it's the player's turn.
     * @param num int
     * @param team string
     * @return ImageIcon
     */
    private ImageIcon getImageCard(int num, String team) { // image for card
        String RnB = "";
        String img = "";
        if (Objects.equals(team, "bluePieces")){
            RnB = "B";
        }else if(Objects.equals(team, "RedPieces")){
            RnB = "R";
        }
        //System.out.println(RnB);
        try {
            if (num == 0){
                img = "./images/" + team + "/dragon" + RnB + ".png";
            }else if(num == 1){
                img = "./images/" + team + "/mage" + RnB + ".png";
            }else if (num == 2){
                img = "./images/" + team + "/slayer" + RnB + ".png";
            }else if (num == 3){
                img = "./images/" + team + "/flag" + RnB + ".png";
            }else if(num == 4 || num == 5){
                img = "./images/" + team + "/knight" + RnB + ".png";
            }else if(num == 6 || num == 7){
                img = "./images/" + team + "/sorceress" + RnB + ".png";
            }else if (num == 8 || num == 9){
                img = "./images/" + team + "/elf" + RnB + ".png";
            }else if (num == 10 || num == 11 || num == 12){
                img = "./images/" + team + "/beastRider" + RnB + ".png";
            }else if (num == 13 || num == 14 || num == 15 || num == 16){
                img = "./images/" + team + "/scout" + RnB + ".png";
            }else if (num == 17 || num == 18 || num == 19 || num == 20 || num == 21){
                img = "./images/" + team + "/dwarf" + RnB + ".png";
            }else if(num == 22 || num == 23 || num == 24 || num == 25 || num == 26 || num == 27){
                img = "./images/" + team + "/trap" + RnB + ".png";
            }else if ( (num == 28 || num == 29) && Objects.equals(team, "bluePieces") ){
                img = "./images/" + team + "/yeti.png";
            }else if( (num == 28 || num == 29) && Objects.equals(team, "RedPieces") ){
                img = "./images/" + team + "/lavaBeast.png";
            }
            return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource(img)))
                    .getScaledInstance(190, 130, Image.SCALE_SMOOTH)); // image
        } catch (IOException ex) {
            Logger.getLogger(Graphs.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * <b>Returns</b> the hidden image of the other player's cards
     * @param playerTurn int
     * @return ImageIcon
     */
    private ImageIcon getHiddenImageCard(int playerTurn){
        if (playerTurn == 0){
            try{
                return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/bluePieces/blueHidden.png")))
                        .getScaledInstance(190, 130, Image.SCALE_SMOOTH));
            }catch(IOException ex){
                Logger.getLogger(Graphs.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }

        }else if( playerTurn == 1){
            try{
                return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/RedPieces/redHidden.png")))
                        .getScaledInstance(190, 130, Image.SCALE_SMOOTH));
            }catch(IOException ex){
                Logger.getLogger(Graphs.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return null;
    }
    int mouseCount=0;
    private class CardListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            JButton second = ((JButton) e.getSource());
            int x2 = getXcoordinate(second);
            int y2 = getYcoordinate(second);
            if (iconSelected && !second.equals(first)) {// move(swap) buttons
                        if(!(c.getBoard().isMovable(x1,y1,x2,y2))){
                            System.out.println("You cant move here buddy, try again");
                            second = null;
                            return;
                        }
                        if(c.getBoard().isInstanceOfFlag(c.getBoard().getPiece(x2,y2))){
                            System.out.println("Game is over");
                            c.setGameOver();
                            makeJFrame();
                        }
                        if(c.getBoard().isInstanceOfTile(c.getBoard().getPiece(x2,y2))){
                            second.setIcon(first.getIcon());
                            second.setName(cardname);
                            first.setIcon(null);
                            c.getBoard().setPiece(c.getBoard().getPiece(x1,y1),x2,y2);
                            c.getBoard().setTile(x1,y1);
                            first.setBorder(BorderFactory.createLineBorder(Color.black));
                            first.setName(null);
                            first = second;
                            iconSelected = false;
                            mouseCount++;
                        }else if (checkIfSameColour(x1,y1,x2,y2)){
                            System.out.println("Same colour, try again");
                            second = null;
                            return;
                        }else if( ( !checkIfSameColour(x1,y1,x2,y2) ) && ( c.getBoard().getPiece(x1,y1).getValue() < c.getBoard().getPiece(x2,y2).getValue() ) ){
                            if(c.getBoard().isInstanceOfDragon(c.getBoard().getPiece(x2,y2))){
                                if(c.getBoard().isInstanceOfSlayer(c.getBoard().getPiece(x1,y1))){
                                    second.setIcon(first.getIcon());
                                    second.setName(cardname);
                                    first.setIcon(null); // if there is player to set icon na pairnei thn eikona tou alliws null
                                    c.getBoard().killHero(x2,y2);
                                    c.getBoard().setPiece(c.getBoard().getPiece(x1,y1),x2,y2);
                                    c.getBoard().setTile(x1,y1);
                                    first.setBorder(BorderFactory.createLineBorder(Color.black));
                                    first.setName(null);
                                    first = second;
                                    iconSelected = false;
                                    mouseCount++;
                                }

                            }
                            System.out.println("The piece you're trying to kill has bigger value. Choose a different tile.");
                            second = null;
                            return;
                        } else if( ( !checkIfSameColour(x1,y1,x2,y2) ) && ( c.getBoard().getPiece(x1,y1).getValue() > c.getBoard().getPiece(x2,y2).getValue() ) ){
                            if(c.getBoard().isInstanceOfBomb(c.getBoard().getPiece(x2,y2))){ //an autos pou kanei epithesh einai o dwarf sthn bomba tote thn eksoudeterwnei kai den pethainei
                                if(c.getBoard().isInstanceOfDwarf(c.getBoard().getPiece(x1,y1))){
                                    second.setIcon(first.getIcon());
                                    second.setName(cardname);
                                    first.setIcon(null);
                                    c.getBoard().killHero(x2,y2);
                                    c.getBoard().setPiece(c.getBoard().getPiece(x1,y1),x2,y2);
                                    c.getBoard().setTile(x1,y1);
                                    first.setBorder(BorderFactory.createLineBorder(Color.black));
                                    first.setName(null);
                                    first = second;
                                    iconSelected = false;
                                    mouseCount++;
                                }else{ // an omws einai allo pioni tote pethainoun kai oi duo
                                    second.setIcon(null);
                                    second.setName(null);
                                    first.setIcon(null);
                                    c.getBoard().killHero(x2,y2);
                                    c.getBoard().killHero(x1,y1);
                                    c.getBoard().setTile(x2,y2);
                                    c.getBoard().setTile(x1,y1);
                                    first.setBorder(BorderFactory.createLineBorder(Color.black));
                                    first.setName(null);
                                    first = second;
                                    iconSelected = false;
                                    mouseCount++;
                                }

                            }else{ // an den einai bomba tote...
                                second.setIcon(first.getIcon());
                                second.setName(cardname);
                                first.setIcon(null); // if there is player to set icon na pairnei thn eikona tou alliws null
                                c.getBoard().killHero(x2,y2);
                                c.getBoard().setPiece(c.getBoard().getPiece(x1,y1),x2,y2);
                                c.getBoard().setTile(x1,y1);
                                first.setBorder(BorderFactory.createLineBorder(Color.black));
                                first.setName(null);
                                first = second;
                                iconSelected = false;
                                mouseCount++;
                            }

                        }else if( ( !checkIfSameColour(x1,y1,x2,y2) ) && ( c.getBoard().getPiece(x1,y1).getValue() == c.getBoard().getPiece(x2,y2).getValue() ) ){
                            // an exoun diaforetiko xrwma kai idio value tote pethainoun kai oi duo
                            second.setIcon(null);
                            second.setName(null);
                            first.setIcon(null); // if there is player to set icon na pairnei thn eikona tou alliws null
                            c.getBoard().killHero(x2,y2);
                            c.getBoard().killHero(x1,y1);
                            c.getBoard().setTile(x2,y2);
                            c.getBoard().setTile(x1,y1);
                            first.setBorder(BorderFactory.createLineBorder(Color.black));
                            first.setName(null);
                            first = second;
                            iconSelected = false;
                            mouseCount++;
                        }



            } else if (!iconSelected && second.getName() != null) { // edw prepei na kanw to error pou leme me ton mixalh
                iconSelected = true;
                first = second;
                 x1 = getXcoordinate(first);
                 y1 = getYcoordinate(first);
                 if(c.getBoard().isInstanceOfImmovable(c.getBoard().getPiece(x1,y1))){
                     System.out.println("You cannot move an immovable piece");
                     iconSelected = false;
                     first = null;
                     return;
                 }
                 mouseCount++;
                second.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
            }

            if (mouseCount%2==0 && mouseCount!=0) {
                c.setPlayerTurn();
                playerTurn = c.getPlayerTurn();
                if(playerTurn==0){
                    for(int i=0; i<8; i++){
                        for(int j=0; j<10; j++){
                            if(c.getBoard().getPiece(i,j).getColour() == 'B'){
                                board[i][j].setIcon(getHiddenImageCard(playerTurn));
                            }else if(c.getBoard().getPiece(i,j).getColour() == 'R') {
                                board[i][j].setIcon(getImageCard(c.getPlayer(playerTurn).getCollection().returnPos(c.getBoard().getPiece(i, j)), "RedPieces"));
                            }
                        }
                    }
                }else if(playerTurn==1){
                    for(int i=0; i<8; i++){
                        for(int j=0; j<10; j++){
                            if(c.getBoard().getPiece(i,j).getColour() == 'R'){
                                board[i][j].setIcon(getHiddenImageCard(playerTurn));
                            }else if(c.getBoard().getPiece(i,j).getColour() == 'B') {
                                board[i][j].setIcon(getImageCard(c.getPlayer(playerTurn).getCollection().returnPos(c.getBoard().getPiece(i, j)), "bluePieces"));
                            }
                        }
                    }
                }
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }


    }

    /**
     * <b>Returns</b> the x coordinate of the piece that is at the same cell with the JButton.
     * @param b JButton
     * @return int i
     */
    public int getXcoordinate(JButton b) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                if (b.equals(board[i][j])) {
                    return i;
                }
            }
        }
        return 11;
    }

    /**
     * <b>Returns</b> the y coordinate of the piece that is at the same cell with the JButton.
     * @param b JButton
     * @return int j
     */
    public int getYcoordinate(JButton b){
        for(int i=0; i<8; i++){
            for(int j=0; j<10; j++){
                if(b.equals(board[i][j])){
                    return j;
                }
            }
        }
        return 11;
    }

    /**
     * <b>Makes</b> a JFrame when the game is over and terminates the program.
     */
    public void makeJFrame(){
        JFrame f;
        JButton exit;
        JLabel text;
        f = new JFrame("Stratego");
        text = new JLabel("Game is over! Click to close.");
        exit = new JButton("Click to close");
        JPanel p = new JPanel();
        p.add(exit);
        p.add(text);
        p.setBackground(Color.BLUE);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(exit);
        exit.addActionListener(o -> {
            f.dispose();
            System.exit(0);
        });
        f.add(p);
        f.setSize(300,300);
        f.show();
    }

    /**
     * <b>Checks</b> if the pieces that are at the given coordinates have the same colour. True if they have the same, false otherwise.
     * @param x1 coordinate of piece1
     * @param y1 coordinate of piece1
     * @param x2 coordinate of piece2
     * @param y2 coordinate of piece2
     * @return boolean
     */
    public boolean checkIfSameColour(int x1, int y1, int x2, int y2){
        return c.getBoard().getPiece(x1,y1).getColour() == c.getBoard().getPiece(x2,y2).getColour();
    }
    public static String cardname = "My Card";

}