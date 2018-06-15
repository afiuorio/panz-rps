import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import java.util.Set;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RPSTest {

  @Test
  public void testRPSRulesRock() {
    Game game = new RPSGame(new HumanPlayer(), new ComputerPlayer());
    try{
      int valueGame = game.compareMoves(Moves.ROCK,Moves.PAPER);
      assertTrue(valueGame > 0);
      valueGame = game.compareMoves(Moves.ROCK,Moves.ROCK);
      assertTrue(valueGame == 0);
      valueGame = game.compareMoves(Moves.ROCK,Moves.SCISSORS);
      assertTrue(valueGame < 0);
    }
    catch(Exception e){
      Assert.fail();
    }
  }

  public void testRPSRulesPaper() {
    Game game = new RPSGame(new HumanPlayer(), new ComputerPlayer());
    try{
      int valueGame = game.compareMoves(Moves.PAPER,Moves.PAPER);
      assertTrue(valueGame == 0);
      valueGame = game.compareMoves(Moves.PAPER,Moves.ROCK);
      assertTrue(valueGame < 0);
      valueGame = game.compareMoves(Moves.PAPER,Moves.SCISSORS);
      assertTrue(valueGame > 0);
    }
    catch(Exception e){
      Assert.fail();
    }
  }

  public void testRPSRulesScissors() {
    Game game = new RPSGame(new HumanPlayer(), new ComputerPlayer());
    try{
      int valueGame = game.compareMoves(Moves.SCISSORS,Moves.PAPER);
      assertTrue(valueGame < 0);
      valueGame = game.compareMoves(Moves.SCISSORS,Moves.ROCK);
      assertTrue(valueGame > 0);
      valueGame = game.compareMoves(Moves.SCISSORS,Moves.SCISSORS);
      assertTrue(valueGame == 0);
    }
    catch(Exception e){
      Assert.fail();
    }
  }

  @Test(expected = IllegalMoveException.class)
  public void testRPSIllegalMove1() throws IllegalMoveException {
    Game game = new RPSGame(new HumanPlayer(), new ComputerPlayer());

    int valueGame = game.compareMoves(Moves.DUMMY,Moves.PAPER);
    assertTrue(valueGame == 0);
  }

  @Test(expected = IllegalMoveException.class)
  public void testRPSIllegalMove2() throws IllegalMoveException {
    Game game = new RPSGame(new HumanPlayer(), new ComputerPlayer());

    int valueGame = game.compareMoves(Moves.SCISSORS,Moves.DUMMY);
    assertTrue(valueGame == 0);
  }

  public void testRPSRulesImmutable(){
    Game g = new RPSGame(new HumanPlayer(), new ComputerPlayer());
    Set<Moves> moves = g.getLegalMoves();
    moves.clear();
    assertFalse(g.getLegalMoves().size() == moves.size());
  }

  public void testRPSGameDraw(){
    String input = "rock";
    String expected = "Which move? rock, paper or scissors?\nROCK vs ROCK\nDraw!\n";

    System.setIn(new ByteArrayInputStream(input.getBytes()));

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    System.setOut(ps);

    Game g = new RPSGame(new HumanPlayer(), new ComputerPlayer(0));
    g.run();
    assertEquals(baos.toString(), expected);
  }

  public void testRPSGameWin(){
    String input = "paper";
    String expected = "Which move? rock, paper or scissors?\nPAPER vs ROCK\nYou win!\n";

    System.setIn(new ByteArrayInputStream(input.getBytes()));

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    System.setOut(ps);

    Game g = new RPSGame(new HumanPlayer(), new ComputerPlayer(0));
    g.run();
    assertEquals(baos.toString(), expected);
  }

  public void testRPSGameLose(){
    String input = "scissors";
    String expected = "Which move? rock, paper or scissors?\nSCISSORS vs ROCK\nYou lose!\n";

    System.setIn(new ByteArrayInputStream(input.getBytes()));

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    System.setOut(ps);

    Game g = new RPSGame(new HumanPlayer(), new ComputerPlayer(0));
    g.run();
    assertEquals(baos.toString(), expected);
  }

}
