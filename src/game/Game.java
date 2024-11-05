package game;

import view.Graphs;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Game extends JFrame {

    public static void main(String[] args) throws IOException {
        Graphs view = new Graphs();
        view.setSize(300, 300);
        view.setVisible(true);

    }
}