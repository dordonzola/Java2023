package org.life;

public class LifeSimulator {

  public static void main(String[] args) {
    Board board = new Board(10, 10);

    Eagle eagleJohn = new Eagle(100);
    eagleJohn.setBoard(board);
    board.addOrganism(eagleJohn, 5, 5);

    Eagle eagleSteve = new Eagle(100);
    eagleSteve.setBoard(board);
    board.addOrganism(eagleSteve, 2, 7);

    Frog frogAmanda = new Frog(100);
    frogAmanda.setBoard(board);
    board.addOrganism(frogAmanda, 7, 7);

    System.out.println("------------START-----------");
    System.out.println("John:");
    System.out.println(eagleJohn.getPosition().getX());
    System.out.println(eagleJohn.getPosition().getY());

    System.out.println("Steve:");
    System.out.println(eagleSteve.getPosition().getX());
    System.out.println(eagleSteve.getPosition().getY());



    System.out.println("Amanda:");
    System.out.println(frogAmanda.getPosition().getX());
    System.out.println(frogAmanda.getPosition().getY());
    System.out.println("\n\n");

    int i=0;
    while (i<1000 && (eagleJohn.getEnergy()!=0 && eagleSteve.getEnergy()!=0) ||
            (eagleJohn.getEnergy()!=0 && frogAmanda.getEnergy()!=0) ||
            (eagleSteve.getEnergy()!=0 && frogAmanda.getEnergy()!=0))
    {
      i++;

      System.out.println("John:");
      if (eagleJohn.getEnergy()!=0)
      {
        eagleJohn.move();
      }

      System.out.println("Steve:");

      if (eagleSteve.getEnergy()!=0)
      {
        eagleSteve.move();
      }

      System.out.println("Amanda:");
      if (frogAmanda.getEnergy()!=0)
      {
        frogAmanda.move();
      }

    }

    System.out.println("\n\n------------WYNIKI-----------");

    System.out.println("John:");
    System.out.println(eagleJohn.getEnergy());

    System.out.println("Steve:");
    System.out.println(eagleSteve.getEnergy());

    System.out.println("Amanda:");
    System.out.println(frogAmanda.getEnergy());


  }
}