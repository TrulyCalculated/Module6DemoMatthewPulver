import java.util.Scanner;
public class Blackjack {
    public static void main(String[] args){

        //Initializes P1Random and Scanner
        P1Random randomGen = new P1Random();
        Scanner io = new Scanner (System.in);

        //Variable declarations for gameState, number of games, number of wins, number of losses, and number of ties respectively.
        boolean gameState;
        int gameCount, winCount, loseCount, tieCount;
        gameState = true;
        gameCount = 0;
        winCount = 0;
        loseCount = 0;
        tieCount = 0;

        //Main game loop.
        while (gameState){
            System.out.println("START GAME #" + (gameCount + 1));
            System.out.println();

            //Decides initial card value and prints a message declaring what card the player gets.
            int cardTotal;
            cardTotal = randomGen.nextInt(13) + 1;
            boolean dealLoop;
            int cardDealt;
            String cardName;
            switch (cardTotal){
                case 1:
                    cardName = "ACE!";
                    cardTotal = 1;
                    break;
                case 11:
                    cardName = "JACK!";
                    cardTotal = 10;
                    break;
                case 12:
                    cardName = "QUEEN!";
                    cardTotal = 10;
                    break;
                case 13:
                    cardName = "KING!";
                    cardTotal = 10;
                    break;
                default:
                    cardName = (cardTotal) + "!";
                    break;
            }
            dealLoop = true;
            System.out.println("Your card is a " + cardName);
            System.out.println("Your hand is: " + cardTotal);
            while (dealLoop) {
                System.out.println();
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.println();
                System.out.println("Choose an option:");
                int decision = io.nextInt();
                switch (decision){

                    //Case 1 deals a card, then displays resulting card for the player.
                    case 1:
                        cardName = "";
                        cardDealt = randomGen.nextInt(13) + 1;
                        switch (cardDealt){
                            case 1:
                                cardName = "ACE!";
                                cardTotal = cardTotal + 1;
                                break;
                            case 2:
                                cardName = "2!";
                                cardTotal = cardTotal + 2;
                                break;
                            case 3:
                                cardName = "3!";
                                cardTotal = cardTotal + 3;
                                break;
                            case 4:
                                cardName = "4!";
                                cardTotal = cardTotal + 4;
                                break;
                            case 5:
                                cardName = "5!";
                                cardTotal = cardTotal + 5;
                                break;
                            case 6:
                                cardName = "6!";
                                cardTotal = cardTotal + 6;
                                break;
                            case 7:
                                cardName = "7!";
                                cardTotal = cardTotal + 7;
                                break;
                            case 8:
                                cardName = "8!";
                                cardTotal = cardTotal + 8;
                                break;
                            case 9:
                                cardName = "9!";
                                cardTotal = cardTotal + 9;
                                break;
                            case 10:
                                cardName = "10!";
                                cardTotal = cardTotal + 10;
                                break;
                            case 11:
                                cardName = "JACK!";
                                cardTotal = cardTotal + 10;
                                break;
                            case 12:
                                cardName = "QUEEN!";
                                cardTotal = cardTotal + 10;
                                break;
                            case 13:
                                cardName = "KING!";
                                cardTotal = cardTotal + 10;
                                break;
                        }
                        System.out.println("Your card is a " + cardName);
                        System.out.println("Your hand is: " + cardTotal);
                        break;

                    //Holds given card value. If the dealer has a higher card value and is less than 21, dealer wins and player loses. If the player has the higher card value, the player wins. If both numbers are the same, then the player ties.
                    case 2:
                        int dealerTotal;
                        dealerTotal = randomGen.nextInt(11) + 16;
                        if (dealerTotal > cardTotal && dealerTotal <= 21){
                            System.out.println("Dealer's hand: " + dealerTotal);
                            System.out.println("Your hand is: " + cardTotal);
                            System.out.println();
                            System.out.println("Dealer wins!");
                            System.out.println();
                            loseCount++;
                            gameCount++;
                            dealLoop = false;
                        }

                        else if (dealerTotal == cardTotal) {
                            System.out.println("Dealer's hand: " + dealerTotal);
                            System.out.println("Your hand is: " + cardTotal);
                            System.out.println();
                            System.out.println("It's a tie! No one wins!");
                            System.out.println();
                            tieCount++;
                            gameCount++;
                            dealLoop = false;
                        }
                        else {
                            System.out.println("Dealer's hand: " + dealerTotal);
                            System.out.println("Your hand is: " + cardTotal);
                            System.out.println();
                            System.out.println("You win!");
                            System.out.println();
                            winCount++;
                            gameCount++;
                            dealLoop = false;
                        }
                        break;

                    //Lists current game statistics.
                    case 3:
                        System.out.println("Number of Player wins: " + winCount);
                        System.out.println("Number of Dealer wins: " + loseCount);
                        System.out.println("Number of tie games: " + tieCount);
                        System.out.println("Total # of games played is: " + gameCount);
                        System.out.println();
                        double ratio;
                        ratio = Math.round((double)winCount/(double)gameCount *100);
                        System.out.println("Percentage of Player wins: " + ratio + "%");
                        break;

                    //Breaks out of the deal loop and the main game loop to exit the program.
                    case 4:
                        gameState = false;
                        dealLoop = false;
                        break;

                    //Handles invalid inputs and restarts the dealing loop.
                    default:
                        System.out.println("Invalid input!");
                        System.out.println("Please enter an integer value between 1 and 4.");
                        break;
                }

                //If the player's hand is 21, then count as a win and loop the game.
                if (cardTotal == 21){
                    System.out.println();
                    System.out.println("BLACKJACK! You win!");
                    System.out.println();
                    winCount++;
                    gameCount++;
                    dealLoop = false;
                }

                //Else, if the player's hand is greater than 21, then count as a loss and loop the game.
                else if (cardTotal > 21){
                    System.out.println();
                    System.out.println("You exceeded 21! You lose.");
                    System.out.println();
                    loseCount++;
                    gameCount++;
                    dealLoop = false;
                }
                }
        }
        }
    }































