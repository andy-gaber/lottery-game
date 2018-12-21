import javax.swing.JOptionPane ;

public class LotteryTester
{
    public static void main(String[] args)
    {
        String betType ;
        double betAmount ;
        int playerNumber ;
        int winningNumber ;
        double payout = 0 ;
        String straight = "Straight" ;
        String box = "Box" ;
                
        //Straight or Box bet
        String playerBet = JOptionPane.showInputDialog("Bet Type: (\"Straight\" or \"Box\") ?") ;
        betType = playerBet ;
        
        //Amount to wager
        String wager = JOptionPane.showInputDialog("Enter bet amount") ;
        betAmount = Double.parseDouble(wager) ;
        
        //Player chooses number
        String playerSelection = JOptionPane.showInputDialog("Enter number") ;
        playerNumber = Integer.parseInt(playerSelection) ;
        
        //winning number
        String winner = JOptionPane.showInputDialog("Enter winning number") ;
        winningNumber = Integer.parseInt(winner) ;
        
        Lottery lotto = new Lottery(betType, betAmount, playerNumber, winningNumber, payout) ;
        
        //Bet type other than "straight" or "box" is not valid bet
        if ( !betType.equalsIgnoreCase(straight) && !betType.equalsIgnoreCase(box) )
            System.out.println("Invalid Bet Type\n") ;
        else
        {
            lotto.compareNumbers() ;
            System.out.println(lotto.getData()) ;
        }
        
        System.exit(0) ;
    }
}
    
