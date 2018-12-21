/**
 * A class that simulates a lottery type numbers game that matches a 
 * players number to a winning number.
 */
public class Lottery
{
    private String betType ;     // player bet type (straight or box)
    private double betAmount ;   // amount the player wagers
    private int playerNumber ;   // number the player chooses
    private int winningNumber ;  // winning number of the game
    private double payout ;      // amount the player wins
    
    /**
     * Creates a Lottery object.
     * @param betType the player bet type (straight or box)
     * @param betAmount the amount player wagers
     * @param playerNumber the number the player chooses
     * @param winnginNumber the winning number of the game
     * @param payout the amount the player wins
     */
    public Lottery(String betType, double betAmount, int playerNumber, 
            int winnginNumber, double payout)
    {
        this.betType = betType ;
        this.betAmount = betAmount ;
        this.playerNumber = playerNumber ;
        this.winningNumber = winnginNumber ;
        this.payout = payout ;
    }
    
    /**
     * Compares player number to winning number.
     */
    public void compareNumbers()
    {
        String straight = "Straight" ;  // used to make sure players input for 
                                        // straight bet is not misspelled    
        String box = "Box" ;            // used to make sure players input for
                                        // box bet is not misspelled
        
        payout = 0 ;
        
        int first = playerNumber / 100 ;               //players first number
        int second = ( ( playerNumber / 10 ) % 10 ) ;        //players second number
        int third = playerNumber % 10 ;                //players third number
        
        int firstWin = winningNumber / 100 ;           //winning first number
        int secondWin = ( ( winningNumber / 10 ) % 10 ) ;    //winning second number
        int thirdWin = winningNumber % 10 ;            //winning third number
        
        // STRAIGHT BET
        
        if ( betType.equalsIgnoreCase( straight ) ) 
        {
            // tests players number and winning number for exact match
            
            if (first == firstWin && second == secondWin && third == thirdWin)
                payout = betAmount * 600 ;   // straight bet winner
            else
                payout = betAmount * 0 ;     // straight bet loser
        }
        
        // BOX BET
        
        else if (betType.equalsIgnoreCase(box)) 
        {
            // tests if players number and winning number contain a combination
            // of identical numbers 
            
            if ( ( (first == firstWin || first == secondWin || first == thirdWin)
                && (second == firstWin || second == secondWin || 
                second == thirdWin) && (third == firstWin || 
                third == secondWin || third == thirdWin) ) 
                && 
                ( (firstWin == first || firstWin == second || firstWin == third)
                && (secondWin == first || secondWin == second || 
                secondWin == third) && (thirdWin == first || thirdWin == second 
                || thirdWin == third) ) )
            {
                // further test to compare players number to winning number in  
                // order to see if each have different sets of duplicate numbers
                // example: 122 and 212 will pass, but 122 and 112 will fail
                
                if ( (first + second + third) == (firstWin + secondWin + 
                    thirdWin) )
                {
                    // players number contains duplicates
                    
                    if (first == second || first == third || second == third)
                        payout = betAmount * 200 ;   // box bet winner
                    
                    // no duplicates in players number                 
                    
                    else
                        payout = betAmount * 100 ;  // box bet winner
                }
                else
                    payout = betAmount * 0 ; // box bet loser
            }
            else
                payout = betAmount * 0 ;  //box bet loser       
        }
    }
    
    /**
     * Returns a String containing all the data for a game played.
     * @return all the data for a game played 
     */
    public String getData()
    {
    	String s = "Bet Type: " + betType + 
                      String.format("%nBet Amount: $%.2f", betAmount) +
                      "\nPlayer Number: " + playerNumber + 
                      "\nWinning Number: " + winningNumber + 
                      String.format("%n%nPayout: $%.2f", payout) ;
        return s ;
    }
}