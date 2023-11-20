package org.life;

import java.util.Random;


public class Frog extends Organism{

    private int energy;
    private Position position;
    private Random random = new Random();
    private Board board;

    public Frog(int energy, Board board)
    {
        this.energy = energy;
        this.board = board;
    }

    @Override
    public void move() {
        int newX = position.getX(); //to jest dotychczasowa pozycja
        int newY = position.getY();

        // Decide whether to move vertically or horizontally
        boolean moveVertically = random.nextBoolean(); //losowanie - prawda/fałsz

        if (moveVertically) {
            // Move up or down by 1
            newY += random.nextBoolean() ? 2 : -2;
        } else {
            // Move left or right by 1
            newX += random.nextBoolean() ? 2 : -2;
        }

        if (board.isValidPosition(newX, newY)) {
            // Use the board's moveOrganism method to move the organism
            board.moveOrganism(newX, newY);
        }
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}