package jst.snake;

import asciiPanel.AsciiPanel;

import javax.swing.*;
import java.util.Scanner;

public class SnakeMain extends JFrame {
    private SnakeSegment firstSegment;
    private SnakeSegment lastSegment;
    private String direction;
    private Scanner myScanner = new Scanner(System.in);
    AsciiPanel gameBoard;

    public SnakeMain(String titel) {
        super(titel);

        gameBoard = createBoard();
        add(gameBoard);

        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setUpBoard();

    }

    public AsciiPanel createBoard() {
        AsciiPanel gameBoard = new AsciiPanel(80, 40);
        return gameBoard;
    }

    public void setUpBoard() {
        firstSegment = new SnakeSegment(40,20);
        displaySnake(firstSegment);

    }

    public void startGame() {

        // do While

    }

    public String checkAndSetDirection() {
        String direction = this.direction;
        if (!(Character.toString(myScanner.next().charAt(myScanner.next().length() - 1)) == direction))  {
            switch (Character.toString(myScanner.next().charAt(myScanner.next().length() - 1))) {
                case "w":
                    direction = "top";
                    break;
                case "a":
                    direction = "left";
                    break;
                case "s":
                    direction = "down";
                    break;
                case "d":
                    direction = "right";
            }
        }
        return direction;
    }

    public void moveSnake(SnakeSegment startSegment) {
        if (startSegment == firstSegment) {
            switch (direction) {
                case "top":
                    startSegment.moveWhenFirstSegment(startSegment.getCurrentX(), startSegment.getCurrentY() - 1);
                    break;
                case "down":
                    startSegment.moveWhenFirstSegment(startSegment.getCurrentX(), startSegment.getCurrentY() + 1);
                    break;
                case "left":
                    startSegment.moveWhenFirstSegment(startSegment.getCurrentX() - 1, startSegment.getCurrentY());
                    break;
                case "right":
                    startSegment.moveWhenFirstSegment(startSegment.getCurrentX() + 1, startSegment.getCurrentY());
                    break;
            }
        }
        else {
            startSegment.move();
        }

        if (startSegment.getNextSegment() != null) {
            moveSnake(startSegment.getNextSegment());
        }

    }

    public void addNewSegment() {
        lastSegment.addNewSegment();
        lastSegment = lastSegment.getNextSegment();


    }

    public void displaySnake(SnakeSegment firstSegment) {
        gameBoard.write("0", firstSegment.getCurrentX(), firstSegment.getCurrentY());
        if (firstSegment.getNextSegment() != null) {
            displaySnake(firstSegment.getNextSegment());
        }

    }

    public boolean isCollision(SnakeSegment firstSegment) {
        if (firstSegment.getCurrentX() == 81 || firstSegment.getCurrentX() == -1 || firstSegment.getCurrentY() == 81 || firstSegment.getCurrentY() == -1) {
            return true;
        }

        return false;
    }
}
