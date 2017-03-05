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
public class Card 
{
    private final String face; //face of the card
    private final String suit; //suit of the card
    
    
    
    //Two argument constructor  initilizes card face, and suit
    public Card(String cardFace, String cardSuit)
    {
        this.face = cardFace;
        this.suit = cardSuit;
        
    }
    
    //Return the string representation of the card
    public String toString()
    {
        return face + " of " + suit;
    }
            //returns the cards numeric value
    public Integer getCardValue()
    {
        if (face.equals ("Ace"))
                return 1;
        if (face.equals ("Deuce"))
            return 2;
        if (face.equals ("Three"))
                return 3;
        if (face.equals ("Four"))
            return 4;
        if (face.equals ("Five"))
                return 5;
        if (face.equals ("Six"))
            return 6;
        if (face.equals ("Seven"))
                return 7;
        if (face.equals ("Eight"))
            return 8;
        if (face.equals ("Nine"))
                return 9;
        if (face.equals ("Ten"))
            return 10;
        if (face.equals ("King"))
                return 10;
        if (face.equals ("Queen"))
            return 10;
        if (face.equals ("Jack"))
                return 10;
        else
            return null;
        
                        
    
    
    
    }
    
}
