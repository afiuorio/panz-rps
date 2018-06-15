import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class RPSGame implements Game{
  private Set<Moves> legalMoves;
  private HashMap<Moves,Moves> defeatBy;
  private Player P1;
  private Player P2;

  public RPSGame(Player p1, Player p2){
    P1 = p1;
    P2 = p2;

    legalMoves = new HashSet<Moves>();
    legalMoves.add(Moves.ROCK);
    legalMoves.add(Moves.PAPER);
    legalMoves.add(Moves.SCISSORS);

    defeatBy = new HashMap<Moves,Moves>();
    defeatBy.put(Moves.ROCK, Moves.PAPER);
    defeatBy.put(Moves.PAPER, Moves.SCISSORS);
    defeatBy.put(Moves.SCISSORS, Moves.ROCK);
  }

  public Set<Moves> getLegalMoves(){
    return new HashSet<Moves>(legalMoves);
  }

  public int compareMoves(Moves a, Moves b) throws IllegalMoveException{
    /*Input checking*/
    if(!legalMoves.contains(a) | !legalMoves.contains(b))
      throw new IllegalMoveException();

    if(a==b)
      return 0;
    if(defeatBy.get(a) == b )
      return 1;
    return -1;
  }

  public void run(){
    Moves P1Move = P1.getMove();
    Moves P2Move = P2.getMove();
    System.out.println(P1Move + " vs " + P2Move);

    try{
      int result = compareMoves(P1Move,P2Move);
      if(result == 0)
        System.out.println("Draw!");
      else if(result < 0)
        System.out.println("You won!");
      else
        System.out.println("You lose!");
    }
    catch (IllegalMoveException e){
      System.err.println("Illegal move");
    }
  }
}
