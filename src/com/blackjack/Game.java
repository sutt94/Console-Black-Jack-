package com.blackjack;
//***************************************************************

//Author: Billy Suttlemyre            Class: COP2551 Intro to OOP   *

//Date: 03/23/2015                Hours Worked: 15 hours         *

//                                                              *

//I, Billy Suttlemyre, hereby pledge on my honor that this code is  *

//solely that of my own. I received no help whatsoever with this*

//project other than with general concepts and debugging.       *

//I did not code this alongside any friend and I did not copy   *

//any lines of code from either the web or from a friend. I can *

//explain the logic of every single line of this code without   *

//hesitation when asked and I understand that I may be asked to *

//do so by the professor. If I am found to be in violation of   *

//this contract, which is based on the Academic Misconduct      *

//policy found in the syllabus, I understand that I will receive*

//an unforgiveable "F" for this course regardless of my prior   *

//grades. I used the textbook's Card and DeckOfCards classes.                                                       *

//***************************************************************
import com.blackjack.Card;
import java.util.*;

public class Game {

    private Player dealer;
    private Player player1;
    private DeckOfCards deck;
    private int minBet;
    private int maxBet;
    private int minValue;
    private final Scanner scanner;
    private int bet;

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getDealer() {
        return dealer;
    }

    public void setDealer(Player dealer) {
        this.dealer = dealer;
    }

    public DeckOfCards getDeck() {
        return deck;
    }

    public void setDeck(DeckOfCards deck) {
        this.deck = deck;
    }

    public int getMinBet() {
        return minBet;
    }

    public void setMinBet(int minBet) {
        this.minBet = minBet;
    }

    public int getMaxBet() {
        return maxBet;
    }

    public void setMaxBet(int maxBet) {
        this.maxBet = maxBet;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }
        //Game constructor
    public Game() {
        

        player1 = new Player();
        player1.getHand().setShowCardInHole(true);
        player1.setBalance(100);

        dealer = new Player();

        scanner = new Scanner(System.in);

    }
        //method that runs the game using my other needed methods
    public void startGame() {
        System.out.println("Welcome to Black Jack!");
        while (true) {
            newGame();
            showBalance(player1);

            bet = takeBet(player1);
            if (bet == 0) {
                gameOver();
            }
            System.out.println("The dealer is dealing the cards...");
            dealHands();
            System.out.println("Dealer's hand is " + dealer.showHand());
            System.out.println("Player 1's hand is " + player1.showHand() + " The value is " + player1.getHand().getValue());

            playerLoop();
            if (player1.isBusted()) {
                System.out.println("You busted! Game over.");
                continue;
            }

            dealerLoop();
            if (dealer.isBusted()) {
                System.out.println("The dealer busted!");
                playerWins();
            } else if (player1.getHand().getValue() > dealer.getHand().getValue()) {
                playerWins();
            } else {
                System.out.println("Sorry, you lose!");
            }

        }

    }
    //method pays out bet winnings upon win and displays win message
    public void playerWins() {
        player1.setBalance(player1.getBalance() + bet + bet);
        System.out.println("Congradulations, you win!");
    }
        //begins a new game, new deck created and shuffled, checks for appropriate balance to contiue
    public void newGame() {
        deck = new DeckOfCards();
        deck.shuffle();
        dealer.getHand().setShowCardInHole(false);
        player1.getHand().getCards().clear();
        dealer.getHand().getCards().clear();
        player1.getHand().setAceInHand(false);
        dealer.getHand().setAceInHand(false);
        if (player1.getBalance() < 5) {
            System.out.println("Your balance is to low. Press Y to insert another quarter and reset balance to $100. Press any other key to exit.");
            if (scanner.next().equalsIgnoreCase("y")) {
                player1.setBalance(100);

            } else {
                gameOver();
            }
        }
    }
        //displays the players balance
    public void showBalance(Player player) {

        System.out.println("Your balance is $" + player.getBalance());

    }
        //takess acceptable bet from player and subtracts from balance, checks player balance is enough to place the bet
            //if not acceptable bet error displayed
    public int takeBet(Player player) {
        int result = 0;
        while (true) {
            System.out.println("Please place your bet, either 5, 10, 15, or 20. Enter 0 to exit.");
            result = scanner.nextInt();
            if (((result == 0) || (result == 5) || (result == 10) || (result == 15) || (result == 20)) && (result <= player.getBalance())) {
                player1.setBalance(player1.getBalance() - result);
                return result;
            }
            System.out.println("Invalid bet.");
        }

    }
        //deals player and dealer hands
    public void dealHands() {

        player1.dealCard(getCard());
        dealer.dealCard(getCard());
        player1.dealCard(getCard());
        dealer.dealCard(getCard());
    }
        //returns next card in the deck, if no more cards creates a new deck, shuffles, and returns first card
    private Card getCard() {
        Card card = deck.dealCard();
        if (card == null) {
            deck = new DeckOfCards();
            deck.shuffle();
            card = deck.dealCard();
        }
        return card;
    }
        //displays game over message and exits 
    public void gameOver() {
        System.out.println("Game over, play again soon");
        System.exit(0);

    }
        //handles the players turn of the game, allows hit or stay until busted
    public void playerLoop() {
        String input = "";
        if (player1.getHand().getValue() == 21) {
            return;
        }
        while (true) {
            System.out.println("Press H to hit or S to stay.");
            input = scanner.next();
            if (input.equalsIgnoreCase("h")) {
                player1.dealCard(getCard());
                System.out.println("Player 1's hand is " + player1.showHand() + " The value is " + player1.getHand().getValue());
                if (player1.isBusted()) {
                    return;
                } else if (player1.getHand().getValue() == 21) {
                    return;
                }

            } else if (input.equalsIgnoreCase("s")) {
                return;
            }
        }
    }
        //handles the dealers turn of the game, dealer automatically hits until hand value of 17 or bust
    public void dealerLoop() {

        System.out.println("Dealer's hand is " + dealer.showHand() + " The value is " + dealer.getHand().getValue());
        if (dealer.getHand().getValue() >= 17) {
            return;
        }
        while (true) {

            dealer.dealCard(getCard());
            System.out.println("The dealer takes a hit...");
            System.out.println("Dealer's hand is " + dealer.showHand() + " And the value is " + dealer.getHand().getValue());
            if (dealer.isBusted()) {
                return;
            } else if (dealer.getHand().getValue() >= 17) {
                return;
            }

        }

    }
        //main method creates a new game object and runs the startGame method, which runs the game
    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.startGame();

    }

}
