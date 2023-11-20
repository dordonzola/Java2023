package org.life;

public class Board {

  public int width;
  public int height;
  Organism[][] organisms;

  public Board(int width, int height) {
    this.width = width;
    this.height = height;
    this.organisms = new Organism[width][height];
  }

  public void addOrganism(Organism organism, int x, int y) {
    if (organisms[x][y] == null) {
      organisms[x][y] = organism;
      organism.setPosition(new Position(x, y));
      //organism.setBoard(this);
    } else {
      System.out.println("Position already occupied!");
    }
  }

  public void moveOrganism(Organism organism, Position position) {
    int newX = position.getX(); //to jest dotychczasowa pozycja
    int newY = position.getY();

    if (newX >= 0 && newX < width && newY >= 0 && newY < height) {
      if (organisms[newX][newY] != null) {
        organism.eat(organisms[newX][newY]);
      }
      organisms[organism.getPosition().getX()][organism.getPosition().getY()] = null;
      organisms[newX][newY] = organism;
      organism.setPosition(new Position(newX, newY));
    } else {
      System.out.println("Invalid move!");
    }
  }

  public boolean isValidPosition(Position position) {
    int newX = position.getX();
    int newY = position.getY();
    return newX >= 0 && newX < width && newY >= 0 && newY < height;
  }

}