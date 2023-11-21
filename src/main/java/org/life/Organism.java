package org.life;

import java.util.Random;

public abstract class Organism {

  protected int energy;
  protected Position position;
  protected Random random = new Random();
  private Board board;

  public Organism(int energy)
  {
    this.energy = energy;
  }


  public void move() {
    int newX = position.getX();
    int newY = position.getY();

    // Decide whether to move vertically or horizontally
    boolean moveVertically = random.nextBoolean();

    if (moveVertically) {
      newY += random.nextBoolean() ? 1 : -1;
    } else {
      newX += random.nextBoolean() ? 1 : -1;
    }

    Position newPosition = new Position(newX, newY);

    if (board.isValidPosition(newPosition)) {
      // Use the board's moveOrganism method to move the organism
      board.moveOrganism(this, newPosition);
      this.energy-=1;
    }
  }


  public void setPosition(Position position) {
    this.position = position;
  }

  public Position getPosition() {
    return position;
  }

  public int getEnergy() {
    return energy;
  }

  public void eat(Organism other){
    System.out.println("Konsumuję rywala");
    this.energy+=other.getEnergy();
    other.energy=0;
  }
}