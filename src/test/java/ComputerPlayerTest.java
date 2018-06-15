import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

public class ComputerPlayerTest {

  @Test
  public void testComputerPlayer() {
    Player p = new ComputerPlayer(0);
    Moves m = p.getMove();
    assertEquals(m,Moves.ROCK);
  }
}
