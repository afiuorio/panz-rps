import java.util.Random;

public class ComputerPlayer implements Player{

  private Random rand;
  private Moves[] possibleMoves = {Moves.ROCK, Moves.PAPER, Moves.SCISSORS} ;

  public ComputerPlayer(){
      rand = new Random();
  }

  public ComputerPlayer(long seed){
      rand = new Random(seed);
  }

  public Moves getMove(){
    int val = rand.nextInt(possibleMoves.length);
    return possibleMoves[val];
  }
}
