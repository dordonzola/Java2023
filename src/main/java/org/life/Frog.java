package org.life;

import java.util.Random;


public class Frog extends Organism{

    private int energy;
    private Position position;
    private final Random random = new Random();
    private Board board;

    public Frog(int energy)
    {
        super(energy);
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public void move() {
        int newX = position.getX(); //to jest dotychczasowa pozycja
        int newY = position.getY();

        boolean moveVertically = random.nextBoolean(); //losowanie - prawda/fałsz
        boolean direction=random.nextBoolean();


        for (int i=0;i<2;i++) {  //Special power - two moves

            if (moveVertically) {
                // Move up or down by 1
                newY += direction ? 1 : -1;
            } else {
                // Move left or right by 1
                newX += direction ? 1 : -1;
            }

            Position newPosition = new Position(newX, newY);

            if (board.isValidPosition(newPosition)) {
                System.out.println(newX);
                System.out.println(newY);
                System.out.println("\n");
                // Use the board's moveOrganism method to move the organism
                board.moveOrganism(this, newPosition);
            }
            else{

                    System.out.println("Koniec planszy!");

            }
            this.energy-=1;
        }
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}