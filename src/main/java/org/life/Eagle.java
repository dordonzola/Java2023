package org.life;

import java.util.Random;

public class Eagle extends Organism {

    private Position position;
    private Random random = new Random();
    private Board board;

    public Eagle(int energy)
    {
        super(energy);
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isValidPosition(Position position) {
        int newX = position.getX();
        int newY = position.getY();
        return newX >= 0 && newX < 10 && newY >= 0 && newY < 10;
    }

    public boolean sight(int radius){
        int currentX=position.getX();
        int currentY=position.getY();

        for (int i=currentX-radius;i<=currentX+radius;i++){
            for (int j=currentY-radius;j<=currentY+radius;j++){
                Position tmpPosition=new Position(i,j);
                if (isValidPosition(tmpPosition) && board.organisms[i][j]!=null){
                    System.out.println("Wykryto rywala");
                    return true;
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

        Position newPosition = new Position(newX, newY);

        if (board.isValidPosition(newPosition)) {
            System.out.println(newX);
            System.out.println(newY);
            // Use the board's moveOrganism method to move the organism
            board.moveOrganism(this, newPosition);
            this.energy-=1;
        }
        else {
            System.out.println("Koniec planszy!");
        }

    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}