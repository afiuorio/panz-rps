import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HumanPlayerTest {

  @Test
  public void testHumanPlayerParser() {
    String input = "rock";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    Player p = new HumanPlayer();
    Moves m = p.getMove();
    assertEquals(m, Moves.ROCK);

    input = "paper";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    m = p.getMove();
    assertEquals(m, Moves.PAPER);

    input = "aaaa";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    m = p.getMove();
    assertEquals(m, Moves.DUMMY);
  }
}
