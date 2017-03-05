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

public class Hand 
{
    private int bet;
    private List<Card> cards;
    private boolean showCardInHole = false;
    private boolean aceInHand = false;

    public boolean isAceInHand() {
        return aceInHand;
    }

    public void setAceInHand(boolean aceInHand) {
        this.aceInHand = aceInHand;
    }

    public boolean isShowCardInHole() {
        return showCardInHole;
    }

    public void setShowCardInHole(boolean showCardInHole) {
        this.showCardInHole = showCardInHole;
    }
    
    

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
        //Hand constructor
   public Hand()
   {
     cards = new ArrayList<Card>();
   }
            //adds a card, if the card value is 1 aceInHand variable set to true
   public void addCard(Card card) 
   {
       cards.add(card);
       if (card.getCardValue()== 1){
           aceInHand = true;
       }
   }
        //places brackets around the cards in the hand for a cleaner look
   public String toString()
    {
        String result = "[";
        for (Card c: cards){
            if (!showCardInHole){
                showCardInHole = true;
                continue;
            }
            result = result + c.toString() + "  ";
            
            
        }
        result = result.trim() + "]";
        return result;
    }
        //gets the value of the hand, two possible values in case of ace
        //ace is handled by checking if aceInHand variable is true, if so adds 10 to the hand value
        //if adding 10 to the hand value causes bust, original result with ace having 1 value is used
   public int getValue(){
       int result = 0;
       int result2 = 0;
       for (Card c: cards){
           result = result + c.getCardValue();
       }
       result2 = result;
       if (aceInHand){
           result2 = result2 + 10;
       }
       if(result2 <= 21){
           return result2;
       }
       return result;
   }
   
   
}
