import java.util.Scanner;

public class HumanPlayer implements Player{

  public Moves getMove(){
    System.out.println("Which move? rock, paper or scissors?");

    Scanner s = new Scanner(System.in);
    String input = s.nextLine();
    switch(input) {
      case "rock":
        return Moves.ROCK;
      case "paper":
        return Moves.PAPER;
      case "scissors":
        return Moves.SCISSORS;
    }
    return Moves.DUMMY;
  }
}
