import java.util.Set;

public interface Game{

  public Set<Moves> getLegalMoves();
  public int compareMoves(Moves a, Moves b) throws IllegalMoveException;
  public void run();
  
}
