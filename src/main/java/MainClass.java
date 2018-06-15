public class MainClass{

  public static void main(String args[]){
    Game g = new RPSGame(new HumanPlayer(),new ComputerPlayer());
    g.run();
  }
}
