package org.life;

public class LifeSimulator {

  public static void main(String[] args) { //tworzymy plansze 10x10
    Board board = new Board(10, 10);

    Eagle eagle1 = new Eagle(100); //tworzymy organizm o energii 100
    board.addOrganism(organism, 5, 5); //ustawiamy organizm na polu 5,5
    organism.move();
  }
}