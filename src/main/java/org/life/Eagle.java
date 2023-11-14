package org.life;

import java.util.Random;

public class Eagle extends Organism {

    private int energy;
    private Position position;
    private Random random = new Random();
    private Board board;

    public Eagle(int energy)
    {
        this.energy = energy;
    }

    public boolean sight(int radius){
        int currentX=position.getX();
        int currentY=position.getY();
        for (int i=currentX-radius;i<=currentX+radius;i++){
            for (int j=currentY-radius;j<=currentY+radius;j++){
                if (isValidPosition(i,j)){
                    if (board.organisms[i][j]!=null){
                        //Organism detected
                        return true;
                    }
                }
            }
        }
        //No organisms found
        return false;
    }

    public void move() {
        int newX = position.getX(); //to jest dotychczasowa pozycja
        int newY = position.getY();

        // Decide whether to move vertically or horizontally
        boolean moveVertically = random.nextBoolean(); //losowanie - prawda/fałsz

        if (moveVertically) {
            // Move up or down by 1
            newY += random.nextBoolean() ? 1 : -1;
        } else {
            // Move left or right by 1
            newX += random.nextBoolean() ? 1 : -1;
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

