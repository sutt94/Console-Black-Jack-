package com.blackjack;


import com.blackjack.Card;

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
public class Player 
{
    private int balance;
    private Hand hand;
    

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
    //Player constructor
   public Player()
   {
     hand = new Hand();
     
    }
    //shows the hand in string representation
   public String showHand(){
       return hand.toString();
   }
    //adds card to hand
public void dealCard(Card card)
{
    hand.addCard(card);
    
}
    //if hand value over 21 busted
public Boolean isBusted(){
    return (hand.getValue() > 21);
}
        
    
    
}
